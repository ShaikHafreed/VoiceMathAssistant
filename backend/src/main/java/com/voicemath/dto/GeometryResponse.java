package com.voicemath.dto;

public class GeometryResponse {

    private String shape;
    private String formula;
    private String result;
    private String steps;

    public GeometryResponse() {
    }

    public GeometryResponse(
            String shape,
            String formula,
            String result,
            String steps) {

        this.shape = shape;
        this.formula = formula;
        this.result = result;
        this.steps = steps;
    }

    public String getShape() {
        return shape;
    }

    public void setShape(String shape) {
        this.shape = shape;
    }

    public String getFormula() {
        return formula;
    }

    public void setFormula(String formula) {
        this.formula = formula;
    }

    public String getResult() {
        return result;
    }

    public void setResult(String result) {
        this.result = result;
    }

    public String getSteps() {
        return steps;
    }

    public void setSteps(String steps) {
        this.steps = steps;
    }
}