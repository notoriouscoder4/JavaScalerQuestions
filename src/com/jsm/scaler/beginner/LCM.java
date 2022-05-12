package com.jsm.scaler.beginner;

import java.util.Scanner;

public class LCM {

    static int gcd(int A, int B) {
        if (A == 0)
            return B;
        return gcd(B % A, A);
    }

    static int lcm(int A, int B) {
        /* gcd(A, B) * lcm(A, B) = A * B */
        return (A * B) / gcd(A, B);
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int A = sc.nextInt();
        int B = sc.nextInt();

        System.out.println(lcm(A, B));
    }
}
