package com.voicemath.controller;

import java.util.List;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.voicemath.model.ConversationMemory;
import com.voicemath.service.ConversationMemoryService;

@RestController
@RequestMapping("/api/memory")
@CrossOrigin(origins = "*")
public class MemoryController {

    private final ConversationMemoryService service;

    public MemoryController(
            ConversationMemoryService service) {

        this.service = service;
    }

    @GetMapping
    public List<ConversationMemory> getMemory() {

        return service.getAll();
    }

    @DeleteMapping
    public void clearMemory() {

        service.deleteAll();
    }
}