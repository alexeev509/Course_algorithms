package com.company.divide.and.rule;

import java.util.Random;
import java.util.Scanner;

public class QuickSort {
    public static void main(String[] args) {
        int[] mass = insertRandomNumbersInMass(new Scanner(System.in).nextInt());
        quickSort(mass, 0, mass.length);
    }

    public static int[] insertRandomNumbersInMass(int massLenght) {
        int[] mass = new int[massLenght];
        Random random = new Random();
        for (int i = 0; i < mass.length; i++) {
            mass[i] = random.nextInt(100);
        }
        return mass;
    }

    public static int[] quickSort(int[] mass, int start, int end) {
        if (start < end) {
            int m = partition(mass, start, end);
            quickSort(mass, start, m);
            quickSort(mass, m + 1, end);
        }
        return mass;
    }

    private static int partition(int[] mass, int start, int end) {
        int meinElemenet = mass[start];
        int j = start;
        for (int i = start + 1; i < end; i++) {
            if (mass[i] < meinElemenet) {
                swap(mass, i, j + 1);
                j++;
            }
        }
        swap(mass, start, j);
        return j;
    }

    private static void swap(int[] mass, int i, int j) {
        int temp = mass[i];
        mass[i] = mass[j];
        mass[j] = temp;
    }
}
