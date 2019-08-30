package com.company.divide.and.rule;

import java.util.Scanner;

public class CountOfInversions {

    private static long countOfInversions = 0;

    public static void main(String[] args) {
        getCountOfInversions(new Scanner(System.in));
    }

    public static void getCountOfInversions(Scanner scanner) {
        int[] mass = getInputMass(scanner);
        mergeSort(mass, 0, mass.length - 1);
        System.out.println(countOfInversions);
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
                    countOfInversions += A.length - leftIndex;
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

    private static int[] getInputMass(Scanner scanner) {
        int countOfElements = scanner.nextInt();
        int[] mass = new int[countOfElements];
        for (int i = 0; i < countOfElements; i++) {
            mass[i] = scanner.nextInt();
        }
        return mass;
    }
}
