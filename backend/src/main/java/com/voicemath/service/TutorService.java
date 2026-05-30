package com.voicemath.service;

import org.springframework.stereotype.Service;

@Service
public class TutorService {

    public String teach(String topic) {

        topic = topic.toLowerCase();

        switch (topic) {

            case "percentage":
                return """
                        PERCENTAGES

                        Percentage means "per hundred".

                        Formula:
                        Percentage = (Part / Total) × 100

                        Example:
                        20% of 500

                        = (20 / 100) × 500

                        = 100
                        """;

            case "algebra":
                return """
                        ALGEBRA

                        Algebra uses variables.

                        Example:

                        x + 5 = 10

                        x = 10 - 5

                        x = 5
                        """;

            default:
                return """
                        Topic not found.

                        Available topics:

                        percentage
                        algebra
                        """;
        }
    }
}