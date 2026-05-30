package com.voicemath.analytics;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.voicemath.model.LearningProgress;
import com.voicemath.service.LearningProgressService;

@RestController
public class AnalyticsController {

    private final AnalyticsService analyticsService;
    private final LearningProgressService progressService;

    public AnalyticsController(
            AnalyticsService analyticsService,
            LearningProgressService progressService) {

        this.analyticsService = analyticsService;
        this.progressService = progressService;
    }

    @GetMapping("/api/analytics")
    public String analytics() {

        List<LearningProgress> progress =
                progressService.getAllProgress();

        return analyticsService.analyze(progress);
    }
}