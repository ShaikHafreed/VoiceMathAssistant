package com.voicemath.service;

import org.springframework.stereotype.Service;

@Service
public class QuadraticSolverService {

    public boolean isQuadratic(
            String expression) {

        return expression.contains("x^2")
                && expression.contains("=");
    }

    public String[] solve(
            String expression) {

        try {

            expression =
                    expression.replace(" ", "");

            String left =
                    expression.split("=")[0];

            left =
                    left.replace("-", "+-");

            String[] terms =
                    left.split("\\+");

            double a = 0;
            double b = 0;
            double c = 0;

            for (String term : terms) {

                if (term.isBlank()) {
                    continue;
                }

                if (term.contains("x^2")) {

                    String value =
                            term.replace("x^2", "");

                    if (value.isBlank()) {
                        a = 1;
                    } else if (value.equals("-")) {
                        a = -1;
                    } else {
                        a = Double.parseDouble(value);
                    }
                }

                else if (term.contains("x")) {

                    String value =
                            term.replace("x", "");

                    if (value.isBlank()) {
                        b = 1;
                    } else if (value.equals("-")) {
                        b = -1;
                    } else {
                        b = Double.parseDouble(value);
                    }
                }

                else {

                    c =
                            Double.parseDouble(term);
                }
            }

            double discriminant =
                    (b * b)
                            - (4 * a * c);

            double root1 =
                    (-b + Math.sqrt(discriminant))
                            / (2 * a);

            double root2 =
                    (-b - Math.sqrt(discriminant))
                            / (2 * a);

            return new String[] {
                    String.valueOf(root1),
                    String.valueOf(root2)
            };

        } catch (Exception e) {

            return new String[] {
                    "Unable to solve",
                    "Unable to solve"
            };
        }
    }

    public String generateSteps(
            String expression,
            String root1,
            String root2) {

        return """
                Step 1: Equation = %s

                Step 2: Identify coefficients

                Step 3: Apply quadratic formula

                x = (-b ± √(b² - 4ac)) / 2a

                Step 4: Calculate discriminant

                Step 5: Root 1 = %s

                Step 6: Root 2 = %s
                """
                .formatted(
                        expression,
                        root1,
                        root2);
    }
}