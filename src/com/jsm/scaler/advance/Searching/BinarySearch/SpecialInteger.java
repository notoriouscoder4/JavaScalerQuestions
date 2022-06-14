package com.jsm.scaler.advance.Searching.BinarySearch;

public class SpecialInteger {
    /*
    Given an array of integers A and an integer B, find and return the maximum value K such that
    there is no subarray in A of size K with the sum of elements greater than B.

    Problem Constraints
    1 <= |A| <= 100000
    1 <= A[i] <= 10^9
    1 <= B <= 10^9

    Input Format
    The first argument given is the integer array A.
    The second argument given is integer B.

    Output Format
    Return the maximum value of K (sub array length).

    Example Input:
    Input 1:
    A = [1, 2, 3, 4, 5]
    B = 10

    Input 2:
    A = [5, 17, 100, 11]
    B = 130

    Example Output:
    Output 1:
     2

    Output 2:
     3

    Example Explanation:
    Explanation 1:
    Constraints are satisfied for maximal value of 2.

    Explanation 2:
    Constraints are satisfied for maximal value of 3.
    */

    private static int specialInteger(int[] A, int B) {
        // k is size of subarray
        // Min K will be 1 and Max will be Length of Array
        int low = 0;
        int high = A.length;
        int k = 0;
        while (low <= high) {
            int mid = (low + high) / 2;
            if (isPossible(A, B, mid)) {
                k = mid;
                low = mid + 1;
            } else
                high = mid - 1;
        }
        return k;
    }

    private static boolean isPossible(int[] A, int B, int range) {
        // Sliding Window Technique
        long curr_sum = 0;
        // Get the sum of first window of size, k which is equal to range
        for (int i = 0; i < range; i++)
            curr_sum += A[i];
        if (curr_sum >= B)
            return false;
        for (int i = range; i < A.length; i++) {
            curr_sum = curr_sum - A[i - range] + A[i];
            if (curr_sum >= B)
                return false;
        }
        return true;
    }

    public static void main(String[] args) {
        int[] A = {1, 2, 3, 4, 5};
        int B = 10;
        System.out.println(specialInteger(A, B));
    }
}
