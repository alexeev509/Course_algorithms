package com.company.dynamic;

import java.util.Scanner;

//http://e-maxx.ru/algo/longest_increasing_subseq_log
//https://www.youtube.com/watch?time_continue=696&v=S9oUiVYEq7E
//https://www.geeksforgeeks.org/longest-monotonically-increasing-subsequence-size-n-log-n/
//
public class BiggestSequenceWithSoutElements {

    public static int[] lis(int[] a) {
        int n = a.length;
        int[] tail = new int[n];
        int[] prev = new int[n];

        int len = 0;
        for (int i = 0; i < n; i++) {
            int pos = lower_bound(a, tail, len, a[i]);
            if (pos == len) {
                ++len;
            }
            prev[i] = pos > 0 ? tail[pos - 1] : -1;
            tail[pos] = i;
        }

        int[] res = new int[len];
        for (int i = tail[len - 1]; i >= 0; i = prev[i]) {
            res[--len] = i + 1;
        }
        return res;
    }

    static int lower_bound(int[] a, int[] tail, int len, int key) {
        int lo = -1;
        int hi = len;
        while (hi - lo > 1) {
            int mid = (lo + hi) >>> 1;
            if (a[tail[mid]] >= key) {
                lo = mid;
            } else {
                hi = mid;
            }
        }
        return hi;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = scanner.nextInt();
        int[] a = new int[n];
        for (int i = 0; i < n; i++) a[i] = scanner.nextInt();

        int[] lis = lis(a);

        System.out.println(lis.length);
        for (int i = 0; i < lis.length; i++)
            System.out.print(lis[i] + " ");
    }


}


//    public static int findSequence(int[] mass) {
//        int[] d = new int[mass.length];
//
//        for (int i = mass.length-1; i >=0; i--) {
//            d[i] = 1;
//            for (int j =  mass.length-1; j > i; j--) {
//                //Think about d !!
//                if (mass[j] <= mass[i] && d[j] + 1 > d[i]) {
//                    d[i] = d[j] + 1;
//                }
//            }
//        }
//
//        int maxIndex = getMaxIndex(d);
//        int max = d[maxIndex];
//        int tempValue = max;
//        int temp = maxIndex;
//        System.out.print(max+"\n"+ ++maxIndex+" ");
//
//        for (int i = maxIndex + 1; i <mass.length; i++) {
//            if (d[i] == d[temp] - 1 && mass[i] <= tempValue) {
//                System.out.print(i+1+" ");
//                temp = i;
//                tempValue = mass[i];
//            }
//        }
//        return max;
//    }
//
//
//
//    private static int getMaxIndex(int[] d) {
//        int max = d[0];
//        int maxIndex = 0;
//        for (int i = 1; i < d.length; i++) {
//            if (max < d[i]) {
//                max = d[i];
//                maxIndex = i;
//            }
//        }
//        return maxIndex;
//    }