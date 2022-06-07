package com.jsm.scaler.advance.Sorting;

public class MaxMod {
    /*
    Given an array A of size N, Groot wants you to pick 2 indices i and j such that:
    1. 1 <= i, j <= N
    2. A[i] % A[j] is maximum among all possible pairs of (i, j).
    Help Groot in finding the maximum value of A[i] % A[j] for some i, j.

    Problem Constraints
    1 <= N <= 100000
    0 <= A[i] <= 100000

    Input Format
    First and only argument in an integer array A.

    Output Format
    Return an integer denoting the maximum value of A[i] % A[j] for any valid i, j.

    Example Input:
    Input 1:
     A = [1, 2, 44, 3]

    Input 2:
     A = [2, 6, 4]

    Example Output:
    Output 1:
     3

    Output 2:
     4

    Example Explanation:
    Explanation 1:
     For i = 3, j = 2  A[i] % A[j] = 3 % 44 = 3.
     No pair exists which has more value than 3.

    Explanation 2:
     For i = 2, j = 1  A[i] % A[j] = 4 % 6 = 4.
    */

    private static int maxMod(int[] A) {
        /* Observation: A % B is max if A < B and A & B are maximum possible, TC: O(N), SC: O(1) */
        int firstMax = Integer.MIN_VALUE;
        int secondMax = Integer.MIN_VALUE;
        for (int a : A) {
            if (firstMax < a) {
                secondMax = firstMax;
                firstMax = a;
            } else if (secondMax < a && a != firstMax)
                secondMax = a;
        }
        if (secondMax != Integer.MIN_VALUE)
            return secondMax;
        return 0;
    }

    public static void main(String[] args) {
        int[] A = {1,2,44,3};
        System.out.println(maxMod(A));
    }
}
