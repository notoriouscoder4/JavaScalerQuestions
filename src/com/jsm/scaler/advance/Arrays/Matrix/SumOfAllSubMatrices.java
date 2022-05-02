package com.jsm.scaler.advance.Arrays.Matrix;

import java.util.ArrayList;
import java.util.Arrays;

public class SumOfAllSubMatrices {
    /*
    Given a 2D Matrix A of dimensions N*N, we need to return the sum of all possible sub_matrices.

    Problem Constraints
    1 <= N <=30
    0 <= A[i][j] <= 10

    Input Format
    Single argument representing a 2-D array A of size N x N.

    Output Format
    Return an integer denoting the sum of all possible sub_matrices in the given matrix.

    Example Input
    A = [ [1, 1]
          [1, 1] ]

    Example Output
    16

    Example Explanation:
    Number of sub_matrices with 1 elements = 4, so sum of all such sub_matrices = 4 * 1 = 4
    Number of sub_matrices with 2 elements = 4, so sum of all such sub_matrices = 4 * 2 = 8
    Number of sub_matrices with 3 elements = 0
    Number of sub_matrices with 4 elements = 1, so sum of such sub_matrix = 4
    Total Sum = 4+8+4 = 16
    */

    private static int solve(ArrayList<ArrayList<Integer>> A) {
        // Contribution Technique
        int n = A.size();
        int sum = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                int TL = (i + 1) * (j + 1);
                int BR = (n - i) * (n - j);
                sum += (TL * BR * A.get(i).get(j));
            }
        }
        return sum;
    }

    public static void main(String[] args) {
        ArrayList<ArrayList<Integer>> A = new ArrayList<>();
        A.add(new ArrayList<>(Arrays.asList(1, 1)));
        A.add(new ArrayList<>(Arrays.asList(1, 1)));
        System.out.println(solve(A));
    }
}
