package com.jsm.scaler.advance.DP;

import java.util.Arrays;

public class Knapsack_0_1_II {
    /*
    Given two integer arrays A and B of size N each which represent values and weights associated with N items respectively.
    Also given an integer C which represents knapsack capacity.
    Find out the maximum value subset of A such that sum of the weights of this subset is smaller than or equal to C.

    NOTE: You cannot break an item, either pick the complete item, or don’t pick it (0-1 property).

    Problem Constraints
    1 <= N <= 500
    1 <= C, B[i] <= 10^6
    1 <= A[i] <= 50

    Input Format:
    First argument is an integer array A of size N denoting the values on N items.
    Second argument is an integer array B of size N denoting the weights on N items.
    Third argument is an integer C denoting the knapsack capacity.

    Output Format:
    Return a single integer denoting the maximum value subset of A such that sum of the weights of this subset is smaller than or equal to C.

    Example Input:
    Input 1:
     A = [6, 10, 12]
     B = [10, 20, 30]
     C = 50

    Input 2:
     A = [1, 3, 2, 4]
     B = [12, 13, 15, 19]
     C = 10

    Example Output:
    Output 1:
     22

    Output 2:
     0

    Example Explanation:
    Explanation 1:
     Taking items with weight 20 and 30 will give us the maximum value i.e. 10 + 12 = 22

    Explanation 2:
     Knapsack capacity is 10 but each item has weight greater than 10 so no items can be considered in the knapsack therefore answer is 0.
    */

    private static int solve(int[] A, int[] B, int C) {
        return knapsack(B, A, C);
    }

    static int knapsack(int[] W, int[] V, int K) {
        int N = W.length;
        int[] dp = new int[K + 1];

        for (int i = 1; i <= N; i++) {
            for (int j = K; j >= 0; j--) {
                dp[j] = dp[j];

                if (j >= W[i - 1]) {
                    dp[j] = Math.max(dp[j], dp[j - W[i - 1]] + V[i - 1]);
                }
            }
        }
        return dp[K];
    }

    /*
    Time Complexity: O(N*W)
    Reason: There are N*W states therefore at max ‘N*W’ new problems will be solved.

    Space Complexity: O(N*W) + O(N)
    Reason: We are using a recursion stack space(O(N)) and a 2D array ( O(N*W)).
    */
    private static int knapsack_memoization(int i, int j, int[] W, int[] V, int[][] dp) {
        if (i == 0 || j == 0)

            // It means there is no item and capacity of knapsack
            return 0;
        /*if (i == 0) {
            if (j >= W[0]) return V[0];
            else return 0;
        }*/
        if (dp[i][j] == -1) {
            int leave = knapsack_memoization(i - 1, j, W, V, dp); // leave ith item
            int pick = Integer.MIN_VALUE;
            if (j >= W[i]) { // pick ith item
                pick = knapsack_memoization(i - 1, j - W[i], W, V, dp) + V[i];
            }
            dp[i][j] = Math.max(leave, pick);
        }
        return dp[i][j];
    }

    private static int knapsack_tabulation(int N, int K, int[] W, int[] V) {
        int[][] dp = new int[N][K + 1];
        // Base case
        for (int j = 0; j <= K; ++j) {
            dp[0][j] = 0;
        }

        for (int i = 1; i < N; ++i) {
            for (int j = 0; j <= K; ++j) {
                int leave = dp[i - 1][j];
                int pick = Integer.MIN_VALUE;
                if (j >= W[i]) {
                    pick = dp[i - 1][j - W[i]] + V[i];
                }
                dp[i][j] = Math.max(leave, pick);
            }
        }
        return dp[N - 1][K];
    }

    public static void main(String[] args) {
        int[] A = {18, 35, 1, 20, 25, 29, 9, 13, 15, 6, 46, 32, 28, 12, 42, 46, 43, 28, 37, 42, 5, 3, 4, 43, 33, 22, 17, 19, 46, 48, 27, 22, 39, 20, 13, 18, 50, 36, 45, 4, 12, 23, 34, 24, 15, 42, 12, 4, 19, 48, 45, 13, 8, 38, 10, 24, 42, 30, 29, 17, 36, 41, 43, 39, 7, 41, 43, 15, 49, 47, 6, 41, 30, 21, 1, 7, 2, 44, 49, 30, 24, 35, 5, 7, 41, 17, 27, 32, 9, 45, 40, 27, 24, 38, 39, 19, 33, 30, 42, 34, 16, 40, 9, 5, 31, 28, 7, 24, 37, 22, 46, 25, 23, 21, 30, 28, 24, 48, 13, 37, 41, 12, 37, 6, 18, 6, 25, 32, 3, 1, 1, 42, 25, 17, 31, 8, 42, 8, 38, 8, 38};
        int[] B = {3652, 5620, 2574, 3471, 3957, 4692, 4855, 3740, 991, 5446, 5089, 2066, 4314, 1740, 2476, 1798, 4994, 3206, 5406, 4370, 3471, 3350, 5458, 6175, 4982, 4908, 3504, 4251, 3804, 893, 5139, 3420, 3263, 2234, 2851, 1815, 5971, 1644, 3276, 1454, 2193, 1766, 4670, 1177, 2712, 1593, 5798, 3759, 4293, 5488, 5232, 4670, 2768, 5252, 1561, 5195, 3396, 206, 5801, 5381, 4786, 3923, 2488, 4077, 1170, 3607, 2707, 4420, 5189, 1150, 2848, 4085, 1618, 1004, 5853, 1801, 4675, 2103, 4535, 5587, 3603, 4176, 4239, 5384, 3981, 1067, 5498, 4585, 5126, 5766, 2509, 3762, 3696, 3845, 5401, 4180, 1494, 1705, 4219, 3584, 252, 1672, 4467, 5470, 5473, 1460, 1743, 1637, 1292, 2491, 1367, 1531, 4693, 5524, 1604, 2675, 3483, 5577, 1390, 5271, 2833, 931, 3553, 3622, 2825, 3333, 4988, 3127, 451, 3774, 5249, 1886, 3543, 2042, 3272, 2971, 3624, 4364, 3204, 5095, 4711};
        int C = 809580;

        System.out.println("The maximum value of items: " + solve(A, B, C));
    }
}
