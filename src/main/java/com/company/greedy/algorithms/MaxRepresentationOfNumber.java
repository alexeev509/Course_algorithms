package com.company.greedy.algorithms;

import java.util.LinkedHashSet;
import java.util.Scanner;
import java.util.Set;

public class MaxRepresentationOfNumber {
    public static void main(String[] args) {
        getRepresentsationOfNumber(new Scanner(System.in));
    }

    public static Set<Integer> getRepresentsationOfNumber(Scanner scanner) {
        int n = scanner.nextInt();
        Set<Integer> setOfNumbers = new LinkedHashSet<>();
        int diffNumber = 1;
        while (true) {
            n -= diffNumber;
            if (n < 0) {
                break;
            }
            if (n == diffNumber || setOfNumbers.contains(new Integer(n))) {
                setOfNumbers.add(diffNumber + n);
            }
            else if (!setOfNumbers.contains(new Integer(diffNumber))) {
                setOfNumbers.add(diffNumber);
            } else {
                break;
            }
            diffNumber++;
        }
        System.out.println(setOfNumbers.size());
        for (Integer number : setOfNumbers) {
            System.out.print(number + " ");
        }
        return setOfNumbers;
    }
}

//BETTER DECISION:
//import java.util.Scanner;
//
//class Main {
//    public static void main(String[] args) {
//
//        Scanner sc = new Scanner(System.in);
//        int n = sc.nextInt();
//        int i = 1;
//
//        StringBuilder sb = new StringBuilder();
//
//        while ( n > 2 * i ) {
//            n -= i;
//            sb.append(i++ + " ");
//        }
//
//        sb.append(n);
//        System.out.println(i);
//        System.out.println(sb.toString());
//    }
//}
