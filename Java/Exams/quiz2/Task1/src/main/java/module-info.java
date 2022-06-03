module com.example.task1 {
    requires javafx.controls;
    requires javafx.fxml;

    requires com.dlsc.formsfx;
    requires org.kordamp.ikonli.javafx;

    opens com.example.task1 to javafx.fxml;
    exports com.example.task1;
}