package com.voicemath.dto;

public class AnalyticsResponse {

    private long totalCalculations;
    private double averageScore;
    private long totalAchievements;
    private String performance;

    public AnalyticsResponse() {
    }

    public AnalyticsResponse(
            long totalCalculations,
            double averageScore,
            long totalAchievements,
            String performance) {

        this.totalCalculations = totalCalculations;
        this.averageScore = averageScore;
        this.totalAchievements = totalAchievements;
        this.performance = performance;
    }

    public long getTotalCalculations() {
        return totalCalculations;
    }

    public double getAverageScore() {
        return averageScore;
    }

    public long getTotalAchievements() {
        return totalAchievements;
    }

    public String getPerformance() {
        return performance;
    }
}