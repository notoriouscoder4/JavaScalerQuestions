package com.jsm.scaler.beginner;

import java.util.Scanner;

public class SumOfEvenRecursion {
    static int solve(int A) {
        if (A == 0)
            return 0;
        if (A % 2 != 0)
            return solve(A - 1);
        else
            return A + solve(A - 2);
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();

        System.out.println(solve(n));
    }
}
