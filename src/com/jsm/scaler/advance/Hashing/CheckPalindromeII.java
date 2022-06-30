package com.jsm.scaler.advance.Hashing;

import java.util.Arrays;

public class CheckPalindromeII {
    /*
    Given a string A consisting of lowercase characters.
    Check if characters of the given string can be rearranged to form a palindrome.
    Return 1 if it is possible to rearrange the characters of the string A such that it becomes a palindrome else return 0.

    Problem Constraints
    1 <= |A| <= 105
    A consists only of lower-case characters.

    Input Format
    First argument is a string A.

    Output Format
    Return 1 if it is possible to rearrange the characters of the string A such that it becomes a palindrome else return 0.

    Example Input

    Input 1:
     A = "abcde"

    Input 2:
     A = "abbaee"

    Example Output

    Output 1:
     0

    Output 2:
     1

    Example Explanation

    Explanation 1:
     No possible rearrangement to make the string palindrome.

    Explanation 2:
     Given string "abbaee" can be rearranged to "aebbea" to form a palindrome.
    */

    private static int solve(String A) {
        int NO_OF_CHARS = 256;

        // Create a count array and initialize all
        // values as 0
        int[] count = new int[NO_OF_CHARS];
        Arrays.fill(count, 0);

        // For each character in input strings,
        // increment count in the corresponding
        // count array
        for (int i = 0; i < A.length(); i++)
            count[(int)(A.charAt(i))]++;

        // Count odd occurring characters
        int odd = 0;
        for (int i = 0; i < NO_OF_CHARS; i++) {
            if ((count[i] & 1) == 1)
                odd++;

            if (odd > 1)
                return 0;
        }

        // Return true if odd count is 0 or 1,
        return 1;

        /* Scaler Solution
        int[] freq = new int[26];
        for (int i = 0; i < A.length(); i++)
            freq[A.charAt(i) - 97]++;
        int odd = 0;
        for (int a: freq)
            if (a % 2 == 1)
                odd++;
        if (odd > 1)
            return 0;
        return 1;
        */
    }

    public static void main(String[] args) {
        String A = "abcde";
        System.out.println(solve(A));
    }
}
