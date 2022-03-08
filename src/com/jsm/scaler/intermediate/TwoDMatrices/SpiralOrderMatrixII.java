package com.jsm.scaler.intermediate.TwoDMatrices;

import java.util.Arrays;

public class SpiralOrderMatrixII {
    /*
    Given an integer A, generate a square matrix filled with elements from 1 to A2 in spiral order.

    Problem Constraints
    1 <= A <= 1000

    Input Format
    First and only argument is integer A

    Output Format
    Return a 2-D matrix which consists of the elements in spiral order.

    Example Input
    Input 1:
    1

    Input 2:
    2

    Example Output
    Output 1:
    [ [1] ]

    Output 2:
    [ [1, 2], [4, 3] ]

    Example Explanation
    Explanation 1:

    Only 1 is to be arranged.

    Explanation 2:
    1 --> 2
          |
          |
    4<--- 3
    */
    public static int[][] generateMatrix(int A) {
        int[][] spiralMatrix = new int[A][A];

        int i = 0; // row
        int j = 0; // column
        int k = 1; // it denotes the value which we want to fill in the spiral matrix
        int dir = 0; // 0 -> Right, 1 -> Down, 2 -> Left, 3 -> Up

        while (k <= A * A) {
            spiralMatrix[i][j] = k;
            k = k + 1;
            if (dir == 0) { // since we are moving right
                j = j + 1;  // we will increase column by 1
                if (j == A || spiralMatrix[i][j] != 0) {
                    dir = 1;
                    j = j - 1;
                    i = i + 1;
                }
            } else if (dir == 1) { // since we are moving down
                i = i + 1;  // we will increase row by 1
                if (i == A || spiralMatrix[i][j] != 0) {
                    dir = 2;
                    i = i - 1;
                    j = j - 1;
                }
            } else if (dir == 2) { // since we are moving left
                j = j - 1;  // we will decrease column by 1
                if (j < 0 || spiralMatrix[i][j] != 0) {
                    dir = 3;
                    j = j + 1;
                    i = i - 1;
                }
            } else if (dir == 3) { // since we are moving up
                i = i - 1;  // we will decrease row by 1
                if (i < 0 || spiralMatrix[i][j] != 0) {
                    dir = 0;
                    i = i + 1;
                    j = j + 1;
                }
            }
        }

        return spiralMatrix;
    }

    public static void main(String[] args) {
        int A = 5;
        System.out.println(Arrays.deepToString(generateMatrix(A)));
    }
}
