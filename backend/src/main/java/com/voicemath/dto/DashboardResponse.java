package com.voicemath.dto;

public class DashboardResponse {

    private long totalCalculations;

    private long totalTopics;

    private double averageScore;

    private String performance;

    public DashboardResponse() {
    }

    public DashboardResponse(
            long totalCalculations,
            long totalTopics,
            double averageScore,
            String performance) {

        this.totalCalculations = totalCalculations;
        this.totalTopics = totalTopics;
        this.averageScore = averageScore;
        this.performance = performance;
    }

    public long getTotalCalculations() {
        return totalCalculations;
    }

    public void setTotalCalculations(long totalCalculations) {
        this.totalCalculations = totalCalculations;
    }

    public long getTotalTopics() {
        return totalTopics;
    }

    public void setTotalTopics(long totalTopics) {
        this.totalTopics = totalTopics;
    }

    public double getAverageScore() {
        return averageScore;
    }

    public void setAverageScore(double averageScore) {
        this.averageScore = averageScore;
    }

    public String getPerformance() {
        return performance;
    }

    public void setPerformance(String performance) {
        this.performance = performance;
    }
}