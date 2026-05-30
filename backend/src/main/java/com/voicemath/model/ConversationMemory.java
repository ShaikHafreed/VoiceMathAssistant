package com.voicemath.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "conversation_memory")
public class ConversationMemory {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(columnDefinition = "TEXT")
    private String userInput;

    @Column(columnDefinition = "TEXT")
    private String assistantResponse;

    public ConversationMemory() {
    }

    public ConversationMemory(
            String userInput,
            String assistantResponse) {

        this.userInput = userInput;
        this.assistantResponse = assistantResponse;
    }

    public Long getId() {
        return id;
    }

    public String getUserInput() {
        return userInput;
    }

    public void setUserInput(
            String userInput) {

        this.userInput = userInput;
    }

    public String getAssistantResponse() {
        return assistantResponse;
    }

    public void setAssistantResponse(
            String assistantResponse) {

        this.assistantResponse =
                assistantResponse;
    }
}