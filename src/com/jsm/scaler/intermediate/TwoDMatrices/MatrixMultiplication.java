package com.jsm.scaler.intermediate.TwoDMatrices;

public class MatrixMultiplication {
    /*
    You are given two integer matrices A(having M X N size) and B(having N X P).
    You have to multiply matrix A with B and return the resultant matrix. (i.e. return the matrix AB).

    Problem Constraints

    1 <= M, N, P <= 100
    -100 <= A[i][j], B[i][j] <= 100

    Input Format
    First argument is a 2D integer matrix A.
    Second argument is a 2D integer matrix B.

    Output Format
    Return a 2D integer matrix denoting AB.

    when you define 2d array a=[n][m]
    n is given by array.length
    and
    m is given by array[0].length
    */

    public static int[][] solve(int[][] A, int[][] B) {
        int rows = A.length;
        int columns = B[0].length;

        int[][] C = new int[rows][columns];
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < columns; j++) {
                C[i][j] = 0;
                for (int k = 0; k < A[0].length; k++) {
                    C[i][j] += A[i][k] * B[k][j];
                }
            }
        }
        return C;
    }

    public static void main(String[] args) {
        int[][] A = {};
        int[][] B = {};
    }

}
