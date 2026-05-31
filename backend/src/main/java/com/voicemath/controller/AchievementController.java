package com.voicemath.controller;

import java.util.List;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.voicemath.model.Achievement;
import com.voicemath.service.AchievementService;

@RestController
@RequestMapping("/api/achievements")
@CrossOrigin(origins = "*")
public class AchievementController {

    private final AchievementService service;

    public AchievementController(
            AchievementService service) {

        this.service = service;
    }

    @GetMapping
    public List<Achievement> getAchievements() {

        return service.getAchievements();
    }
}