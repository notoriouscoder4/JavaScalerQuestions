package com.jsm.scaler.intermediate.TwoDMatrices;

public class MatrixSubtraction {
    /*
    You are given two integer matrices A and B having same size
    (Both having same number of rows (N) and columns (M)). You have to
    subtract matrix A from B and return the resultant matrix. (i.e. return the matrix A - B).

    If X and Y are two matrices of the same order (same dimensions).
    Then X - Y is a matrix of the same order as X and Y and its elements
    are obtained by subtracting the elements of Y from the corresponding
    elements of X. Thus if Z = [z[i][j]] = X - Y, then [z[i][j]] = [x[i][j]] – [y[i][j]].

    Problem Constraints

    1 <= N, M <= 103
    -109 <= A[i][j], B[i][j] <= 109



    Input Format
    First argument is a 2D integer matrix A.
    Second argument is a 2D integer matrix B.

    Output Format
    Return a 2D matrix denoting A - B.
    */

    public static int[][] solve(int[][] A, int[][] B) {
        int rows = A.length;
        int columns = B[0].length;

        int[][] C = new int[rows][columns];

        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < columns; j++) {
                C[i][j] = A[i][j] - B[i][j];
            }
        }
        return C;
    }

    public static void main(String[] args) {
        int[][] A = {};
        int[][] B = {};
    }
}
