package com.jsm.scaler.advance.StringPatternMatching;

public class SmallestPrefixString {
    /*
    Given 2 strings A and B of size N and M respectively consisting of lowercase alphabets,
    find the lexicographically smallest string that can be formed by concatenating non-empty prefixes of A and B (in that order).
    Note: The answer string has to start with a non-empty prefix of string A followed by a non-empty prefix of string B.

    Problem Constraints
    1 <= N, M <= 100000

    Input Format
    The first argument is a string A of size N.
    The second argument is a string B of size M.

    Output Format
    Return lexicographically smallest string that can be formed by concatenating non-empty prefixes of A and B (in that order).

    Example Input
    Input 1:
     A = "abba"
     B = "cdd"

    Input 2:
     A = "acd"
     B = "bay"

    Example Output
    Output 1:
     "abbac"

    Output 2:
     "ab"

    Example Explanation:
    Explanation 1:
     We can concatenate prefix of A i.e "abba" and prefix of B i.e "c".
     The lexicographically smallest string will be "abbac".

    Explanation 2:
     We can concatenate prefix of A i.e "a" and prefix of B i.e "b".
     The lexicographically smallest string will be "ab".

     */

    private static String smallestPrefix(String A, String B) {
        String ans = String.valueOf(A.charAt(0));
        for (int i = 1; i < A.length(); i++) {
            if (A.charAt(i) < B.charAt(0)) {
                ans += A.charAt(i);
            } else {
                break;
            }
        }
        return ans + B.charAt(0);
    }

    public static void main(String[] args) {
        String A = "acd";
        String B = "bay";
        System.out.println(smallestPrefix(A, B));
    }
}
