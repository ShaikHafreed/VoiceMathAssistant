package com.voicemath.parser;

import org.springframework.stereotype.Service;

@Service
public class SpeechCorrectionService {

    public String correct(String speech) {

        if (speech == null) {
            return "";
        }

        speech = speech.toLowerCase().trim();

        /*
         * MULTIPLICATION
         */
        speech = speech.replace("timess", "times");
        speech = speech.replace("time's", "times");
        speech = speech.replace("time is", "times");
        speech = speech.replace("multiplys", "multiply");
        speech = speech.replace("multiplies", "multiply");
        speech = speech.replace("multiply with", "multiplied by");
        speech = speech.replace("multiplied with", "multiplied by");

        /*
         * DIVISION
         */
        speech = speech.replace("devide", "divide");
        speech = speech.replace("devided", "divided");
        speech = speech.replace("divideed", "divided");
        speech = speech.replace("divide byy", "divide by");
        speech = speech.replace("overr", "over");

        /*
         * PERCENTAGE
         */
        speech = speech.replace("persent", "percent");
        speech = speech.replace("persents", "percent");
        speech = speech.replace("percentagee", "percentage");
        speech = speech.replace("persantage", "percentage");
        speech = speech.replace("percentage of", "percent of");

        /*
         * ADDITION
         */
        speech = speech.replace("pluss", "plus");
        speech = speech.replace("addd", "add");
        speech = speech.replace("added to", "plus");

        /*
         * SUBTRACTION
         */
        speech = speech.replace("minuss", "minus");
        speech = speech.replace("subtract from", "minus");

        /*
         * POWERS
         */
        speech = speech.replace("power off", "power of");
        speech = speech.replace("raised too", "raised to");
        speech = speech.replace("raise to", "raised to");

        /*
         * SQRT
         */
        speech = speech.replace("squart root", "square root");
        speech = speech.replace("squre root", "square root");
        speech = speech.replace("square route", "square root");
        speech = speech.replace("root off", "root of");

        /*
         * CBRT
         */
        speech = speech.replace("cube route", "cube root");
        speech = speech.replace("cube rout", "cube root");
        speech = speech.replace("cube roots", "cube root");

        /*
         * LOG
         */
        speech = speech.replace("logerithm", "log");
        speech = speech.replace("logaritham", "log");
        speech = speech.replace("logorithm", "log");

        /*
         * TRIGONOMETRY
         */
        speech = speech.replace("sine", "sin");
        speech = speech.replace("cosine", "cos");
        speech = speech.replace("tangent", "tan");

        /*
         * COMMON SPEECH NOISE
         */
        speech = speech.replace("equals to", "");
        speech = speech.replace("equal to", "");
        speech = speech.replace("answer is", "");
        speech = speech.replace("please calculate", "");
        speech = speech.replace("can you calculate", "");
        speech = speech.replace("could you calculate", "");
        speech = speech.replace("what is", "");
        speech = speech.replace("how much is", "");

        /*
         * REMOVE DUPLICATE SPACES
         */
        speech = speech.replaceAll("\\s+", " ").trim();

        System.out.println("CORRECTED SPEECH = " + speech);

        return speech;
    }
}