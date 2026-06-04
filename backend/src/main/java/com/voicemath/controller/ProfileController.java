package com.voicemath.controller;

import java.util.List;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.voicemath.dto.ProfileResponse;
import com.voicemath.repository.CalculationRepository;
import com.voicemath.repository.LearningProgressRepository;
import com.voicemath.service.GamificationService;

@RestController
@CrossOrigin(origins = "*")
public class ProfileController {

    private final CalculationRepository calculationRepository;
    private final LearningProgressRepository progressRepository;
    private final GamificationService gamificationService;

    public ProfileController(
            CalculationRepository calculationRepository,
            LearningProgressRepository progressRepository,
            GamificationService gamificationService) {

        this.calculationRepository =
                calculationRepository;

        this.progressRepository =
                progressRepository;

        this.gamificationService =
                gamificationService;
    }

    @GetMapping("/api/profile")
    public ProfileResponse getProfile() {

        long calculations =
                calculationRepository.count();

        double averageScore =
                progressRepository.findAll()
                        .stream()
                        .mapToDouble(
                                p -> p.getScore())
                        .average()
                        .orElse(0);

        averageScore =
                Math.round(
                        averageScore * 100.0)
                        / 100.0;

        long xp =
                gamificationService
                        .calculateXP(
                                calculations);

        String level =
                gamificationService
                        .calculateLevel(
                                xp);

        List<String> achievements =
                gamificationService
                        .getAchievements(
                                calculations,
                                averageScore);

        return new ProfileResponse(
                "Student",
                level,
                calculations,
                averageScore,
                achievements);
    }
}