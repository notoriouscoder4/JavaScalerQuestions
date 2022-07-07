package com.jsm.scaler.advance.StringPatternMatching;

public class CountA {
    /*
    You are given a string A. Find the number of substrings that start and end with 'a'.

    Problem Constraints
    1 <= |A| <= 10^5
    The string will have only lowercase English letters.

    Input Format
    Given the only argument is a String A.

    Output Format
    Return number of substrings that start and end with 'a'.

    Example Input
    Input 1:
     A = "aab"

    Input 2:
     A = "bcbc"

    Example Output:
    Output 1:
     3

    Output 2:
     0

    Example Explanation:
    Explanation 1:
     Substrings that start and end with 'a' are:
        1. "a"
        2. "aa"
        3. "a"

    Explanation 2:
     There are no substrings that start and end with 'a'.
    */

    private static int countA(String A) {
        int count;
        int numOfA = 0;

        for (int i = 0; i < A.length(); i++) {
            if (A.charAt(i) == 'a')
                numOfA++;
        }

        count = (numOfA * (numOfA + 1)) / 2;
        return count;
    }

    public static void main(String[] args) {
        String A = "aab";
        System.out.println(countA(A));
    }
}
