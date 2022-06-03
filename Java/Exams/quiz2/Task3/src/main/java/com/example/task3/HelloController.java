package com.example.task3;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;

import java.sql.*;

public class HelloController {
    @FXML
    private TextField name_input;
    @FXML
    private TextField address_input;
    @FXML
    private TextField phone_input;
    @FXML
    private TextField headmaster_input;
    @FXML
    private TextField delete_id_input;
    @FXML
    private TableView<University> university_table;
    @FXML
    private Label status;
    @FXML
    private TableColumn<University, Integer> id_column;
    @FXML
    private TableColumn<University, String> name_column;
    @FXML
    private TableColumn<University, String> address_column;
    @FXML
    private TableColumn<University, String> phone_column;
    @FXML
    private TableColumn<University, String> headmaster_column;


    private Connection connection = DriverManager.getConnection(
            "jdbc:mysql://localhost:3306/java_quiz_2", "Tornike", "$33P$yR7&#TGPgGa5rfttZh^#@sPovU4%8ci2jU$"
    );

    public HelloController() throws SQLException {
        get();
    }

    @FXML
    protected void save() throws SQLException {
        PreparedStatement statement = connection.prepareStatement(
                "INSERT INTO university(name, address, phone, headmaster) VALUES (?,?,?,?)"
        );

        statement.setString(1, name_input.getText());
        statement.setString(2, address_input.getText());
        statement.setString(3, phone_input.getText());
        statement.setString(4, headmaster_input.getText());

        statement.executeUpdate();
        status.setText("Saved!");
    }

    @FXML
    protected void delete() throws SQLException {
        int id = Integer.parseInt(delete_id_input.getText());

        PreparedStatement statement = connection.prepareStatement(
                "DELETE FROM university WHERE id = ?"
        );

        statement.setInt(1, id);
        statement.executeUpdate();
        status.setText("Deleted!");
    }

    @FXML
    protected void get() throws SQLException {
        Statement statement = this.connection.createStatement();
        ObservableList<University> universities = FXCollections.observableArrayList();
        ResultSet response = statement.executeQuery("SELECT * FROM university");
        while (response.next()){
            universities.add(
                    new University(
                            response.getInt("id"),
                            response.getString("name"),
                            response.getString("address"),
                            response.getString("phone"),
                            response.getString("headmaster")
                    )
            );
        }

        id_column.setCellValueFactory(new PropertyValueFactory<>("id"));
        name_column.setCellValueFactory(new PropertyValueFactory<>("name"));
        address_column.setCellValueFactory(new PropertyValueFactory<>("address"));
        phone_column.setCellValueFactory(new PropertyValueFactory<>("phone"));
        headmaster_column.setCellValueFactory(new PropertyValueFactory<>("headmaster"));
        university_table.setItems(universities);
    }
}