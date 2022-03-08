package com.jsm.scaler.intermediate.TwoDMatrices;

public class MinorDiagonalSum {
    /*
    You are given a N X N integer matrix. You have to find the sum of all the minor diagonal elements of A.
    Minor diagonal of a M X M matrix A is a collection of elements A[i, j] such that i + j = M + 1 (where i, j are 1-based).

    Problem Constraints

    1 <= N <= 103
    -1000 <= A[i][j] <= 1000

    Input Format
    First and only argument is a 2D integer matrix A.

    Output Format
    Return an integer denoting the sum of minor diagonal elements.
    */

    public static int solve(int[][] A) {
        int sum = 0;
        for (int i = 0; i < A.length; i++) {
            sum += A[i][A.length - i - 1];
        }
        return sum;
    }

    public static void main(String[] args) {
        int[][] A = {{1, -2, -3},
                {-4, 5, -6},
                {-7, -8, 9}};
        System.out.println(solve(A));
    }
}
