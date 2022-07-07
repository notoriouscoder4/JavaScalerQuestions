package com.jsm.scaler.advance.StringPatternMatching;

public class ClosestPalindrome {
    /*
    Groot has a profound love for palindrome which is why he keeps fooling around with strings.
    A palindrome string is one that reads the same backward as well as forward.

    Given a string A of size N consisting of lowercase alphabets,
    he wants to know if it is possible to make the given string a palindrome by changing exactly one of its character.

    Problem Constraints
    1 <= N <= 10^5

    Input Format
    The first and only argument is a string A.

    Output Format
    Return the string YES if it is possible to make the given string a palindrome by changing exactly 1 character.
    Else, it should return the string NO.

    Example Input
    Input 1:
     A = "abbba"

    Input 2:
     A = "adaddb"

    Example Output
    Output 1:
     "YES"

    Output 2:
     "NO"

    Example Explanation:
    Explanation 1:
     We can change the character at index 3(1-based) to any other character. The string will be palindromic.

    Explanation 2:
     To make the string palindromic we need to change 2 characters.
    */

    private static String solve(String A) {
        int n = A.length();
        int flag = 0;
        for (int i = 0; i < (n >> 1); i++) {
            if (A.charAt(i) != A.charAt(n - i - 1)) {
                if (flag == 1) return "NO";
                flag++;
            }
        }
        return (flag == 1 || (n & 1) == 1) ? "YES" : "NO";
    }

    public static void main(String[] args) {
        String A = "abbba";
        System.out.println(solve(A));
    }
}
