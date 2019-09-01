package com.company.divide.and.rule;

import java.util.Random;

//https://www.geeksforgeeks.org/quicksort-tail-call-optimization-reducing-worst-case-space-log-n/
public class QuickSortTailRecursion {
    public static void main(String[] args) {
        int[] mass = insertRandomNumbersInMass(8);
        sort(mass, 0, mass.length - 1);
    }

    public static int[] insertRandomNumbersInMass(int massLenght) {
        int[] mass = new int[massLenght];
        Random random = new Random();
        for (int i = 0; i < mass.length; i++) {
            mass[i] = random.nextInt(100);
        }
        return mass;
    }

    public static int[] sort(int[] mass, int low, int height) {
        while (low < height) {
            int m = partition(mass, low, height);
            sort(mass, low, m - 1);
            low = m + 1;
        }
        return mass;
    }

    private static int partition(int[] mass, int low, int height) {
        int mainElement = mass[low];
        int j = low;
        for (int i = low + 1; i < height; i++) {
            if (mass[i] < mainElement) {
                swap(mass, i, ++j);
            }
        }
        swap(mass, low, j);
        return j;
    }

    private static void swap(int[] mass, int i, int j) {
        int temp = mass[i];
        mass[i] = mass[j];
        mass[j] = temp;
    }
}
