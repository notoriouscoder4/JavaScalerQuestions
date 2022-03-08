package com.jsm.scaler.intermediate.CarryForwardArrays;

public class EvenSubArrays {
    /*
    You are given an integer array A.

    Decide whether it is possible to divide the array into one or more
    subarrays of even length such that first and last element of all subarrays will be even.

    Return "YES" if it is possible otherwise return "NO" (without quotes).

    Problem Constraints
    1 <= |A|, A[i] <= 106

    Input Format
    The first and the only input argument is an integer array, A.

    Output Format
    Return a string "YES" or "NO" denoting the answer.
    */

    public static String solve(int[] A) {
        if (A.length % 2 == 1 || A[0] % 2 == 1 || A[A.length - 1] % 2 == 1) {
            return "NO";
        }
        if (A[0] % 2 == A[A.length - 1] % 2) {
            return "YES";
        }

        for (int i = 1; i < A.length - 1; i++) {
            if (A[i] == A[i + 1]) {
                return "YES";
            }
        }

        return "NO";
    }

    public static void main(String[] args) {
        int[] A = {2, 4, 8, 7, 6};
        System.out.println(solve(A));
    }
}
