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

import com.voicemath.ocr.OCRService;

@RestController
@RequestMapping("/api/ocr")
@CrossOrigin(origins = "*")
public class OCRController {

    private final OCRService ocrService;

    public OCRController(OCRService ocrService) {
        this.ocrService = ocrService;
    }

    @PostMapping
    public ResponseEntity<String> extractText(
            @RequestParam("file") MultipartFile multipartFile)
            throws IOException {

        File tempFile =
                File.createTempFile(
                        "ocr-image",
                        multipartFile.getOriginalFilename());

        multipartFile.transferTo(tempFile);

        String text =
                ocrService.extractText(tempFile);

        tempFile.delete();

        return ResponseEntity.ok(text);
    }
}