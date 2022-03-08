package com.jsm.scaler.intermediate.SubArrays;

public class MaximumSubarrayEasy {
    /*
    You are given an integer array C of size A. Now you need to find a
    subarray (contiguous elements) so that the sum of contiguous elements is maximum.
    But the sum must not exceed B.

    Problem Constraints
    1 <= A <= 103
    1 <= B <= 109
    1 <= C[i] <= 106


    Input Format
    The first argument is the integer A.
    The second argument is the integer B.
    The third argument is the integer array C.

    Output Format
    Return a single integer which denotes the maximum sum.
    */

    public static int maxSubArray(int A, int B, int[] C) {
        int maxSum = 0;
        int currSum = 0;
        int left = 0;

        for (int i = 0; i < A; i++) {
            currSum += C[i];
            while (currSum > B) {
                currSum -= C[left];
                left++;
            }
            // maxSum = Math.max(maxSum, currSum);
            if (maxSum < currSum)
                maxSum = currSum;
            if (currSum < 0)
                currSum = 0;
        }
        return maxSum;
    }

    public static void main(String[] args) {
        int[] C = {2, 2, 2};
        System.out.println(maxSubArray(3, 1, C));
    }
}
