package com.example.task2;

import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.time.LocalDateTime;
import java.util.Arrays;

public class HelloController {
    @FXML
    private Label status;
    @FXML
    private TextField input;

    @FXML
    protected void calculate() throws IOException {
        try{
            String equation = input.getText();
            if (equation.isEmpty()){
                status.setText("Input Is required!");
            } else {
                String[] operands = equation.split("[+\\-*/]");
                char operator = equation.charAt(
                        equation.indexOf(operands[0]) + operands[0].length()
                );

                int result = evaluate(
                        Integer.parseInt(operands[0]),
                        Integer.parseInt(operands[1]),
                        operator
                );
                save(result);
            }
        } catch (Exception exception){
            status.setText("Not processable Data!");
        }
    }

    /**
     * ატარებს ოპერაციას ორ რიცხვზე
     */
    private int evaluate(int num1, int num2, char operation){
        switch (operation){
            case '+':
                return num1 + num2;
            case '-':
                return num1 - num2;
            case '*':
                return num1 * num2;
            case '/':
                if (num2 == 0)
                    throw new ArithmeticException("No zero allowed!");
                return num1 / num2;
        }

        throw new ArithmeticException("Not supported Operation");
    }

    /**
     * შედეგის ფაილში ჩაწერა დროსთან ერთად
     */
    private void save(int number) throws IOException {
        BufferedWriter bufferedWriter = new BufferedWriter(
                new FileWriter("results.txt", true)
        );

        bufferedWriter.write(
                "Date : " + LocalDateTime.now() + "\nResult = " + number + "\n###########\n"
        );

        bufferedWriter.close();
        status.setText("Saved!");
    }
}