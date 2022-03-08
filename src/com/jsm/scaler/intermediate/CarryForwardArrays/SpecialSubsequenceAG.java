package com.jsm.scaler.intermediate.CarryForwardArrays;

public class SpecialSubsequenceAG {
    /*
    You have given a string A having Uppercase English letters.
    You have to find that how many times subsequence "AG" is there in the given string.

    NOTE: Return the answer modulo 109 + 7 as the answer can be very large.

    Problem Constraints
    1 <= length(A) <= 105*/

    public static int solve(String A) {
        char[] a = A.toCharArray();
        int ans = 0;
        int count_a = 0;

        for (int i = 0; i < a.length; i++) {
            if (a[i] == 'A') {
                count_a++;
            } else if (a[i] == 'G') {
                ans += count_a;
            }
        }
        return ans;
    }

    public static void main(String[] args) {
        String A = "GAB";
        System.out.println(solve(A));
    }
}
