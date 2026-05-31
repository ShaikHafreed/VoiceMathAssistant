package com.voicemath.dto;

import java.util.List;

public class ProfileResponse {

    private String studentName;
    private String level;
    private long totalCalculations;
    private double averageScore;
    private List<String> achievements;

    public ProfileResponse() {
    }

    public ProfileResponse(
            String studentName,
            String level,
            long totalCalculations,
            double averageScore,
            List<String> achievements) {

        this.studentName = studentName;
        this.level = level;
        this.totalCalculations = totalCalculations;
        this.averageScore = averageScore;
        this.achievements = achievements;
    }

    public String getStudentName() {
        return studentName;
    }

    public String getLevel() {
        return level;
    }

    public long getTotalCalculations() {
        return totalCalculations;
    }

    public double getAverageScore() {
        return averageScore;
    }

    public List<String> getAchievements() {
        return achievements;
    }
}