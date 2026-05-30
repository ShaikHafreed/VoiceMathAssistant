package com.voicemath.controller;

import java.time.LocalDateTime;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.voicemath.dto.QuizAnswerRequest;
import com.voicemath.dto.QuizQuestionResponse;
import com.voicemath.dto.QuizResultResponse;
import com.voicemath.model.LearningProgress;
import com.voicemath.repository.LearningProgressRepository;

@RestController
@RequestMapping("/api/quiz")
@CrossOrigin(origins = "*")
public class QuizController {

    private final LearningProgressRepository repository;

    public QuizController(
            LearningProgressRepository repository) {

        this.repository = repository;
    }

    @GetMapping
    public QuizQuestionResponse getQuestion() {

        return new QuizQuestionResponse(
                "What is 5 + 7 ?");
    }

    @PostMapping("/submit")
    public QuizResultResponse submitAnswer(
            @RequestBody QuizAnswerRequest request) {

        boolean correct =
                "12".equals(
                        request.getAnswer().trim());

        double score =
                correct ? 100 : 0;

        LearningProgress progress =
                new LearningProgress(
                        "Quiz",
                        score,
                        LocalDateTime.now());

        repository.save(progress);

        return new QuizResultResponse(
                correct,
                correct
                        ? "Correct Answer"
                        : "Wrong Answer",
                score);
    }
}