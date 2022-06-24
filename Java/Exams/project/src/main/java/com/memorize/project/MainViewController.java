package com.memorize.project;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;
import java.util.Objects;

public class MainViewController {

    @FXML
    protected void navigateToCollectionPage() throws IOException {
        Stage collectionStage = new Stage();
        Parent root = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("collection-view.fxml")));
        collectionStage.setTitle("My Collection");
        collectionStage.setScene(new Scene(root, 600, 400));
        collectionStage.show();
    }

    @FXML
    protected void navigateToHistoryPage() throws IOException {
        Stage collectionStage = new Stage();
        Parent root = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("results-view.fxml")));
        collectionStage.setTitle("My History");
        collectionStage.setScene(new Scene(root, 600, 400));
        collectionStage.show();
    }

    @FXML
    protected void navigateToQuestionPage() throws IOException {
        Stage collectionStage = new Stage();
        Parent root = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("question-view.fxml")));
        collectionStage.setTitle("Questions");
        collectionStage.setScene(new Scene(root, 600, 330));
        collectionStage.show();
    }
}
