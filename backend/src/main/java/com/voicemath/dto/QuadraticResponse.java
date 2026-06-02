package com.voicemath.dto;

public class QuadraticResponse {

    private String root1;
    private String root2;
    private String steps;

    public QuadraticResponse() {
    }

    public QuadraticResponse(
            String root1,
            String root2,
            String steps) {

        this.root1 = root1;
        this.root2 = root2;
        this.steps = steps;
    }

    public String getRoot1() {
        return root1;
    }

    public void setRoot1(String root1) {
        this.root1 = root1;
    }

    public String getRoot2() {
        return root2;
    }

    public void setRoot2(String root2) {
        this.root2 = root2;
    }

    public String getSteps() {
        return steps;
    }

    public void setSteps(String steps) {
        this.steps = steps;
    }
}