/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package searchandreplacefunctionality;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.PrintWriter;
import java.net.URL;
import java.util.ResourceBundle;
import java.util.Scanner;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.stage.FileChooser;
import javafx.stage.FileChooser.ExtensionFilter;
import javafx.stage.Stage;

/**
 *
 * @author AleksanderSTUD
 */
public class FXMLDocumentController implements Initializable {

    @FXML
    private TextField searchTextField;
    @FXML
    private TextField replaceTextField;
    @FXML
    private Button replaceButton;
    @FXML
    private Button saveAsButton;
    @FXML
    private Button openFileButton;
    private FileChooser fileChooser;
    private File file;
    Stage stage;
    @FXML
    private TextArea textArea;

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        stage = new Stage();
        this.file = new File(".");
        fileChooser = new FileChooser();
        fileChooser.setTitle("Open Resource File");

        //File file = new File("src/searchandreplacefunctionality/HelloWorld.txt");
    }

    @FXML
    private void replaceOnAction(ActionEvent event) {
        String textFromSearchField = "", textFromReplaceField = "";

        textFromSearchField = searchTextField.getText();
        textFromReplaceField = replaceTextField.getText();

        textArea.setText(textArea.getText().replaceAll(textFromSearchField, textFromReplaceField));

        searchTextField.clear();
        replaceTextField.clear();
    }

    @FXML
    private void saveAsOnAction(ActionEvent event) {
        String textFromTextArea = textArea.getText();
        File selectedFile = fileChooser.showSaveDialog(stage);
        fileChooser.getExtensionFilters().
                addAll(new ExtensionFilter("TXT files (*.txt)", "*.txt"));

        if (!selectedFile.exists()) {
            try {
                selectedFile.createNewFile();

            } catch (IOException ex) {
                Alert alert = new Alert(Alert.AlertType.ERROR, "Could not create file", new ButtonType("ok"));

            }
        }

        try (PrintWriter writer = new PrintWriter(selectedFile)) {
            writer.println(textFromTextArea);
        } catch (FileNotFoundException ex) {
            Alert alert = new Alert(Alert.AlertType.ERROR, "File not found", new ButtonType("ok"));
        }
        textArea.clear();
    }

    @FXML
    private void openFileOnAction(ActionEvent event) {
        fileChooser.getExtensionFilters().addAll(new ExtensionFilter("TXT files (*.txt)", "*.txt"));
        File selectedFile = fileChooser.showOpenDialog(stage);
        try (Scanner scanFile = new Scanner(selectedFile)) {

            while (scanFile.hasNextLine()) {
                textArea.appendText(scanFile.nextLine() + System.lineSeparator());
            }
        } catch (FileNotFoundException ex) {
            textArea.setText("ERROR - Could not open file (File not found)");
        }
    }

}

//@FXML
//    private void buttonOnAction(ActionEvent event) {
//        String textFromSearchField = "", textFromReplaceField = "";
//        String[] searchLines = null;
//        String[] replaceLines = null;
//
//        if (event.getSource() == replaceButton) {
//            textFromSearchField = searchTextField.getText();
//            textFromReplaceField = replaceTextField.getText();
//
//            searchLines = textFromSearchField.split(" ");
//            replaceLines = textFromReplaceField.split(" ");
//
//            textFromSearchField = searchLines[0];
//            textFromReplaceField = replaceLines[0];
//
//        } else if (event.getSource() == saveAsButton) {
//            fileChooser.setInitialDirectory(file);
//        } else if (event.getSource() == openFileButton) {
//
//            fileChooser.getExtensionFilters().addAll(new ExtensionFilter("All Files", "*.*"));
//            File selectedFile = fileChooser.showOpenDialog(stage);
//
//            try (Scanner scanFile = new Scanner(selectedFile)) {
//
//                while (scanFile.hasNextLine()) {
//
//                    //String setTextField = scanFile.nextLine();
//                    //saveText = setTextField;
//                    textArea.appendText(scanFile.nextLine() + System.getProperty("line.seperator"));
//
//                }
//
//            } catch (FileNotFoundException ex) {
//                Alert alert = new Alert(Alert.AlertType.ERROR);
//            }
//
//        }
//    }
