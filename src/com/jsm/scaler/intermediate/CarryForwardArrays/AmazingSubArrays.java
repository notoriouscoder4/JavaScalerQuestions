package com.jsm.scaler.intermediate.CarryForwardArrays;

public class AmazingSubArrays {
    /*
    You are given a string S, and you have to find all the amazing substrings of S.
    Amazing Substring is one that starts with a vowel (a, e, i, o, u, A, E, I, O, U).

    Input

    Only argument given is string S.
    Output

    Return a single integer X mod 10003, here X is number of Amazing Substrings in given string.

    Constraints
    1 <= length(S) <= 1e6
    S can have special characters
    */

    public static int solve(String A) {
        int cnt = 0;
        for (int i = 0; i < A.length(); i++) {
            if (isVowel(A.charAt(i))) {
                cnt += A.length() - i;
            }
        }
        return cnt % 10003;
    }

    public static boolean isVowel(char c) {
        if (c <= 90) {
            c += 32;
        }
        return c == 97 || c == 101 || c == 105 || c == 111 || c == 117;
    }

    public static void main(String[] args) {
        String A = "ABEC";
        System.out.println(solve(A));
    }
}
