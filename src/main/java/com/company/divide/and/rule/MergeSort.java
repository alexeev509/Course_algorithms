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

            int middle = (low + heigh) / 2;

            mergeSort(mass, low, middle);
            mergeSort(mass, middle + 1, heigh);

            merge(mass, low, middle, heigh);

        }
    }

    public static void merge(int[] mass, int low, int middle, int heigh) {
        int leftIndex = low;
        int rightIndex = middle + 1;
        int index = low;
        int[] copyOfMass = Arrays.copyOfRange(mass, 0, mass.length);

        while (index <= heigh) {
            if (leftIndex <= middle && rightIndex <= heigh) {
                if (copyOfMass[leftIndex] > copyOfMass[rightIndex]) {
                    mass[index++] = copyOfMass[rightIndex++];
                } else if (copyOfMass[leftIndex] <= copyOfMass[rightIndex]) {
                    mass[index++] = copyOfMass[leftIndex++];
                }
            } else if (rightIndex <= heigh) {
                mass[index++] = copyOfMass[rightIndex++];
            } else if (leftIndex <= middle) {
                mass[index++] = copyOfMass[leftIndex++];
            }
        }
    }
}
