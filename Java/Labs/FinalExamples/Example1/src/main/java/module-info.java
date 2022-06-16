module com.example.example1 {
    requires javafx.controls;
    requires javafx.fxml;


    opens com.example.example1 to javafx.fxml;
    exports com.example.example1;
}