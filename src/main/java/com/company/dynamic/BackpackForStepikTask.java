package com.company.dynamic;

import java.util.Scanner;

public class BackpackForStepikTask {
    int[][] mass;
    int W;
    int n;
    int[] w;

    public BackpackForStepikTask(Scanner scanner) {
        W = scanner.nextInt();
        n = scanner.nextInt();
        w = new int[n + 1];
        for (int i = 0; i < n; i++) {
            w[i + 1] = scanner.nextInt();
        }
        n++;
        W++;
        mass = new int[n][W];

    }

    public static void main(String[] args) {
        BackpackForStepikTask backpack = new BackpackForStepikTask(new Scanner(System.in));
        System.out.println(backpack.getMaxSumm());
    }

    public int getMaxSumm() {
        for (int i = 0; i < n; i++) {
            mass[i][0] = 0;
        }
        for (int i = 0; i < W; i++) {
            mass[0][i] = 0;
        }
        for (int i = 1; i < n; i++) {
            for (int j = 1; j < W; j++) {
                if (j >= w[i]) {
                    mass[i][j] = Math.max(mass[i - 1][j], mass[i - 1][j - w[i]] + w[i]);
                } else {
                    mass[i][j] = mass[i - 1][j];
                }
            }
        }
        return mass[n - 1][W - 1];
    }
}
