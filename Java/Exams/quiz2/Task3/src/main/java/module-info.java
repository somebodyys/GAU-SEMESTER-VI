module com.example.task3 {
    requires javafx.controls;
    requires javafx.fxml;
    requires java.sql;


    opens com.example.task3 to javafx.fxml;
    exports com.example.task3;
}