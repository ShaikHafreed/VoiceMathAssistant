package com.voicemath.dto;

public class TutorResponse {

    private String topic;
    private String explanation;
    private String example;
    private String quiz;

    public TutorResponse() {
    }

    public TutorResponse(
            String topic,
            String explanation,
            String example,
            String quiz) {

        this.topic = topic;
        this.explanation = explanation;
        this.example = example;
        this.quiz = quiz;
    }

    public String getTopic() {
        return topic;
    }

    public void setTopic(String topic) {
        this.topic = topic;
    }

    public String getExplanation() {
        return explanation;
    }

    public void setExplanation(String explanation) {
        this.explanation = explanation;
    }

    public String getExample() {
        return example;
    }

    public void setExample(String example) {
        this.example = example;
    }

    public String getQuiz() {
        return quiz;
    }

    public void setQuiz(String quiz) {
        this.quiz = quiz;
    }
}