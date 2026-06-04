package com.voicemath.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.voicemath.model.Streak;

public interface StreakRepository
        extends JpaRepository<Streak, Long> {
}