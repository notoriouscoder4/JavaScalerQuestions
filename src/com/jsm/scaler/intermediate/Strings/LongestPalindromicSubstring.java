package com.jsm.scaler.intermediate.Strings;

public class LongestPalindromicSubstring {
    /*
    Given a string A of size N, find and return the longest palindromic substring in A.
    Substring of string A is A[i...j] where 0 <= i <= j < len(A)
    Palindrome string:
    A string which reads the same backwards. More formally, A is palindrome if reverse(A) = A.
    Incase of conflict, return the substring which occurs first ( with the least starting index).

    Problem Constraints
    1 <= N <= 10000

    Input Format
    First and only argument is a string A.

    Output Format
    Return a string denoting the longest palindromic substring of string A.

    Example Input
    A = "aaaabaaa"

    Example Output
    "aaabaaa"

    Example Explanation
    We can see that longest palindromic substring is of length 7 and the string is "aaabaaa".
    */

    public static String longestPalindrome(String A) {
        int start = 0;
        int end = 0;

        for (int i = 0; i < A.length(); i++) {
            int len1 = getPalLength(A, i, i);
            int len2 = getPalLength(A, i, i + 1);

            int len = Math.max(len1, len2);
            if (len > end - start + 1) {
                start = i - (len - 1) / 2;
                end = i + len / 2;
            }
        }
        return A.substring(start, end + 1);

        /*
        int n;
        boolean[][] dp;
        int i;
        n = A.length();
        dp = new boolean[n][n];
        for (i = 0; i < n; i++)
            dp[i][i] = true;

        for (int len = 2; len <= n; len++) {
            int j;
            for (i = 0; i < n - len + 1; i++) {
                j = i + len - 1;
                if (len == 2) {
                    if (A.charAt(i) == A.charAt(j)) {
                        dp[i][j] = true;
                    }
                } else {
                    if (A.charAt(i) == A.charAt(j) && dp[i + 1][j - 1])
                        dp[i][j] = true;
                }
            }
        }
        int start = -1;
        int len = -1;
        for (i = 0; i < n; i++) {
            for (int j = i; j < n; j++) {
                if (dp[i][j] && j - i + 1 > len) {
                    len = j - i + 1;
                    start = i;
                }
            }
        }
        return A.substring(start, start + len);
        */
    }

    public static int getPalLength(String A, int i, int j) {
        while (i >= 0 && j < A.length() && A.charAt(i) == A.charAt(j)) {
            i--;
            j++;
        }
        return j - i - 1;
    }

    public static void main(String[] args) {
        String A = "aaaabaaa";
        System.out.println(longestPalindrome(A));
    }
}
