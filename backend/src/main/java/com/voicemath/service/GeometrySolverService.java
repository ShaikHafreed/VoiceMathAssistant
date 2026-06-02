package com.voicemath.service;

import org.springframework.stereotype.Service;

@Service
public class GeometrySolverService {

    public boolean isGeometry(
            String expression) {

        expression =
                expression.toLowerCase();

        return expression.contains("circle")
                || expression.contains("rectangle")
                || expression.contains("triangle")
                || expression.contains("sphere")
                || expression.contains("cube")
                || expression.contains("cylinder");
    }

    public String solve(
            String expression) {

        try {

            expression =
                    expression.toLowerCase();

            // AREA OF CIRCLE

            if (expression.contains("areaofcircle")) {

                double radius =
                        extractNumber(
                                expression);

                double area =
                        Math.PI
                                * radius
                                * radius;

                return String.valueOf(area);
            }

            // CIRCUMFERENCE

            if (expression.contains("circumferenceofcircle")) {

                double radius =
                        extractNumber(
                                expression);

                double circumference =
                        2
                                * Math.PI
                                * radius;

                return String.valueOf(
                        circumference);
            }

            // RECTANGLE AREA

            if (expression.contains("areaofrectangle")) {

                double[] values =
                        extractTwoNumbers(
                                expression);

                return String.valueOf(
                        values[0]
                                * values[1]);
            }

            // RECTANGLE PERIMETER

            if (expression.contains("perimeterofrectangle")) {

                double[] values =
                        extractTwoNumbers(
                                expression);

                return String.valueOf(
                        2
                                * (values[0]
                                + values[1]));
            }

            // TRIANGLE AREA

            if (expression.contains("areaoftriangle")) {

                double[] values =
                        extractTwoNumbers(
                                expression);

                return String.valueOf(
                        0.5
                                * values[0]
                                * values[1]);
            }

            // SPHERE VOLUME

            if (expression.contains("volumeofsphere")) {

                double radius =
                        extractNumber(
                                expression);

                double volume =
                        (4.0 / 3.0)
                                * Math.PI
                                * Math.pow(
                                        radius,
                                        3);

                return String.valueOf(
                        volume);
            }

            // CUBE VOLUME

            if (expression.contains("volumeofcube")) {

                double side =
                        extractNumber(
                                expression);

                return String.valueOf(
                        Math.pow(
                                side,
                                3));
            }

            // CYLINDER VOLUME

            if (expression.contains("volumeofcylinder")) {

                double[] values =
                        extractTwoNumbers(
                                expression);

                double radius =
                        values[0];

                double height =
                        values[1];

                double volume =
                        Math.PI
                                * radius
                                * radius
                                * height;

                return String.valueOf(
                        volume);
            }

            return "Unable To Solve";

        } catch (Exception e) {

            return "Unable To Solve";
        }
    }

 public String generateSteps(
        String expression,
        String result) {

    if (expression.contains("areaofcircle")) {

        String radius =
                expression.replaceAll("[^0-9]", "");

        return """
                Step 1: Formula

                Area = π × r²

                Step 2: Substitute

                Area = π × %s²

                Step 3: Calculate

                Area = %s
                """
                .formatted(radius, result);
    }

    if (expression.contains("circumferenceofcircle")) {

        String radius =
                expression.replaceAll("[^0-9]", "");

        return """
                Step 1: Formula

                Circumference = 2πr

                Step 2: Substitute

                Circumference = 2 × π × %s

                Step 3: Result

                Circumference = %s
                """
                .formatted(radius, result);
    }

    if (expression.contains("volumeofcube")) {

        String side =
                expression.replaceAll("[^0-9]", "");

        return """
                Step 1: Formula

                Volume = side³

                Step 2: Substitute

                Volume = %s³

                Step 3: Calculate

                Volume = %s
                """
                .formatted(side, result);
    }

    if (expression.contains("areaoftriangle")) {

        return """
                Step 1: Formula

                Area = ½ × base × height

                Step 2: Substitute values

                Step 3: Calculate

                Area = %s
                """
                .formatted(result);
    }

    return """
            Geometry Solution

            Result = %s
            """
            .formatted(result);
}

    private double extractNumber(
            String text) {

        String number =
                text.replaceAll(
                        "[^0-9.]",
                        "");

        return Double.parseDouble(
                number);
    }

    private double[] extractTwoNumbers(
            String text) {

        String numbers =
                text.replaceAll(
                        "[^0-9 ]",
                        " ");

        String[] values =
                numbers.trim()
                        .split("\\s+");

        return new double[] {
                Double.parseDouble(
                        values[0]),
                Double.parseDouble(
                        values[1])
        };
    }
}