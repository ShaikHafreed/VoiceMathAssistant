package com.voicemath.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

@Service
public class GamificationService {

    public long calculateXP(
            long totalCalculations) {

        return totalCalculations * 10;
    }

    public String calculateLevel(
            long xp) {

        if (xp >= 2000) {

            return "🏆 Grand Master";
        }

        if (xp >= 1000) {

            return "🥇 Master";
        }

        if (xp >= 500) {

            return "🥈 Expert";
        }

        if (xp >= 250) {

            return "🥉 Solver";
        }

        if (xp >= 100) {

            return "⭐ Explorer";
        }

        return "🌱 Beginner";
    }

    public List<String> getAchievements(
            long calculations,
            double averageScore) {

        List<String> achievements =
                new ArrayList<>();

        if (calculations >= 1) {

            achievements.add(
                    "🎯 First Calculation");
        }

        if (calculations >= 10) {

            achievements.add(
                    "🥉 Beginner Solver");
        }

        if (calculations >= 50) {

            achievements.add(
                    "🥈 Active Learner");
        }

        if (calculations >= 100) {

            achievements.add(
                    "🥇 Math Champion");
        }

        if (averageScore >= 80) {

            achievements.add(
                    "🏆 Quiz Master");
        }

        if (averageScore >= 90) {

            achievements.add(
                    "🔥 Elite Performer");
        }

        return achievements;
    }
}