package com.voicemath.dto;

public class QuizResultResponse {

    private boolean correct;

    private String message;

    private double score;

    public QuizResultResponse() {
    }

    public QuizResultResponse(
            boolean correct,
            String message,
            double score) {

        this.correct = correct;
        this.message = message;
        this.score = score;
    }

    public boolean isCorrect() {
        return correct;
    }

    public void setCorrect(boolean correct) {
        this.correct = correct;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public double getScore() {
        return score;
    }

    public void setScore(double score) {
        this.score = score;
    }
}