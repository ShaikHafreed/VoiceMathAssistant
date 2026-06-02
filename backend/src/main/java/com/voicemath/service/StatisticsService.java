package com.voicemath.service;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

import org.springframework.stereotype.Service;

@Service
public class StatisticsService {

    public boolean isStatistics(String expression) {

        if (expression == null) {
            return false;
        }

        expression = expression.toLowerCase();

        return expression.startsWith("mean")
                || expression.startsWith("average")
                || expression.startsWith("median")
                || expression.startsWith("mode")
                || expression.startsWith("variance")
                || expression.startsWith("stddev")
                || expression.startsWith("standarddeviation");
    }

    public String solve(String expression) {

        try {

            expression = expression.toLowerCase();

            double[] values =
                    extractNumbers(expression);

            if (values.length == 0) {
                return "Invalid Statistics Expression";
            }

            // Mean / Average
            if (expression.startsWith("mean")
                    || expression.startsWith("average")) {

                double sum = 0;

                for (double n : values) {
                    sum += n;
                }

                return String.valueOf(
                        sum / values.length);
            }

            // Median
            if (expression.startsWith("median")) {

                Arrays.sort(values);

                int middle =
                        values.length / 2;

                if (values.length % 2 == 0) {

                    double median =
                            (values[middle - 1]
                                    + values[middle]) / 2;

                    return String.valueOf(median);
                }

                return String.valueOf(
                        values[middle]);
            }

            // Mode
            if (expression.startsWith("mode")) {

                Map<Double, Integer> count =
                        new HashMap<>();

                double mode = values[0];
                int max = 0;

                for (double n : values) {

                    count.put(
                            n,
                            count.getOrDefault(n, 0) + 1);

                    if (count.get(n) > max) {

                        max = count.get(n);
                        mode = n;
                    }
                }

                return String.valueOf(mode);
            }

            // Variance
            if (expression.startsWith("variance")) {

                double mean =
                        calculateMean(values);

                double variance = 0;

                for (double n : values) {

                    variance +=
                            Math.pow(
                                    n - mean,
                                    2);
                }

                variance /= values.length;

                return String.valueOf(
                        variance);
            }

            // Standard Deviation
            if (expression.startsWith("stddev")
                    || expression.startsWith("standarddeviation")) {

                double mean =
                        calculateMean(values);

                double variance = 0;

                for (double n : values) {

                    variance +=
                            Math.pow(
                                    n - mean,
                                    2);
                }

                variance /= values.length;

                return String.valueOf(
                        Math.sqrt(variance));
            }

            return "Unknown";

        } catch (Exception e) {

            e.printStackTrace();
            return "Invalid Statistics Expression";
        }
    }

    public String generateSteps(
            String expression,
            String result) {

        expression =
                expression.toLowerCase();

        double[] values =
                extractNumbers(expression);

        // Average / Mean
        if (expression.startsWith("mean")
                || expression.startsWith("average")) {

            double sum = 0;

            for (double n : values) {
                sum += n;
            }

            return """
                    📊 Statistics Solution

                    Numbers:
                    %s

                    Step 1:
                    Add all values

                    Sum = %.2f

                    Step 2:
                    Count values

                    Count = %d

                    Step 3:
                    Mean = Sum / Count

                    Mean = %.2f / %d

                    Final Answer = %s
                    """
                    .formatted(
                            Arrays.toString(values),
                            sum,
                            values.length,
                            sum,
                            values.length,
                            result);
        }

        // Median
        if (expression.startsWith("median")) {

            return """
                    📊 Statistics Solution

                    Numbers:
                    %s

                    Step 1:
                    Sort the numbers

                    Step 2:
                    Select middle value

                    Final Answer = %s
                    """
                    .formatted(
                            Arrays.toString(values),
                            result);
        }

        // Mode
        if (expression.startsWith("mode")) {

            return """
                    📊 Statistics Solution

                    Numbers:
                    %s

                    Step 1:
                    Count occurrences of each value

                    Step 2:
                    Find most frequent value

                    Final Answer = %s
                    """
                    .formatted(
                            Arrays.toString(values),
                            result);
        }

        // Variance
        if (expression.startsWith("variance")) {

            return """
                    📊 Statistics Solution

                    Numbers:
                    %s

                    Step 1:
                    Calculate Mean

                    Step 2:
                    Calculate squared differences

                    Step 3:
                    Average squared differences

                    Final Answer = %s
                    """
                    .formatted(
                            Arrays.toString(values),
                            result);
        }

        // Standard Deviation
        if (expression.startsWith("stddev")
                || expression.startsWith("standarddeviation")) {

            return """
                    📊 Statistics Solution

                    Numbers:
                    %s

                    Step 1:
                    Calculate Variance

                    Step 2:
                    Take Square Root of Variance

                    Final Answer = %s
                    """
                    .formatted(
                            Arrays.toString(values),
                            result);
        }

        return """
                📊 Statistics Solution

                Result = %s
                """
                .formatted(result);
    }

    private double calculateMean(
            double[] values) {

        double sum = 0;

        for (double n : values) {
            sum += n;
        }

        return sum / values.length;
    }

    private double[] extractNumbers(
            String expression) {

        String numbers =
                expression.replaceAll(
                        "[^0-9 ]",
                        " ");

        String[] parts =
                numbers.trim()
                        .split("\\s+");

        double[] result =
                new double[parts.length];

        for (int i = 0; i < parts.length; i++) {

            result[i] =
                    Double.parseDouble(
                            parts[i]);
        }

        return result;
    }
}