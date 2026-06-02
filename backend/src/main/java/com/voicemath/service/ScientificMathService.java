package com.voicemath.service;

import org.springframework.stereotype.Service;

@Service
public class ScientificMathService {

    public boolean isScientific(String expression) {

        if (expression == null) {
            return false;
        }

        expression = expression.toLowerCase();

        return expression.startsWith("sin")
                || expression.startsWith("cos")
                || expression.startsWith("tan")
                || expression.startsWith("log")
                || expression.startsWith("ln");
    }

    public String generateSteps(
            String expression,
            String result) {

        expression = expression.toLowerCase();

        if (expression.startsWith("sin")) {

            String value =
                    expression.replace("sin", "");

            return """
                    Step 1: Expression = sin(%s)

                    Step 2: Convert degrees to radians

                    Step 3: Apply sine formula

                    Step 4: Result = %s
                    """
                    .formatted(value, result);
        }

        if (expression.startsWith("cos")) {

            String value =
                    expression.replace("cos", "");

            return """
                    Step 1: Expression = cos(%s)

                    Step 2: Convert degrees to radians

                    Step 3: Apply cosine formula

                    Step 4: Result = %s
                    """
                    .formatted(value, result);
        }

        if (expression.startsWith("tan")) {

            String value =
                    expression.replace("tan", "");

            return """
                    Step 1: Expression = tan(%s)

                    Step 2: Convert degrees to radians

                    Step 3: Apply tangent formula

                    Step 4: Result = %s
                    """
                    .formatted(value, result);
        }

        if (expression.startsWith("log")) {

            String value =
                    expression.replace("log", "");

            return """
                    Step 1: Expression = log(%s)

                    Step 2: Apply base-10 logarithm

                    Step 3: Result = %s
                    """
                    .formatted(value, result);
        }

        if (expression.startsWith("ln")) {

            String value =
                    expression.replace("ln", "");

            return """
                    Step 1: Expression = ln(%s)

                    Step 2: Apply natural logarithm

                    Step 3: Result = %s
                    """
                    .formatted(value, result);
        }

        return """
                Scientific Calculation

                Result = %s
                """
                .formatted(result);
    }
}