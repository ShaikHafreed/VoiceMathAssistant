package com.voicemath.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "achievements")
public class Achievement {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String title;

    private String description;

    private boolean achieved;

    public Achievement() {
    }

    public Achievement(
            String title,
            String description,
            boolean achieved) {

        this.title = title;
        this.description = description;
        this.achieved = achieved;
    }

    public Long getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(
            String description) {

        this.description = description;
    }

    public boolean isAchieved() {
        return achieved;
    }

    public void setAchieved(
            boolean achieved) {

        this.achieved = achieved;
    }
}