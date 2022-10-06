package com.jsm.scaler.advance.DP;

import java.util.Arrays;

public class Longest_Common_Subsequence {
    /*
    Given two strings A and B. Find the longest common subsequence ( A sequence which does not need to be contiguous),
    which is common in both the strings.
    You need to return the length of such longest common subsequence.

    Problem Constraints
    1 <= Length of A, B <= 1005

    Input Format
    First argument is a string A.
    Second argument is a string B.

    Output Format
    Return an integer denoting the length of the longest common subsequence.

    Example Input:
    Input 1:
     A = "abbcdgf"
     B = "bbadcgf"

    Input 2:
     A = "aaaaaa"
     B = "ababab"

    Example Output:
    Output 1:
     5

    Output 2:
     3

    Example Explanation:
    Explanation 1:
     The longest common subsequence is "bbcgf", which has a length of 5.

    Explanation 2:
     The longest common subsequence is "aaa", which has a length of 3.
    */


    /*
        Time Complexity: O(N*M)
        Reason: There are N*M states therefore at max ‘N*M’ new problems will be solved.
    */
    /*
        Space Complexity: O(N*M) + O(N+M)
        Reason: We are using an auxiliary recursion stack space(O(N+M)) (see the recursive tree, in the worst case, we will go till N+M calls at a time) and a 2D array ( O(N*M)).
    */
    private static int lcs_memoization(String A, String B, int i, int j, int[][] dp) {
        if (i < 0 || j < 0) return 0;
        if (dp[i][j] != -1) return dp[i][j];

        if (A.charAt(i) == B.charAt(j))
            return dp[i][j] = 1 + lcs_memoization(A, B, i - 1, j - 1, dp);
        else
            return dp[i][j] = Math.max(lcs_memoization(A, B, i - 1, j, dp), lcs_memoization(A, B, i, j - 1, dp));
    }

    /*
        Time Complexity: O(N*M)
        Reason: There are two nested loops
    */
    /*
        Space Complexity: O(N*M)
        Reason: We are using an external array of size ‘N*M’. Stack Space is eliminated.
    */
    private static int lcs_tabulation(String A, String B) {
        int n = A.length();
        int m = B.length();

        int[][] lcs = new int[n + 1][m + 1];
        for (int[] rows : lcs)
            Arrays.fill(rows, -1);

        for (int i = 0; i <= n; i++) {
            lcs[i][0] = 0;
        }
        for (int i = 0; i <= m; i++) {
            lcs[0][i] = 0;
        }

        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= m; j++) {
                if (A.charAt(i - 1) == B.charAt(j - 1))
                    lcs[i][j] = 1 + lcs[i - 1][j - 1];
                else
                    lcs[i][j] = Math.max(lcs[i - 1][j], lcs[i][j - 1]);
            }
        }

        return lcs[n][m];
    }

    /*
        Time Complexity: O(N*M)
        Reason: There are two nested loops.
    */
    /*
        Space Complexity: O(M)
        Reason: We are using an external array of size ‘M+1’ to store only two rows.
    */
    private static int lcs_tabulation_space_optimization(String A, String B) {
        int n = A.length();
        int m = B.length();

        // Base Case is covered as we have initialized the prev and cur to 0.
        int[] prev = new int[m + 1];
        int[] cur = new int[m + 1];
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= m; j++) {
                if (A.charAt(i - 1) == B.charAt(j - 1))
                    cur[j] = 1 + prev[j - 1];
                else
                    cur[j] = Math.max(prev[j], cur[j - 1]);
            }
            prev = cur.clone();
        }

        return prev[m];
    }


    private static int lcs(String A, String B) {
        int n = A.length();
        int m = B.length();

        int[][] dp = new int[n][m];
        for (int[] rows : dp)
            Arrays.fill(rows, -1);

        return lcs_memoization(A, B, n - 1, m - 1, dp);
    }

    public static void main(String[] args) {
        String A = "acd";
        String B = "ced";
        System.out.println("The Length of Longest Common Subsequence is: " + lcs(A, B));
    }
}
