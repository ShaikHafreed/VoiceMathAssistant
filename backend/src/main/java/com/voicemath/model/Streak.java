package com.voicemath.model;

import java.time.LocalDate;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Streak {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private int currentStreak;

    private int longestStreak;

    private LocalDate lastActiveDate;

    public Streak() {
    }

    public Streak(
            int currentStreak,
            int longestStreak,
            LocalDate lastActiveDate) {

        this.currentStreak = currentStreak;
        this.longestStreak = longestStreak;
        this.lastActiveDate = lastActiveDate;
    }

    public Long getId() {
        return id;
    }

    public int getCurrentStreak() {
        return currentStreak;
    }

    public void setCurrentStreak(
            int currentStreak) {

        this.currentStreak = currentStreak;
    }

    public int getLongestStreak() {
        return longestStreak;
    }

    public void setLongestStreak(
            int longestStreak) {

        this.longestStreak = longestStreak;
    }

    public LocalDate getLastActiveDate() {
        return lastActiveDate;
    }

    public void setLastActiveDate(
            LocalDate lastActiveDate) {

        this.lastActiveDate = lastActiveDate;
    }
}