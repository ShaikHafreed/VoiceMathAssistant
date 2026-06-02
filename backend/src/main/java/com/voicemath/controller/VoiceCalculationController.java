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
import com.voicemath.parser.SpeechCorrectionService;
import com.voicemath.service.AlgebraSolverService;
import com.voicemath.service.CalculationService;
import com.voicemath.service.ConversationMemoryService;
import com.voicemath.service.GeometrySolverService;
import com.voicemath.service.GraphAnalysisService;
import com.voicemath.service.QuadraticSolverService;
import com.voicemath.service.ScientificMathService;
import com.voicemath.service.StatisticsService;
import com.voicemath.service.StepByStepService;

@RestController
@RequestMapping("/api")
@CrossOrigin(origins = "*")
public class VoiceCalculationController {

    private final MathParserService parserService;
    private final SpeechCorrectionService correctionService;
    private final MathEngineService engineService;
    private final CalculationService calculationService;
    private final ConversationMemoryService conversationMemoryService;

    private final StepByStepService stepByStepService;
    private final AlgebraSolverService algebraSolverService;
    private final ScientificMathService scientificMathService;
    private final QuadraticSolverService quadraticSolverService;
    private final GraphAnalysisService graphAnalysisService;
    private final GeometrySolverService geometrySolverService;
    private final StatisticsService statisticsService;

    public VoiceCalculationController(
            MathParserService parserService,
            SpeechCorrectionService correctionService,
            MathEngineService engineService,
            CalculationService calculationService,
            ConversationMemoryService conversationMemoryService,
            StepByStepService stepByStepService,
            AlgebraSolverService algebraSolverService,
            ScientificMathService scientificMathService,
            QuadraticSolverService quadraticSolverService,
            GraphAnalysisService graphAnalysisService,
            GeometrySolverService geometrySolverService,
            StatisticsService statisticsService) {

        this.parserService = parserService;
        this.correctionService = correctionService;
        this.engineService = engineService;
        this.calculationService = calculationService;
        this.conversationMemoryService = conversationMemoryService;

        this.stepByStepService = stepByStepService;
        this.algebraSolverService = algebraSolverService;
        this.scientificMathService = scientificMathService;
        this.quadraticSolverService = quadraticSolverService;
        this.graphAnalysisService = graphAnalysisService;
        this.geometrySolverService = geometrySolverService;
        this.statisticsService = statisticsService;
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

        System.out.println(
                "ORIGINAL SPEECH = " + speech);

        System.out.println(
                "PARSED EXPRESSION = " + expression);

        String result;
        String steps;

        // ==========================
        // STATISTICS
        // ==========================

        if (statisticsService.isStatistics(
                expression)) {

            result =
                    statisticsService.solve(
                            expression);

            steps =
                    statisticsService.generateSteps(
                            expression,
                            result);
        }

        // ==========================
        // GEOMETRY
        // ==========================

        else if (geometrySolverService.isGeometry(
                expression)) {

            result =
                    geometrySolverService.solve(
                            expression);

            steps =
                    geometrySolverService.generateSteps(
                            expression,
                            result);
        }

        // ==========================
        // GRAPH ANALYSIS
        // ==========================

        else if (
                graphAnalysisService.isGraphFunction(
                        expression)) {

            result =
                    graphAnalysisService.analyze(
                            expression);

            steps =
                    graphAnalysisService.generateSteps(
                            expression,
                            result);
        }

        // ==========================
        // QUADRATIC EQUATIONS
        // ==========================

        else if (
                quadraticSolverService.isQuadratic(
                        expression)) {

            String[] roots =
                    quadraticSolverService.solve(
                            expression);

            result =
                    "Root1 = "
                            + roots[0]
                            + ", Root2 = "
                            + roots[1];

            steps =
                    quadraticSolverService.generateSteps(
                            expression,
                            roots[0],
                            roots[1]);
        }

        // ==========================
        // ALGEBRA
        // ==========================

        else if (
                algebraSolverService.isEquation(
                        expression)) {

            result =
                    algebraSolverService.solve(
                            expression);

            steps =
                    algebraSolverService.generateSteps(
                            expression,
                            result);
        }

        // ==========================
        // SCIENTIFIC MATH
        // ==========================

        else if (
                scientificMathService.isScientific(
                        expression)) {

            result =
                    engineService.evaluate(
                            expression);

            steps =
                    scientificMathService.generateSteps(
                            expression,
                            result);
        }

        // ==========================
        // NORMAL CALCULATOR
        // ==========================

        else {

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
                speech,
                result,
                steps);
    }
}