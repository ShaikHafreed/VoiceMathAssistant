package com.voicemath.dto;

public class StatisticsResponse {

    private String operation;
    private String result;
    private String steps;

    public StatisticsResponse() {
    }

    public StatisticsResponse(
            String operation,
            String result,
            String steps) {

        this.operation = operation;
        this.result = result;
        this.steps = steps;
    }

    public String getOperation() {
        return operation;
    }

    public void setOperation(
            String operation) {
        this.operation = operation;
    }

    public String getResult() {
        return result;
    }

    public void setResult(
            String result) {
        this.result = result;
    }

    public String getSteps() {
        return steps;
    }

    public void setSteps(
            String steps) {
        this.steps = steps;
    }
}