package com.company.dynamic;

import java.util.Scanner;

//n+1 and m+1 because in original algorithm indexes start from zero!
public class EditDestination {
    public static void main(String[] args) {
        run(new Scanner(System.in));
    }

    public static void run(Scanner scanner) {
        String input_1 = scanner.nextLine();
        String input_2 = scanner.nextLine();
        int n = input_1.length();
        int m = input_2.length();
        int[][] D = startInitializationMassD(n + 1, m + 1);
        int minDistination = getMinDistination(D, input_1, input_2, n + 1, m + 1);
        System.out.println(minDistination);
    }

    public static int[][] startInitializationMassD(int n, int m) {
        int[][] D = new int[n][m];
        for (int i = 0; i < n; i++) {
            D[i][0] = i;
        }
        for (int j = 0; j < m; j++) {
            D[0][j] = j;
        }
        return D;
    }

    public static int getMinDistination(int[][] D, String in_1, String in_2, int n, int m) {
        for (int i = 1; i < n; i++) {
            for (int j = 1; j < m; j++) {
                int c = diff(in_1.charAt(i - 1), in_2.charAt(j - 1));
                D[i][j] = Math.min(D[i - 1][j] + 1, Math.min(D[i][j - 1] + 1, D[i - 1][j - 1] + c));
            }
        }
        return D[n - 1][m - 1];
    }

    private static int diff(char c1, char c2) {
        if (c1 != c2) {
            return 1;
        }
        return 0;
    }
}
