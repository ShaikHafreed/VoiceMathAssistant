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

        if (speech == null) {
            return "";
        }

        speech = speech.toLowerCase().trim();

        speech = speech.replace("what is", "");
        speech = speech.replace("how much is", "");
        speech = speech.replace("calculate", "");

        speech = speech.replace("square root of", "sqrt ");
        speech = speech.replace("cube root of", "cbrt ");

        speech = speech.replace("to the power of", "^");
        speech = speech.replace("raised to", "^");
        speech = speech.replace("power", "^");

        speech = speech.replace("percent of", "%");
        speech = speech.replace("percentage of", "%");

        speech = speech.replace("multiplied by", "*");
        speech = speech.replace("times", "*");
        speech = speech.replace("into", "*");

        speech = speech.replace("divided by", "/");
        speech = speech.replace("divide by", "/");

        speech = speech.replace("plus", "+");
        speech = speech.replace("minus", "-");

        speech = speech.replace("?", "");

        speech = convertWordsToNumbers(speech);

        speech = speech.replaceAll("\\s+", " ").trim();

        System.out.println("PARSED = " + speech);

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