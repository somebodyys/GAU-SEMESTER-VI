package com.memorize.project;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

import java.net.URL;
import java.sql.*;
import java.util.ArrayList;
import java.util.Objects;
import java.util.Random;
import java.util.ResourceBundle;

public class QuestionViewController implements Initializable {

    private final Connection connection = DriverManager.getConnection(
            "jdbc:mysql://localhost:3306/java_project", "Tornike", "$33P$yR7&#TGPgGa5rfttZh^#@sPovU4%8ci2jU$"
    );

    private ArrayList<Question> randomQuestions = new ArrayList<>();
    private int currentIndex = 0;
    private boolean finished = false;
    private ArrayList<String[]> myAnswers = new ArrayList<>();

    @FXML
    private Label scoreLabel;
    @FXML
    private Label questionLabel;
    @FXML
    private TextField answerInput;
    @FXML
    private Button answerButton;
    @FXML
    private TextField noteInput;

    public QuestionViewController() throws SQLException {
        get();
    }

    @FXML
    protected void get() throws SQLException {
        Random random = new Random();
        PreparedStatement statement = connection.prepareStatement(
                "SELECT * FROM questions ORDER BY RAND() LIMIT ?"
        );

        statement.setInt(1, random.nextInt(5, 15));
        ResultSet response = statement.executeQuery();

        while (response.next()){
            randomQuestions.add(
                    new Question(
                            response.getInt("id"),
                            response.getString("question"),
                            response.getString("answer"),
                            response.getInt("score")
                    )
            );
        }
    }

    @FXML
    protected void answer() throws SQLException {
        if (finished){
            finished = false;
            answerButton.setText("Answer");
            currentIndex = 0;
        }
        processAnswer();
        getNextQuestion();
    }

    private void processAnswer(){
        Question myCurrentQuestion = randomQuestions.get(currentIndex);
        int tempScore = Objects.equals(answerInput.getText(), myCurrentQuestion.getAnswer())
                ? myCurrentQuestion.getScore() : 0;
        scoreLabel.setText(
                String.valueOf(Integer.parseInt(scoreLabel.getText()) + tempScore)
        );
        String[] temp = {
                String.valueOf(myCurrentQuestion.getId()),
                String.valueOf(tempScore),
                answerInput.getText()
        };
        myAnswers.add(temp);
    }

    private void getNextQuestion() throws SQLException {
        if(randomQuestions.size() - 1 > currentIndex){
            currentIndex++;
            questionLabel.setText(randomQuestions.get(currentIndex).getQuestion());
            answerInput.setText("");
        } else {
            int resultId = saveResult();
            saveDetails(resultId);
            questionLabel.setText("Well Done! That's all for now");
            answerButton.setText("Start Over");
            answerInput.setText("");
            noteInput.setText("");
            finished = true;
            myAnswers.clear();
            scoreLabel.setText("0");
            randomQuestions.clear();
            get();
        }
    }

    private int saveResult() throws SQLException {
        PreparedStatement statement = connection.prepareStatement(
                "INSERT INTO results(score, note) VALUES (?,?)"
        );
        statement.setInt(1, Integer.parseInt(scoreLabel.getText()));
        statement.setString(2, noteInput.getText());
        statement.executeUpdate();


        statement = connection.prepareStatement(
                "SELECT LAST_INSERT_ID() as result_id"
        );
        ResultSet response = statement.executeQuery();

        if(response.next()){
            return response.getInt("result_id");
        }

        return -1;
    }

    private void saveDetails(int result_id) throws SQLException {

        for (String[] temp:myAnswers) {
            PreparedStatement statement = connection.prepareStatement(
                    "INSERT INTO details(result_id, question_id, score, answered) VALUES (?,?,?,?)"
            );
            statement.setInt(1, result_id);
            statement.setInt(2, Integer.parseInt(temp[0]));
            statement.setInt(3, Integer.parseInt(temp[1]));
            statement.setString(4, temp[2]);
            statement.executeUpdate();
        }
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        questionLabel.setText(randomQuestions.get(currentIndex).getQuestion());
        scoreLabel.setText("0");
    }
}
