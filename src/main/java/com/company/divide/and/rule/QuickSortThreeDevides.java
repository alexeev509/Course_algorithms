package com.company.divide.and.rule;

import java.util.Random;

public class QuickSortThreeDevides {
    public static void main(String[] args) {
        int[] mass = insertRandomNumbersInMass(8);
        qSort(mass, 0, mass.length - 1);
    }

    public static int[] insertRandomNumbersInMass(int massLenght) {
        int[] mass = new int[massLenght];
        Random random = new Random();
        for (int i = 0; i < mass.length; i++) {
            mass[i] = random.nextInt(100);
        }
        return mass;
    }

    public static int[] qSort(int[] mass, int l, int r) {
        if (l < r) {
            int[] m = partition(mass, l, r);
            qSort(mass, l, m[0] - 1);
            qSort(mass, m[1] + 1, r);
        }
        return mass;
    }

    /**
     * Разбиваем на три отрезка.
     */
    private static int[] partition(int[] array, int l, int r) {
        int ref = (int) (Math.random() * (r - l)) + l;
        int x = array[ref];
        int lm = l;
        int rm = r;
        int current = l;
        int count = l;
        while (count <= r) {
            if (array[current] < x) {
                swap(array, current, lm);
                current++;
                lm++;
            } else if (array[current] > x) {
                swap(array, current, rm);
                rm--;
            } else {
                current++;
            }
            count++;
        }
        return new int[]{lm, rm};
    }

    private static void swap(int[] mass, int i, int j) {
        int temp = mass[i];
        mass[i] = mass[j];
        mass[j] = temp;
    }
}
