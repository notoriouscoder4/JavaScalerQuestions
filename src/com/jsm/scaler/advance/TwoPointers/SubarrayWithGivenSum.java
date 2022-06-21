package com.jsm.scaler.advance.TwoPointers;

import java.util.Arrays;

public class SubarrayWithGivenSum {
    /*
    Given an array of positive integers A and an integer B, find and return first continuous subarray which adds to B.
    If the answer does not exist return an array with a single element "-1".
    First sub-array means the sub-array for which starting index in minimum.

    Problem Constraints
    1 <= length of the array <= 100000
    1 <= A[i] <= 10^9
    1 <= B <= 10^9

    Input Format
    The first argument given is the integer array A.
    The second argument given is integer B.

    Output Format
    Return the first continuous sub-array which adds to B and if the answer does not exist return an array with a single element "-1".

    Example Input:
    Input 1:
     A = [1, 2, 3, 4, 5]
     B = 5

    Input 2:
     A = [5, 10, 20, 100, 105]
     B = 110

    Example Output:
    Output 1:
     [2, 3]

    Output 2:
     -1

    Example Explanation:
    Explanation 1:
     [2, 3] sums up to 5.

    Explanation 2:
     No subarray sums up to required number.
    */

    private static int[] solve(int[] A, int B) {
        int left = 0;
        int right = 0;
        int currSum = A[right];
        while (right < A.length && left <= right) {
            if (currSum == B) {
                int[] ans = new int[right - left + 1];
                for (int i = left; i <= right; i++)
                    ans[i - left] = A[i];
                return ans;
            } else if (currSum < B) {
                right++;
                if (right < A.length)
                    currSum += A[right];
            } else {
                currSum -= A[left];
                left++;
                // we are doing this because, suppose this is the case, A: {5, 1} and B = 1, then initially our left and right pointer will point to index 0
                // and currSum = A[right] which is equal to 5, then we can see that our currSum > B,
                // then we will first decrease current sum as currSum -= A[left] and increase left as left++, then left will point to index 1 and
                // right will still point to index 0. In this case left becomes greater than right, then we'll do below things
                if (left > right && left < A.length) {
                    right++;
                    currSum += A[right];
                }
            }
        }
        return new int[]{-1};
    }

    public static void main(String[] args) {
        int[] A = {1, 2, 3, 4, 5};
        int B = 5;
        System.out.println(Arrays.toString(solve(A, B)));
    }
}
