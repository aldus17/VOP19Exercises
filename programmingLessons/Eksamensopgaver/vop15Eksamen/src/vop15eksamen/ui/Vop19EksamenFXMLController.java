/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package vop15eksamen.ui;

import java.net.URL;
import java.util.Arrays;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.control.ToggleGroup;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import vop15eksamen.facade.Facade;
import vop15eksamen.laundry_facade.LaundrySingleton;

/**
 * FXML Controller class
 *
 * @author AleksanderSTUD
 */
public class Vop19EksamenFXMLController implements Initializable {

    @FXML
    private TextField sizeTextField;
    @FXML
    private TextField maxTextField;
    @FXML
    private TextArea outputLogTextArea;
    @FXML
    private TextField divisorTextField;
    @FXML
    private Button fillArrayButton;
    @FXML
    private Button fillArrayUniqueButton;
    @FXML
    private Button sumOfArrayButton;
    @FXML
    private Button exitButton;
    @FXML
    private AnchorPane rootPane;
    @FXML
    private Button clearOutputButton;
    @FXML
    private RadioButton sixKGRButton;
    @FXML
    private RadioButton twelveKGRButton;
    @FXML
    private RadioButton dryerRButton;
    @FXML
    private TextField progamTextField;
    @FXML
    private TextField outputTextField;
    @FXML
    private Button exitButton1;

    private Facade facade;
    @FXML
    private Button startWashingButton;
    private ToggleGroup tg;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        facade = new Facade();
        LaundrySingleton.getInstance().buildLaundry();
        outputLogTextArea.setEditable(false);
        outputTextField.setEditable(false);

        tg = new ToggleGroup();
        sixKGRButton.setToggleGroup(tg);
        twelveKGRButton.setToggleGroup(tg);
        dryerRButton.setToggleGroup(tg);
    }

    @FXML
    private void buttonActionHandler(ActionEvent event) {
        try {
            if (event.getSource() == fillArrayButton) {
                String fillArrayString = Arrays.toString(
                        facade.fillArray(
                                Integer.valueOf(sizeTextField.getText()),
                                Integer.valueOf(maxTextField.getText())));

                outputLogTextArea.appendText(fillArrayString + "\n");
            } else if (event.getSource() == fillArrayUniqueButton) {
                int[] getIntArray = facade.fillUniqueArray(
                        Integer.valueOf(sizeTextField.getText()),
                        Integer.valueOf(maxTextField.getText()));

                // String fillArrayUniqueString = Arrays.toString(facade.fillUniqueArray(Integer.valueOf(sizeTextField.getText()), Integer.valueOf(maxTextField.getText())));
                if (!(getIntArray == null)) {
                    outputLogTextArea.appendText(Arrays.toString(getIntArray) + "\n");
                } else {
                    outputLogTextArea.appendText("size er større end max!\n");
                }
            } else if (event.getSource() == sumOfArrayButton) {

                String sumDivisor = "Divisor of "
                        + divisorTextField.getText() + " has Sum: "
                        + facade.sumOfDivisors(
                                Integer.valueOf(divisorTextField.getText()));
                outputLogTextArea.appendText(sumDivisor + "\n");

            }
        } catch (NumberFormatException e) {
            outputLogTextArea.appendText("Not a number or missing number value\n");
        }
    }

//    @FXML
//    private void exitButtonHandler(ActionEvent event) {
//        Stage stage = (Stage) rootPane.getScene().getWindow();
//        stage.close();
//    }
    @FXML
    private void operationActionHandler(ActionEvent event) {
        if (event.getSource() == exitButton || event.getSource() == exitButton1) {
            Stage stage = (Stage) rootPane.getScene().getWindow();
            stage.close();
        } else if (event.getSource() == clearOutputButton) {
            outputLogTextArea.clear();
            sizeTextField.clear();
            maxTextField.clear();
            divisorTextField.clear();

        }
    }

    @FXML
    private void radioButtonHandler(ActionEvent event) {

    }

    @FXML
    private void washingButtonHandler(ActionEvent event) {

        int programNumber = 0;
        int machineId;
        try {
            programNumber = Integer.valueOf(progamTextField.getText());

            if (event.getSource() == startWashingButton && tg.getSelectedToggle() == sixKGRButton) {
                machineId = 0;

                String sixKGText1 = LaundrySingleton.getInstance().getProgName(machineId, programNumber);
                String sixKGText2 = String.format("%.2f", LaundrySingleton.getInstance().getPrice(machineId, programNumber));
                outputTextField.setText(sixKGText1 + sixKGText2);

            } else if (event.getSource() == startWashingButton && tg.getSelectedToggle() == twelveKGRButton) {
                machineId = 1;

                String twelveKGText1 = LaundrySingleton.getInstance().getProgName(machineId, programNumber);
                String twelveKGText2 = String.format("%.2f", LaundrySingleton.getInstance().getPrice(machineId, programNumber));

                outputTextField.setText(twelveKGText1 + twelveKGText2);

            } else if (event.getSource() == startWashingButton && tg.getSelectedToggle() == dryerRButton) {
                try {
                    machineId = 2;

                    String dryerText1 = LaundrySingleton.getInstance().getProgName(machineId, programNumber);
                    String dryerText2 = String.format("%.2f", LaundrySingleton.getInstance().getPrice(machineId, programNumber));
                    outputTextField.setText(dryerText1 + dryerText2);
                } catch (Exception e) {
                    outputTextField.setText("Fejl ved læsning af minutter!");
                }
            }
        } catch (NullPointerException e) {
            outputTextField.setText("Maskinen kunne ikke findes eller program ikke defineret");
        } catch (NumberFormatException e) {

            outputTextField.setText("Kun program nummer er tilladt eller Fejl ved læsning af minutter!");
        }
    }

}
