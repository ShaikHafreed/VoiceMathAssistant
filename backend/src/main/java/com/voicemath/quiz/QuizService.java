package com.voicemath.quiz;

import org.springframework.stereotype.Service;

@Service
public class QuizService {

    public String generateQuiz(String topic) {

        switch (topic.toLowerCase()) {

            case "percentage":
                return """
                Q1: 20% of 200 ?

                A) 20
                B) 40
                C) 60
                D) 80

                Correct Answer: B
                """;

            default:
                return "No Quiz Available";
        }
    }
}