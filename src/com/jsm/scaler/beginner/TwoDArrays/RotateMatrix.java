package com.jsm.scaler.beginner.TwoDArrays;

public class RotateMatrix {

    public static void rotateMatrix(int[][] A) {
        int len = A.length;

        for (int i = 0; i < len / 2; i++) {
            for (int j = i; j < len - i - 1; j++) {
                int temp = A[i][j];
                A[i][j] = A[len - j - 1][i];
                A[len - j - 1][i] = A[len - i - 1][len - j - 1];
                A[len - i - 1][len - j - 1] = A[j][len - i - 1];
                A[j][len - i - 1] = temp;
            }
        }
    }

    public static void displayMatrix(int[][] arr) {
        for (int i = 0; i < arr.length; i++) {
            int cols_in_current_row = arr[i].length;
            for (int j = 0; j < cols_in_current_row; j++) {
                System.out.print(arr[i][j] + " ");
            }
            System.out.println();
        }
    }

    public static void main(String[] args) {
        int[][] arr = {{1, 2, 3, 4},
                {5, 6, 7, 8},
                {9, 10, 11, 12},
                {13, 14, 15, 16}};
        rotateMatrix(arr);
        displayMatrix(arr);
    }
}
