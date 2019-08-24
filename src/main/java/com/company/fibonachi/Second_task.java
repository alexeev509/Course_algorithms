package com.company.fibonachi;

import java.util.Scanner;

public class Second_task {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println(getFibonachiNumber(scanner.nextInt()));
    }

    public static int getFibonachiNumber(int n){
        if(n==0){
            return 0;
        }
        if(n==1){
            return 1;
        }

        int a=0;
        int b=1;
        int c=0;
        for (int i = 0; i < n; i++) {
            c=(a+b)%10;
            a=b;
            b=c;
        }

        return a;
    }
}
