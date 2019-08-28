package com.company.divide.and.rule;

import java.util.*;

//without recursion
public class MergeSortQueue {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("please enter the size of array!");
        int[] mass = insertRandomNumbersInMass(scanner.nextInt());
        System.out.println(Arrays.toString(mass));
        mergeSort(mass);
    }

    public static int[] insertRandomNumbersInMass(int massLenght) {
        int[] mass = new int[massLenght];
        Random random = new Random();
        for (int i = 0; i < mass.length; i++) {
            mass[i] = random.nextInt(100);
        }
        return mass;
    }

    public static int[] mergeSort(int[] mass) {
        Queue<int[]> queue = new LinkedList<>();
        for (int i = 0; i < mass.length; i++) {
            queue.add(new int[]{mass[i]});
        }
        while (queue.size() > 1) {
            queue.add(merge(queue.poll(), queue.poll()));
        }
        return queue.poll();
    }

    public static int[] merge(int[] massA, int[] massB) {
        int[] resultMass = new int[massA.length + massB.length];
        int leftIndex = 0;
        int rightIndex = 0;
        int index = 0;

        while (index < resultMass.length) {
            if (leftIndex < massA.length && rightIndex < massB.length) {
                if (massA[leftIndex] > massB[rightIndex]) {
                    resultMass[index++] = massB[rightIndex++];
                } else if (massA[leftIndex] <= massB[rightIndex]) {
                    resultMass[index++] = massA[leftIndex++];
                }
            } else if (rightIndex < massB.length) {
                resultMass[index++] = massB[rightIndex++];
            } else if (leftIndex < massA.length) {
                resultMass[index++] = massA[leftIndex++];
            }
        }
        return resultMass;
    }
}
