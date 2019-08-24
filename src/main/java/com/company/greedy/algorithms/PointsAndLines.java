package com.company.greedy.algorithms;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class PointsAndLines {
    public static void main(String[] args) {

        List<Integer> points = getPoints(new Scanner(System.in));
        System.out.println(points.size());
        for (Integer point : points) {
            System.out.print(point + " ");
        }
    }

    public static List<Integer> getPoints(Scanner scanner) {
        int countOfLines = scanner.nextInt();
        int[][] massOfPoints = new int[countOfLines][2];
        for (int i = 0; i < massOfPoints.length; i++) {
            massOfPoints[i][0] = scanner.nextInt();
            massOfPoints[i][1] = scanner.nextInt();
//            System.out.println(Arrays.toString(massOfPoints[i]));
        }
        insertSort(massOfPoints);
        return getMinPoints(massOfPoints);
    }

    private static List<Integer> getMinPoints(int[][] mass) {
        List<Integer> listOfPoints = new ArrayList<>();
        int i = 0;
        while (i < mass.length) {
            int min = mass[i][1];
            listOfPoints.add(mass[i][1]);
            i++;
            while (i < mass.length && min >= mass[i][0] && min <= mass[i][1]) {
                i++;
            }
        }
        return listOfPoints;
    }

    public static int[][] insertSort(int[][] mass) {
        int j;
        for (int i = 1; i < mass.length; i++) {
            int currentStartOfLine = mass[i][0];
            int currentEndOfLine = mass[i][1];

            for (j = i - 1; j >= 0 && currentEndOfLine <= mass[j][1]; j--) {
                mass[j + 1][0] = mass[j][0];
                mass[j + 1][1] = mass[j][1];
            }
            mass[++j][0] = currentStartOfLine;
            mass[j][1] = currentEndOfLine;
        }
        return mass;
    }
}
