package com.jsm.scaler.intermediate.Arrays;

public class GoodPair {
    /*
    Given an array A and a integer B. A pair(i,j) in the array is a good pair
    if i!=j and (A[i]+A[j]==B). Check if any good pair exist or not.

    Problem Constraints

    1 <= A.size() <= 104
    1 <= A[i] <= 109
    1 <= B <= 109

    Input Format

    First argument is an integer array A.
    Second argument is an integer B.

    Output Format

    Return 1 if good pair exist otherwise return 0.
    */

    public static int goodPair(int[] A, int B) {
        for (int i = 0; i < A.length; i++) {
            for (int j = i + 1; j < A.length; j++) {
                if (A[i] + A[j] == B)
                    return 1;
            }
        }
        return 0;
    }

    public static void main(String[] args) {
        int[] A = {3, -2, 1, 4, 3, 6, 8};
        System.out.println(goodPair(A, 10));
    }

}
