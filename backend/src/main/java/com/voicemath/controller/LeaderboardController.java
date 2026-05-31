package com.voicemath.controller;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.voicemath.dto.LeaderboardEntry;
import com.voicemath.model.StudentProfile;
import com.voicemath.repository.StudentProfileRepository;

@RestController
@RequestMapping("/api/leaderboard")
@CrossOrigin(origins = "*")
public class LeaderboardController {

    private final StudentProfileRepository repository;

    public LeaderboardController(
            StudentProfileRepository repository) {

        this.repository = repository;
    }

    @GetMapping
    public List<LeaderboardEntry> getLeaderboard() {

        List<StudentProfile> students =
                repository.findAll();

        students.sort(
                Comparator.comparing(
                        StudentProfile::getTotalScore)
                        .reversed());

        List<LeaderboardEntry> leaderboard =
                new ArrayList<>();

        int rank = 1;

        for (StudentProfile student : students) {

            leaderboard.add(
                    new LeaderboardEntry(
                            rank++,
                            student.getStudentName(),
                            student.getTotalScore()
                    )
            );
        }

        return leaderboard;
    }
}