package com.jsm.scaler.advance.Hashing;

import java.util.HashSet;

public class SubarrayWithZeroSum {
    /*
    Given an array of integers A, find and return whether the given array contains a non-empty subarray with a sum equal to 0.
    If the given array contains a sub-array with sum zero return 1, else return 0.

    Problem Constraints
    1 <= |A| <= 100000
    -10^9 <= A[i] <= 10^9

    Input Format
    The only argument given is the integer array A.

    Output Format
    Return whether the given array contains a subarray with a sum equal to 0.

    Example Input:
    Input 1:
     A = [1, 2, 3, 4, 5]

    Input 2:
     A = [-1, 1]

    Example Output:
    Output 1:
     0

    Output 2:
     1

    Example Explanation:
    Explanation 1:
     No subarray has sum 0.

    Explanation 2:
     The array has sum 0.
    */

    private static int solve(int[] A) {
        HashSet<Long> set = new HashSet<>();
        long sum = 0;
        set.add(sum);
        for (int a : A) {
            sum += a;
            if (set.contains(sum))
                return 1;
            else
                set.add(sum);
        }
        return 0;
    }

    public static void main(String[] args) {
        int[] A = {1, 2, 3, 4, 5};
        System.out.println(solve(A));
    }
}
