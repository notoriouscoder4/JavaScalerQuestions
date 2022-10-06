package com.jsm.scaler.advance.DP;

public class Regular_Expression_Match {
    /*
    Implement wildcard pattern matching with support for ' ? ' and ' * ' for strings A and B.
    1. ' ? ' : Matches any single character.
    2. ' * ' : Matches any sequence of characters (including the empty sequence).
    The matching should cover the entire input string (not partial).

    Problem Constraints
    1 <= length(A), length(B) <= 10^4

    Input Format
    The first argument of input contains a string A.
    The second argument of input contains a string B.

    Output Format
    Return 1 if the patterns match else return 0.

    Example Input:
    Input 1:
     A = "aaa"
     B = "a*"

    Input 2:
     A = "acz"
     B = "a?a"

    Example Output:
    Output 1:
     1

    Output 2:
     0

    Example Explanation:
    Explanation 1:
     Since '*' matches any sequence of characters. Last two 'a' in string A will be match by '*'.
     So, the pattern matches we return 1.

    Explanation 2:
     '?' matches any single character. First two character in string A will be match.
     But the last character i.e 'z' != 'a'. Return 0.
    */

    private static boolean isAllStars(String pattern, int i) {
        for (int j = 1; j <= i; ++j) {
            if (pattern.charAt(j - 1) != '*')
                return false;
        }
        return true;
    }

    private static int wildCardMatching_recursion(int i, int j, String text, String pattern) {
        // Base conditions
        if (i < 0 && j < 0) return 1;
        if (i < 0 && j >= 0) return 0;
        if (j < 0 && i >= 0) return isAllStars(pattern, i) ? 1 : 0;

        if ((text.charAt(i) == pattern.charAt(j)) || pattern.charAt(j) == '?')
            return wildCardMatching_recursion(i - 1, j - 1, text, pattern);

        if (pattern.charAt(j) == '*')
            return (wildCardMatching_recursion(i - 1, j, text, pattern) | wildCardMatching_recursion(i, j - 1, text, pattern));
        return 0;
    }

    /*
    Time Complexity: O(N*M)
    Reason: There are N*M states therefore at max ‘N*M’ new problems will be solved.

    Space Complexity: O(N*M) + O(N+M)
    Reason: We are using a recursion stack space(O(N+M)) and a 2D array ( O(N*M)).
    */
    private static int wildCardMatching_memoization(int i, int j, String text, String pattern, int[][] dp) {
        // Base conditions
        if (i < 0 && j < 0) return 1;
        if (j < 0 && i >= 0) return 0;
        if (i < 0 && j >= 0) return isAllStars(pattern, j) ? 1 : 0;

        if (dp[i][j] != -1) return dp[i][j];

        if ((text.charAt(i) == pattern.charAt(j)) || pattern.charAt(j) == '?')
            return dp[i][j] = wildCardMatching_memoization(i - 1, j - 1, text, pattern, dp);

        if (pattern.charAt(j) == '*')
            return (wildCardMatching_memoization(i - 1, j, text, pattern, dp) == 1 || wildCardMatching_memoization(i, j - 1, text, pattern, dp) == 1) ? 1 : 0;
        return 0;
    }

    /*
    Time Complexity: O(N*M)
    Reason: There are two nested loops

    Space Complexity: O(N*M)
    Reason: We are using an external array of size ‘N*M’. Stack Space is eliminated.
    */
    private static int wildCardMatching_tabulation(String A, String B) {
        int n = B.length();
        int m = A.length();

        boolean[][] dp = new boolean[n + 1][m + 1];
        dp[0][0] = true;

        for (int j = 1; j <= m; j++) {
            dp[0][j] = false;
        }
        for (int i = 1; i <= n; i++) {
            dp[i][0] = isAllStars(B, i);
        }


        for (int i = 1; i <= n; ++i) {
            for (int j = 1; j <= m; ++j) {
                if ((B.charAt(i - 1) == A.charAt(j - 1)) || B.charAt(i - 1) == '?')
                    dp[i][j] = dp[i - 1][j - 1];

                else {
                    if (B.charAt(i - 1) == '*')
                        dp[i][j] = dp[i - 1][j] || dp[i][j - 1];
                    else
                        dp[i][j] = false;
                }
            }
        }
        return dp[n][m] ? 1 : 0;
    }

    private static int isMatch(final String A, final String B) {
        int n = A.length();
        int m = B.length();

        //return wildCardMatching_recursion(n - 1, m - 1, A, B);


        /*int[][] dp = new int[n][m];
        for (int[] row : dp) {
            Arrays.fill(row, -1);
        }

        return wildCardMatching_memoization(n - 1, m - 1, A, B, dp);
*/
        return wildCardMatching_tabulation(A, B);
    }

    public static void main(String[] args) {
        String A = "aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa";
        String B = "a**************************************************************************************";
        System.out.println(isMatch(A, B));
    }
}
