package com.voicemath.dto;

public class CalculationRequest {

    private String speech;

    public CalculationRequest() {
    }

    public CalculationRequest(String speech) {
        this.speech = speech;
    }

    public String getSpeech() {
        return speech;
    }

    public void setSpeech(String speech) {
        this.speech = speech;
    }
}