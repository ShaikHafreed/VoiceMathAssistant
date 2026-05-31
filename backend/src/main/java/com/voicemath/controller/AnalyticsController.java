package com.voicemath.controller;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.voicemath.dto.AnalyticsResponse;
import com.voicemath.repository.CalculationRepository;
import com.voicemath.repository.LearningProgressRepository;

@RestController
@RequestMapping("/api/analytics")
@CrossOrigin(origins = "*")
public class AnalyticsController {

    private final CalculationRepository calculationRepository;
    private final LearningProgressRepository progressRepository;

    public AnalyticsController(
            CalculationRepository calculationRepository,
            LearningProgressRepository progressRepository) {

        this.calculationRepository =
                calculationRepository;

        this.progressRepository =
                progressRepository;
    }

    @GetMapping
    public AnalyticsResponse getAnalytics() {

        long totalCalculations =
                calculationRepository.count();

        double averageScore =
                progressRepository.findAll()
                        .stream()
                        .mapToDouble(
                                p -> p.getScore())
                        .average()
                        .orElse(0);

        long achievements = 0;

        if (totalCalculations >= 10)
            achievements++;

        if (totalCalculations >= 50)
            achievements++;

        if (totalCalculations >= 100)
            achievements++;

        String performance;

        if (averageScore >= 80)
            performance = "Excellent";
        else if (averageScore >= 60)
            performance = "Good";
        else
            performance = "Needs Improvement";

        return new AnalyticsResponse(
                totalCalculations,
                averageScore,
                achievements,
                performance);
    }
}