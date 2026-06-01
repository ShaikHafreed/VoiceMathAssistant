package com.voicemath.dto;

public class CalculationResponse {

    private String expression;
    private String result;
    private String steps;

    public CalculationResponse() {
    }

    public CalculationResponse(
            String expression,
            String result,
            String steps) {

        this.expression = expression;
        this.result = result;
        this.steps = steps;
    }

    public String getExpression() {
        return expression;
    }

    public void setExpression(
            String expression) {

        this.expression = expression;
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