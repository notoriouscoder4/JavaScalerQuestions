package com.jsm.scaler.intermediate.TwoDMatrices;

public class ScalarMultiplication {
    /*
    You are given a matrix A and and an integer B,
    you have to perform scalar multiplication of matrix A with an integer B.

    Problem Constraints
    1 <= A.size() <= 1000
    1 <= A[i].size() <= 1000
    1 <= A[i][j] <= 1000
    1 <= B <= 1000

    Input Format
    First argument is 2D array of integers A representing matrix.
    Second argument is an integer B.

    Output Format
    You have to return a 2D array of integers after doing required operations.
    */
    public static int[][] solve(int[][] A, int B) {
        int rows = A.length;
        int columns = A[0].length;
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < columns; j++) {
                A[i][j] *= B;
            }
        }
        return A;
    }

    public static void main(String[] args) {

    }
}
