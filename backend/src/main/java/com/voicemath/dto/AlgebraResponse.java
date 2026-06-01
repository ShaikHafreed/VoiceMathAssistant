package com.voicemath.dto;

public class AlgebraResponse {

    private boolean algebra;
    private String variable;
    private String value;

    public AlgebraResponse() {
    }

    public AlgebraResponse(
            boolean algebra,
            String variable,
            String value) {

        this.algebra = algebra;
        this.variable = variable;
        this.value = value;
    }

    public boolean isAlgebra() {
        return algebra;
    }

    public void setAlgebra(
            boolean algebra) {

        this.algebra = algebra;
    }

    public String getVariable() {
        return variable;
    }

    public void setVariable(
            String variable) {

        this.variable = variable;
    }

    public String getValue() {
        return value;
    }

    public void setValue(
            String value) {

        this.value = value;
    }
}