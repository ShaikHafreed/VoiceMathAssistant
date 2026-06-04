package com.voicemath.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

@Service
public class RecommendationService {

    public String getTopic(double averageScore) {

        if (averageScore < 40) {
            return "Basic Arithmetic";
        }

        if (averageScore < 60) {
            return "Percentages and Fractions";
        }

        if (averageScore < 80) {
            return "Algebra and Geometry";
        }

        return "Advanced Mathematics";
    }

    public String getReason(double averageScore) {

        if (averageScore < 40) {
            return "Focus on strengthening your mathematical foundation.";
        }

        if (averageScore < 60) {
            return "You are improving. Practice intermediate concepts.";
        }

        if (averageScore < 80) {
            return "Great progress. Start exploring advanced concepts.";
        }

        return "Excellent performance. You are ready for higher-level mathematics.";
    }

    public List<String> getSuggestedTopics(double averageScore) {

        List<String> topics = new ArrayList<>();

        if (averageScore < 40) {

            topics.add("Addition");
            topics.add("Subtraction");
            topics.add("Multiplication");
            topics.add("Division");

        } else if (averageScore < 60) {

            topics.add("Fractions");
            topics.add("Percentages");
            topics.add("Decimals");
            topics.add("Ratios");

        } else if (averageScore < 80) {

            topics.add("Algebra");
            topics.add("Geometry");
            topics.add("Statistics");
            topics.add("Trigonometry");

        } else {

            topics.add("Calculus");
            topics.add("Linear Algebra");
            topics.add("Probability");
            topics.add("Advanced Geometry");
        }

        return topics;
    }
}