package com.jsm.scaler.intermediate.BitManipulations;

public class SubArraysWithBitwiseOR1 {
    /*
    Given an array B of length A with elements 1 or 0. Find the number of subarrays with bitwise OR 1.

    Problem Constraints
    1 <= A <= 105

    Input Format
    The first argument is a single integer A.
    The second argument is an integer array B.

    Output Format
    Return the number of subarrays with bitwise array 1.

    Example Input

    Input 1:
     A = 3
    B = [1, 0, 1]

    Input 2:
     A = 2
    B = [1, 0]

    Example Output

    Output 1:
    5

    Output2:
    2


    Example Explanation

    Explanation 1:
    The subarrays are :- [1], [0], [1], [1, 0], [0, 1], [1, 0, 1]
    Except the subarray [0] all the other subarrays has a Bitwise OR = 1
    Explanation 2:

    The subarrays are :- [1], [0], [1, 0]
    Except the subarray [0] all the other subarrays has a Bitwise OR = 1
    */
    public static long solve(int A, int[] B) {
        long ans = 0;
        int last = 0;
        for (int i = 0; i < A; i++) {
            if (B[i] == 1)
                last = i + 1;
            ans += last;
        }
        return ans;
    }

    public static void main(String[] args) {
        int A = 3;
        int[] B = {1, 0, 1};
        System.out.println(solve(A, B));
    }
}
