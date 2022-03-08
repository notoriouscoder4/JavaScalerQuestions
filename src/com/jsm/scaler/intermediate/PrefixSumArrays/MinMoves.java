package com.jsm.scaler.intermediate.PrefixSumArrays;

public class MinMoves {

    /*
    Given an integer array A of size N. In one second you can increase the value of one element by 1.
    Find the minimum time in seconds to make all elements of the array equal.

    Problem Constraints

    1 <= N <= 1000000
    1 <= A[i] <= 1000

    Input Format

    First argument is an integer array A.

    Output Format

    Return an integer denoting the minimum time to make all elements equal.
*/

    public static int minMoves(int[] A) {
        int arraySum = 0, max;
        max = A[0];
        for (int i = 1; i < A.length; i++) {
            if (A[i] > max)
                max = A[i];
        }

        for (int i : A) {
            arraySum += max - i;
        }

        return arraySum;
    }

    public static void main(String[] args) {
        int[] A = {2, 4, 1, 3, 2};
        System.out.println(minMoves(A));
    }
}
