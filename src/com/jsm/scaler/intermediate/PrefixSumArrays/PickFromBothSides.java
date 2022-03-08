package com.jsm.scaler.intermediate.PrefixSumArrays;

public class PickFromBothSides {
    /*
    Given an integer array A of size N.

    You can pick B elements from either left or right end of the array A to get maximum sum.
    Find and return this maximum possible sum.

    NOTE: Suppose B = 4 and array A contains 10 elements then
    You can pick first four elements or can pick last four elements or
    can pick 1 from front and 3 from back etc . you need to return the maximum possible sum of elements you can pick.

    Problem Constraints

    1 <= N <= 105
    1 <= B <= N
    -103 <= A[i] <= 103

    Input Format

    First argument is an integer array A.
    Second argument is an integer B.

    Output Format

    Return an integer denoting the maximum possible sum of elements you picked.
    */

    public static int solve(int[] A, int B) {
        int currSum = 0;
        for (int i = 0; i < B; i++) {
            currSum += A[i];
        }

        int maxSum = currSum;
        // inc -> include and exc -> exclude
        int inc = A.length - 1, exc = B - 1;
        while (inc >= 0 && exc >= 0) {
            currSum += A[inc--];
            currSum -= A[exc--];
            maxSum = Math.max(maxSum, currSum);
        }
        return maxSum;
    }

    public static void main(String[] args) {
        int[] A = {5, -2, 3 , 1, 2};
        System.out.println(solve(A, 3));
    }
}
