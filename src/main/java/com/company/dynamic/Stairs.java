package com.company.dynamic;

import java.util.Scanner;

public class Stairs {
    private int n;
    private int[] mass;

    public static void main(String[] args) {
        System.out.println(new Stairs(new Scanner(System.in)).getMaxSumm());

    }

    public Stairs(Scanner scanner) {
        n = scanner.nextInt();
        mass = new int[n];
        for (int i = 0; i < n; i++) {
            mass[i] = scanner.nextInt();
        }
    }

    public int getMaxSumm() {

        if (mass.length == 1) {
            return mass[0];
        }
        int[] D = new int[n];
        //Start condition
        D[0] = mass[0];
        if (mass[1] >= 0 && mass[0] >= 0) {
            D[1] = mass[0] + mass[1];
        } else if (mass[1] < 0 && mass[0] < 0) {
            D[1] = mass[1];
        } else if (mass[0] >= 0 && mass.length == 2) {
            D[1] = mass[0] + mass[1];
        } else if (mass[0] >= 0) {
            D[1] = mass[0];
        } else if (mass[1] >= 0) {
            D[1] = mass[1];
        }

        //
        for (int i = 2; i < mass.length; i++) {
            D[i] += Math.max(D[i - 1], D[i - 2]) + mass[i];
        }
        //
        return D[n - 1];
    }
}
