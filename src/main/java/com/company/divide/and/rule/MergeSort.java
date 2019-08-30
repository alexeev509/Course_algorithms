package com.company.divide.and.rule;

import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;

public class MergeSort {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("please enter the size of array!");
        int[] mass = insertRandomNumbersInMass(scanner.nextInt());
        System.out.println(Arrays.toString(mass));
        mergeSort(mass, 0, mass.length - 1);
        System.out.println(Arrays.toString(mass));
    }

    public static int[] insertRandomNumbersInMass(int massLenght) {
        int[] mass = new int[massLenght];
        Random random = new Random();
        for (int i = 0; i < mass.length; i++) {
            mass[i] = random.nextInt(100);
        }
        return mass;
    }

    public static void mergeSort(int[] mass, int low, int heigh) {
        if (low < heigh) {

            int middle = low + (heigh - low) / 2;

            mergeSort(mass, low, middle);
            mergeSort(mass, middle + 1, heigh);

            merge(mass, low, middle, heigh);

        }
    }

    public static void merge(int[] mass, int low, int middle, int height) {
        int leftIndex = 0;
        int rightIndex = 0;
        int index = low;
        int[] A = new int[middle - low + 1];
        int[] B = new int[height - middle];

        for (int i = 0; i < A.length; i++) {
            A[i] = mass[low + i];
        }

        for (int i = 0; i < B.length; i++) {
            B[i] = mass[middle + 1 + i];
        }

        while (index <= height) {
            if (leftIndex < A.length && rightIndex < B.length) {
                if (A[leftIndex] > B[rightIndex]) {
                    mass[index++] = B[rightIndex++];

                } else if (A[leftIndex] <= B[rightIndex]) {
                    mass[index++] = A[leftIndex++];
                }
            } else if (rightIndex < B.length) {
                mass[index++] = B[rightIndex++];
            } else if (leftIndex < A.length) {
                mass[index++] = A[leftIndex++];
            }
        }
    }
}
