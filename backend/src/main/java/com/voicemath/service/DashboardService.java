package com.voicemath.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.voicemath.dto.DashboardResponse;
import com.voicemath.model.Calculation;
import com.voicemath.model.LearningProgress;
import com.voicemath.repository.CalculationRepository;
import com.voicemath.repository.LearningProgressRepository;

@Service
public class DashboardService {

    private final CalculationRepository calculationRepository;
    private final LearningProgressRepository progressRepository;

    public DashboardService(
            CalculationRepository calculationRepository,
            LearningProgressRepository progressRepository) {

        this.calculationRepository = calculationRepository;
        this.progressRepository = progressRepository;
    }

    public DashboardResponse getDashboard() {

        List<Calculation> calculations =
                calculationRepository.findAll();

        List<LearningProgress> progressList =
                progressRepository.findAll();

        long totalCalculations =
                calculations.size();

        long totalTopics =
                progressList.size();

        double averageScore =
                progressList.stream()
                        .mapToDouble(
                                LearningProgress::getScore)
                        .average()
                        .orElse(0);

        String performance;

        if (averageScore >= 80) {

            performance = "Excellent";

        } else if (averageScore >= 60) {

            performance = "Good";

        } else {

            performance = "Needs Improvement";
        }

        return new DashboardResponse(
                totalCalculations,
                totalTopics,
                averageScore,
                performance);
    }
}