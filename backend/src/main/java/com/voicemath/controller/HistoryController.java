package com.voicemath.controller;

import java.util.List;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.voicemath.model.Calculation;
import com.voicemath.service.CalculationService;

@RestController
@RequestMapping("/api/history")
@CrossOrigin(origins = "*")
public class HistoryController {

    private final CalculationService calculationService;

    public HistoryController(
            CalculationService calculationService) {

        this.calculationService =
                calculationService;
    }

    @GetMapping
    public List<Calculation> getHistory() {

        return calculationService.getAll();
    }
}