package com.jsm.scaler.intermediate.TwoDMatrices;

import java.util.Arrays;

public class AddTheMatrices {
    /*
    You are given two matrices A & B of same size, you have to return another matrix which is the sum of A and B.

    Problem Constraints

    1 <= A.size(), B.size() <= 1000
    1 <= A[i].size(), B[i].size() <= 1000
    1 <= A[i][j], B[i][j] <= 1000

    Input Format
    First argument is vector of vector of integers representing matrix A.
    Second argument is vecotor of vector of integers representing matrix B.

    Output Format
    You have to return a vector of vector of integers after doing required operations.
    */
    public static int[][] solve(int[][] A, int[][] B) {
        int[][] C = new int[A.length][B[0].length];

        for (int i = 0; i < A.length; i++) {
            for (int j = 0; j < B[0].length; j++) {
                C[i][j] = A[i][j] + B[i][j];
            }
        }
        return C;
    }

    public static void main(String[] args) {
        int[][] A = {{6}, {2}, {3}, {10}, {1}, {3}};
        int[][] B = {{6}, {7}, {3}, {8}, {1}, {2}};

        System.out.println(Arrays.deepToString(solve(A, B)));
    }
}
