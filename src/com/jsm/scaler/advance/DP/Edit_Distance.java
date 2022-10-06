package com.jsm.scaler.advance.DP;

import java.util.Arrays;

public class Edit_Distance {
    /*
    Given two strings A and B, find the minimum number of steps required to convert A to B. (each operation is counted as 1 step.)

    You have the following 3 operations permitted on a word:
    1. Insert a character
    2. Delete a character
    3. Replace a character

    Problem Constraints
    1 <= length(A), length(B) <= 450

    Input Format
    The first argument of input contains a string, A.
    The second argument of input contains a string, B.

    Output Format
    Return an integer, representing the minimum number of steps required.

    Example Input:
    Input 1:
     A = "abad"
     B = "abac"

    Input 2:
     A = "Anshuman"
     B = "Antihuman

    Example Output:
    Output 1:
     1

    Output 2:
     2

    Example Explanation:
    Explanation 1:
     A = "abad" and B = "abac"
     After applying operation: Replace d with c. We get A = B.

    Explanation 2:
     A = "Anshuman" and B = "Antihuman"
     After applying operations: Replace s with t and insert i before h. We get A = B.
    */

    private static int minDistance(String A, String B) {
        int n = A.length();
        int m = B.length();
        /* For Recursion
        return minDistance_recursion(n - 1, m - 1, A, B);
        */

        /* For Memoization */
        int[][] dp = new int[n][m];
        for (int[] row : dp) {
            Arrays.fill(row, -1);
        }
        return minDistance_memoization(n - 1, m - 1, A, B, dp);
    }

    /* TC: O(3^N * 3^M): 3 for given operations, SC: O(N+M) for recursion stack space*/
    private static int minDistance_recursion(int i, int j, String A, String B) {
        if (i < 0)
            return j + 1;
        if (j < 0)
            return i + 1;
        if (A.charAt(i) == B.charAt(j))
            return minDistance_recursion(i - 1, j - 1, A, B);
        return 1 + Math.min(minDistance_recursion(i - 1, j, A, B), // delete
                Math.min(minDistance_recursion(i, j - 1, A, B), // inset
                        minDistance_recursion(i - 1, j - 1, A, B))); // replace
    }

    /* TC: O(N*M), SC: O(N*M) + O(N+M), N*M for dp and N+M for recursion stack space*/
    private static int minDistance_memoization(int i, int j, String A, String B, int[][] dp) {
        if (i < 0) return j + 1;
        if (j < 0) return i + 1;
        if (dp[i][j] != -1)
            return dp[i][j];
        if (A.charAt(i) == B.charAt(j))
            return dp[i][j] = minDistance_memoization(i - 1, j - 1, A, B, dp);
        return dp[i][j] = 1 + Math.min(minDistance_memoization(i - 1, j, A, B, dp), // delete
                Math.min(minDistance_memoization(i, j - 1, A, B, dp), // insert
                        minDistance_memoization(i - 1, j - 1, A, B, dp))); // replace
    }

    /* TC: O(N*M), SC: O(N*M), N*M for dp */
    private static int minDistance_tabulation(String A, String B) {
        int n = A.length();
        int m = B.length();

        int[][] dp = new int[n + 1][m + 1];
        for (int i = 0; i <= n; ++i) dp[i][0] = i;
        for (int j = 0; j <= m; ++j) dp[0][j] = j;

        for (int i = 1; i <= n; ++i) {
            for (int j = 1; j <= m; ++j) {
                if (A.charAt(i - 1) == B.charAt(j - 1)) {
                    dp[i][j] = dp[i - 1][j - 1];
                } else {
                    dp[i][j] = 1 + Math.min(dp[i - 1][j - 1], Math.min(dp[i - 1][j], dp[i][j - 1]));
                }
            }
        }
        return dp[n][m];
    }

    private static int minDistance_spaceOptimization(String A, String B) {
        int n = A.length();
        int m = B.length();

        int[] prev = new int[m + 1];
        int[] cur = new int[m + 1];

        for (int j = 0; j < m + 1; ++j) prev[j] = j;

        for (int i = 1; i < n + 1; ++i) {
            cur[0] = i;
            for (int j = 1; j < m + 1; ++j) {
                if (A.charAt(i - 1) == B.charAt(j - 1)) {
                    cur[j] = prev[j - 1];
                } else {
                    cur[j] = 1 + Math.min(prev[j - 1], Math.min(prev[j], cur[j - 1]));
                }
            }
            prev = cur.clone();
        }
        return prev[m];
    }

    public static void main(String[] args) {
        String A = "Anshuman";
        String B = "Antihuman";
        System.out.println(minDistance_spaceOptimization(A, B));
    }
}
