package com.example.task1;

import javafx.fxml.FXML;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;

import java.util.Random;

public class HelloController {
    @FXML
    private ChoiceBox language;
    @FXML
    private TextField word_count;
    @FXML
    private TextArea random_text;
    @FXML
    private Label error;

    private final char[] georgian = {
            'ა', 'ბ', 'გ', 'დ', 'ე', 'ვ', 'ზ', 'თ', 'ი', 'კ', 'ლ', 'მ', 'ნ', 'ო', 'პ', 'ჟ','რ', 'ს','ტ', 'უ', 'ფ', 'ქ','ღ','ყ','შ','ჩ','ც','ძ','წ','ჭ','ხ','ჯ','ჰ'
    };

    private final char[] english = {
            'a','b','c','d','e','f','g','h','i','j','k','l','m','n','o','p','q','r','s','t','u','v','w','x','y','z'
    };

    @FXML
    protected void generate() {
        StringBuilder result = new StringBuilder();
        String lang = language.getValue().toString();
        String words = word_count.getText();
        Random random = new Random();

        try{
            int words_count = Integer.parseInt(words);
            error.setText("");

            for (int i = 0; i < words_count; i++) {
                StringBuilder tempWord = new StringBuilder();
                int charCount = random.nextInt(4, 10);
                for (int j = 0; j < charCount; j++) {
                    int index;
                    switch (lang) {
                        case "ქართული" -> {
                            index = random.nextInt(0, georgian.length);
                            tempWord.append(georgian[index]);
                        }
                        case "english" -> {
                            index = random.nextInt(0, english.length);
                            tempWord.append(english[index]);
                        }
                    }
                }

                result.append(tempWord).append(" ");
            }
            random_text.setText(result.toString());
        }catch (NumberFormatException exception){
            error.setText("Must Be digit!");
        }
    }
}