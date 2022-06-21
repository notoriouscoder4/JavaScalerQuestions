package com.jsm.scaler.advance.TwoPointers;

public class MinimizeTheAbsoluteDifference {
    /*
    Given three sorted arrays A, B and C of not necessarily same sizes.
    Calculate the minimum absolute difference between the maximum and minimum number from the triplet a, b, c
    such that a, b, c belongs arrays A, B, C respectively. i.e. minimize | max(a,b,c) - min(a,b,c) |.

    Example :
    Input:
    A : [ 1, 4, 5, 8, 10 ]
    B : [ 6, 9, 15 ]
    C : [ 2, 3, 6, 6 ]

    Output:
    1
    Explanation: We get the minimum difference for a=5, b=6, c=6 as | max(a,b,c) - min(a,b,c) | = |6-5| = 1.
    */

    private static int minimize(int[] A, int[] B, int[] C) {
        int minimizeAbsDiff = Integer.MAX_VALUE;
        int i = 0; // pointer 1 for array A
        int j = 0; // pointer 2 for array B
        int k = 0; // pointer 3 for array C
        while (i < A.length && j < B.length && k < C.length) {
            int max = Math.max(A[i], Math.max(B[j], C[k]));
            int min = Math.min(A[i], Math.min(B[j], C[k]));
            minimizeAbsDiff = Math.min(minimizeAbsDiff, max - min);
            int compare = Math.min(A[i], Math.min(B[j], C[k]));
            if (compare == A[i])
                i++;
            else if (compare == B[j])
                j++;
            else
                k++;
        }
        return minimizeAbsDiff;
    }

    public static void main(String[] args) {
        int[] A = {1, 4, 5, 8, 10};
        int[] B = {6, 9, 15};
        int[] C = {2, 3, 6, 6};
        System.out.println(minimize(A, B, C));
    }
}
