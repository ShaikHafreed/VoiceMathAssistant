package com.voicemath.dto;

import java.util.List;

public class RecommendationResponse {

    private String topic;
    private String reason;
    private List<String> suggestions;

    public RecommendationResponse() {
    }

    public RecommendationResponse(
            String topic,
            String reason,
            List<String> suggestions) {

        this.topic = topic;
        this.reason = reason;
        this.suggestions = suggestions;
    }

    public String getTopic() {
        return topic;
    }

    public void setTopic(String topic) {
        this.topic = topic;
    }

    public String getReason() {
        return reason;
    }

    public void setReason(String reason) {
        this.reason = reason;
    }

    public List<String> getSuggestions() {
        return suggestions;
    }

    public void setSuggestions(
            List<String> suggestions) {

        this.suggestions = suggestions;
    }
}