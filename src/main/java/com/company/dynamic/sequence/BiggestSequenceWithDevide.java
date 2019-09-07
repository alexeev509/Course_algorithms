package com.company.dynamic.sequence;

import java.util.Arrays;
import java.util.Scanner;

public class BiggestSequenceWithDevide {
    public static void main(String[] args) {
        System.out.println(run(new Scanner(System.in)));
    }

    public static int run(Scanner scanner) {
        int countOfElemenets = scanner.nextInt();
        int[] mass = new int[countOfElemenets];
        for (int i = 0; i < mass.length; i++) {
            mass[i] = scanner.nextInt();
        }
        return findSequence(mass);
    }

    public static int findSequence(int[] mass) {
        int[] d = new int[mass.length];

        for (int i = 0; i < mass.length; i++) {
            d[i] = 1;
            for (int j = 0; j < i; j++) {
                //Think about d !!
                if (mass[i] % mass[j] == 0 && d[j] + 1 > d[i]) {
                    d[i] = d[j] + 1;
                }
            }
        }
        return Arrays.stream(d).max().getAsInt();
    }
}
