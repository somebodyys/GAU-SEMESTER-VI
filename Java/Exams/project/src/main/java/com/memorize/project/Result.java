package com.memorize.project;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

import java.sql.*;

public class Result implements Runnable {

    private int id;
    private int score;
    private String note;
    private ObservableList<Detail> details = FXCollections.observableArrayList();


    public ObservableList<Detail> getDetails() {
        return details;
    }

    public Result(int id, int score, String note) {
        this.id = id;
        this.score = score;
        this.note = note;
    }

    public String details(){
        return "SELECT * FROM details WHERE result_id = ?";
    }

    @Override
    public void run() {
        try {
            Connection connection = DriverManager.getConnection(
                    "jdbc:mysql://localhost:3306/java_project", "Tornike", "$33P$yR7&#TGPgGa5rfttZh^#@sPovU4%8ci2jU$"
            );

            PreparedStatement statement = connection.prepareStatement(details());
            statement.setString(1, String.valueOf(this.id));
            ResultSet response = statement.executeQuery();

            details.clear();
            while (response.next()){
                details.add(
                        new Detail(
                                response.getInt("id"),
                                response.getInt("result_id"),
                                response.getInt("question_id"),
                                response.getInt("score"),
                                response.getString("answered")
                        )
                );
            }

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public int getId() {
        return id;
    }

    public int getScore() {
        return score;
    }

    public String getNote() {
        return note;
    }

    public void setScore(int score) {
        this.score = score;
    }

    public void setNote(String note) {
        this.note = note;
    }
}
