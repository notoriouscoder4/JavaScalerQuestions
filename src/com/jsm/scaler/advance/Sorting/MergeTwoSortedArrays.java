package com.jsm.scaler.advance.Sorting;

import java.util.Arrays;

public class MergeTwoSortedArrays {
    /*
    Given two sorted integer arrays A and B, merge B and A as one sorted array and return it as an output.

    Problem Constraints
    -10^10 <= A[i], B[i] <= 10^10

    Input Format
    First Argument is a 1-D array representing A.
    Second Argument is also a 1-D array representing B.

    Output Format
    Return a 1-D vector which you got after merging A and B.

    Example Input:
    Input 1:
    A = [4, 7, 9 ]
    B = [2, 11, 19 ]

    Input 2:
    A = [1]
    B = [2]

    Example Output:
    Output 1:
    [2, 4, 7, 9, 11, 19]

    Output 2:
    [1, 2]

    Example Explanation:
    Explanation 1:
    Merging A and B produces the output as described above.

    Explanation 2:
     Merging A and B produces the output as described above.
    */

    private static int[] mergeTwoSortedArrays(final int[] A, final int[] B) {
        int n = A.length;
        int m = B.length;
        int[] C = new int[n + m];
        int i = 0; // for Array A
        int j = 0; // for Array B
        int k = 0; // for Array C
        while (i < n && j < m) {
            if (A[i] < B[j]) {
                C[k] = A[i];
                i++;
            } else {
                C[k] = B[j];
                j++;
            }
            k++;
        }
        while (i < n) {
            C[k] = A[i];
            i++;
            k++;
        }
        while (j < m) {
            C[k] = B[j];
            j++;
            k++;
        }
        return C;
    }

    public static void main(String[] args) {
        int[] A = {4, 7, 9};
        int[] B = {2, 11, 19};
        System.out.println(Arrays.toString(mergeTwoSortedArrays(A, B)));
    }
}
