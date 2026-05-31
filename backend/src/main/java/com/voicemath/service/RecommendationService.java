package com.voicemath.service;

import org.springframework.stereotype.Service;

@Service
public class RecommendationService {

    public String getTopic(
            double averageScore) {

        if (averageScore < 40) {

            return "Basic Arithmetic";
        }

        if (averageScore < 60) {

            return "Percentages";
        }

        if (averageScore < 80) {

            return "Algebra";
        }

        return "Advanced Algebra";
    }

    public String getReason(
            double averageScore) {

        if (averageScore < 40) {

            return "You need stronger fundamentals.";
        }

        if (averageScore < 60) {

            return "More practice will improve accuracy.";
        }

        if (averageScore < 80) {

            return "You are progressing well.";
        }

        return "You are ready for advanced topics.";
    }
}