/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package aldus17_ta_2;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;

/**
 *
 * @author AleksanderStationaer
 */
public class FXMLDocumentController implements Initializable {

    @FXML
    private Button producerBtn;
    @FXML
    private TextField producersTextField;
    @FXML
    private TextField consumerTextField;
    @FXML
    private ListView<CharBuffer> listView;
    private ObservableList<CharBuffer> obs;
    @FXML
    private TextField tf1;
    @FXML
    private TextField tf2;
    @FXML
    private TextField tf3;
    @FXML
    private TextField tf4;
    @FXML
    private TextField tf5;

    @Override
    public void initialize(URL url, ResourceBundle rb) {

    }

    @FXML
    private void producerButtonOnAction(ActionEvent event) {

    }

    @FXML
    private void textFieldsOnAction(ActionEvent event) {

    }

}
