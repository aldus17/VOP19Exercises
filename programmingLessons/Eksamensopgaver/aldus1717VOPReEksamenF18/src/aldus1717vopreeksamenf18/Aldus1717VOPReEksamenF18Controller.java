package aldus1717vopreeksamenf18;

import java.net.URL;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.control.ToggleGroup;
import population.TownStatistics;

public class Aldus1717VOPReEksamenF18Controller implements Initializable {

    // Scrolling Text
    private Label label;
    @FXML
    private TextField inputTF;
    @FXML
    private RadioButton shiftCharRB;
    @FXML
    private RadioButton shiftWholeWordsRB;
    @FXML
    private Button startBtn;
    @FXML
    private Button stopBtn;
    @FXML
    private Label updateLabel;
    // Danish Towns
    @FXML
    private Button readFileBtn;
    @FXML
    private Button sortBtn;
    @FXML
    private Button clearBtn;
    @FXML
    private TextArea outputTA;
    // Other attributes
    private ToggleGroup tg;
    private Thread thread;
    private int sleepTime;
    private int count;
    private TownStatistics townStatistics;

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        count = 0;
        sleepTime = 200;
        tg = new ToggleGroup();
        shiftCharRB.setToggleGroup(tg);
        shiftWholeWordsRB.setToggleGroup(tg);
        townStatistics = new TownStatistics();
    }

    @FXML
    private void scrollingTextButtonsOnAction(ActionEvent event) {

        if (event.getSource() == startBtn) {
            Runnable runner = shiftCharRB.isSelected() ? new CharacterScroller() : new WordScroller();

            thread = new Thread(runner);
            thread.setDaemon(true);
            thread.start();

        } else if (event.getSource() == stopBtn) {
            thread.interrupt();
            count = 0;
        }

    }

    @FXML
    private void danishTownButtonsOnAction(ActionEvent event) {

        if (event.getSource() == readFileBtn) {
            townStatistics.readFile("Danske Byer.txt");
            outputTA.appendText("Unsorted: " + townStatistics.toString());
        }
        if (event.getSource() == sortBtn) {
            townStatistics.sort();
            outputTA.appendText("Sorted: " + townStatistics.toString());
        }
        if (event.getSource() == clearBtn) {
            outputTA.clear();
        }

    }

    class CharacterScroller implements Runnable {

        @Override
        public void run() {
            try {
                while (!Thread.interrupted()) {
                    count++;
                    Platform.runLater(new Runnable() {
                        @Override
                        public void run() {

                            char startIndex = inputTF.getText().charAt(0);
                            int endIndex = inputTF.getText().length();
                            String substring = inputTF.getText().substring(1, endIndex) + startIndex;
                            inputTF.setText(substring);
                            updateLabel.setText("char update: " + String.valueOf(count));
                        }
                    });
                    Thread.sleep(sleepTime);
                }

            } catch (InterruptedException ex) {
                Logger.getLogger(Aldus1717VOPReEksamenF18Controller.class.getName()).log(Level.SEVERE, null, ex);

            }

        }

    }

    class WordScroller implements Runnable {

        @Override
        public void run() {
            try {
                while (!Thread.interrupted()) {

                    String[] stringArr = inputTF.getText().split(" ");
                    inputTF.clear();
                    count++;
                    Platform.runLater(new Runnable() {
                        @Override
                        public void run() {

                            for (int i = 1; i < stringArr.length; i++) {
                                inputTF.appendText(stringArr[i] + " ");
                                System.out.println("String[i]: " + stringArr[i] + " ");
                            }
                            inputTF.appendText(stringArr[0] + " ");
                            System.out.println("String[0]: " + stringArr[0] + " ");
                            updateLabel.setText("word update: " + String.valueOf(count));
                        }
                    });
                    Thread.sleep(sleepTime);
                }

            } catch (InterruptedException ex) {
                Logger.getLogger(Aldus1717VOPReEksamenF18Controller.class.getName()).log(Level.SEVERE, null, ex);

            }
        }

    }

}
