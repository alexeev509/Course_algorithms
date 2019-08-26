package com.company.greedy.algorithms.heap;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Heap {
    private static List<Integer> heap = new ArrayList<>();

    public static void main(String[] args) {
        start(new Scanner(System.in));
    }

    public static void start(Scanner scanner) {
        int countOfCommands = scanner.nextInt();
        for (int i = 0; i < countOfCommands + 1; i++) {
            String command = scanner.nextLine();
            switch (command.split(" ")[0]) {
                case "Insert":
                    insertElementInMaxHeap(Integer.parseInt(command.split(" ")[1]));
                    break;
                case "ExtractMax":
                    extractMax();
                    break;
            }
        }
    }

    public static List<Integer> extractMax() {
        int max = heap.get(0);
        System.out.println(max);
        heap.remove(siftDown());
        return heap;
    }

    public static List<Integer> insertElementInMaxHeap(int element) {
        heap.add(element);
        siftUp();
        return heap;
    }

    public static int siftDown() {
        int parentIndex = 0;
        int childIndex = (parentIndex * 2) + 1;
        while (childIndex < heap.size()) {

            if (childIndex + 1 < heap.size() && heap.get(childIndex) <= heap.get(childIndex + 1)) {
                swap(parentIndex, childIndex + 1);
                parentIndex = childIndex + 1;

            } else {
                swap(parentIndex, childIndex);
                parentIndex = childIndex;
            }
            childIndex = (parentIndex * 2) + 1;
        }
        return parentIndex;
    }

    public static void siftUp() {
        int childIndex = heap.size() - 1;
        int parentIndex = (childIndex - 1) / 2;
        while (heap.get(parentIndex) < heap.get(childIndex)) {
            swap(parentIndex, childIndex);
            childIndex = parentIndex;
            parentIndex = (childIndex - 1) / 2;
        }
    }

    public static void swap(int firstIndex, int secondIndex) {
        Integer temp = heap.get(firstIndex);
        heap.set(firstIndex, heap.get(secondIndex));
        heap.set(secondIndex, temp);
    }
}
