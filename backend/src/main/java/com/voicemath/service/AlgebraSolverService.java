package com.voicemath.service;

import org.springframework.stereotype.Service;

@Service
public class AlgebraSolverService {

    public boolean isEquation(
            String expression) {

        return expression.contains("=")
                && expression.contains("x");
    }

    public String solve(
            String expression) {

        try {

            expression =
                    expression.replace(" ", "");

            String[] sides =
                    expression.split("=");

            String left =
                    sides[0];

            String right =
                    sides[1];

            double rhs =
                    Double.parseDouble(right);

            if (left.contains("+")) {

                String[] parts =
                        left.split("\\+");

                String variablePart =
                        parts[0];

                double number =
                        Double.parseDouble(parts[1]);

                double result =
                        rhs - number;

                return String.valueOf(result);
            }

            if (left.contains("-")) {

                String[] parts =
                        left.split("-");

                String variablePart =
                        parts[0];

                double number =
                        Double.parseDouble(parts[1]);

                double result =
                        rhs + number;

                return String.valueOf(result);
            }

            if (left.contains("*")) {

                String[] parts =
                        left.split("\\*");

                String variablePart =
                        parts[0];

                double number =
                        Double.parseDouble(parts[1]);

                double result =
                        rhs / number;

                return String.valueOf(result);
            }

            if (left.contains("/")) {

                String[] parts =
                        left.split("/");

                String variablePart =
                        parts[0];

                double number =
                        Double.parseDouble(parts[1]);

                double result =
                        rhs * number;

                return String.valueOf(result);
            }

            return "Unable to solve";

        } catch (Exception e) {

            return "Unable to solve";
        }
    }

    public String generateSteps(
            String expression,
            String result) {

        return """
                Step 1: Equation = %s

                Step 2: Move constant to other side

                Step 3: Solve x

                Step 4: x = %s
                """
                .formatted(
                        expression,
                        result);
    }
}