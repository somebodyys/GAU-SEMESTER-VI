package com.example.example1;

import javafx.fxml.FXML;
import javafx.scene.control.Label;

import java.util.Random;

public class HelloController {
    @FXML
    private Label balanceLabel;

    @FXML
    private Label numberOneLabel;
    @FXML
    private Label numberTwoLabel;
    @FXML
    private Label numberThreeLabel;
    @FXML
    private Label numberFourLabel;
    @FXML
    private Label numberFiveLabel;

    private Player player;

    public HelloController() {
        this.player = new Player(100);
    }

    @FXML
    protected void roll(){
        int positiveCounter= 0, negativeCounter = 0;
        Random random = new Random();
        Label[] myDisplay = {
                numberOneLabel,
                numberTwoLabel,
                numberThreeLabel,
                numberFourLabel,
                numberFiveLabel
        };

        for (Label temp: myDisplay) {
            int tempNumber = random.nextInt(-100, 100);

            if(isPositive(tempNumber)) {
                positiveCounter++;
            }else{
                negativeCounter++;
            }

            temp.setText(String.valueOf(tempNumber));
        }

        if(positiveCounter > negativeCounter){
            player.win(5);
        }else{
            player.lose(5);
        }

        resetBalanceLabel();
    }

    @FXML
    protected void reset(){
        player.setBalance(100);
        resetBalanceLabel();
    }

    private void resetBalanceLabel(){
        balanceLabel.setText(
                String.valueOf(player.getBalance())
        );
    }

    protected boolean isPositive(int number){
        return number >= 0;
    }
}