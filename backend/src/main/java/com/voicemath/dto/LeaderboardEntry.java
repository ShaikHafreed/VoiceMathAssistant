package com.voicemath.dto;

public class LeaderboardEntry {

    private int rank;
    private String studentName;
    private Double score;

    public LeaderboardEntry() {
    }

    public LeaderboardEntry(
            int rank,
            String studentName,
            Double score) {

        this.rank = rank;
        this.studentName = studentName;
        this.score = score;
    }

    public int getRank() {
        return rank;
    }

    public void setRank(int rank) {
        this.rank = rank;
    }

    public String getStudentName() {
        return studentName;
    }

    public void setStudentName(String studentName) {
        this.studentName = studentName;
    }

    public Double getScore() {
        return score;
    }

    public void setScore(Double score) {
        this.score = score;
    }
}