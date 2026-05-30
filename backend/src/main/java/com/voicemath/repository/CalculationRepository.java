package com.voicemath.repository;

import com.voicemath.model.Calculation;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CalculationRepository
        extends JpaRepository<Calculation, Long> {
}