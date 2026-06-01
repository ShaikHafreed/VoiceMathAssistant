package com.voicemath.controller;

import java.io.File;
import java.io.IOException;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.voicemath.dto.OCRMathResponse;
import com.voicemath.engine.MathEngineService;
import com.voicemath.model.Calculation;
import com.voicemath.ocr.OCRService;
import com.voicemath.parser.MathParserService;
import com.voicemath.service.CalculationService;

@RestController
@RequestMapping("/api/ocr-math")
@CrossOrigin(origins = "*")
public class OCRMathController {

    private final OCRService ocrService;
    private final MathParserService parserService;
    private final MathEngineService engineService;
    private final CalculationService calculationService;

    public OCRMathController(
            OCRService ocrService,
            MathParserService parserService,
            MathEngineService engineService,
            CalculationService calculationService) {

        this.ocrService = ocrService;
        this.parserService = parserService;
        this.engineService = engineService;
        this.calculationService = calculationService;
    }

    @PostMapping
    public ResponseEntity<OCRMathResponse> solveMathImage(
            @RequestParam("file") MultipartFile multipartFile)
            throws IOException {

        File tempFile =
                File.createTempFile(
                        "ocr-math-",
                        multipartFile.getOriginalFilename());

        multipartFile.transferTo(tempFile);

        String ocrText =
                ocrService.extractText(tempFile);

        String cleanedText = ocrText;

        cleanedText = cleanedText.replace("\n", " ");
        cleanedText = cleanedText.replace("\r", " ");
        cleanedText = cleanedText.replace("=", "");
        cleanedText = cleanedText.replaceAll("\\s+", " ").trim();

        System.out.println("OCR TEXT = " + ocrText);
        System.out.println("CLEANED TEXT = " + cleanedText);

        String expression =
                parserService.parse(cleanedText);

        String result =
                engineService.evaluate(expression);

        Calculation calculation =
                new Calculation(
                        expression,
                        result);

        calculationService.save(calculation);

        tempFile.delete();

        return ResponseEntity.ok(
                new OCRMathResponse(
                        ocrText,
                        expression,
                        result));
    }
}