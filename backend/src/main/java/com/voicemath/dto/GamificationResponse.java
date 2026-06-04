package com.voicemath.dto;

import java.util.List;

public class GamificationResponse {

    private long xp;
    private String level;
    private List<String> achievements;

    public GamificationResponse() {
    }

    public GamificationResponse(
            long xp,
            String level,
            List<String> achievements) {

        this.xp = xp;
        this.level = level;
        this.achievements = achievements;
    }

    public long getXp() {
        return xp;
    }

    public void setXp(long xp) {
        this.xp = xp;
    }

    public String getLevel() {
        return level;
    }

    public void setLevel(String level) {
        this.level = level;
    }

    public List<String> getAchievements() {
        return achievements;
    }

    public void setAchievements(
            List<String> achievements) {

        this.achievements = achievements;
    }
}