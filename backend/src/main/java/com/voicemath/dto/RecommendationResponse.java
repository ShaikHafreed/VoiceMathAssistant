package com.voicemath.dto;

public class RecommendationResponse {

    private String topic;
    private String reason;

    public RecommendationResponse() {
    }

    public RecommendationResponse(
            String topic,
            String reason) {

        this.topic = topic;
        this.reason = reason;
    }

    public String getTopic() {
        return topic;
    }

    public String getReason() {
        return reason;
    }
}