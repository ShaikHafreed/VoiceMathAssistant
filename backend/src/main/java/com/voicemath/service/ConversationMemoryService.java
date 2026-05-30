package com.voicemath.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.voicemath.model.ConversationMemory;
import com.voicemath.repository.ConversationMemoryRepository;

@Service
public class ConversationMemoryService {

    private final ConversationMemoryRepository repository;

    public ConversationMemoryService(
            ConversationMemoryRepository repository) {

        this.repository = repository;
    }

    public ConversationMemory save(
            String userInput,
            String response) {

        return repository.save(
                new ConversationMemory(
                        userInput,
                        response));
    }

    public List<ConversationMemory> getAll() {

        return repository.findAll();
    }

    public void deleteAll() {

        repository.deleteAll();
    }
}