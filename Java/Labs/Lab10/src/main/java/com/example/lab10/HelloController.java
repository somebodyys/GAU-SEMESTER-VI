package com.example.lab10;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

public class HelloController {

    @FXML
    private TextField inputField;

    @FXML
    protected void onOpenBracketClick(){
        inputField.appendText("(");
    }

    @FXML
    protected void onClosingBracketClick(){
        inputField.appendText(")");
    }

    @FXML
    protected void onZeroButtonClick(){
        inputField.appendText("0");
    }
    @FXML
    protected void onOneButtonClick(){
        inputField.appendText("1");
    }
    @FXML
    protected void onTwoButtonClick(){
        inputField.appendText("2");
    }
    @FXML
    protected void onThreeButtonClick(){
        inputField.appendText("3");
    }
    @FXML
    protected void onFourButtonClick(){
        inputField.appendText("4");
    }
    @FXML
    protected void onFiveButtonClick(){
        inputField.appendText("5");
    }
    @FXML
    protected void onSixButtonClick(){
        inputField.appendText("6");
    }
    @FXML
    protected void onSevenButtonClick(){
        inputField.appendText("7");
    }
    @FXML
    protected void onEightButtonClick(){
        inputField.appendText("8");
    }
    @FXML
    protected void onNineButtonClick(){
        inputField.appendText("9");
    }
    @FXML
    protected void onPlusButtonClick(){
        inputField.appendText("+");
    }
    @FXML
    protected void onMinusButtonClick(){
        inputField.appendText("-");
    }
    @FXML
    protected void onMultButtonClick(){
        inputField.appendText("*");
    }
    @FXML
    protected void onDivButtonClick(){
        inputField.appendText("/");
    }
    @FXML
    protected void onEqualsButtonClick(){
        String input = inputField.getText();
        inputField.appendText("=");
        SecondCalculator secondCalculator = new SecondCalculator(input);
        inputField.appendText(Integer.toString(secondCalculator.calculate()));
    }

}