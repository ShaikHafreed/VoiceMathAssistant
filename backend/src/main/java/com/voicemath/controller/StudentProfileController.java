package com.voicemath.controller;

import java.util.List;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.voicemath.model.StudentProfile;
import com.voicemath.service.StudentProfileService;

@RestController
@RequestMapping("/api/student")
@CrossOrigin(origins = "*")
public class StudentProfileController {

    private final StudentProfileService service;

    public StudentProfileController(
            StudentProfileService service) {

        this.service = service;
    }

    @PostMapping
    public StudentProfile saveProfile(
            @RequestBody StudentProfile profile) {

        return service.save(profile);
    }

    @GetMapping
    public List<StudentProfile> getProfiles() {

        return service.getAll();
    }
}