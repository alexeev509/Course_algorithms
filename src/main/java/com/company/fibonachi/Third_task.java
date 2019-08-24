package com.company.fibonachi;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Third_task {
    private static int m;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        getFibonacciRest(scanner.nextLong(),scanner.nextLong());

    }

    public static ArrayList<Long> getSequencePeriod(long m){
        ArrayList<Long> s = new ArrayList();
        s.add((long)0);
        s.add((long)1);
        for(int i = 2; i < m * 6; i++){
            s.add((s.get(i - 1) + s.get(i - 2)) % m);
            if(s.get(i) == 1 && s.get(i-1) == 0){
                break;
            }
        }
        return s;
    }

    private static long getFibonacciRest(long n, long m){
        ArrayList<Long> s = getSequencePeriod(m);
        long period = s.size() - 2; // находим период Пизано
        int val = (int)(n % period);
        System.out.println(s.get(val));
        return s.get(val);
    }
}
