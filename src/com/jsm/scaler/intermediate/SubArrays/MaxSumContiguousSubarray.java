package com.jsm.scaler.intermediate.SubArrays;

public class MaxSumContiguousSubarray {
    /*
    Find the contiguous non empty subarray within an array, A of length N which has the largest sum.

    Problem Constraints
    1 <= N <= 1e6
    -1000 <= A[i] <= 1000

    Input Format
    The first and the only argument contains an integer array, A.

    Output Format
    Return an integer representing the maximum possible sum of the contiguous subarray.

    We would be solving the problem by following approaches –
    1. Simple approach:-
    The simple approach to solve this problem is to run two for loops and for every
    subarray check if it is the maximum sum possible. Follow the below steps to solve the problem.

    a. Run a loop for i from 0 to n – 1, where n is the size of the array.
    b. Now, we will run a nested loop for j from i to n – 1 and add the value of the element at index j to a variable currentMax.
    c. Lastly, for every subarray, we will check if the currentMax is the maximum sum of all contiguous subarrays.

    public static int maximumSubarraySum(int[] arr) {
        int n = arr.length;
        int maxSum = Integer.MIN_VALUE;

        for (int i = 0; i <= n - 1; i++) {
            int currSum = 0;
            for (int j = i; j <= n - 1; j++) {
            currSum += arr[j];
            if (currSum > maxSum) {
                maxSum = currSum;
            }
            }
        }

        return maxSum;
    }
    public static void main(String args[]) {
        // Your code goes here
        int a[] = {1, 3, 8, -2, 6, -8, 5};
        System.out.println(maximumSubarraySum(a));
    }

    Time complexity: O(N^2), Where N is the size of the array.
    Space complexity: O(1)


    2. Efficient Approach: Kadane’s Algorithm:-

    Kadane’s Algorithm is an iterative dynamic programming algorithm. It calculates the
    maximum sum subarray ending at a particular position by using the maximum sum
    subarray ending at the previous position. Follow the below steps to solve the problem.

    a. Define two-variable currSum which stores maximum sum ending here and maxSum which stores maximum sum so far.
    b. Initialize currSum with 0 and maxSum with INT_MIN.
    c. Now, iterate over the array and add the value of the current element to currSum and check
        i) If currSum is greater than maxSum, update maxSum equals to currSum.
        ii) If currSum is less than zero, make currSum equal to zero.
    d. Finally, print the value of maxSum.

    Time complexity: O(N), Where N is the size of the array.
    Space complexity: O(1)
    */
    public static int maxSubArray(int[] A) {
        int maxSum = Integer.MIN_VALUE;
        int currSum = 0;

        for (int i = 0; i < A.length; i++) {
            currSum += A[i];

            if (maxSum < currSum) {
                maxSum = currSum;
            }
            if (currSum < 0) {
                currSum = 0;
            }
        }
        return maxSum;
    }

    public static void main(String[] args) {
        int[] A = {1, 3, 8, -2, 6, -8, 5};
        System.out.println(maxSubArray(A));
    }
}
