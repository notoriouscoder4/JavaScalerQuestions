package com.jsm.scaler.advance.DP;

import java.util.Arrays;

public class Cutting_A_Rod {
    /*
    Given a rod of length N units and an array A of size N denotes prices that contains prices of all pieces of size 1 to N.
    Find and return the maximum value that can be obtained by cutting up the rod and selling the pieces.

    Problem Constraints
    1 <= N <= 1000
    0 <= A[i] <= 10^6

    Input Format
    First and only argument is an integer array A of size N.

    Output Format
    Return an integer denoting the maximum value that can be obtained by cutting up the rod and selling the pieces.

    Example Input:
    Input 1:
     A = [3, 4, 1, 6, 2]

    Input 2:
     A = [1, 5, 2, 5, 6]

    Example Output:
    Output 1:
     15

    Output 2:
     11

    Example Explanation:
    Explanation 1:
     Cut the rod of length 5 into 5 rods of length (1, 1, 1, 1, 1) and sell them for (3 + 3 + 3 + 3 + 3) = 15.

    Explanation 2:
     Cut the rod of length 5 into 3 rods of length (2, 2, 1) and sell them for (5 + 5 + 1) = 11.
    */

    private static int solve(int[] A) {
        int n = A.length;
        int[][] dp = new int[n][n + 1];
        for (int[] row : dp) {
            Arrays.fill(row, -1);
        }
        return cuttingRod_memoization(A, n - 1, n, dp);
    }

    private static int cuttingRod_memoization(int[] price, int i, int j, int[][] dp) {
        if (i == 0)
            return j * price[0];
        if (dp[i][j] == -1) {
            int notTaken = cuttingRod_memoization(price, i - 1, j, dp);
            int taken = Integer.MIN_VALUE;
            if (j >= i + 1) {
                taken = cuttingRod_memoization(price, i, j - (i + 1), dp) + price[i];
            }
            dp[i][j] = Math.max(notTaken, taken);
        }
        return dp[i][j];
    }

    private static int cuttingRod_tabulation(int[] price) {
        int n = price.length;
        int[][] dp = new int[n][n + 1];

        for (int j = 0; j <= n; ++j) {
            dp[0][j] = j * price[0];
        }

        for (int i = 1; i < n; ++i) {
            for (int j = 0; j <= n; ++j) {
                int notTaken = dp[i - 1][j];
                int taken = Integer.MIN_VALUE;
                if (j >= i + 1) {
                    taken = dp[i][j - (i + 1)] + price[i];
                }
                dp[i][j] = Math.max(notTaken, taken);
            }
        }
        return dp[n - 1][n];
    }

    public static void main(String[] args) {
        int[] A = {1, 5, 2, 5, 6};
        System.out.println(cuttingRod_tabulation(A));
    }
}
