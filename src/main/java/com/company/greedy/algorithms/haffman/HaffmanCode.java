package com.company.greedy.algorithms.haffman;


import java.util.*;

public class HaffmanCode {
    public static void main(String[] args) {
        System.out.println(getOptimalCode(new Scanner(System.in)).toString());
    }

    public static StringBuffer getOptimalCode(Scanner scanner) {

        String input = scanner.nextLine();
        Map<Character, Integer> charsMapFrequency = getFrequencyOfChars(input);
        Node tree = createTree(charsMapFrequency);
        Map<Character, String> charsAndCodes = new LinkedHashMap<>();
        createMapOdCodesForSymbols(tree, "", -1, charsAndCodes);

        return getResult(input, charsAndCodes);
    }

    private static StringBuffer getResult(String input, Map<Character, String> charsAndCodes) {
        StringBuffer result = new StringBuffer();

        for (Map.Entry<Character, String> entry : charsAndCodes.entrySet()) {
            result.append(entry.getKey())
                    .append(": ")
                    .append(entry.getValue())
                    .append("\n");
        }
        char[] chars = input.toCharArray();
        StringBuffer encodeString = new StringBuffer();
        for (int i = 0; i < chars.length; i++) {
            encodeString.append(charsAndCodes.get(chars[i]));
        }
        return new StringBuffer().append(charsAndCodes.size())
                .append(" ")
                .append(encodeString.length())
                .append("\n")
                .append(result.toString())
                .append(encodeString);
    }

    public static void createMapOdCodesForSymbols(Node currentNode, String code, Integer rightOrLeft, Map<Character, String> charsAndCodes) {
        if (currentNode == null) {
            return;
        }
        if (rightOrLeft == 1) {
            code += "1";
        }
        if (rightOrLeft == 0) {
            code += "0";
        }
        createMapOdCodesForSymbols(currentNode.getRight(), code, 1, charsAndCodes);
        createMapOdCodesForSymbols(currentNode.getLeft(), code, 0, charsAndCodes);
//        System.out.println(currentNode.symbol+" "+code);
        if (currentNode.getSymbol() != null) {
            charsAndCodes.put(currentNode.symbol, code);
        }
    }

    public static Node createTree(Map<Character, Integer> charsMapFrequency) {
        Comparator<Node> queueComparator = Comparator.comparingInt(Node::getPriority);

        Queue<Node> queue = new PriorityQueue<>(queueComparator);
        for (Map.Entry<Character, Integer> entry : charsMapFrequency.entrySet()) {
            queue.add(new Node(null, null, entry.getKey(), entry.getValue(), entry.getValue()));
        }
        while (queue.size() > 1) {
            Node nodeLeft = queue.poll();
            Node nodeRight = queue.poll();
            queue.add(new Node(nodeLeft, nodeRight, null, null, nodeLeft.getPriority() + nodeRight.getPriority()));
        }
        if (charsMapFrequency.size() == 1) {
            Node nodeTop = queue.poll();
            queue.add(new Node(nodeTop, null, null, null, nodeTop.getPriority()));
        }
        return queue.poll();
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

    private static class Node {
        Node left;
        Node Right;
        Character symbol;
        Integer frequency;
        Integer priority;

        public Node(Node left, Node right, Character symbol, Integer frequency, Integer priority) {
            this.left = left;
            Right = right;
            this.symbol = symbol;
            this.frequency = frequency;
            this.priority = priority;
        }

        public Integer getPriority() {
            return priority;
        }

        public Node getLeft() {
            return left;
        }

        public Node getRight() {
            return Right;
        }

        public Character getSymbol() {
            return symbol;
        }

        @Override
        public String toString() {
            return "Node{" +
                    "left=" + left +
                    ", Right=" + Right +
                    ", symbol=" + symbol +
                    ", frequency=" + frequency +
                    ", priority=" + priority +
                    '}';
        }
    }
}


