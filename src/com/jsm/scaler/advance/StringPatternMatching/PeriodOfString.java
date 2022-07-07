package com.jsm.scaler.advance.StringPatternMatching;

public class PeriodOfString {
    /*
    You are given a string A of length N consisting of lowercase alphabets. Find the period of the string.
    Period of the string is the minimum value of k (k >= 1), that satisfies A[i] = A[i % k] for all valid i.

    Problem Constraints
    1 <= N <= 10^6

    Input Format
    First and only argument is a string A of length N.

    Output Format
    Return an integer, denoting the period of the string.

    Example Input:
    Input 1:
     A = "abababab"

    Input 2:
     A = "aaaa"

    Example Output:
    Output 1:
     2

    Output 2:
     1

    Example Explanation:
    Explanation 1:
     Period of the string will be 2:
     Since, for all i, A[i] = A[i%2].

    Explanation 2:
     Period of the string will be 1.
    */

    private static int solve(String A) {
        int n = A.length();
        int[] lps = new int[A.length()];
        createLPS(A, lps);

        return (n - lps[n - 1]);
    }

    private static void createLPS(String A, int[] lps) {
        int n = A.length();
        lps[0] = 0;

        int x;
        for (int i = 1; i < n; i++) {
            x = lps[i - 1];
            while (A.charAt(x) != A.charAt(i)) {
                if (x == 0) {
                    x = -1;
                    break;
                }
                x = lps[x - 1];
            }
            lps[i] = x + 1;
        }
    }

    public static void main(String[] args) {
        String A = "abababab";
        System.out.println(solve(A));
    }
}
