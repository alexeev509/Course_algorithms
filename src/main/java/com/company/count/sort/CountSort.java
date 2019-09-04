package com.company.count.sort;

import java.util.Scanner;

public class CountSort {
    public static final int MAX_VALUE = 10;

    public static void main(String[] args) {
        run(new Scanner(System.in));

    }

    public static int[] run(Scanner scanner) {

        int countOfElemenets = scanner.nextInt();
        int[] mass = new int[countOfElemenets];
        for (int i = 0; i < mass.length; i++) {
            mass[i] = scanner.nextInt();
        }
        return counterSort(mass);
    }

    private static int[] counterSort(int[] mass) {
        int[] result = new int[mass.length];
        int[] B = new int[MAX_VALUE];
        //Определяем количество элементов каждого типа
        for (int i = 0; i < mass.length; i++) {
            B[mass[i] - 1] = B[mass[i] - 1] + 1;
        }
        //определяем позиции куда ставить элементы
        for (int i = 1; i < MAX_VALUE; i++) {
            B[i] += B[i - 1];
        }
        for (int i = mass.length - 1; i >= 0; i--) {
            B[mass[i] - 1] -= 1;
            result[B[mass[i] - 1]] = mass[i];
        }
        printMass(result);
        return result;
    }

    private static void printMass(int[] mass) {
        for (int i = 0; i < mass.length; i++) {
            System.out.print(mass[i] + " ");
        }
    }
}
