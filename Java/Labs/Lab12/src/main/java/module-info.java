module com.example.lab12 {
    requires javafx.controls;
    requires javafx.fxml;

    requires com.dlsc.formsfx;
    requires org.kordamp.ikonli.javafx;
    requires java.sql;

    opens com.example.lab12 to javafx.fxml;
    exports com.example.lab12;
}