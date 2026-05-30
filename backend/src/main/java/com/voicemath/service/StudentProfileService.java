package com.voicemath.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.voicemath.model.StudentProfile;
import com.voicemath.repository.StudentProfileRepository;

@Service
public class StudentProfileService {

    private final StudentProfileRepository repository;

    public StudentProfileService(
            StudentProfileRepository repository) {

        this.repository = repository;
    }

    public StudentProfile save(
            StudentProfile profile) {

        return repository.save(profile);
    }

    public List<StudentProfile> getAll() {

        return repository.findAll();
    }
}