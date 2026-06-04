package com.voicemath.controller;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.voicemath.dto.RecommendationResponse;
import com.voicemath.repository.LearningProgressRepository;
import com.voicemath.service.RecommendationService;

@RestController
@RequestMapping("/api/recommendation")
@CrossOrigin(origins = "*")
public class RecommendationController {

    private final LearningProgressRepository repository;
    private final RecommendationService service;

    public RecommendationController(
            LearningProgressRepository repository,
            RecommendationService service) {

        this.repository = repository;
        this.service = service;
    }

    @GetMapping
    public RecommendationResponse getRecommendation() {

        double averageScore =
                repository.findAll()
                        .stream()
                        .mapToDouble(
                                p -> p.getScore())
                        .average()
                        .orElse(0);

return new RecommendationResponse(

        service.getTopic(
                averageScore),

        service.getReason(
                averageScore),

        service.getSuggestedTopics(
                averageScore)
);
    } }