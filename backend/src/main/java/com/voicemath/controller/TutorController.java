package com.voicemath.controller;

import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.voicemath.service.TutorService;

@RestController
@RequestMapping("/api/tutor")
@CrossOrigin(origins = "*")
public class TutorController {

    private final TutorService tutorService;

    public TutorController(TutorService tutorService) {
        this.tutorService = tutorService;
    }

    @GetMapping(
            value = "/{topic}",
            produces = MediaType.TEXT_HTML_VALUE
    )
    public String teach(
            @PathVariable String topic) {

        String lesson = tutorService.teach(topic);

        return lesson.replace("\n", "<br>");
    }
}