package com.jsm.scaler.intermediate.TwoDMatrices;

import java.util.Arrays;

public class RowSum {
    /*
    You are given a 2D integer matrix A, return a 1D integer vector containing row-wise sums of original matrix.

    Problem Constraints
    1 <= A.size() <= 103
    1 <= A[i].size() <= 103
    1 <= A[i][j] <= 103

    Input Format
    First argument is a vector of vector of integers.(2D matrix).

    Output Format
    Return a vector conatining row-wise sums of original matrix.

    Example Input
    Input 1:

    [1,2,3,4]
    [5,6,7,8]
    [9,2,3,4]

    Example Output
    Output 1:

    {10,26,18}
    */

    public static int[] solve(int[][] A) {
        int[] rowSum = new int[A.length];

        for (int i = 0; i < A.length; i++) {
            int sum = 0;
            for (int j = 0; j < A[0].length; j++) {
                sum += A[i][j];
            }
            rowSum[i] = sum;
        }
        return rowSum;
    }

    public static void main(String[] args) {
        int[][] A = {{1, 2, 3, 4},
                {5, 6, 7, 8},
                {9, 2, 3, 4}};
        System.out.println(Arrays.toString(solve(A)));
    }
}
