package com.voicemath.controller;

import org.springframework.web.bind.annotation.*;

import com.voicemath.dto.CalculationRequest;
import com.voicemath.dto.ExplanationResponse;
import com.voicemath.engine.MathEngineService;
import com.voicemath.explanation.ExplanationService;
import com.voicemath.parser.MathParserService;

@RestController
@RequestMapping("/api/explain")
@CrossOrigin(origins = "*")
public class ExplanationController {

    private final MathParserService parserService;
    private final MathEngineService engineService;
    private final ExplanationService explanationService;

    public ExplanationController(
            MathParserService parserService,
            MathEngineService engineService,
            ExplanationService explanationService) {

        this.parserService = parserService;
        this.engineService = engineService;
        this.explanationService = explanationService;
    }

    @PostMapping
    public ExplanationResponse explain(
            @RequestBody CalculationRequest request) {

        String expression =
                parserService.parse(
                        request.getSpeech());

        String result =
                engineService.evaluate(
                        expression);

        String explanation =
                explanationService.explain(
                        expression,
                        result);

        return new ExplanationResponse(
                explanation);
    }
}