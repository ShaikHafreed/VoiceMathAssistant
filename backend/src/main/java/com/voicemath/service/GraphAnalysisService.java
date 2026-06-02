package com.voicemath.service;

import org.springframework.stereotype.Service;

@Service
public class GraphAnalysisService {

    public boolean isGraphFunction(
            String expression) {

        if (expression == null) {
            return false;
        }

        expression = expression.toLowerCase();

        return expression.contains("x^2")
                && !expression.contains("=");
    }

    public String analyze(
            String expression) {

        try {

            expression =
                    expression.replace(" ", "");

            String temp =
                    expression.replace("-", "+-");

            String[] terms =
                    temp.split("\\+");

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

            double vertexX =
                    -b / (2 * a);

            double vertexY =
                    (a * vertexX * vertexX)
                            + (b * vertexX)
                            + c;

            double discriminant =
                    (b * b)
                            - (4 * a * c);

            String roots;

            if (discriminant < 0) {

                roots =
                        "No Real X Intercepts";

            } else {

                double root1 =
                        (-b + Math.sqrt(discriminant))
                                / (2 * a);

                double root2 =
                        (-b - Math.sqrt(discriminant))
                                / (2 * a);

                roots =
                        "(" + root1 + ",0), "
                                + "(" + root2 + ",0)";
            }

            String opening =
                    a > 0
                            ? "Upward"
                            : "Downward";

            return """
                    Graph Analysis

                    Vertex:
                    (%s,%s)

                    Axis Of Symmetry:
                    x = %s

                    Opening:
                    %s

                    X Intercepts:
                    %s

                    Y Intercept:
                    (0,%s)
                    """
                    .formatted(
                            vertexX,
                            vertexY,
                            vertexX,
                            opening,
                            roots,
                            c);

        } catch (Exception e) {

            return "Unable To Analyze Graph";
        }
    }

    public String generateSteps(
            String expression,
            String analysis) {

        return """
                Step 1:
                Function = %s

                Step 2:
                Identify a,b,c

                Step 3:
                Calculate Vertex

                Step 4:
                Calculate Axis Of Symmetry

                Step 5:
                Calculate X Intercepts

                Step 6:
                Calculate Y Intercept

                %s
                """
                .formatted(
                        expression,
                        analysis);
    }
}