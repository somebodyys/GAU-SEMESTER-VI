module com.memorize.project {
    requires javafx.controls;
    requires javafx.fxml;
    requires java.sql;

    opens com.memorize.project to javafx.fxml;
    exports com.memorize.project;
}