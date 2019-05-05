/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package facadeSingleton;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.control.ToggleGroup;
import opg4_polymorphism.ShapeFacade;

/**
 *
 * @author AleksanderSTUD
 */
public class FXMLDocumentController implements Initializable {

    @FXML
    private RadioButton ellipseRadioButton;
    @FXML
    private RadioButton rectangleRadioButton;
    @FXML
    private RadioButton circleRadioButton;
    @FXML
    private RadioButton squareRadioButton;
    @FXML
    private TextField input1;
    @FXML
    private TextField input2;
    @FXML
    private TextArea informationField;
    @FXML
    private Button getInfoButton;
    
    @FXML
    private ToggleGroup toggleGroupShape;
    @FXML
    private Button clearButton;
    @FXML
    private Label labelPara2;
    @FXML
    private Label labelPara1;

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        ellipseRadioButton.setUserData(ShapeFacade.SHAPES.ELLIPSE);
        rectangleRadioButton.setUserData(ShapeFacade.SHAPES.RECTANGLE);
        circleRadioButton.setUserData(ShapeFacade.SHAPES.CIRCLE);
        squareRadioButton.setUserData(ShapeFacade.SHAPES.SQUERE);
    }

    @FXML
    private void radioButtonOnAction(ActionEvent event) {

        ShapeFacade.SHAPES shape = (ShapeFacade.SHAPES) toggleGroupShape.getSelectedToggle().getUserData();
        if (shape == ShapeFacade.SHAPES.CIRCLE || shape == ShapeFacade.SHAPES.SQUERE) {
            input2.setVisible(false);
            labelPara2.setVisible(false);
        } else {
            input2.setVisible(true);
            labelPara1.setVisible(true);
        }
    }

    @FXML
    private void getInfoOnAction(ActionEvent event) {
        String stringResult = "";
        ShapeFacade.SHAPES shape = (ShapeFacade.SHAPES) toggleGroupShape.getSelectedToggle().getUserData();
        double p1 = Double.valueOf(input1.getText());
        if (shape == ShapeFacade.SHAPES.CIRCLE || shape == ShapeFacade.SHAPES.SQUERE) {

            stringResult = ShapeFacade.getInstance().getShapeInfo(shape, new double[]{p1});
        } else {
            double p2 = Double.valueOf(input2.getText());
            stringResult = ShapeFacade.getInstance().getShapeInfo(shape, new double[]{p1, p2});
        }

        informationField.appendText(stringResult + "\n");
    }

    @FXML
    private void clearButtonOnAction(ActionEvent event) {
        informationField.clear();
    }

}
