package com.company.divide.and.rule;

import java.util.Random;
import java.util.Scanner;

public class TaskAboutLinesAndPointsQuickSort {
    private static int[] leftPoints;
    private static int[] rightPoints;
    private static int[] massOfPoints;

    public static void main(String[] args) {
        start(new Scanner(System.in));
    }

    public static void start(Scanner scanner) {
        int countOfLines = scanner.nextInt();
        int countOfPoints = scanner.nextInt();
        insertInputValuesInMasses(scanner, countOfLines);
        insertInputValuesInMassOfPoints(scanner, countOfPoints);
        QuickSortForLines.qSort(leftPoints, 0, leftPoints.length - 1);
        QuickSortForLines.qSort(rightPoints, 0, rightPoints.length - 1);

        for (int i = 0; i < massOfPoints.length; i++) {
            int count = 0;
            for (int j = 0; j < leftPoints.length; j++) {
                if (leftPoints[j] <= massOfPoints[i] && rightPoints[j] >= massOfPoints[i]) {
                    count++;
                }
            }
            System.out.print(count + " ");
        }


    }

    public static void insertInputValuesInMasses(Scanner scanner, int countOfLines) {
        leftPoints = new int[countOfLines];
        rightPoints = new int[countOfLines];
        for (int i = 0; i < countOfLines; i++) {
            leftPoints[i] = scanner.nextInt();
            rightPoints[i] = scanner.nextInt();
        }
    }

    public static void insertInputValuesInMassOfPoints(Scanner scanner, int countOfPoints) {
        massOfPoints = new int[countOfPoints];
        for (int i = 0; i < countOfPoints; i++) {
            massOfPoints[i] = scanner.nextInt();
        }
    }
}

class QuickSortForLines {
    private static Random r = new Random();

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
//        int ref = (int) (Math.random() * (r - l)) + l;
        int ref = l - (l - r) / 2;
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

//    public static void binarySearch(int[] mass,int x){
//        int low=0;
//        int height=mass.length;
//        int middle=low-(low-height)/2;
//        int count=0;
//        while (low<height){
//            if(mass[middle]==x){
//                count++;
//            }
//            if(mass[middle]<)
//        }
//    }
}


//        int median=mass[i][columnZeroOrFirst];
//        if((mass[cur][columnZeroOrFirst]<mass[j][columnZeroOrFirst] &&
//                mass[i][columnZeroOrFirst]>mass[j][columnZeroOrFirst])
//                ||
//                (mass[cur][columnZeroOrFirst]>mass[j][columnZeroOrFirst] &&
//                        mass[i][columnZeroOrFirst]<mass[j][columnZeroOrFirst])){
//            cur=j;
//        }else if((mass[cur][columnZeroOrFirst]<mass[i][columnZeroOrFirst] &&
//                mass[j][columnZeroOrFirst]>mass[i][columnZeroOrFirst])
//                ||
//                (mass[cur][columnZeroOrFirst]>mass[i][columnZeroOrFirst] &&
//                        mass[j][columnZeroOrFirst]<mass[i][columnZeroOrFirst])){
//            cur=i;
//        }