package com.jsm.scaler.beginner;

import java.util.Scanner;

public class PowerRecursion {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int p = sc.nextInt();

        System.out.println(power(n, p));
    }

    static int power(int n, int p) {
        if (p == 0)
            return 1;
        else return n * power(n, p - 1);
    }
}
