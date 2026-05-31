package com.voicemath.report;

import java.io.ByteArrayOutputStream;

import org.springframework.stereotype.Service;

import com.itextpdf.text.Document;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.pdf.PdfWriter;

@Service
public class ReportService {

    public byte[] generateReport(
            long calculations,
            double score,
            long achievements,
            String performance) {

        try {

            Document document =
                    new Document();

            ByteArrayOutputStream output =
                    new ByteArrayOutputStream();

            PdfWriter.getInstance(
                    document,
                    output);

            document.open();

            document.add(
                    new Paragraph(
                            "VOICE MATH ASSISTANT"));

            document.add(
                    new Paragraph(" "));

            document.add(
                    new Paragraph(
                            "Student Learning Report"));

            document.add(
                    new Paragraph(" "));

            document.add(
                    new Paragraph(
                            "Total Calculations : "
                                    + calculations));

            document.add(
                    new Paragraph(
                            "Average Score : "
                                    + score));

            document.add(
                    new Paragraph(
                            "Achievements : "
                                    + achievements));

            document.add(
                    new Paragraph(
                            "Performance : "
                                    + performance));

            document.close();

            return output.toByteArray();

        } catch (Exception e) {

            throw new RuntimeException(e);
        }
    }
}