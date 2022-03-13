package com.jsm.scaler.intermediate.BitManipulations;

public class SingleNumber {
    /*
    Given an array of integers A, every element appears twice except for one. Find that integer that occurs once.
    NOTE: Your algorithm should have a linear runtime complexity. Could you implement it without using extra memory?

    Problem Constraints
    2 <= |A| <= 2000000
    0 <= A[i] <= INTMAX

    Input Format
    The first and only argument of input contains an integer array A.

    Output Format
    Return a single integer denoting the single element.

    Example Input

    Input 1:
     A = [1, 2, 2, 3, 1]

    Input 2:
     A = [1, 2, 2]

    Example Output

    Output 1:
     3

    Output 2:
     1
    */

    public static int singleNumber(final int[] A) {
        int ans = 0;
        for (int i = 0; i < A.length; i++) {
            ans = ans ^ A[i];
        }
        return ans;
    }

    public static void main(String[] args) {
        int[] A = {1, 2, 2, 3, 1};
        System.out.println(singleNumber(A));
    }
}
