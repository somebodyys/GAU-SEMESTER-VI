package com.example.task4;

import javafx.beans.NamedArg;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;

import java.net.URL;
import java.sql.*;
import java.util.ResourceBundle;

public class HelloController implements Initializable {

    private Connection connection = DriverManager.getConnection(
            "jdbc:mysql://localhost:3306/java_final", "Tornike", "$33P$yR7&#TGPgGa5rfttZh^#@sPovU4%8ci2jU$"
    );

    @FXML
    private Label statusLabel;
    @FXML
    private TextField nameInput;
    @FXML
    private TextField authorInput;
    @FXML
    private TextField priceInput;
    @FXML
    private DatePicker releaseDateInput;
    @FXML
    private TableView<Book> table;
    @FXML
    private TableColumn<Book, Integer> idColumn;
    @FXML
    private TableColumn<Book, String> nameColumn;
    @FXML
    private TableColumn<Book, String> authorColumn;
    @FXML
    private TableColumn<Book, String> releaseDateColumn;
    @FXML
    private TableColumn<Book, Float> priceColumn;

    ObservableList<Book> books = FXCollections.observableArrayList();

    public HelloController() throws SQLException {
        get();
    }

    @FXML
    protected void save() throws SQLException {
        PreparedStatement statement = connection.prepareStatement(
                "INSERT INTO books(name, author, release_date, price) VALUES (?,?,?,?)"
        );

        statement.setString(1, nameInput.getText());
        statement.setString(2, authorInput.getText());
        statement.setString(3, String.valueOf(releaseDateInput.getValue()));
        statement.setString(4, priceInput.getText());

        statement.executeUpdate();
        statusLabel.setText("Saved!");
        get();
    }

    @FXML
    protected void get() throws SQLException {
        Statement statement = this.connection.createStatement();
        ResultSet response = statement.executeQuery("SELECT * FROM books");

        books.clear();
        while (response.next()){
            books.add(
                    new Book(
                            response.getInt("id"),
                            response.getString("name"),
                            response.getString("author"),
                            response.getString("release_date"),
                            response.getFloat("price")
                    )
            );
        }
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        idColumn.setCellValueFactory(new PropertyValueFactory<>("id"));
        nameColumn.setCellValueFactory(new PropertyValueFactory<>("name"));
        authorColumn.setCellValueFactory(new PropertyValueFactory<>("author"));
        releaseDateColumn.setCellValueFactory(new PropertyValueFactory<>("releaseDate"));
        priceColumn.setCellValueFactory(new PropertyValueFactory<>("price"));

        table.setItems(books);
    }
}