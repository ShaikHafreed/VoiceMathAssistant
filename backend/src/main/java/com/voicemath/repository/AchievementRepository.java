package com.voicemath.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.voicemath.model.Achievement;

public interface AchievementRepository
        extends JpaRepository<Achievement, Long> {
}