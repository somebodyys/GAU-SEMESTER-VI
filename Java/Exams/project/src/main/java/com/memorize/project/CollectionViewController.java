package com.memorize.project;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;

import java.net.URL;
import java.sql.*;
import java.util.ResourceBundle;

public class CollectionViewController implements Initializable {

    private final Connection connection = DriverManager.getConnection(
            "jdbc:mysql://localhost:3306/java_project", "Tornike", "$33P$yR7&#TGPgGa5rfttZh^#@sPovU4%8ci2jU$"
    );

    ObservableList<Question> questions = FXCollections.observableArrayList();
    Question loadedQuestion = null;

    @FXML
    private TableView<Question> collectionTable;
    @FXML
    private TableColumn<Question, Integer> idColumn;
    @FXML
    private TableColumn<Question, String> questionColumn;
    @FXML
    private TableColumn<Question, String> answerColumn;
    @FXML
    private TableColumn<Question, String> scoreColumn;

    @FXML
    private TextField idInput;
    @FXML
    private TextField questionInput;
    @FXML
    private TextField answerInput;
    @FXML
    private TextField scoreInput;


    public CollectionViewController() throws SQLException {
        get();
    }

    @FXML
    protected void get() throws SQLException {
        Statement statement = this.connection.createStatement();
        ResultSet response = statement.executeQuery("SELECT * FROM questions");

        questions.clear();
        while (response.next()){
            questions.add(
                    new Question(
                            response.getInt("id"),
                            response.getString("question"),
                            response.getString("answer"),
                            response.getInt("score")
                    )
            );
        }
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        idColumn.setCellValueFactory(new PropertyValueFactory<>("id"));
        questionColumn.setCellValueFactory(new PropertyValueFactory<>("question"));
        answerColumn.setCellValueFactory(new PropertyValueFactory<>("answer"));
        scoreColumn.setCellValueFactory(new PropertyValueFactory<>("score"));

        collectionTable.setItems(questions);
    }

    @FXML
    protected void create() throws SQLException {
        PreparedStatement statement = connection.prepareStatement(
                "INSERT INTO questions(question, answer, score) VALUES (?,?,?)"
        );

        statement.setString(1, questionInput.getText());
        statement.setString(2, answerInput.getText());
        statement.setString(3, scoreInput.getText());

        statement.executeUpdate();
        get();
        clearInputs();
    }
    @FXML
    protected void update() throws SQLException {
        if (loadedQuestion != null){
            PreparedStatement statement = connection.prepareStatement(
                    "UPDATE questions SET question = ?, answer = ?, score = ? WHERE id = ?"
            );

            statement.setString(1, questionInput.getText());
            statement.setString(2, answerInput.getText());
            statement.setInt(3, Integer.parseInt(scoreInput.getText()));
            statement.setInt(4, loadedQuestion.getId());
            statement.executeUpdate();
        }

        get();
        clearInputs();
    }
    @FXML
    protected void delete() throws SQLException {
        if (loadedQuestion != null){
            PreparedStatement statement = connection.prepareStatement(
                    "DELETE FROM questions WHERE id = ?"
            );

            statement.setString(
                    1,
                    String.valueOf(loadedQuestion.getId())
            );

            statement.executeUpdate();
        }

        get();
        clearInputs();
    }

    @FXML
    protected void load() throws SQLException {

        PreparedStatement statement = connection.prepareStatement(
                "SELECT * FROM questions WHERE id = ?"
        );

        statement.setString(1, idInput.getText());
        ResultSet response = statement.executeQuery();

        if (response.next()){
            loadedQuestion = new Question(
                    response.getInt("id"),
                    response.getString("question"),
                    response.getString("answer"),
                    response.getInt("score")
            );
        }

        setInputs(loadedQuestion);
    }

    private void setInputs(Question question){
        idInput.setText(String.valueOf(question.getId()));
        questionInput.setText(question.getQuestion());
        answerInput.setText(question.getAnswer());
        scoreInput.setText(String.valueOf(question.getScore()));
    }

    private void clearInputs(){
        idInput.setText("");
        questionInput.setText("");
        answerInput.setText("");
        scoreInput.setText("");
    }
}
