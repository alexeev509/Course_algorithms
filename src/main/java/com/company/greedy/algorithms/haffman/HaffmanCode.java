package com.company.greedy.algorithms.haffman;

import java.util.*;

public class HaffmanCode {
    public static void main(String[] args) {

    }

    public static String getOptimalCode(Scanner scanner) {


        String input = scanner.nextLine();
        Map<Character, Integer> charsMapFrequency = getFrequencyOfChars(input);

        return null;
    }

    public static Map<Character, Integer> getFrequencyOfChars(String input) {
        Map<Character, Integer> mapOfChars = new HashMap<>();
        char[] inputStringChars = input.toCharArray();
        for (char aChar : inputStringChars) {
            if (mapOfChars.containsKey(aChar)) {
                mapOfChars.replace(aChar, mapOfChars.get(aChar) + 1);
            } else {
                mapOfChars.put(aChar, 1);
            }
        }
        mapOfChars = sortMapByValue(mapOfChars);
        return mapOfChars;
    }

    private static Map<Character, Integer> sortMapByValue(Map<Character, Integer> mapOfChars) {
        Map<Character, Integer> result = new LinkedHashMap<>();
        mapOfChars.entrySet()
                .stream()
                .sorted(Map.Entry.<Character, Integer>comparingByValue().reversed())
                .forEach(e -> result.put(e.getKey(), e.getValue()));
        return result;
    }
}
