/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package vopexam2014;

import arrays.ArrayTester;
import java.net.URL;
import java.util.ResourceBundle;
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
import poly_and_strings.FlipUpperLowerManip;
import poly_and_strings.StringManipulable;
import poly_and_strings.ToLowerManip;
import poly_and_strings.ToUpperManip;
import urban_population.UrbanPopulationStatistics;

/**
 *
 * @author PCATG
 */
public class vopExam2014Controller implements Initializable {

    // Poly And String
    @FXML
    private Label label;
    @FXML
    private TextField inputPolyAndStringTF;
    @FXML
    private RadioButton upperCaseBtn;
    @FXML
    private RadioButton lowerCaseBtn;
    @FXML
    private RadioButton flipCaseBtn;
    @FXML
    private TextArea outputPolyAndStringTA;
    @FXML
    private Button polyAndStringExitBtn;
    @FXML
    private Button polyAndStringClearBtn;
    // ArrayTest
    @FXML
    private TextArea outputArrayTestTA;
    @FXML
    private Button fillBtn;
    @FXML
    private Button sortBtn;
    @FXML
    private Button reverseBtn;
    @FXML
    private TextField inputArrayTestTF;
    @FXML
    private Button arrayTestExitBtn;
    @FXML
    private Button arrayTestClearBtn;
    // UrbanPopulation
    @FXML
    private TextArea outputUrbanTA;
    @FXML
    private Button urbanExitBtn;
    @FXML
    private Button urbanClearBtn;
    @FXML
    private Button runBtn;
    // Other attributes
    private Button convertBtn;
    private StringManipulable stringManipulable;
    private ToggleGroup tg;
    private ArrayTester arrayTester;
    private UrbanPopulationStatistics urbanPopulationStatistics;

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        tg = new ToggleGroup();
        upperCaseBtn.setToggleGroup(tg);
        lowerCaseBtn.setToggleGroup(tg);
        flipCaseBtn.setToggleGroup(tg);

    }

    @FXML
    private void radioButtonHandler(ActionEvent event) {
        if (tg.getSelectedToggle() == upperCaseBtn) {
            stringManipulable = new ToUpperManip(inputPolyAndStringTF.getText());
            outputPolyAndStringTA.setText(stringManipulable.manip());
        }
        if (tg.getSelectedToggle() == lowerCaseBtn) {
            stringManipulable = new ToLowerManip(inputPolyAndStringTF.getText());
            outputPolyAndStringTA.setText(stringManipulable.manip());
        }
        if (tg.getSelectedToggle() == flipCaseBtn) {
            stringManipulable = new FlipUpperLowerManip(inputPolyAndStringTF.getText());
            outputPolyAndStringTA.setText(stringManipulable.manip());
        }
    }

    @FXML
    private void arrayTestButtonOnAction(ActionEvent event) {
        if (event.getSource() == fillBtn) {
            try {

                arrayTester = new ArrayTester(
                        Integer.valueOf(inputArrayTestTF.getText()));
                outputArrayTestTA.appendText("Array filled: " + arrayTester.toString());
            } catch (NumberFormatException e) {
                outputArrayTestTA.appendText("\nNot a number\n");
            }
        }
        if (event.getSource() == sortBtn) {
            arrayTester.sort();
            outputArrayTestTA.appendText("Sorted: " + arrayTester.toString());

        }
        if (event.getSource() == reverseBtn) {
            arrayTester.reverse();
            outputArrayTestTA.appendText("Reversed: " + arrayTester.toString());
        }
    }

    @FXML
    private void urbanBtnOnAction(ActionEvent event) {
        if (event.getSource() == runBtn) {
            urbanPopulationStatistics = new UrbanPopulationStatistics("ByBefolkning.txt");
            outputUrbanTA.setText(urbanPopulationStatistics.toString());
        }
    }

    @FXML
    private void optActionHandler(ActionEvent event) {
        if (event.getSource() == arrayTestExitBtn
                || event.getSource() == polyAndStringExitBtn
                || event.getSource() == urbanExitBtn) {
            Platform.exit();
        }
        if (event.getSource() == arrayTestClearBtn) {
            outputArrayTestTA.clear();
        } else if (event.getSource() == polyAndStringClearBtn) {
            outputPolyAndStringTA.clear();
        } else if (event.getSource() == urbanClearBtn) {
            outputUrbanTA.clear();
        }
    }

}
