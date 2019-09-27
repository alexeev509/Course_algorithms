package com.company.dynamic;

public class Money {
    private int[] D;
    private int[] C;
    private int n;

    public static void main(String[] args) {
        Money money = new Money();
        money.setN(10);
        money.setD(new int[money.getN() + 1]);
        money.setC(new int[]{1, 5, 10});
        System.out.println(money.changer());
    }

    public int changer() {
        D[0] = 0;
        D[1] = 1;
        for (int i = 2; i <= n; i++) {
            D[i] = Integer.MAX_VALUE;
            for (int j = 0; j < C.length; j++) {
                if (C[j] <= i) {
                    D[i] = Math.min(D[i], D[i - C[j]] + 1);
                }
            }
        }
        return D[n];
    }

    public int[] getD() {
        return D;
    }

    public void setD(int[] d) {
        D = d;
    }

    public int[] getC() {
        return C;
    }

    public void setC(int[] c) {
        C = c;
    }

    public int getN() {
        return n;
    }

    public void setN(int n) {
        this.n = n;
    }
}
