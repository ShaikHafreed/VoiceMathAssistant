package com.voicemath.service;

import org.springframework.stereotype.Service;

@Service
public class StepByStepService {

    public String generateSteps(
            String expression,
            String result) {

        try {

            if (expression.contains("+")) {

                String[] parts =
                        expression.split("\\+");

                return """
                        Step 1: Expression = %s

                        Step 2: Add %s and %s

                        Step 3: Result = %s
                        """
                        .formatted(
                                expression,
                                parts[0],
                                parts[1],
                                result);
            }

            if (expression.contains("-")) {

                String[] parts =
                        expression.split("-");

                return """
                        Step 1: Expression = %s

                        Step 2: Subtract %s from %s

                        Step 3: Result = %s
                        """
                        .formatted(
                                expression,
                                parts[1],
                                parts[0],
                                result);
            }

            if (expression.contains("*")) {

                String[] parts =
                        expression.split("\\*");

                return """
                        Step 1: Expression = %s

                        Step 2: Multiply %s by %s

                        Step 3: Result = %s
                        """
                        .formatted(
                                expression,
                                parts[0],
                                parts[1],
                                result);
            }

            if (expression.contains("/")) {

                String[] parts =
                        expression.split("/");

                return """
                        Step 1: Expression = %s

                        Step 2: Divide %s by %s

                        Step 3: Result = %s
                        """
                        .formatted(
                                expression,
                                parts[0],
                                parts[1],
                                result);
            }

            if (expression.startsWith("sqrt")) {

                String value =
                        expression.replace(
                                "sqrt",
                                "");

                return """
                        Step 1: Find square root of %s

                        Step 2: √%s = %s

                        Step 3: Result = %s
                        """
                        .formatted(
                                value,
                                value,
                                result,
                                result);
            }

            if (expression.startsWith("cbrt")) {

                String value =
                        expression.replace(
                                "cbrt",
                                "");

                return """
                        Step 1: Find cube root of %s

                        Step 2: ∛%s = %s

                        Step 3: Result = %s
                        """
                        .formatted(
                                value,
                                value,
                                result,
                                result);
            }

            if (expression.contains("%")) {

                String[] parts =
                        expression.split("%");

                return """
                        Step 1: Percentage Expression = %s

                        Step 2: (%s / 100) × %s

                        Step 3: Result = %s
                        """
                        .formatted(
                                expression,
                                parts[0],
                                parts[1],
                                result);
            }

            if (expression.contains("^")) {

                String[] parts =
                        expression.split("\\^");

                return """
                        Step 1: Expression = %s

                        Step 2: Raise %s to power %s

                        Step 3: Result = %s
                        """
                        .formatted(
                                expression,
                                parts[0],
                                parts[1],
                                result);
            }

            return """
                    Step 1: Expression = %s

                    Step 2: Evaluated

                    Step 3: Result = %s
                    """
                    .formatted(
                            expression,
                            result);

        } catch (Exception e) {

            return """
                    Result = %s
                    """
                    .formatted(result);
        }
    }
}