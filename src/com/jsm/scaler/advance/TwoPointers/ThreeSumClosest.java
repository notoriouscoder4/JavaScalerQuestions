package com.jsm.scaler.advance.TwoPointers;

import java.util.Arrays;

public class ThreeSumClosest {
    /*
    Given an array A of N integers, find three integers in A such that the sum is closest to a given number B.
    Return the sum of those three integers.

    Assume that there will only be one solution.

    Problem Constraints
    -10^8 <= B <= 10^8
    1 <= N <= 10^4
    -10^8 <= A[i] <= 10^8

    Input Format
    First argument is an integer array A of size N.
    Second argument is an integer B denoting the sum you need to get close to.

    Output Format
    Return a single integer denoting the sum of three integers which is closest to B.

    Example Input:
    Input 1:
    A = [-1, 2, 1, -4]
    B = 1

    Input 2:

    A = [1, 2, 3]
    B = 6

    Example Output:
    Output 1:
    2

    Output 2:
    6

    Example Explanation:
    Explanation 1:
     The sum that is closest to the target is 2. (-1 + 2 + 1 = 2)

    Explanation 2:
     Take all elements to get exactly 6.
    */

    private static int threeSumClosest(int[] A, int B) {
        // TC: O(N^2)
        Arrays.sort(A);
        int diff = Integer.MAX_VALUE;
        int ans = 0;
        for (int i = 0; i < A.length; i++) { // fixating the first element
            int first = A[i];
            int start = i + 1; // or low
            int end = A.length - 1; // or high
            while (start < end) {
                int currSum = first + A[start] + A[end];
                if (currSum == B) {
                    return B;
                } else if (Math.abs(currSum - B) < diff) {
                    diff = Math.abs(currSum - B);
                    ans = currSum;
                }
                if (currSum < B)
                    start++;
                else
                    end--;
            }
        }
        return ans;
    }

    public static void main(String[] args) {
        int[] A = {-1, 2, 1, -4};
        // sorted A = {-4, -1, 1, 2}
        int B = 1;
        System.out.println(threeSumClosest(A, B));
    }
}
