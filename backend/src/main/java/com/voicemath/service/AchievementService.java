package com.voicemath.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import com.voicemath.model.Achievement;

@Service
public class AchievementService {

    private final CalculationService calculationService;

    public AchievementService(
            CalculationService calculationService) {

        this.calculationService =
                calculationService;
    }

    public List<Achievement> getAchievements() {

        int calculations =
                calculationService
                        .getAll()
                        .size();

        List<Achievement> badges =
                new ArrayList<>();

        badges.add(
                new Achievement(
                        "🥉 Beginner Solver",
                        "Complete 10 calculations",
                        calculations >= 10));

        badges.add(
                new Achievement(
                        "🥈 Math Explorer",
                        "Complete 50 calculations",
                        calculations >= 50));

        badges.add(
                new Achievement(
                        "🥇 Math Master",
                        "Complete 100 calculations",
                        calculations >= 100));

        return badges;
    }
}