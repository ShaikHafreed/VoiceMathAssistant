package com.voicemath.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.voicemath.model.StudentProfile;

public interface StudentProfileRepository
        extends JpaRepository<StudentProfile, Long> {
}