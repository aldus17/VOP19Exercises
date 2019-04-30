/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package one_armed_bandit;

import java.io.File;
import java.net.URL;
import java.util.Random;
import java.util.ResourceBundle;
import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

/**
 *
 * @author AleksanderSTUD
 */
public class FXMLDocumentController implements Initializable {

    @FXML
    private Button stop1Button;
    @FXML
    private Button stop2Button;
    @FXML
    private Button stop3Button;
    @FXML
    private Button startButton;

    private Image[] imageArray;
    @FXML
    private ImageView imageView1;
    @FXML
    private ImageView imageView2;
    @FXML
    private ImageView imageView3;
    @FXML
    private Label labelResult;

    private Thread thread1;
    private Thread thread2;
    private Thread thread3;
    private int spinsAlive;
    private static int countWin;
    private int totalMoney;
    @FXML
    private Label moneyWonLabel;

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        imageArray = new Image[10];

        for (int i = 0; i < imageArray.length; i++) {
            imageArray[i] = new Image(new File("src/images/fruits" + i + ".png").toURI().toString());

        }
        
        imageView1.setImage(imageArray[new Random().nextInt(9)]);
        imageView2.setImage(imageArray[new Random().nextInt(9)]);
        imageView3.setImage(imageArray[new Random().nextInt(9)]);
        totalMoney = 100;
        String winStringg = String.valueOf(totalMoney);
        moneyWonLabel.setText(winStringg);

    }

    @FXML
    private void stopActionHandler(ActionEvent event) {
        if (event.getSource() == stop1Button) {
            thread1.interrupt();
            stop1Button.setDisable(true);
        } else if (event.getSource() == stop2Button) {
            thread2.interrupt();
            stop2Button.setDisable(true);
        } else if (event.getSource() == stop3Button) {
            thread3.interrupt();
            stop3Button.setDisable(true);
        }
    }

    @FXML
    private void startActionHandler(ActionEvent event) {
        if (event.getSource() == startButton) {
            thread1 = new Thread(new BanditRunnable(0, 120, imageView1));
            thread2 = new Thread(new BanditRunnable(0, 100, imageView2));
            thread3 = new Thread(new BanditRunnable(0, 140, imageView3));
            thread1.setDaemon(true);
            thread2.setDaemon(true);
            thread3.setDaemon(true);

            thread1.start();
            stop1Button.setDisable(false);
            thread2.start();
            stop2Button.setDisable(false);
            thread3.start();
            stop3Button.setDisable(false);

            startButton.setDisable(true);
            labelResult.setText("Running...");
        }

    }

    private synchronized void aliveCount(boolean spinsUp) {
        if (spinsUp) {
            this.spinsAlive++;

        } else {
            this.spinsAlive--;
        }
        System.out.println("Alive spins: " + spinsAlive);
        if (this.spinsAlive == 0) {
            startButton.setDisable(false);
            Platform.runLater(new Runnable() {
                @Override
                public void run() {

                    if (imageView1.getImage() == imageView2.getImage() && imageView1.getImage() == imageView3.getImage()) {
                        labelResult.setText("3 equals JACKPOT!!!, you won 1000$");
                        countWin += 1000;
                        totalMoney += countWin;

                    } else if (imageView1.getImage() == imageView2.getImage()
                            || imageView1.getImage() == imageView3.getImage()
                            || imageView2.getImage() == imageView3.getImage()) {
                        labelResult.setText("2 equals! you won 10$");
                        countWin += 10;
                        totalMoney += countWin;
                    } else {
                        labelResult.setText("No equal, you loose 2$");
                        totalMoney -= 2;
                        
                    }
                    String winString = String.valueOf(totalMoney);

                    moneyWonLabel.setText(winString);
                }
            });

        }
    }

    public class BanditRunnable implements Runnable {

        private int i; //Index of current picture
        private long sleepTime;
        private boolean running;
        private ImageView iw;

        public BanditRunnable(int i, long sleepTime, ImageView iw) {
            this.i = i;
            this.sleepTime = sleepTime;
            this.iw = iw;
        }

        @Override
        public void run() {

            running = true;
            aliveCount(true);
            while (running) {

                // Når der skal pilles i UI, skal man anvende Platform.runLater()
                Platform.runLater(new Runnable() {
                    @Override
                    public void run() {

                        iw.setImage(imageArray[i]);
                        i = (i + 1) % imageArray.length;

                    }

                });
                // A synchronized keyword can be used to avoid race condition and develop thread-safe classes
                synchronized (this) {
                    try {
                        //Thread.sleep(sleepTime);
                        wait(sleepTime);
                    } catch (InterruptedException ex) {
                        running = false;
                        aliveCount(false);
                        if (running) {

                        }
                    }
                }
            }
        }

    }
}
