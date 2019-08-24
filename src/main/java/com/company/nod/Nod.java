package com.company.nod;

import java.util.Scanner;

public class Nod {
    public static void main(String[] args) {
        System.out.println(getNod(new Scanner(System.in)));
    }

    public static long getNod(Scanner scanner) {
        long a = scanner.nextLong();
        long b = scanner.nextLong();
        return getNod(a, b);
    }

    public static long getNod(long a, long b) {
        do {
            if (a == 0) {
                return b;
            }
            if (b == 0) {
                return a;
            }
            if (b >= a) {
                b = b % a;
            } else {
                a = a % b;
            }

        } while (a != 0 || b != 0);
        if (a == 0) {
            return b;
        }
        return a;

    }
}
