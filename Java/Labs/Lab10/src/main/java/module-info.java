module com.example.lab10 {
    requires javafx.controls;
    requires javafx.fxml;

    requires com.dlsc.formsfx;
    requires org.kordamp.ikonli.javafx;

    opens com.example.lab10 to javafx.fxml;
    exports com.example.lab10;
}