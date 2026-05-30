package com.voicemath.dto;

public class OCRMathResponse {

    private String ocrText;
    private String expression;
    private String result;

    public OCRMathResponse() {
    }

    public OCRMathResponse(
            String ocrText,
            String expression,
            String result) {

        this.ocrText = ocrText;
        this.expression = expression;
        this.result = result;
    }

    public String getOcrText() {
        return ocrText;
    }

    public void setOcrText(String ocrText) {
        this.ocrText = ocrText;
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
}