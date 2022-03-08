package com.jsm.scaler.intermediate.SubArrays;

public class SubArrayWithLeastAverage {
    /*
    Find the subarray of size K with the least average given an array of size N.

    Problem Constraints
    1<=k<=N<=1e5
    -1e5<=A[i]<=1e5

    Input Format
    First argument contains an array A of integers of size N.
    Second argument contains integer k.


    Output Format
    Return the index of the first element of the subarray of size k that has least average.
    Array indexing starts from 0.

    Example Input
    Input 1:
    A=[3, 7, 90, 20, 10, 50, 40]
    B=3
    Input 2:

    A=[3, 7, 5, 20, -10, 0, 12]
    B=2

    Example Output
    Output 1:
    3
    Output 2:
    4
    */

    public static int solve(int[] A, int k) {

        // Initialize beginning index of result
        int res_index = 0;

        // Compute sum of first subarray of size k
        int curr_sum = 0;
        for (int i = 0; i < k; i++) {
            curr_sum += A[i];
        }

        // Initialize minimum sum as current sum
        int min_sum = curr_sum;

        // Traverse from (k+1)`th element to n`th element
        for (int i = k; i < A.length; i++) {
            // Add current tem and remove first item of
            // previous subarray
            curr_sum += A[i] - A[i - k];

            // Update the result if needed
            if (curr_sum < min_sum) {
                min_sum = curr_sum;
                res_index = i - k + 1;
            }
        }
        return res_index;
    }

    public static void main(String[] args) {
        int[] A = {3, 7, 90, 20, 10, 50, 40};
        System.out.println(solve(A, 3));
    }
}
