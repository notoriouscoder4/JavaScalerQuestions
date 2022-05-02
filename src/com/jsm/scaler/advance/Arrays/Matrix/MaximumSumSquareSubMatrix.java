package com.jsm.scaler.advance.Arrays.Matrix;

public class MaximumSumSquareSubMatrix {
    /*
    Given a 2D integer matrix A of size N x N, find a B x B submatrix where B<= N and B>= 1,
    such that the sum of all the elements in the submatrix is maximum.

    Problem Constraints
    1 <= N <= 103.
    1 <= B <= N
    -102 <= A[i][j] <= 102.

    Input Format
    First argument is an 2D integer matrix A.
    Second argument is an integer B.

    Output Format
    Return a single integer denoting the maximum sum of submatrix of size B x B.

    Example Input
    Input 1:
     A = [
            [1, 1, 1, 1, 1]
            [2, 2, 2, 2, 2]
            [3, 8, 6, 7, 3]
            [4, 4, 4, 4, 4]
            [5, 5, 5, 5, 5]
         ]
     B = 3

    Input 2:
     A = [
            [2, 2]
            [2, 2]
        ]
     B = 2

    Example Output:
    Output 1:
     48

    Output 2:
     8

    Example Explanation:
    Explanation 1:
        Maximum sum 3 x 3 matrix is
        8 6 7
        4 4 4
        5 5 5
        Sum = 48

    Explanation 2:
     Maximum sum 2 x 2 matrix is
      2 2
      2 2
      Sum = 8
    */

    private static int solve(int[][] A, int B) {
        int n = A.length;
        prefixSumMatrix(A);
        int maxSum = Integer.MIN_VALUE;
        int curr_sum;
        for (int i = B - 1; i < n; i++) {
            for (int j = B - 1; j < n; j++) {
                //Now i,j are ending index BR
                curr_sum = A[i][j];
                if (i > B - 1)
                    curr_sum -= A[i - B][j];
                if (j > B - 1)
                    curr_sum -= A[i][j - B];
                if (i > B - 1 && j > B - 1)
                    curr_sum += A[i - B][j - B];
                maxSum = Math.max(maxSum, curr_sum);
            }
        }
        return maxSum;
    }

    private static void prefixSumMatrix(int[][] A) {
        // row wise prefix sum
        for (int row = 0; row < A.length; row++) {
            int sum = A[row][0];
            for (int col = 1; col < A[row].length; col++) {
                sum = sum + A[row][col];
                A[row][col] = sum;
            }
        }

        // column wise prefix sum
        for (int col = 0; col < A[0].length; col++) {
            int sum = A[0][col];
            for (int row = 1; row < A.length; row++) {
                sum = sum + A[row][col];
                A[row][col] = sum;
            }
        }
    }

    public static void main(String[] args) {
        int[][] A = {{1, 1, 1, 1, 1},
                {2, 2, 2, 2, 2},
                {3, 8, 6, 7, 3},
                {4, 4, 4, 4, 4},
                {5, 5, 5, 5, 5}};
        int B = 3;
        System.out.println(solve(A, B));
    }
}
