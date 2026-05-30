package com.voicemath.controller;

import java.util.List;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.voicemath.model.Calculation;
import com.voicemath.service.CalculationService;

@RestController
@RequestMapping("/api/calculations")
@CrossOrigin(origins = "*")
public class CalculationController {

    private final CalculationService service;

    public CalculationController(CalculationService service) {
        this.service = service;
    }

    @PostMapping
    public Calculation save(@RequestBody Calculation calculation) {
        return service.save(calculation);
    }

    @GetMapping
    public List<Calculation> getAll() {
        return service.getAll();
    }

    @DeleteMapping
    public void clearHistory() {
        service.deleteAll();
    }
}