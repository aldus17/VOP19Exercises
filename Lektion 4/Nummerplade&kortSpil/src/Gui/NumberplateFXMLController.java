/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Gui;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.RadioButton;
import javafx.scene.control.Tab;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.control.ToggleGroup;
import javax.swing.ButtonGroup;
import opg2_numberplates.NumberPlates;
import opg3_playingcards.DeckOfCards;

/**
 * FXML Controller class
 *
 * @author AleksanderSTUD
 */
public class NumberplateFXMLController implements Initializable {

    @FXML
    private Tab numberPlateTab;
    @FXML
    private Button checkButton;
    @FXML
    private TextField plateTextField;
    @FXML
    private Label resultLabel;
    @FXML
    private Tab playCardTabb;

    @FXML
    private Label enteredPlateLabel;

    @FXML
    private Button mixBtn;
    @FXML
    private RadioButton radiobtn1;
    @FXML
    private RadioButton radiobtn2;
    @FXML
    private RadioButton radiobtn3;
    private ButtonGroup rbgroup;
    @FXML
    private TextArea playCardResultTextArea;

    private NumberPlates nb;
    private DeckOfCards deckOfCards;
    private ToggleGroup toggleGroup;
    @FXML
    private Button sortBtn;

    /**
     * Initializes the controller class.
     *
     * @param url
     * @param rb
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        this.nb = new NumberPlates();
        this.deckOfCards = new DeckOfCards();
        toggleGroup = new ToggleGroup();
        radiobtn1.setToggleGroup(toggleGroup);
        radiobtn2.setToggleGroup(toggleGroup);
        radiobtn3.setToggleGroup(toggleGroup);
        playCardResultTextArea.setText(deckOfCards.toString());

    }

    @FXML
    private void checkOnAction(ActionEvent event) {
        String resultFromTextField = plateTextField.getText();
        String result;
        if (event.getSource() == checkButton) {

            result = nb.validate(resultFromTextField);

            resultLabel.setText(result);
            enteredPlateLabel.setText(resultFromTextField);
            plateTextField.clear();
        }

    }

    @FXML
    private void mixOnActionHandler(ActionEvent event) {

        if (event.getSource() == mixBtn) {
            if (toggleGroup.getSelectedToggle() == radiobtn1) {

                deckOfCards.shuffle(Integer.parseInt(radiobtn1.getText()));
                playCardResultTextArea.setText(deckOfCards.toString());
            } else if (toggleGroup.getSelectedToggle() == radiobtn2) {
                deckOfCards.shuffle(Integer.parseInt(radiobtn2.getText()));
                playCardResultTextArea.setText(deckOfCards.toString());
            } else if (toggleGroup.getSelectedToggle() == radiobtn3) {
                deckOfCards.shuffle(Integer.parseInt(radiobtn3.getText()));
                playCardResultTextArea.setText(deckOfCards.toString());
            }
        }

    }

    @FXML
    private void sortOnAction(ActionEvent event) {
        DeckOfCards sortDeckOfCards = new DeckOfCards();
        if (event.getSource() == sortBtn) {
            playCardResultTextArea.clear();
            playCardResultTextArea.setText(sortDeckOfCards.toString());
        }
    }

}
