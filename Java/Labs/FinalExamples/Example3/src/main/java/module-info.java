module com.example.example3 {
    requires javafx.controls;
    requires javafx.fxml;


    opens com.example.example3 to javafx.fxml;
    exports com.example.example3;
}