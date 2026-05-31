package com.voicemath.controller;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.voicemath.dto.StudyPlanResponse;
import com.voicemath.repository.LearningProgressRepository;
import com.voicemath.service.StudyPlanService;

@RestController
@RequestMapping("/api/study-plan")
@CrossOrigin(origins = "*")
public class StudyPlanController {

    private final LearningProgressRepository repository;
    private final StudyPlanService service;

    public StudyPlanController(
            LearningProgressRepository repository,
            StudyPlanService service) {

        this.repository = repository;
        this.service = service;
    }

    @GetMapping
    public StudyPlanResponse getPlan() {

        double averageScore =
                repository.findAll()
                        .stream()
                        .mapToDouble(
                                p -> p.getScore())
                        .average()
                        .orElse(0);

        return new StudyPlanResponse(
                service.generatePlan(
                        averageScore));
    }
}