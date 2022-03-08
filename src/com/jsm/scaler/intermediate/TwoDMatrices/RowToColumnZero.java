package com.jsm.scaler.intermediate.TwoDMatrices;

import java.util.HashSet;
import java.util.Set;

public class RowToColumnZero {
    /*
    You are given a 2D integer matrix A, make all the elements in a row or
    column zero if the A[i][j] = 0. Specifically, make entire ith row and jth column zero.

    Problem Constraints
    1 <= A.size() <= 103
    1 <= A[i].size() <= 103
    0 <= A[i][j] <= 103

    Input Format
    First argument is a vector of vector of integers.(2D matrix).

    Output Format
    Return a vector of vector after doing required operations.
    */

    public static int[][] solve(int[][] A) {
        Set<Integer> zero_rows = new HashSet<>();
        Set<Integer> zero_cols = new HashSet<>();

        for (int i = 0; i < A.length; i++) {
            for (int j = 0; j < A[0].length; j++) {
                if (A[i][j] == 0) {
                    if (!zero_rows.contains(i)) {
                        zero_rows.add(i);
                    }

                    if (!zero_cols.contains(j)) {
                        zero_cols.add(j);
                    }
                }
            }
        }

        for (int r : zero_rows) {
            for (int c = 0; c < A[0].length; ++c) {
                A[r][c] = 0;
            }
        }

        for (int c : zero_cols) {
            for (int r = 0; r < A.length; ++r) {
                A[r][c] = 0;
            }
        }

        return A;
    }
}
