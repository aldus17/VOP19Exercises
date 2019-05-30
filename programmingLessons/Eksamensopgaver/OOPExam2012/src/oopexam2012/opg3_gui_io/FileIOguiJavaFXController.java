/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package oopexam2012.opg3_gui_io;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.control.ToggleGroup;

/**
 * FXML Controller class
 *
 * @author PCATG
 */
public class FileIOguiJavaFXController implements Initializable {

    @FXML
    private TextArea outputTA;
    @FXML
    private TextField inputTF;
    @FXML
    private RadioButton textRB;
    @FXML
    private RadioButton objectRB;
    @FXML
    private Button writeToFileBtn;
    @FXML
    private Button readFromFileBtn;
    @FXML
    private Button clearBtn;
    @FXML
    private Button exitBtn;
    // other attributes
    private FileIOInterface fileIOInterface;

    private ToggleGroup tg;

    @Override
    public void initialize(URL url, ResourceBundle rb) {

        tg = new ToggleGroup();
        textRB.setToggleGroup(tg);
        objectRB.setToggleGroup(tg);

    }

    @FXML
    private void buttonOnAction(ActionEvent event) {
        if (event.getSource() == writeToFileBtn) {
            if (tg.getSelectedToggle() == textRB) {
                fileIOInterface = new TextFile();
                fileIOInterface.writeToFile(inputTF.getText());
            } else if (tg.getSelectedToggle() == objectRB) {
                fileIOInterface = new ObjFile();
                fileIOInterface.writeToFile(inputTF.getText());
            }
        }
        if (event.getSource() == readFromFileBtn) {
            if (tg.getSelectedToggle() == textRB) {
                fileIOInterface = new TextFile();
                outputTA.appendText(fileIOInterface.readFromFile());
            } else if (tg.getSelectedToggle() == objectRB) {
                fileIOInterface = new ObjFile();
                outputTA.appendText(fileIOInterface.readFromFile());
            }
        }
    }

    @FXML
    private void optButtonsOnAction(ActionEvent event) {
        if (event.getSource() == exitBtn) {
            Platform.exit();
        }
        if (event.getSource() == clearBtn) {
            outputTA.clear();

        }
    }

}
