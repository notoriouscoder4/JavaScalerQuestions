package com.jsm.scaler.intermediate.Arrays;

import java.util.Scanner;

public class MinimumPicks {
    /*
    You are given an array of integers A of size N.
    Return the difference between the maximum among all even numbers of A and the minimum among all odd numbers in A.

    Problem Constraints
    2 <= N <= 1e5
    -1e9 <= A[i] <= 1e9
    There is atleast 1 odd and 1 even number in A

    Input Format

    The first argument given is the integer array, A.

    Output Format

    Return maximum among all even numbers of A - minimum among all odd numbers in A.
    */

    public static int solve(int[] A) {
        int maxEven = Integer.MIN_VALUE;
        int minOdd = Integer.MAX_VALUE;

        for (int j : A) {
            if (j > maxEven && j % 2 == 0) {
                maxEven = j;
            } else if (j < minOdd && j % 2 != 0) {
                minOdd = j;
            }
        }

        return maxEven - minOdd;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int[] A = new int[N];
        for (int i = 0; i < N; i++) {
            A[i] = sc.nextInt();
        }

        System.out.println(solve(A));
    }
}
