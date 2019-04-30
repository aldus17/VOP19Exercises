/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lektion.pkg11.flashingtext;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.RadioButton;
import javafx.scene.control.ToggleGroup;

/**
 *
 * @author erso
 */
public class FXMLDocumentController implements Initializable {

    @FXML
    private Label funLabel;
    private String text;
    @FXML
    private Button startButton;
    @FXML
    private Button stopButton;
    @FXML   
    private RadioButton toggleBtn100ms;
    @FXML
    private RadioButton toggleBtn200ms;
    @FXML
    private RadioButton toggleBtn400ms;

    private boolean running = true;
    private Thread thread;
    private ToggleGroup tg;

    @Override
    public void initialize(URL url, ResourceBundle rb) {

        this.tg = new ToggleGroup();
        toggleBtn100ms.setToggleGroup(tg);
        toggleBtn200ms.setToggleGroup(tg);
        toggleBtn400ms.setToggleGroup(tg);
        tg.getToggles().forEach(toggle -> {
            Node node = (Node) toggle;
            node.setDisable(true);
        });
    }

    @FXML
    private void btnOnActionHandler(ActionEvent event) {
        if (event.getSource() == startButton) {
            tg.getToggles().forEach(toggle -> {
                Node node = (Node) toggle;
                node.setDisable(false);
            });
            thread = new Thread(new Runnable() {
                @Override
                public void run() {
                    try {
                        while (running) {
                            if (funLabel.getText().trim().length() == 0) {
                                text = "Programming is fun";
                            } else {
                                text = "";
                            }

                            Platform.runLater(new Runnable() {
                                @Override
                                public void run() {
                                    funLabel.setText(text);
                                }
                            });
                            
                            
                            if (toggleBtn100ms.isSelected()) {
                                Thread.sleep(100);
                            } else if (toggleBtn200ms.isSelected()) {
                                Thread.sleep(200);
                            } else if (toggleBtn400ms.isSelected()) {
                                Thread.sleep(400);
                            } else {
                                Thread.sleep(100);
                                toggleBtn100ms.setSelected(true);
                            }

                        }
                    } catch (InterruptedException ex) {
                    }
                }
            });
            thread.setDaemon(true);
            thread.start();
            if (thread.isAlive()) {
                startButton.setDisable(true);
            }
//            startButton.disableProperty().set(true);
        }
        if (event.getSource() == stopButton) {
            if (thread != null) {
                thread.interrupt();
                thread = null;
                funLabel.setText("Welcome");
                tg.getSelectedToggle().setSelected(false);
                startButton.disableProperty().set(false);
                tg.getToggles().forEach(toggle -> {
                    Node node = (Node) toggle;
                    node.setDisable(true);
                });
            }
        }
    }
}
