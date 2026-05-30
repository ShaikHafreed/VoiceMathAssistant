package com.voicemath.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.voicemath.model.LearningProgress;

public interface LearningProgressRepository
        extends JpaRepository<LearningProgress, Long> {
}