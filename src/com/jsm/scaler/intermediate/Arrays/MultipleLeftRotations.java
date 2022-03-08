package com.jsm.scaler.intermediate.Arrays;

import java.util.Arrays;

public class MultipleLeftRotations {
    /*
    Given an array of integers A and multiple values in B, which represents
    the number of times array A needs to be left rotated.

    Find the rotated array for each value and return the result in the form
    of a matrix where ith row represents the rotated array for the ith value in B.

    Problem Constraints
    1 <= length of both arrays <= 2000
    -10^9 <= A[i] <= 10^9 0 <= B[i] <= 2000

    Input Format
    The first argument given is the integer array A.
    The second argument given is the integer array B.

    Output Format
    Return the resultant matrix.
    */

    public static int[][] solve(int[] A, int[] B) {
        int[][] arr = new int[B.length][B.length];
        int len_A = A.length;

        if (len_A == 1) {
            arr[0] = A;
            return arr;
        }

        int s = 0, e = len_A - 1;
        while (s < e) {
            int temp_ele = A[s];
            A[s] = A[e];
            A[e] = temp_ele;
            s++;
            e--;
        }

        int arr_idx = 0;

        for (int val : B) {
            int[] temp;
            temp = A.clone();
            val %= len_A;
            int s1 = 0, e1 = len_A - val - 1;

            while (s1 < e1) {
                int temp_ele = temp[s1];
                temp[s1] = temp[e1];
                temp[e1] = temp_ele;
                s1++;
                e1--;
            }

            int s2 = len_A - val, e2 = len_A - 1;
            while (s2 < e2) {
                int temp_ele = temp[s2];
                temp[s2] = temp[e2];
                temp[e2] = temp_ele;
                s2++;
                e2--;
            }
            arr[arr_idx] = temp;
            arr_idx += 1;
        }
        return arr;
    }

    public static void main(String[] args) {
        int[] A = {1, 2, 3, 4, 5};
        int[] B = {2, 3};
        System.out.println(Arrays.deepToString(solve(A, B)));
    }
}
