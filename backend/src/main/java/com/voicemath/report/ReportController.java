package com.voicemath.report;

import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.voicemath.model.LearningProgress;
import com.voicemath.repository.CalculationRepository;
import com.voicemath.repository.LearningProgressRepository;

@RestController
@CrossOrigin(origins = "*")
public class ReportController {

    private final CalculationRepository calculationRepository;
    private final LearningProgressRepository learningRepository;
    private final ReportService reportService;

    public ReportController(
            CalculationRepository calculationRepository,
            LearningProgressRepository learningRepository,
            ReportService reportService) {

        this.calculationRepository =
                calculationRepository;

        this.learningRepository =
                learningRepository;

        this.reportService =
                reportService;
    }

    @GetMapping("/api/report")
    public ResponseEntity<byte[]> report() {

        long totalCalculations =
                calculationRepository.count();

        double averageScore =
                learningRepository.findAll()
                        .stream()
                        .mapToDouble(
                                LearningProgress::getScore)
                        .average()
                        .orElse(0);

        String performance =
                averageScore >= 80
                        ? "Excellent"
                        : averageScore >= 60
                        ? "Good"
                        : "Needs Improvement";

        long achievements =
                totalCalculations >= 10 ? 1 : 0;

        byte[] pdf =
                reportService.generateReport(
                        totalCalculations,
                        averageScore,
                        achievements,
                        performance);

        return ResponseEntity.ok()
                .header(
                        HttpHeaders.CONTENT_DISPOSITION,
                        "attachment; filename=Student_Report.pdf")
                .contentType(
                        MediaType.APPLICATION_PDF)
                .body(pdf);
    }
}