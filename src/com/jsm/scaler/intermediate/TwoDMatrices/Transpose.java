package com.jsm.scaler.intermediate.TwoDMatrices;

import java.util.Arrays;

public class Transpose {
    /*
    You are given a matrix A, you have to return another matrix which is the transpose of A.

    NOTE: Transpose of a matrix A is defined as - AT[i][j] = A[j][i] ; Where 1 ≤ i ≤ col and 1 ≤ j ≤ row

    Problem Constraints

    1 <= A.size() <= 1000
    1 <= A[i].size() <= 1000
    1 <= A[i][j] <= 1000

    Input Format
    First argument is vector of vector of integers A representing matrix.

    Output Format
    You have to return a vector of vector of integers after doing required operations.
    */
    public static int[][] solve(int[][] A) {
        int rows = A.length;
        int columns = A[0].length;
        int[][] transpose_A = new int[columns][rows];
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < columns; j++) {
                transpose_A[j][i] = A[i][j];
            }
        }
        return transpose_A;
    }

    public static void main(String[] args) {
        int[][] A = {{21, 62, 16, 44, 55, 100, 16, 86, 29},
                {62, 72, 85, 35, 14, 1, 89, 15, 73},
                {42, 44, 30, 56, 25, 52, 61, 23, 54},
                {5, 35, 12, 35, 55, 74, 50, 50, 80},
                {2, 65, 65, 82, 26, 36, 66, 60, 1},
                {18, 1, 16, 91, 42, 11, 72, 97, 35},
                {23, 57, 9, 28, 13, 44, 40, 47, 98}};
        System.out.println(Arrays.deepToString(solve(A)));
    }
}
