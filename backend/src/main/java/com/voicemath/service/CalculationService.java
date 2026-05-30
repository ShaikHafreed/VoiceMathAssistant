package com.voicemath.service;

import com.voicemath.model.Calculation;
import com.voicemath.repository.CalculationRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CalculationService {

    private final CalculationRepository repository;

    public CalculationService(CalculationRepository repository) {
        this.repository = repository;
    }

    public Calculation save(Calculation calculation) {
        return repository.save(calculation);
    }

    public List<Calculation> getAll() {
        return repository.findAll();
    }

    public void deleteAll() {
        repository.deleteAll();
    }
}