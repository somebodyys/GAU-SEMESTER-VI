package com.memorize.project;

public class Detail {

    private int id;
    private int result_id;
    private int question_id;
    private int score;
    private String answered;


    public Detail(int id, int result_id, int question_id, int score, String answered) {
        this.id = id;
        this.result_id = result_id;
        this.question_id = question_id;
        this.score = score;
        this.answered = answered;
    }

    public String getAnswered() {
        return answered;
    }

    public void setAnswered(String answered) {
        this.answered = answered;
    }

    public int getId() {
        return id;
    }

    public int getResult_id() {
        return result_id;
    }

    public void setResult_id(int result_id) {
        this.result_id = result_id;
    }

    public void setQuestion_id(int question_id) {
        this.question_id = question_id;
    }

    public int getQuestion_id() {
        return question_id;
    }

    public int getScore() {
        return score;
    }

    public void setScore(int score) {
        this.score = score;
    }
}
