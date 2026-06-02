package com.voicemath.dto;

public class GraphAnalysisResponse {

    private String vertex;
    private String axisOfSymmetry;
    private String xIntercepts;
    private String yIntercept;
    private String openingDirection;
    private String steps;

    public GraphAnalysisResponse() {
    }

    public GraphAnalysisResponse(
            String vertex,
            String axisOfSymmetry,
            String xIntercepts,
            String yIntercept,
            String openingDirection,
            String steps) {

        this.vertex = vertex;
        this.axisOfSymmetry = axisOfSymmetry;
        this.xIntercepts = xIntercepts;
        this.yIntercept = yIntercept;
        this.openingDirection = openingDirection;
        this.steps = steps;
    }

    public String getVertex() {
        return vertex;
    }

    public void setVertex(String vertex) {
        this.vertex = vertex;
    }

    public String getAxisOfSymmetry() {
        return axisOfSymmetry;
    }

    public void setAxisOfSymmetry(String axisOfSymmetry) {
        this.axisOfSymmetry = axisOfSymmetry;
    }

    public String getxIntercepts() {
        return xIntercepts;
    }

    public void setxIntercepts(String xIntercepts) {
        this.xIntercepts = xIntercepts;
    }

    public String getyIntercept() {
        return yIntercept;
    }

    public void setyIntercept(String yIntercept) {
        this.yIntercept = yIntercept;
    }

    public String getOpeningDirection() {
        return openingDirection;
    }

    public void setOpeningDirection(String openingDirection) {
        this.openingDirection = openingDirection;
    }

    public String getSteps() {
        return steps;
    }

    public void setSteps(String steps) {
        this.steps = steps;
    }
}