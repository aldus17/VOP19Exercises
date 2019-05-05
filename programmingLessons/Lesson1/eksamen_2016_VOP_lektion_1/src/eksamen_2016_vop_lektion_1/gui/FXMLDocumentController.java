/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package eksamen_2016_vop_lektion_1.gui;

import eksamen_2016_vop_lektion_1.AtbashCipher;
import eksamen_2016_vop_lektion_1.CeasarCipher;
import eksamen_2016_vop_lektion_1.CipherInterface;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.RadioButton;
import javafx.scene.control.Spinner;
import javafx.scene.control.SpinnerValueFactory;
import javafx.scene.control.TextField;
import javafx.scene.control.ToggleGroup;

/**
 * FXML Controller class
 *
 * @author AleksanderSTUD
 */
public class FXMLDocumentController implements Initializable {

    private TextField beskedTextField;
    @FXML
    private Spinner<Integer> ceasarSpinner;

    @FXML
    private RadioButton atbashRadioButton;
    @FXML
    private RadioButton ceasarRadioButton;
    @FXML
    private TextField originalTextField;
    @FXML
    private TextField encryptTextField;
    @FXML
    private Button encryptButton;
    @FXML
    private Button decryptButton;
    @FXML
    private TextField decryptTextField;
    private CipherInterface crypterAtbash;
    private CipherInterface crypterCeasar;
    private TextField ceasarText;
    @FXML
    private Button clearTextFieldButton;

    /**
     * Initializes the controller class.
     *
     * @param url
     * @param rb
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        ToggleGroup groupButton = new ToggleGroup();
        atbashRadioButton.setToggleGroup(groupButton);
        ceasarRadioButton.setToggleGroup(groupButton);
        
        
        ceasarSpinner.setValueFactory(new SpinnerValueFactory.IntegerSpinnerValueFactory(
                0, CipherInterface.ALPHABETH.length - 1,
                CipherInterface.ALPHABETH.length / 2));

    }

    @FXML
    private void encryptHandler(ActionEvent event) {
        if (event.getSource() == encryptButton) {

            if (atbashRadioButton.isSelected()) {
                crypterAtbash = new AtbashCipher();
                //encryptedText.setText(crypter.encrypt(originalText.getText()));
                encryptTextField.setText(crypterAtbash.encrypt(originalTextField.getText()));

            } else if (ceasarRadioButton.isSelected()) {
                int keyValue = ceasarSpinner.isVisible() ? ceasarSpinner.getValue() : new Integer(ceasarText.getText());
                crypterCeasar = new CeasarCipher(keyValue);
                encryptTextField.setText(crypterCeasar.encrypt(originalTextField.getText()));
            }
        }
    }

    @FXML
    private void decryptHandler(ActionEvent event) {
        if (event.getSource() == decryptButton) {

            if (atbashRadioButton.isSelected()) {
                crypterAtbash = new AtbashCipher();
                //encryptedText.setText(crypter.encrypt(originalText.getText()));
                decryptTextField.setText(crypterAtbash.decrypt(encryptTextField.getText()));

            } else if (ceasarRadioButton.isSelected()) {
                int keyValue = ceasarSpinner.isVisible() ? ceasarSpinner.getValue() : new Integer(ceasarText.getText());
                crypterCeasar = new CeasarCipher(keyValue);
                decryptTextField.setText(crypterCeasar.decrypt(encryptTextField.getText()));
            }
        }
    }

    @FXML
    private void clearButtonActionHandler(ActionEvent event) {
        if (event.getSource() == clearTextFieldButton) {
            originalTextField.clear();
            encryptTextField.clear();
            decryptTextField.clear();

        }
    }

}
