package com.voicemath.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.voicemath.model.ConversationMemory;

public interface ConversationMemoryRepository
        extends JpaRepository<
        ConversationMemory,
        Long> {
}