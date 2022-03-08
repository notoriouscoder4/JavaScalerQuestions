package com.jsm.scaler.beginner;

import java.util.Scanner;

public class Sum1toA {
    public static int solve(int A) {
        int ans = 0;

        for (int i = 1; i <= A; i++) {
            if (i % 2 == 0) {
                ans += i;
            }
        }
        return ans;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int A = sc.nextInt();

        solve(A);
    }
}
