package com.company.divide.and.rule;

import java.util.Scanner;

public class BinarySearch {
    public static void main(String[] args) {
        start(new Scanner(System.in));
    }

    public static void start(Scanner scanner) {
        int[] mass = createMassFromInputString(scanner.nextLine());
        int[] massOfFoundNumbers = createMassFromInputString(scanner.nextLine());
        for (int i = 0; i < massOfFoundNumbers.length; i++) {
            int index = binarySearch(mass, massOfFoundNumbers[i]);
            if (index != -1) {
                index++;
            }
            System.out.print(index + " ");
        }

    }

    public static int[] createMassFromInputString(String input) {
        String[] split = input.split(" ");
        int massLength = Integer.parseInt(split[0]);
        int[] mass = new int[massLength];
        for (int i = 1; i < split.length; i++) {
            mass[i - 1] = Integer.parseInt(split[i]);
        }
        return mass;
    }

    public static int binarySearch(int mass[], int x) {
        int low = 0;
        int high = mass.length - 1;

        while (low <= high) {
            int middle = (low + high) / 2;
            if (mass[middle] == x) {
                return middle;
            }
            if (mass[middle] < x) {
                low = middle + 1;
            } else {
                high = middle - 1;
            }
        }
        return -1;
    }
}
