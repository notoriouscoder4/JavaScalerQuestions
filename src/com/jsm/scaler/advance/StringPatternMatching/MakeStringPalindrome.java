package com.jsm.scaler.advance.StringPatternMatching;

public class MakeStringPalindrome {
    /*
    Given a string A of size N consisting only of lowercase alphabets.
    The only operation allowed is to insert characters in the beginning of the string.

    Find and return how many minimum characters are needed to be inserted to make the string a palindrome string.

    Problem Constraints
    1 <= N <= 10^6

    Input Format
    The only argument given is a string A.

    Output Format
    Return an integer denoting the minimum characters needed to be inserted in the beginning to make the string a palindrome string.

    Example Input:
    Input 1:
     A = "abc"

    Input 2:
     A = "bb"

    Example Output:
    Output 1:
     2

    Output 2:
     0

    Example Explanation:
    Explanation 1:
     Insert 'b' at beginning, string becomes: "babc".
     Insert 'c' at beginning, string becomes: "cbabc".

    Explanation 2:
     There is no need to insert any character at the beginning as the string is already a palindrome.
    */

    private static int solve(String A) {
        StringBuilder sb = new StringBuilder(A);
        sb.reverse();
        System.out.println(sb);
        String palin = A + "$" + sb;
        int[] lps = new int[palin.length()];
        createLPS(palin, lps);

        return A.length() - lps[lps.length - 1];
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
        String A = "abc";
        System.out.println(solve(A));
    }
}
