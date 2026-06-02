package com.voicemath.parser;

import java.util.HashMap;
import java.util.Map;

import org.springframework.stereotype.Service;

@Service
public class MathParserService {

    private static final Map<String, Integer> NUMBER_MAP = new HashMap<>();

    static {

        NUMBER_MAP.put("zero", 0);
        NUMBER_MAP.put("one", 1);
        NUMBER_MAP.put("two", 2);
        NUMBER_MAP.put("three", 3);
        NUMBER_MAP.put("four", 4);
        NUMBER_MAP.put("five", 5);
        NUMBER_MAP.put("six", 6);
        NUMBER_MAP.put("seven", 7);
        NUMBER_MAP.put("eight", 8);
        NUMBER_MAP.put("nine", 9);

        NUMBER_MAP.put("ten", 10);
        NUMBER_MAP.put("eleven", 11);
        NUMBER_MAP.put("twelve", 12);
        NUMBER_MAP.put("thirteen", 13);
        NUMBER_MAP.put("fourteen", 14);
        NUMBER_MAP.put("fifteen", 15);
        NUMBER_MAP.put("sixteen", 16);
        NUMBER_MAP.put("seventeen", 17);
        NUMBER_MAP.put("eighteen", 18);
        NUMBER_MAP.put("nineteen", 19);

        NUMBER_MAP.put("twenty", 20);
        NUMBER_MAP.put("thirty", 30);
        NUMBER_MAP.put("forty", 40);
        NUMBER_MAP.put("fifty", 50);
        NUMBER_MAP.put("sixty", 60);
        NUMBER_MAP.put("seventy", 70);
        NUMBER_MAP.put("eighty", 80);
        NUMBER_MAP.put("ninety", 90);
    }

    public String parse(String speech) {

        if (speech == null || speech.isBlank()) {
            return "";
        }
        speech = speech.replace("percent of", "%");
        speech = speech.replace("percentage of", "%");

        speech = speech.toLowerCase().trim();

        speech = speech.replace("what is", "");
        speech = speech.replace("how much is", "");
        speech = speech.replace("calculate", "");
        speech = speech.replace("solve", "");

        speech = speech.replace("cube root of", "cbrt ");
        speech = speech.replace("cube root", "cbrt ");

        speech = speech.replace("square root of", "sqrt ");
        speech = speech.replace("square root", "sqrt ");

        speech = speech.replace("root of", "sqrt ");
        speech = speech.replace("root", "sqrt ");

        speech = speech.replace("to the power of", "^");
        speech = speech.replace("raised to", "^");
        speech = speech.replace("x squared", "x^2");
        speech = speech.replace("x square", "x^2");
        speech = speech.replace("x²", "x^2");
        speech = speech.replace("power of", "^");

        speech = speech.replace("percent of", "%");
        speech = speech.replace("percentage of", "%");

        speech = speech.replace("multiplied by", "*");
        speech = speech.replace("multiply by", "*");
        speech = speech.replace("multiply", "*");
        speech = speech.replace("multiplys", "*");
        speech = speech.replace("multiplies", "*");

        speech = speech.replace("sine", "sin ");
        speech = speech.replace("cosine", "cos ");
        speech = speech.replace("tangent", "tan ");

        speech = speech.replace("natural log", "ln ");
        speech = speech.replace("natural logarithm", "ln ");
        speech = speech.replace("logarithm", "log ");

        speech = speech.replace("times", "*");
        speech = speech.replace("timess", "*");
        speech = speech.replace("time's", "*");
        speech = speech.replace("time is", "*");
        speech = speech.replace("equals", "=");
        speech = speech.replace("equal to", "=");

        speech = speech.replace("x squared", "x^2");
        speech = speech.replace("x square", "x^2");
        speech = speech.replace("x²", "x^2");
        speech = speech.replace("into", "*");
        speech = speech.replace(" x ", "*");

        speech = speech.replace("divided by", "/");
        speech = speech.replace("divide by", "/");
        speech = speech.replace("over", "/");

        speech = speech.replace("plus", "+");
        speech = speech.replace("minus", "-");

        speech = speech.replace("?", "");

        speech = convertWordsToNumbers(speech);

        speech = speech.replace("mean of", "mean ");
        speech = speech.replace("average of", "average ");
        speech = speech.replace("median of", "median ");
        speech = speech.replace("mode of", "mode ");
        speech = speech.replace("variance of", "variance ");
        speech = speech.replace("standard deviation of", "standarddeviation ");

boolean statisticsQuery =
        speech.startsWith("mean")
        || speech.startsWith("average")
        || speech.startsWith("median")
        || speech.startsWith("mode")
        || speech.startsWith("variance")
        || speech.startsWith("standarddeviation");

if (!statisticsQuery) {

    speech = speech.replaceAll("\\s+", "");
}

        System.out.println("PARSED = " + speech);
        System.out.println("FINAL PARSED = " + speech);
        System.out.println("BEFORE RETURN = " + speech);

        return speech;
    }

    private String convertWordsToNumbers(String speech) {

        String[] words = speech.split("\\s+");

        StringBuilder result = new StringBuilder();

        for (String word : words) {

            if (NUMBER_MAP.containsKey(word)) {

                result.append(NUMBER_MAP.get(word));

            } else {

                result.append(word);
            }

            result.append(" ");
        }

        return result.toString().trim();
    }
}