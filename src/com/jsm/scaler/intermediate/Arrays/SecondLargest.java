package com.jsm.scaler.intermediate.Arrays;

public class SecondLargest {
    /*
    You are given an integer array A. You have to find the second largest element/value in the array or report that no such element exists.

    Problem Constraints
    1 <= |A| <= 105
    0 <= A[i] <= 109

    Input Format
    The first argument is an integer array A.

    Output Format
    Return the second largest element. If no such element exist then return -1.
    */

    public static int solve(int[] A) {
        int max = -1;
        int secondMax = -1;
        int idx = 0;

        for(int i = 0; i < A.length; i++) {
            if(A[i] > max) {
                idx = i;
                max = A[i];
            }
        }

        for(int j = 0; j < A.length; j++) {
            if((j != idx) && (A[j] > secondMax)) {
                secondMax = A[j];
            }
        }

        return secondMax;
    }

    public static void main(String[] args) {
        int[] A = {2, 1, 2};
        System.out.println(solve(A));
    }
}
