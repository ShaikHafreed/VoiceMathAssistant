package com.voicemath.service;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.stereotype.Service;

import com.voicemath.model.LearningProgress;
import com.voicemath.repository.LearningProgressRepository;

@Service
public class LearningProgressService {

    private final LearningProgressRepository repository;

    public LearningProgressService(
            LearningProgressRepository repository) {

        this.repository = repository;
    }

    public LearningProgress saveProgress(
            String topic,
            Double score) {

        LearningProgress progress =
                new LearningProgress(
                        topic,
                        score,
                        LocalDateTime.now());

        return repository.save(progress);
    }

    public List<LearningProgress> getAllProgress() {

        return repository.findAll();
    }
}