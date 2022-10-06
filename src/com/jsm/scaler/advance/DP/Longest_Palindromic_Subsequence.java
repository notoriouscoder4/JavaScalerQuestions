package com.jsm.scaler.advance.DP;

public class Longest_Palindromic_Subsequence {
    /*
    Given a string A. Find the longest palindromic subsequence (A subsequence which does not need to be contiguous and is a palindrome).
    You need to return the length of longest palindromic subsequence.

    Problem Constraints
    1 <= length of(A) <= 10^3

    Input Format
    First and only integer is a string A.

    Output Format
    Return an integer denoting the length of longest palindromic subsequence.

    Example Input:
    Input 1:
     A = "bebeeed"

    Input 2:
     A = "aedsead"

    Example Output:
    Output 1:
     4

    Output 2:
     5

    Example Explanation:
    Explanation 1:
     The longest palindromic subsequence is "eeee", which has a length of 4.

    Explanation 2:
     The longest palindromic subsequence is "aedea", which has a length of 5.
    */

    private static int longestPalindromicSubsequence(String A) {
        StringBuilder rev = new StringBuilder();
        rev.append(A);
        rev.reverse();

        return longest_common_subsequence(A, rev.toString());
    }

    private static int longest_common_subsequence(String s, String r) {
        int n = s.length();
        int m = r.length();
        int[][] lcs = new int[n + 1][m + 1];

        for (int i = 0; i <= n; ++i) {
            for (int j = 0; j <= m; ++j) {
                if (i == 0 || j == 0)
                    lcs[i][j] = 0;
                else if (s.charAt(i - 1) == r.charAt(j - 1))
                    lcs[i][j] = 1 + lcs[i - 1][j - 1];
                else
                    lcs[i][j] = Math.max(lcs[i - 1][j], lcs[i][j - 1]);
            }
        }
        return lcs[n][m];
    }

    public static void main(String[] args) {
        String A = "bebeeed";
        System.out.println(longestPalindromicSubsequence(A));
    }
}
