package com.voicemath.controller;

import java.util.List;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import com.voicemath.model.LearningProgress;
import com.voicemath.service.LearningProgressService;

@RestController
@CrossOrigin(origins = "*")
public class LearningController {

    private final LearningProgressService service;

    public LearningController(
            LearningProgressService service) {

        this.service = service;
    }

    @GetMapping("/api/progress/test")
    public String test() {

        return "Learning Controller Working";
    }

    @PostMapping("/api/progress/{topic}/{score}")
    public LearningProgress saveProgress(

            @PathVariable String topic,

            @PathVariable Double score) {

        return service.saveProgress(
                topic,
                score);
    }

    @GetMapping("/api/progress")
    public List<LearningProgress> getProgress() {

        return service.getAllProgress();
    }
}