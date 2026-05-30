package com.voicemath.explanation;

import org.springframework.stereotype.Service;

@Service
public class ExplanationService {

    public String explain(
            String expression,
            String result) {

        if (expression.contains("+")) {

            String[] parts = expression.split("\\+");

            return "Add "
                    + parts[0]
                    + " and "
                    + parts[1]
                    + ". Result is "
                    + result;
        }

        if (expression.contains("-")) {

            String[] parts = expression.split("-");

            return "Subtract "
                    + parts[1]
                    + " from "
                    + parts[0]
                    + ". Result is "
                    + result;
        }

        if (expression.contains("*")) {

            return "Multiply the numbers. Result is "
                    + result;
        }

        if (expression.contains("/")) {

            return "Divide the numbers. Result is "
                    + result;
        }

        return "Calculation completed. Result is "
                + result;
    }
}