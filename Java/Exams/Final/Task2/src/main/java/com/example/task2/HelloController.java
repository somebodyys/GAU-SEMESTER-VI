package com.example.task2;

import javafx.fxml.FXML;
import javafx.scene.control.Label;

import java.util.Random;

public class HelloController {

    private Player player;

    public HelloController() {
        this.player = new Player(100);
    }

    @FXML
    private Label zeroOne;
    @FXML
    private Label zeroTwo;
    @FXML
    private Label zeroThree;
    @FXML
    private Label zeroFour;
    @FXML
    private Label zeroFive;

    @FXML
    private Label oneOne;
    @FXML
    private Label oneTwo;
    @FXML
    private Label oneThree;
    @FXML
    private Label oneFour;
    @FXML
    private Label oneFive;

    @FXML
    private Label twoOne;
    @FXML
    private Label twoTwo;
    @FXML
    private Label twoThree;
    @FXML
    private Label twoFour;
    @FXML
    private Label twoFive;

    @FXML
    private Label threeOne;
    @FXML
    private Label threeTwo;
    @FXML
    private Label threeThree;
    @FXML
    private Label threeFour;
    @FXML
    private Label threeFive;

    @FXML
    private Label balanceLabel;

    @FXML
    protected void roll() {
        Random random = new Random();
        int sum = 0;
        Label[] myLabels = {
                zeroOne,
                zeroTwo,
                zeroThree,
                zeroFour,
                zeroFive,
                oneOne,
                oneTwo,
                oneThree,
                oneFour,
                oneFive,
                twoOne,
                twoTwo,
                twoThree,
                twoFour,
                twoFive,
                threeOne,
                threeTwo,
                threeThree,
                threeFour,
                threeFive
        };


        for (Label temp: myLabels) {
            int randomNumber = random.nextInt(-20, 35);
            temp.setText(String.valueOf(randomNumber));
            sum += randomNumber;
        }

        if(sum > 100){
            this.player.win(5);
        } else{
            this.player.lose(10);
        }

        balanceLabel.setText(
                String.valueOf(this.player.getBalance())
        );
    }
}