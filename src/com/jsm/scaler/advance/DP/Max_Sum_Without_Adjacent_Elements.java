package com.jsm.scaler.advance.DP;

public class Max_Sum_Without_Adjacent_Elements {
    /*
    Given a 2 x N grid of integer, A, choose numbers such that the sum of the numbers is maximum and no two chosen numbers are adjacent horizontally, vertically or diagonally, and return it.

    Note: You can choose more than 2 numbers.

    Problem Constraints
    1 <= N <= 20000
    1 <= A[i] <= 2000

    Input Format
    The first and the only argument of input contains a 2d matrix, A.

    Output Format
    Return an integer, representing the maximum possible sum.

    Example Input:
    Input 1:
     A = [
            [1]
            [2]
         ]

    Input 2:
     A = [
            [1, 2, 3, 4]
            [2, 3, 4, 5]
         ]

    Example Output:
    Output 1:
     2

    Output 2:
     8

    Example Explanation:
    Explanation 1:
     We will choose 2.

    Explanation 2:
     We will choose 3 and 5.
    */

    private static int adjacent(int[][] A) {
        if (A[0].length == 1)
            return Math.max(A[0][0], A[1][0]);
        for (int i = 0; i < A[0].length; ++i)
            A[0][i] = Math.max(A[0][i], A[1][i]);

        int[] dp = solveHorizontalDP(A[0]);
        return dp[A[0].length - 1];
    }

    private static int[] solveHorizontalDP(int[] row) {
        int[] dp = new int[row.length];
        dp[0] = row[0];
        dp[1] = Math.max(row[0], row[1]);
        for (int i = 2; i < row.length; ++i) {
            dp[i] = Math.max(dp[i - 1], row[i] + dp[i - 2]);
        }
        return dp;
    }

    public static void main(String[] args) {
        int[][] A = {{1, 2, 3, 4}, {2, 3, 4, 5}};
        System.out.println(adjacent(A));
    }
}
