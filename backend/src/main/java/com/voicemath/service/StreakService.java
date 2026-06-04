package com.voicemath.service;

import java.time.LocalDate;

import org.springframework.stereotype.Service;

import com.voicemath.model.Streak;
import com.voicemath.repository.StreakRepository;

@Service
public class StreakService {

    private final StreakRepository repository;

    public StreakService(
            StreakRepository repository) {

        this.repository = repository;
    }

    public void updateStreak() {

        Streak streak;

        if (repository.count() == 0) {

            streak =
                    new Streak(
                            1,
                            1,
                            LocalDate.now());

            repository.save(streak);

            return;
        }

        streak =
                repository.findAll().get(0);

        LocalDate today =
                LocalDate.now();

        LocalDate lastDate =
                streak.getLastActiveDate();

        if (lastDate == null) {

            streak.setCurrentStreak(1);
        }

        else if (lastDate.plusDays(1)
                .equals(today)) {

            streak.setCurrentStreak(
                    streak.getCurrentStreak() + 1);
        }

        else if (!lastDate.equals(today)) {

            streak.setCurrentStreak(1);
        }

        if (streak.getCurrentStreak()
                > streak.getLongestStreak()) {

            streak.setLongestStreak(
                    streak.getCurrentStreak());
        }

        streak.setLastActiveDate(today);

        repository.save(streak);
    }

    public Streak getStreak() {

        if (repository.count() == 0) {

            Streak streak =
                    new Streak(
                            0,
                            0,
                            LocalDate.now());

            return repository.save(streak);
        }

        return repository.findAll().get(0);
    }
}