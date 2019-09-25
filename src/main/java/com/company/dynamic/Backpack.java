package com.company.dynamic;

import java.util.Scanner;

public class Backpack {

    int[][] mass;
    int W;
    int n;
    int[] w;
    int[] c;

    public Backpack(Scanner scanner) {
        W = scanner.nextInt();
        n = scanner.nextInt();
        w = new int[n + 1];
        c = new int[n + 1];
        for (int i = 0; i < n; i++) {
            w[i + 1] = scanner.nextInt();
            c[i + 1] = scanner.nextInt();
        }
        n++;
        W++;
        mass = new int[n][W];

    }

    public static void main(String[] args) {
        Backpack backpack = new Backpack(new Scanner(System.in));
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
                    mass[i][j] = Math.max(mass[i - 1][j], mass[i - 1][j - w[i]] + c[i]);
                } else {
                    mass[i][j] = mass[i - 1][j];
                }
            }
        }
        return mass[n - 1][W - 1];
    }

}
//10
//        4
//        6
//        30
//        3
//        14
//        4
//        16
//        2
//        9


//13
//        5
//        3
//        1
//        4
//        6
//        5
//        4
//        8
//        7
//        9
//        6