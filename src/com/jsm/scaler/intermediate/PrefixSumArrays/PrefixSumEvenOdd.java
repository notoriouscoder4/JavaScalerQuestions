package com.jsm.scaler.intermediate.PrefixSumArrays;

public class PrefixSumEvenOdd {

    /*
    Given an array, arr[] of size N, the task is to find the count of array indices such that
    removing an element from these indices makes the sum of even-indexed and odd-indexed array elements equal.

    Problem Constraints
    1<=n<=1e5
    -1e5<=A[i]<=1e5

    Input Format

    First argument contains an array A of integers of size N

    Output Format

    Return the count of array indices such that removing an element from
    these indices makes the sum of even-indexed and odd-indexed array elements equal.
    */

    public static int solve(int[] A) {

        int[] PSe = new int[A.length];
        int[] PSo = new int[A.length];
        PSe[0] = A[0];
        PSo[0] = 0;

        int SumEven;
        int SumOdd;
        int ans = 0;

        for (int i = 1; i < A.length; i++) {
            if (i % 2 == 1) {
                PSo[i] = PSo[i - 1] + A[i];
                PSe[i] = PSe[i - 1];
            } else {
                PSe[i] = PSe[i - 1] + A[i];
                PSo[i] = PSo[i - 1];
            }
        }

        for (int i = 0; i < A.length; i++) {
            if (i == 0) {
                SumEven = PSe[0];
                SumOdd = PSo[0];
            } else {
                SumEven = PSe[i - 1] + (PSo[A.length - 1] - PSo[i]);
                SumOdd = PSo[i - 1] + (PSe[A.length - 1] - PSe[i]);
            }
            if (SumEven == SumOdd)
                ans++;
        }

        return ans;
    }

    public static void main(String[] args) {
        int[] A = {1, 1, 1};
        System.out.println(solve(A));
    }
}
