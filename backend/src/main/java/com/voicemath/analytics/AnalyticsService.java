package com.voicemath.analytics;

import java.util.List;

import org.springframework.stereotype.Service;

import com.voicemath.model.LearningProgress;

@Service
public class AnalyticsService {

    public String analyze(List<LearningProgress> progress) {

        double avg = progress.stream()
                .mapToDouble(LearningProgress::getScore)
                .average()
                .orElse(0);

        if (avg > 80)
            return "Excellent";

        if (avg > 60)
            return "Good";

        return "Needs Improvement";
    }
}