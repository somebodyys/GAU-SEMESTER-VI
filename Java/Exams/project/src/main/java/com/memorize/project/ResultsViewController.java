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

public class ResultsViewController implements Initializable {
    private final Connection connection = DriverManager.getConnection(
            "jdbc:mysql://localhost:3306/java_project", "Tornike", "$33P$yR7&#TGPgGa5rfttZh^#@sPovU4%8ci2jU$"
    );
    @FXML
    private TableView<Result> resultsTable;
    @FXML
    private TableColumn<Result, Integer> idColumnResults;
    @FXML
    private TableColumn<Result, Integer> scoreColumnResults;
    @FXML
    private TableColumn<Result, String> noteColumnResults;

    @FXML
    private TableView<Detail> detailsTable;
    @FXML
    private TableColumn<Detail, Integer> idColumnDetails;
    @FXML
    private TableColumn<Detail, Integer> questionIdColumnDetails;
    @FXML
    private TableColumn<Detail, String> answeredColumnDetails;
    @FXML
    private TableColumn<Detail, Integer> scoreColumnDetails;
    
    @FXML
    private TextField idInput;

    Result myResult = null;


    ObservableList<Result> results = FXCollections.observableArrayList();
    ObservableList<Detail> details = FXCollections.observableArrayList();

    public ResultsViewController() throws SQLException {
        get();
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        idColumnResults.setCellValueFactory(new PropertyValueFactory<>("id"));
        scoreColumnResults.setCellValueFactory(new PropertyValueFactory<>("score"));
        noteColumnResults.setCellValueFactory(new PropertyValueFactory<>("note"));

        idColumnDetails.setCellValueFactory(new PropertyValueFactory<>("id"));
        questionIdColumnDetails.setCellValueFactory(new PropertyValueFactory<>("question_id"));
        scoreColumnDetails.setCellValueFactory(new PropertyValueFactory<>("score"));
        answeredColumnDetails.setCellValueFactory(new PropertyValueFactory<>("answered"));

        detailsTable.setItems(details);
        resultsTable.setItems(results);
    }

    @FXML
    protected void get() throws SQLException {
        Statement statement = this.connection.createStatement();
        ResultSet response = statement.executeQuery("SELECT * FROM results");

        results.clear();
        while (response.next()){
            results.add(
                    new Result(
                            response.getInt("id"),
                            response.getInt("score"),
                            response.getString("note")
                    )
            );
        }
    }

    @FXML
    protected void load() throws SQLException {
        PreparedStatement statement = connection.prepareStatement(
                "SELECT * FROM results WHERE id = ?"
        );

        statement.setString(1, idInput.getText());
        ResultSet response = statement.executeQuery();

        if (response.next()){
             myResult = new Result(
                    response.getInt("id"),
                    response.getInt("score"),
                    response.getString("note")
            );
            
            myResult.run();
        }

        displayDetails();
    }

    private void displayDetails(){

        if (myResult != null){
            details = myResult.getDetails();
            detailsTable.setItems(details);
        }
    }
}
