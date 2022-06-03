package com.example.lab12;

import javafx.fxml.FXML;
import javafx.scene.control.*;

import java.sql.*;

public class HelloController {
    @FXML
    private Label welcomeText;
    @FXML
    private ChoiceBox type;
    @FXML
    private ChoiceBox city;
    @FXML
    private ChoiceBox region;
    @FXML
    private ChoiceBox property_type;
    @FXML
    private ToggleGroup room_count;
    @FXML
    private TextField price;
    @FXML
    private ChoiceBox currency;
    @FXML
    private CheckBox email;
    @FXML
    private CheckBox phone;
    @FXML
    private TextArea text;

    @FXML
    protected void onSubmit() throws SQLException {
        Connection connection = DriverManager.getConnection(
                "jdbc:mysql://localhost:3306/java_lab_12", "Tornike", "$33P$yR7&#TGPgGa5rfttZh^#@sPovU4%8ci2jU$"
        );

        PreparedStatement statement = connection.prepareStatement(
                "INSERT INTO statements(type, city, region, property_type,room_count) VALUES (?,?,?,?,?)"
        );

        RadioButton selected = (RadioButton) room_count.getSelectedToggle();
        statement.setString(1, type.getValue().toString());
        statement.setString(2, city.getValue().toString());
        statement.setString(3, region.getValue().toString());
        statement.setString(4, property_type.getValue().toString());
        statement.setInt(5, Integer.parseInt(selected.getText()));

        statement.executeUpdate();
    }
}