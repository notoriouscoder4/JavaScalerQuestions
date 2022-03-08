package com.jsm.beginnercodingtest;

import java.util.Scanner;

public class EvenRemainder {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int A = sc.nextInt();

        int N = sc.nextInt();
        int[] B = new int[N];

        for (int i = 0; i < N; i++) {
            B[i] = sc.nextInt();
        }

        int count = 0;
        for (int i = 0; i < B.length; i++) {
            if (B[i] % A == 2 && B[i] % A == 0) {
                count++;
            }
        }
        System.out.println("Count: " + count);
    }
}
