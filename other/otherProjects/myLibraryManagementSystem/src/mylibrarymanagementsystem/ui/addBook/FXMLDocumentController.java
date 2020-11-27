/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mylibrarymanagementsystem.ui.addBook;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXTextField;
import java.net.URL;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import mylibrarymanagementsystem.database.DatabaseHandler;

/**
 *
 * @author PCATG
 */
public class FXMLDocumentController implements Initializable {
    
    // FXML Overrides
    @FXML
    private JFXTextField bookTitelTxtField;
    @FXML
    private JFXTextField bookIDTxtField;
    @FXML
    private JFXTextField bookAuthorTxtField;
    @FXML
    private JFXTextField bookPublisherTxtField;
    @FXML
    private JFXButton bookSaveButton;
    @FXML
    private JFXButton bookCancelButton;
    @FXML
    private AnchorPane rootPane;
    
    // Other attributes
    DatabaseHandler databaseHandler;

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        databaseHandler = new DatabaseHandler();

        checkData();
    }

    @FXML
    private void addBook(ActionEvent event) {
        String bookID = bookIDTxtField.getText();
        String bookAuthor = bookAuthorTxtField.getText();
        String bookName = bookTitelTxtField.getText();
        String bookPublisher = bookPublisherTxtField.getText();

        if (bookID.isEmpty()
                || bookAuthor.isEmpty()
                || bookName.isEmpty()
                || bookPublisher.isEmpty()) {
            Alert alertMessage = new Alert(Alert.AlertType.ERROR);
            alertMessage.setHeaderText(null);
            alertMessage.setContentText("FEJL: Udfyld venligst alle felter");
            alertMessage.showAndWait();
            return;
        }
        String action = "INSERT INTO BOOK VALUES ("
                + "'" + bookID + "',"
                + "'" + bookName + "',"
                + "'" + bookAuthor + "',"
                + "'" + bookPublisher + "',"
                + "" + true + ""
                + ")";
        System.out.println(action);

        if (databaseHandler.execAction(action)) {
            Alert alertMessage = new Alert(Alert.AlertType.INFORMATION);
            alertMessage.setHeaderText(null);
            alertMessage.setContentText("Success");
            alertMessage.showAndWait();
        } else {    // ERROR
            Alert alertMessage = new Alert(Alert.AlertType.ERROR);
            alertMessage.setHeaderText(null);
            alertMessage.setContentText("Fejlede ved tilføjelse");
            alertMessage.showAndWait();
        }
    }

    @FXML
    private void cancelAdd(ActionEvent event) {
        Stage stage = (Stage) rootPane.getScene().getWindow();
        stage.close();
    }

    private void checkData() {
        String query = "SELECT title FROM BOOK";
        ResultSet resultSet = databaseHandler.execQuery(query);
        try {
            while (resultSet.next()) {
                String titleText = resultSet.getString("title");
                System.out.println(titleText);
            }
        } catch (SQLException ex) {
            Logger.getLogger(FXMLDocumentController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

}
