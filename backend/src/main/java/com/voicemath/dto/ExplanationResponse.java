package com.voicemath.dto;

public class ExplanationResponse {

    private String expression;
    private String result;
    private String explanation;

    public ExplanationResponse() {
    }

    public ExplanationResponse(
            String expression,
            String result,
            String explanation) {

        this.expression = expression;
        this.result = result;
        this.explanation = explanation;
    }

    public String getExpression() {
        return expression;
    }

    public void setExpression(String expression) {
        this.expression = expression;
    }

    public String getResult() {
        return result;
    }

    public void setResult(String result) {
        this.result = result;
    }

    public String getExplanation() {
        return explanation;
    }

    public void setExplanation(String explanation) {
        this.explanation = explanation;
    }
}