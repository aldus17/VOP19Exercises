/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lesson.pkg07.callback.example;

import facade.CallBackInterface;
import facade.FacadeWithCallback;
import java.io.File;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

/**
 *
 * @author erso
 */
public class FXMLDocumentController implements Initializable, CallBackInterface {

    @FXML
    private TextArea textArea;
    @FXML
    private Button startButton;
    @FXML
    private Button stopButton;
    @FXML
    private ImageView die1view;
    @FXML
    private ImageView die2view;

    private FacadeWithCallback facade;
    private Thread t1;

    @Override
    public void initialize(URL url, ResourceBundle rb) {

        startButton.setDisable(false);
        stopButton.setDisable(true);
    }

    @FXML
    private void buttonAction(ActionEvent event) {
        if (event.getSource() == startButton) {

            // Initialize the facade and start it.
            // handle access to the buttons
            facade = new FacadeWithCallback(this);
            facade.start();

            startButton.setDisable(true);
            stopButton.setDisable(false);
            
        } else {
    // Stop the facade
    facade.interrupt();
//    startButton.setDisable(false); // REDUNDANT
//    stopButton.setDisable(true);
        }
    }

    @Override
    public void updateMessage(String message) {
// This is the implementation of the CallBack. Remember it is called fro a Thread!
// append the message to the textArea
        textArea.appendText(message + "\n");
        if (message.equalsIgnoreCase("Over And Out...,")) {
            startButton.setDisable(false);
            stopButton.setDisable(true);
        }
    }

    @Override
    public void updateImages(File i1, File i2) {
// change the pictures on the imageViews
    die1view.setImage(new Image(i1.toURI().toString()));
    die2view.setImage(new Image(i2.toURI().toString()));

    }

}
