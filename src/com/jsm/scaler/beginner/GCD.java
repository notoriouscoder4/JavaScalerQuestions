package com.jsm.scaler.beginner;

import java.util.Scanner;

public class GCD {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int A = sc.nextInt();
        int B = sc.nextInt();

        System.out.println(gcd(A, B));
    }

    public static int gcd(int A, int B) {
        if (A == 0)
            return B;

        if (B == 0)
            return A;

        if (A == B)
            return A;

        if (A > B)
            return gcd(A - B, B);
        return gcd(A, B - A);
    }
}
