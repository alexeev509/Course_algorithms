package com.company.greedy.algorithms.haffman;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;

public class DecodeHaffmanCode {
    public static void main(String[] args) {
        System.out.println(readInputAndDecode(new Scanner(System.in)).toString());
    }

    public static StringBuffer readInputAndDecode(Scanner scanner) {
        String reader = scanner.nextLine();
        String[] spliter = reader.split(" ");
        int countOfSymbolsInPlainTxt = Integer.parseInt(spliter[0]);
        int countOfSymbolsInHaffmanCode = Integer.parseInt(spliter[1]);
        Map<String, Character> frequencyCharsMap = new LinkedHashMap<>(countOfSymbolsInPlainTxt);
        for (int i = 0; i < countOfSymbolsInPlainTxt; i++) {
            reader = scanner.nextLine();
            spliter = reader.split(": ");
            frequencyCharsMap.put(spliter[1], spliter[0].charAt(0));
        }
        String haffmanCode = scanner.nextLine();
        return decode(haffmanCode, frequencyCharsMap);
    }

    public static StringBuffer decode(String haffmanCode, Map<String, Character> frequencyCharsMap) {
        StringBuffer result = new StringBuffer();
        char[] chars = haffmanCode.toCharArray();
        String codeOfSymbol = "";
        for (char aChar : chars) {
            codeOfSymbol += String.valueOf(aChar);
            if (frequencyCharsMap.containsKey(codeOfSymbol)) {
                result.append(frequencyCharsMap.get(codeOfSymbol));
                codeOfSymbol = "";
            }
        }
        return result;
    }
}
