package com.voicemath.dto;

public class QuizQuestionResponse {

    private String question;

    public QuizQuestionResponse() {
    }

    public QuizQuestionResponse(String question) {
        this.question = question;
    }

    public String getQuestion() {
        return question;
    }

    public void setQuestion(String question) {
        this.question = question;
    }
}