package com.voicemath.controller;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.voicemath.dto.CalculationRequest;
import com.voicemath.dto.CalculationResponse;
import com.voicemath.engine.MathEngineService;
import com.voicemath.model.Calculation;
import com.voicemath.parser.MathParserService;
import com.voicemath.service.CalculationService;
import com.voicemath.service.ConversationMemoryService;

@RestController
@RequestMapping("/api")
@CrossOrigin(origins = "*")
public class VoiceCalculationController {

    private final MathParserService parserService;
    private final MathEngineService engineService;
    private final CalculationService calculationService;
    private final ConversationMemoryService conversationMemoryService;

    public VoiceCalculationController(
            MathParserService parserService,
            MathEngineService engineService,
            CalculationService calculationService,
            ConversationMemoryService conversationMemoryService) {

        this.parserService = parserService;
        this.engineService = engineService;
        this.calculationService = calculationService;
        this.conversationMemoryService = conversationMemoryService;
    }

    @PostMapping("/calculate")
    public CalculationResponse calculate(
            @RequestBody CalculationRequest request) {

        String speech =
                request.getSpeech();

        String expression =
                parserService.parse(speech);

        String result =
                engineService.evaluate(expression);

        Calculation calculation =
                new Calculation(
                        expression,
                        result);

        calculationService.save(calculation);

        conversationMemoryService.save(
                speech,
                result);

        return new CalculationResponse(
                expression,
                result);
    }
}