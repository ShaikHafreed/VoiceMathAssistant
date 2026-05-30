package com.voicemath.engine;

import org.springframework.stereotype.Service;

@Service
public class MathEngineService {

    public String evaluate(String expression) {

        try {

            expression = expression.trim();

            if (expression.startsWith("sqrt")) {

                double value =
                        Double.parseDouble(
                                expression.replace("sqrt", "").trim());

                return String.valueOf(
                        Math.sqrt(value));
            }

            if (expression.startsWith("cbrt")) {

                double value =
                        Double.parseDouble(
                                expression.replace("cbrt", "").trim());

                return String.valueOf(
                        Math.cbrt(value));
            }

            if (expression.startsWith("log")) {

                double value =
                        Double.parseDouble(
                                expression.replace("log", "").trim());

                return String.valueOf(
                        Math.log10(value));
            }

            if (expression.startsWith("sin")) {

                double value =
                        Double.parseDouble(
                                expression.replace("sin", "").trim());

                return String.valueOf(
                        Math.sin(Math.toRadians(value)));
            }

            if (expression.startsWith("cos")) {

                double value =
                        Double.parseDouble(
                                expression.replace("cos", "").trim());

                return String.valueOf(
                        Math.cos(Math.toRadians(value)));
            }

            if (expression.startsWith("tan")) {

                double value =
                        Double.parseDouble(
                                expression.replace("tan", "").trim());

                return String.valueOf(
                        Math.tan(Math.toRadians(value)));
            }

            if (expression.contains("^")) {

                String[] parts =
                        expression.split("\\^");

                double a =
                        Double.parseDouble(parts[0].trim());

                double b =
                        Double.parseDouble(parts[1].trim());

                return String.valueOf(
                        Math.pow(a, b));
            }

            if (expression.contains("%")) {

                String[] parts =
                        expression.split("%");

                double percent =
                        Double.parseDouble(parts[0].trim());

                double total =
                        Double.parseDouble(parts[1].trim());

                return String.valueOf(
                        (percent / 100) * total);
            }

            if (expression.contains("+")) {

                String[] parts =
                        expression.split("\\+");

                return String.valueOf(
                        Double.parseDouble(parts[0].trim())
                                + Double.parseDouble(parts[1].trim()));
            }

            if (expression.contains("-")) {

                String[] parts =
                        expression.split("-");

                return String.valueOf(
                        Double.parseDouble(parts[0].trim())
                                - Double.parseDouble(parts[1].trim()));
            }

            if (expression.contains("*")) {

                String[] parts =
                        expression.split("\\*");

                return String.valueOf(
                        Double.parseDouble(parts[0].trim())
                                * Double.parseDouble(parts[1].trim()));
            }

            if (expression.contains("/")) {

                String[] parts =
                        expression.split("/");

                return String.valueOf(
                        Double.parseDouble(parts[0].trim())
                                / Double.parseDouble(parts[1].trim()));
            }

            return "Unsupported Expression";

        } catch (Exception e) {

            e.printStackTrace();

            return "Invalid Expression";
        }
    }
}