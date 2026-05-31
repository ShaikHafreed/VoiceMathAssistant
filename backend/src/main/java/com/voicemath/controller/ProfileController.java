package com.voicemath.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.voicemath.dto.ProfileResponse;
import com.voicemath.repository.CalculationRepository;
import com.voicemath.repository.LearningProgressRepository;

@RestController
@CrossOrigin(origins = "*")
public class ProfileController {

    private final CalculationRepository calculationRepository;
    private final LearningProgressRepository progressRepository;

    public ProfileController(
            CalculationRepository calculationRepository,
            LearningProgressRepository progressRepository) {

        this.calculationRepository =
                calculationRepository;

        this.progressRepository =
                progressRepository;
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

        String level;

        if (calculations >= 100) {

            level = "Advanced";

        } else if (calculations >= 50) {

            level = "Intermediate";

        } else {

            level = "Beginner";
        }

        List<String> achievements =
                new ArrayList<>();

        if (calculations >= 10) {

            achievements.add(
                    "🥉 Beginner Solver");
        }

        if (calculations >= 50) {

            achievements.add(
                    "🥈 Active Learner");
        }

        if (averageScore >= 80) {

            achievements.add(
                    "🏆 Quiz Master");
        }

        if (calculations >= 100) {

            achievements.add(
                    "🥇 Math Champion");
        }

        return new ProfileResponse(
                "Student",
                level,
                calculations,
                averageScore,
                achievements);
    }
}