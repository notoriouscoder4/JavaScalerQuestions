package com.jsm.scaler.intermediate.TwoDMatrices;

public class AntiDiagonals {
    /*
    Give a N * N square matrix A, return an array of its anti-diagonals. Look at the example for more details.

    Problem Constraints
    1<= N <= 1000
    1<= A[i][j] <= 1e9

    Input Format
    First argument is an integer N, denoting the size of square 2D matrix.
    Second argument is a 2D array A of size N * N.

    Output Format
    Return a 2D integer array of size (2 * N-1) * N, representing the anti-diagonals of input array A.
    The vacant spaces in the grid should be assigned to 0.

    Example Input
    Input 1:
    3
    1 2 3
    4 5 6
    7 8 9

    Input 2:
    1 2
    3 4


    Example Output
    Output 1:

    1 0 0
    2 4 0
    3 5 7
    6 8 0
    9 0 0

    Output 2:
    1 0
    2 3
    4 0
    */
    public static int[][] diagonal(int[][] A) {
        int[][] B = new int[2 * A.length - 1][A.length];
        int rows = 0;
        for (int i = 0; i < A[0].length; i++) {
            int cols = 0;
            int x = 0, y = i;
            while (x < A.length && y >= 0) {
                B[rows][cols] = A[x][y];
                x++;
                y--;
                cols++;
            }
            int zeroes = i;
            while (zeroes < A[0].length - 1) {
                B[rows][cols] = 0;
                cols++;
                zeroes++;
            }
            rows++;
        }

        for (int i = 1; i < A.length; i++) {
            int x = i, y = A[0].length - 1;
            int cols = 0;
            while (x < A.length && y >= 0) {
                B[rows][cols] = A[x][y];
                x++;
                y--;
                cols++;
            }
            int zeroes = i;
            while (zeroes > 0) {
                B[rows][cols] = 0;
                zeroes--;
                cols++;
            }
            rows++;
        }
        return B;
    }
    public static void main(String[] args) {

    }
}
