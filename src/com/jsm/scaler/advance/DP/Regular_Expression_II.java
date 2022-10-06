package com.jsm.scaler.advance.DP;

public class Regular_Expression_II {
    /*
    Implement wildcard pattern matching with support for ' ? ' and ' * ' for strings A and B.
    1. ' . ' : Matches any single character.
    2. ' * ' : Matches zero or more of the preceding element.
    The matching should cover the entire input string (not partial).

    Problem Constraints
    1 <= length(A), length(B) <= 10^4

    Input Format
    The first argument of input contains a string A.
    The second argument of input contains a string B denoting the pattern.

    Output Format
    Return 1 if the patterns match else return 0.

    Example Input:
    Input 1:
     A = "aab"
     B = "c*a*b"

    Input 2:
     A = "acz"
     B = "a.a"

    Example Output:
    Output 1:
     1

    Output 2:
     0

    Example Explanation:
    Explanation 1:
     'c' can be repeated 0 times, 'a' can be repeated 1 time. Therefore, it matches "aab".
     So, return 1.

    Explanation 2:
     '.' matches any single character. First two character in string A will be match.
     But the last character i.e 'z' != 'a'. Return 0.
    */

    private static int wildCardMatching_tabulation(String A, String B) {
        int n = A.length();
        int m = B.length();

        boolean[][] dp = new boolean[n + 1][m + 1];
        dp[0][0] = true;

        for (int i = 0; i <= n; ++i) {
            for (int j = 1; j <= m; ++j) {
                if ((i == 0 && j == 2) && B.charAt(j - 1) == '*')
                    dp[i][j] = true;
                else if (i == 0)
                    dp[i][j] = false;
                else {
                    if (A.charAt(i - 1) == B.charAt(j - 1) || B.charAt(j - 1) == '.') {
                        dp[i][j] = dp[i - 1][j - 1];
                    } else if (B.charAt(j - 1) == '*') {
                        if (B.charAt(j - 2) == '.') {
                            dp[i][j] = dp[i - 1][j] || dp[i][j - 2];
                        } else
                            dp[i][j] = dp[i][j - 2] || (A.charAt(i - 1) == B.charAt(j - 2) && dp[i - 1][j]);
                    } else
                        dp[i][j] = false;
                }
            }
        }
        return dp[n][m] ? 1 : 0;
    }

    private static int isMatch(final String A, final String B) {
        return wildCardMatching_tabulation(A, B);
    }

    public static void main(String[] args) {
        String A = "aab";
        String B = "c*a*b";
        System.out.println(isMatch(A, B));
    }
}
