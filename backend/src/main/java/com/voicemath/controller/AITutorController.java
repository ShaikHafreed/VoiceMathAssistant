package com.voicemath.controller;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.voicemath.dto.TutorResponse;
import com.voicemath.service.AITutorService;

@RestController
@RequestMapping("/api/tutor")
@CrossOrigin(origins = "*")
public class AITutorController {

    private final AITutorService tutorService;

    public AITutorController(
            AITutorService tutorService) {

        this.tutorService =
                tutorService;
    }

    @GetMapping("/{topic}")
    public TutorResponse teach(

            @PathVariable
            String topic) {

        return tutorService.teach(
                topic);
    }
}