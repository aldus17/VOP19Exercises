package vop15reexamf15;

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
import vop15reexamf15.opg1_facade.SpecialNumbers;
import vop15reexamf15.opg2_polymorphi.CheckerInterface;
import vop15reexamf15.opg2_polymorphi.EvenChecker;
import vop15reexamf15.opg2_polymorphi.IsPowerOf2Checker;
import vop15reexamf15.opg2_polymorphi.NumberCheckerFacade;
import vop15reexamf15.opg2_polymorphi.PrimeChecker;
import vop15reexamf15.opg2_polymorphi.SquareChecker;
import vop15reexamf15.opg4_cards.DeckOfCards;

public class Vop15ReExamF15Controller implements Initializable {

    // opg 1 FXML
    @FXML
    private TextField inNumTextField;
    @FXML
    private Button isEvenButton;
    @FXML
    private Button isPrimeButton;
    @FXML
    private Button isPowerOf2Button;
    @FXML
    private TextField outputNumResultTextField;
    @FXML
    private Button isSquareButton;
    // opg 2 FXML
    @FXML
    private Button clearButton;
    @FXML
    private RadioButton powerOf2RB;
    @FXML
    private RadioButton primeRB;
    @FXML
    private RadioButton evenNumRB;
    @FXML
    private TextField minNumTextField;
    @FXML
    private TextField maxNumTextField;
    @FXML
    private TextArea checkNumberTextArea;
    @FXML
    private RadioButton squareRB;
    // Shuffle cards tab
    @FXML
    private Button specialNumbersExitButton;
    @FXML
    private Button checkNumbersExitButton;
    @FXML
    private AnchorPane rootPane;
    @FXML
    private Button mixBtn;
    @FXML
    private RadioButton radiobtn1;
    @FXML
    private RadioButton radiobtn2;
    @FXML
    private RadioButton radiobtn3;
    @FXML
    private Button sortBtn;
    @FXML
    private TextArea playCardResultTextArea;
    @FXML
    private Button shuffleCardsExitButton1;
    // Other attributes
    private SpecialNumbers specialNumbers;
    private NumberCheckerFacade numberCheckerFacade;
    private ToggleGroup tg1, tg2;
    private DeckOfCards deckOfCards;

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        outputNumResultTextField.setEditable(false);
        specialNumbers = new SpecialNumbers();
        numberCheckerFacade = new NumberCheckerFacade();

        tg1 = new ToggleGroup();
        powerOf2RB.setToggleGroup(tg1);
        primeRB.setToggleGroup(tg1);
        evenNumRB.setToggleGroup(tg1);
        squareRB.setToggleGroup(tg1);

        this.deckOfCards = new DeckOfCards();
        tg2 = new ToggleGroup();
        radiobtn1.setToggleGroup(tg2);
        radiobtn2.setToggleGroup(tg2);
        radiobtn3.setToggleGroup(tg2);
        playCardResultTextArea.setText(deckOfCards.toString());
    }

    @FXML
    private void numberButtonOnAction(ActionEvent event) {

        try {
            int getNum = Integer.valueOf(inNumTextField.getText());
            if (event.getSource() == isEvenButton) {

                if (!specialNumbers.isEven(getNum)) {
                    outputNumResultTextField.setText(String.valueOf(getNum)
                            + " er ikke et lige tal");

                } else {
                    outputNumResultTextField.setText(String.valueOf(getNum)
                            + " er et lige tal");
                }

            } else if (event.getSource() == isPrimeButton) {

                if (!specialNumbers.isPrime(getNum)) {
                    outputNumResultTextField.setText(String.valueOf(getNum)
                            + " er ikke et primtal");

                } else {
                    outputNumResultTextField.setText(String.valueOf(getNum)
                            + " er et primtal");
                }
            } else if (event.getSource() == isPowerOf2Button) {

                if (!specialNumbers.isPowerOf2(getNum)) {
                    outputNumResultTextField.setText(String.valueOf(getNum)
                            + " er ikke potens af 2");

                } else {
                    outputNumResultTextField.setText(String.valueOf(getNum)
                            + " er potens af 2");
                }
            } else if (event.getSource() == isSquareButton) {
                if (!specialNumbers.isSquare(getNum)) {
                    outputNumResultTextField.setText(String.valueOf(getNum)
                            + " er ikke et kvardrattal");

                } else {
                    outputNumResultTextField.setText(String.valueOf(getNum)
                            + " er et kvardrattal");
                }
            }
        } catch (NumberFormatException e) {
            outputNumResultTextField.setText("Not a number or number not entered");
        }

    }

    @FXML
    private void checkNumbersRadioOnAction(ActionEvent event) {
        CheckerInterface checker;
        int min = 0;
        int max = 0;
        try {
            min = Integer.valueOf(minNumTextField.getText());
            max = Integer.valueOf(maxNumTextField.getText());

            if (tg1.getSelectedToggle() == evenNumRB) {
                checker = new EvenChecker();
                checkNumberTextArea.appendText("Even numbers:\n"
                        + Arrays.toString(numberCheckerFacade.checkNumbers(min, max, checker).toArray())
                        + "\n count: " + numberCheckerFacade.getCount() + "\n");
            } else if (tg1.getSelectedToggle() == primeRB) {
                checker = new PrimeChecker();
                checkNumberTextArea.appendText("Prime numbers:\n"
                        + Arrays.toString(numberCheckerFacade.checkNumbers(min, max, checker).toArray())
                        + "\n count: " + numberCheckerFacade.getCount() + "\n");
            } else if (tg1.getSelectedToggle() == powerOf2RB) {
                checker = new IsPowerOf2Checker();
                checkNumberTextArea.appendText("Power of 2 numbers:\n"
                        + Arrays.toString(numberCheckerFacade.checkNumbers(min, max, checker).toArray())
                        + "\n count: " + numberCheckerFacade.getCount() + "\n");
            } else if (tg1.getSelectedToggle() == squareRB) {
                checker = new SquareChecker();
                checkNumberTextArea.appendText("Square numbers:\n"
                        + Arrays.toString(numberCheckerFacade.checkNumbers(min, max, checker).toArray())
                        + "\n count: " + numberCheckerFacade.getCount() + "\n");
            }
        } catch (NumberFormatException e) {
            checkNumberTextArea.appendText("Missing numbers in min/max fields or value is not a number\n");
        }
    }

    @FXML
    private void operationActionHandler(ActionEvent event) {
        if (event.getSource() == clearButton) {
            checkNumberTextArea.clear();
        } else if (event.getSource() == specialNumbersExitButton
                || event.getSource() == checkNumbersExitButton
                || event.getSource() == shuffleCardsExitButton1) {
            Stage stage = (Stage) rootPane.getScene().getWindow();
            stage.close();
        }
    }

    @FXML
    private void mixOnActionHandler(ActionEvent event) {

        if (event.getSource() == mixBtn) {
            if (tg2.getSelectedToggle() == radiobtn1) {

                deckOfCards.shuffle(Integer.parseInt(radiobtn1.getText()));
                playCardResultTextArea.setText(deckOfCards.toString());
            } else if (tg2.getSelectedToggle() == radiobtn2) {
                deckOfCards.shuffle(Integer.parseInt(radiobtn2.getText()));
                playCardResultTextArea.setText(deckOfCards.toString());
            } else if (tg2.getSelectedToggle() == radiobtn3) {
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
