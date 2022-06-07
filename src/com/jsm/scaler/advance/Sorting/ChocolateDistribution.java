package com.jsm.scaler.advance.Sorting;

import java.util.Arrays;

public class ChocolateDistribution {
    /*
    Given an array A of N integers where each value represents number of chocolates in a packet.
    i-th can have A[i] number of chocolates.
    There are B number students, the task is to distribute chocolate packets following below conditions:
    1. Each student gets one packet.
    2. The difference between the number of chocolates in packet with maximum chocolates and packet with minimum chocolates given to the students is minimum.
    Return the minimum difference (that can be achieved) between maximum and minimum number of chocolates distributed.

    Problem Constraints
    0 <= N <= 10^5
    1 <= A[i] <= 10^7
    0 <= B <= 10^5

    Input Format
    The first argument contains an integer array A.
    The second argument contains an integer B.

    Output Format
    Return the minimum difference (that can be achieved) between maximum and minimum number of chocolates distributed.

    Example Input:
    Input:
      A : [3, 4, 1, 9, 56, 7, 9, 12]
      B : 5

    Example Output:
    Output:
      6

    Example Explanation:
    Explanation:
      Minimum Difference is 6
      The set goes like 3,4,7,9,9 and the output is 9-3 = 6
    */

    private static int solve(int[] A, int B) {
        /*
        An efficient solution is based on the observation that to minimize the difference, we must choose consecutive elements from a sorted packet.
        We first sort the array arr[0..n-1], then find the sub_array of size m with the minimum difference between the last and first elements.
        */
        int n = A.length;
        if (B == 0 || n == 0)
            return 0;
        Arrays.sort(A);
        if (n < B)
            return -1;
        int min_diff = Integer.MAX_VALUE;
        for (int i = 0; i + B - 1 < n; i++) {
            int diff = A[i + B - 1] - A[i];
            if (diff < min_diff)
                min_diff = diff;
        }
        return min_diff;
    }

    public static void main(String[] args) {
        int[] A = {3, 4, 1, 9, 56, 7, 9, 12};
        int B = 5;
        System.out.println(solve(A, B));
    }
}
