package com.voicemath.controller;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.voicemath.service.AlgebraSolverService;
import com.voicemath.dto.CalculationRequest;
import com.voicemath.dto.CalculationResponse;
import com.voicemath.engine.MathEngineService;
import com.voicemath.model.Calculation;
import com.voicemath.parser.MathParserService;
import com.voicemath.parser.SpeechCorrectionService;
import com.voicemath.service.CalculationService;
import com.voicemath.service.ConversationMemoryService;
import com.voicemath.service.StepByStepService;

@RestController
@RequestMapping("/api")
@CrossOrigin(origins = "*")
public class VoiceCalculationController {

    private final MathParserService parserService;
    private final AlgebraSolverService algebraSolverService;
    private final SpeechCorrectionService correctionService;
    private final MathEngineService engineService;
    private final CalculationService calculationService;
    private final ConversationMemoryService conversationMemoryService;
    private final StepByStepService stepByStepService;

    public VoiceCalculationController(
            MathParserService parserService,
            SpeechCorrectionService correctionService,
            MathEngineService engineService,
            CalculationService calculationService,
            ConversationMemoryService conversationMemoryService,
            StepByStepService stepByStepService) {

        this.parserService = parserService;
        this.correctionService = correctionService;
        this.engineService = engineService;
        this.calculationService = calculationService;
        this.conversationMemoryService = conversationMemoryService;
        this.stepByStepService = stepByStepService;
    }

    @PostMapping("/calculate")
    public CalculationResponse calculate(
            @RequestBody CalculationRequest request) {

        String speech =
                request.getSpeech();

        speech =
                correctionService.correct(
                        speech);

        String expression =
                parserService.parse(
                        speech);
        System.out.println("ORIGINAL SPEECH = " + speech);
        System.out.println("PARSED EXPRESSION = " + expression);
        String result;
String steps;

if (algebraSolverService.isEquation(expression)) {

    result =
            algebraSolverService.solve(
                    expression);

    steps =
            algebraSolverService.generateSteps(
                    expression,
                    result);

} else {

    result =
            engineService.evaluate(
                    expression);

    steps =
            stepByStepService.generateSteps(
                    expression,
                    result);
}
        Calculation calculation =
                new Calculation(
                        expression,
                        result);

        calculationService.save(
                calculation);

        conversationMemoryService.save(
                speech,
                result);

        return new CalculationResponse(
                expression,
                result,
                steps);
    }
}