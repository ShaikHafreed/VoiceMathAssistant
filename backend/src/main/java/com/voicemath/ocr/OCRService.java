package com.voicemath.ocr;

import java.io.File;

import org.springframework.stereotype.Service;

import net.sourceforge.tess4j.Tesseract;
import net.sourceforge.tess4j.TesseractException;

@Service
public class OCRService {

    public String extractText(File file) {

        try {

            System.out.println("=================================");
            System.out.println("OCR SERVICE STARTED");
            System.out.println("FILE = " + file.getAbsolutePath());

            Tesseract tesseract = new Tesseract();

            String tessDataPath =
                    "C:\\Program Files\\Tesseract-OCR\\tessdata";

            System.out.println("DATAPATH = " + tessDataPath);

            File tessFolder = new File(tessDataPath);

            System.out.println("TESSDATA EXISTS = "
                    + tessFolder.exists());

            File engFile = new File(
                    tessDataPath
                    + File.separator
                    + "eng.traineddata");

            System.out.println("ENG FILE EXISTS = "
                    + engFile.exists());

            System.out.println("ENG FILE PATH = "
                    + engFile.getAbsolutePath());

            tesseract.setDatapath(tessDataPath);

            tesseract.setLanguage("eng");

            System.out.println("STARTING OCR...");

            String result = tesseract.doOCR(file);

            System.out.println("OCR SUCCESS");
            System.out.println("RESULT = ");
            System.out.println(result);

            System.out.println("=================================");

            result = result.replace("\n", " ");
result = result.replace("\r", " ");

return result.trim();

        } catch (TesseractException e) {

            System.out.println("=================================");
            System.out.println("OCR FAILED");
            e.printStackTrace();
            System.out.println("=================================");

            return "OCR Failed";
        }
    }
}