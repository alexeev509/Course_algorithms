package com.company.greedy.algorithms;

import java.util.Arrays;
import java.util.Scanner;

public class Backpack {
    public static void main(String[] args) {
        System.out.printf("%.3f",getMaxSumm(new Scanner(System.in)));
    }

    public static Double getMaxSumm(Scanner scanner) {
        int countOfItems = scanner.nextInt();
        int visibilityOfBackpack = scanner.nextInt();
        double[][] itemsDescription = new double[countOfItems][2];
        for (int i = 0; i < itemsDescription.length; i++) {
            itemsDescription[i][0] = scanner.nextInt();
            itemsDescription[i][1] = scanner.nextInt();
        }
        insertSort(itemsDescription);
//        for (int i = 0; i < itemsDescription.length; i++) {
//            System.out.println(Arrays.toString(itemsDescription[i]));
//        }
        double resultSumm = 0;
        for (int i = 0; i < itemsDescription.length; i++) {
            if (itemsDescription[i][1] <= visibilityOfBackpack) {
                resultSumm += itemsDescription[i][0];
                visibilityOfBackpack -= itemsDescription[i][1];
            } else if (visibilityOfBackpack != 0) {
                double priceOfOneItem=itemsDescription[i][0]/itemsDescription[i][1];
                resultSumm += visibilityOfBackpack*priceOfOneItem;
                visibilityOfBackpack = 0;
                break;
            }
        }
        return resultSumm;
    }

    public static double[][] insertSort(double[][] massOfItems) {
        int j;
        for (int i = 1; i < massOfItems.length; i++) {
            double price = massOfItems[i][0];
            double capacity = massOfItems[i][1];
            double k = price / capacity;

            for (j = i - 1; j >= 0; j--) {

                double k2 =  massOfItems[j][0] / massOfItems[j][1];
                if (k > k2) {
                    massOfItems[j + 1][0] = massOfItems[j][0];
                    massOfItems[j + 1][1] = massOfItems[j][1];
                } else {
                    break;
                }
            }
            massOfItems[++j][0] =  price;
            massOfItems[j][1] =  capacity;
        }
        return massOfItems;
    }
}
