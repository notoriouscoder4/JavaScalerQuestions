package com.jsm.scaler.advance.Arrays;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class MaxSumContiguousSubArray {
    /*
    Find the contiguous non-empty sub-array within an array, A of length N, with the largest sum.

    Problem Constraints
    1 <= N <= 1e6
    -1000 <= A[i] <= 1000

    Input Format
    The first and the only argument contains an integer array, A.

    Output Format
    Return an integer representing the maximum possible sum of the contiguous sub-array.

    Example Input:
    Input 1:
     A = [1, 2, 3, 4, -10]

    Input 2:
     A = [-2, 1, -3, 4, -1, 2, 1, -5, 4]

    Example Output:
    Output 1:
     10

    Output 2:
     6

    Example Explanation:
    Explanation 1:
     The sub-array [1, 2, 3, 4] has the maximum possible sum of 10.

    Explanation 2:
     The sub-array [4,-1,2,1] has the maximum possible sum of 6.
    */

    private static int maxSubArray(final List<Integer> A) {
        int ans = Integer.MIN_VALUE;
        int sum = 0;
        for (Integer integer : A) {
            sum += integer;
            ans = Math.max(ans, sum);
            if (sum < 0)
                sum = 0;
        }
        return ans;
    }

    public static void main(String[] args) {
        List<Integer> A = new ArrayList<>(Arrays.asList(1, 2, 3, 4, -10));
        System.out.println(maxSubArray(A));
    }
}
