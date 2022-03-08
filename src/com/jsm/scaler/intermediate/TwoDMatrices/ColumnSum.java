package com.jsm.scaler.intermediate.TwoDMatrices;

import java.util.Arrays;

public class ColumnSum {
    /*
    You are given a 2D integer matrix A, return a 1D integer vector containing column-wise sums of original matrix.

    Problem Constraints

    1 <= A.size() <= 103
    1 <= A[i].size() <= 103
    1 <= A[i][j] <= 103

    Input Format
    First argument is a vector of vector of integers.(2D matrix).

    Output Format
    Return a vector conatining column-wise sums of original matrix.

    Example Input

    Input 1:
    [1,2,3,4]
    [5,6,7,8]
    [9,2,3,4]


    Example Output

    Output 1:
    {15,10,13,16}
    */

    public static int[] solve(int[][] A) {
        int[] sum = new int[A[0].length];
        for (int j = 0; j < A.length; j++) {
            for (int i = 0; i < A[0].length; i++) {
                sum[i] += A[j][i];
            }
        }
        return sum;
    }

    public static void main(String[] args) {
        int[][] A = {{1, 2, 3, 4}, {5, 6, 7, 8}, {9, 2, 3, 4}};
        System.out.println(Arrays.toString(solve(A)));
    }
}
