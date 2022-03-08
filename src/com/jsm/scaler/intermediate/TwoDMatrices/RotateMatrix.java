package com.jsm.scaler.intermediate.TwoDMatrices;

import java.util.Arrays;

public class RotateMatrix {
    /*
    You are given a n x n 2D matrix A representing an image.
    Rotate the image by 90 degrees (clockwise).
    You need to do this in place.
    Note: If you end up using an additional array, you will only receive partial score.

    Problem Constraints
    1 <= n <= 1000

    Input Format
    First argument is a 2D matrix A of integers

    Output Format
    Return the 2D rotated matrix.
    */

    public static int[][] solve(int[][] A) {
        int rows = A.length;
        int columns = A[0].length;

        int[][] rotateBy90 = new int[columns][rows];
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < columns; j++) {
                rotateBy90[j][i] = A[i][j];
            }
        }

        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < columns; j++) {
                int temp = rotateBy90[i][j];
                rotateBy90[i][j] = rotateBy90[j][i];
                rotateBy90[j][i] = temp;
            }
        }
        return rotateBy90;
    }

    public static void main(String[] args) {
        int[][] A = {{1, 2},
                {3, 4}};
        System.out.println(Arrays.deepToString(solve(A)));
    }
}
