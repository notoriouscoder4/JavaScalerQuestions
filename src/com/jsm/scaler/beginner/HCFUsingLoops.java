package com.jsm.scaler.beginner;

import java.util.Scanner;

public class HCFUsingLoops {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();

        for (int i = 1; i <= T; i++) {
            int A = sc.nextInt();
            int B = sc.nextInt();

            System.out.println(gcdOrHcf(A, B));
        }
    }

    public static int gcdOrHcf(int A, int B) {
        if (A == 0)
            return B;
        return gcdOrHcf(B % A, A);
    }
}
