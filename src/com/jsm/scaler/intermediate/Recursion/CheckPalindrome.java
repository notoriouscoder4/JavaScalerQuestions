package com.jsm.scaler.intermediate.Recursion;

public class CheckPalindrome {
    /*
    Write a recursive function that checks whether string A is a palindrome or Not.
    Return 1 if the string A is a palindrome, else return 0.
    Note: A palindrome is a string that's the same when read forward and backward.

    Problem Constraints
    1 <= A <= 50000
    String A consists only of lowercase letters.

    Input Format
    The first and only argument is a string A.

    Output Format
    Return 1 if string A is a palindrome, else return 0.

    Example Input

    Input 1:
     A = "naman"

    Input 2:
     A = "strings"

    Example Output

    Output 1:
     1

    Output 2:
     0

    Example Explanation

    Explanation 1:
     "naman" is a palindromic string, so return 1.

    Explanation 2:
     "strings" is not a palindrome, so return 0.
    */

    public static int checkPalindrome(String A) {
        int n = A.length();
        if (n == 0)
            return 1;
        return isPalindrome(A, 0, n - 1);
    }

    public static int isPalindrome(String A, int start, int end) {
        if (start > end)
            return 1;
        if (A.charAt(start) == A.charAt(end))
            return isPalindrome(A, start + 1, end - 1);
        return 0;
    }

    public static void main(String[] args) {
        String A = "naman";
        System.out.println(checkPalindrome(A));
    }
}
