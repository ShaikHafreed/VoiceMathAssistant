package com.voicemath.engine;

import net.objecthunter.exp4j.Expression;
import net.objecthunter.exp4j.ExpressionBuilder;
import org.springframework.stereotype.Service;

@Service
public class MathEngineService {

    public String evaluate(String expression) {

        try {

            expression = expression.trim().toLowerCase();

            if (expression.startsWith("sqrt")) {

                double value =
                        Double.parseDouble(
                                expression.replace("sqrt", "").trim());

                return String.valueOf(Math.sqrt(value));
            }

            if (expression.startsWith("cbrt")) {

                double value =
                        Double.parseDouble(
                                expression.replace("cbrt", "").trim());

                return String.valueOf(Math.cbrt(value));
            }

            if (expression.startsWith("log")) {

                double value =
                        Double.parseDouble(
                                expression.replace("log", "").trim());

                return String.valueOf(Math.log10(value));
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

            if (expression.contains("%")) {

                String[] parts =
                        expression.split("%");

                double percent =
                        Double.parseDouble(parts[0].trim());

                double total =
                        Double.parseDouble(parts[1].trim());

                return String.valueOf(
                        (percent / 100.0) * total);
            }

            Expression exp =
                    new ExpressionBuilder(expression)
                            .build();

            double result = exp.evaluate();

            if (result == (long) result) {
                return String.valueOf((long) result);
            }

            return String.valueOf(result);

        } catch (Exception e) {

            e.printStackTrace();
            return "Invalid Expression";
        }
    }
}