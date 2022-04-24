package com.jsm.scaler.intermediate.SubsequenceAndSubset;

public class SubArrayOR {
    /*
    You are given an array of integers A of size N.
    The value of a sub-array is defined as BITWISE OR of all elements in it.
    Return the sum of value of all sub-arrays of A % 109 + 7.

    Problem Constraints
    1 <= N <= 105
    1 <= A[i] <= 108

    Input Format:
    The first argument given is the integer array A.

    Output Format:
    Return the sum of Value of all sub-arrays of A % 109 + 7.

    Example Input:
    Input 1:
     A = [1, 2, 3, 4, 5]

    Input 2:
     A = [7, 8, 9, 10]

    Example Output:
    Output 1:
     71

    Output 2:
     110

    Example Explanation
    Explanation 1:
     Value([1]) = 1
     Value([1, 2]) = 3
     Value([1, 2, 3]) = 3
     Value([1, 2, 3, 4]) = 7
     Value([1, 2, 3, 4, 5]) = 7
     Value([2]) = 2
     Value([2, 3]) = 3
     Value([2, 3, 4]) = 7
     Value([2, 3, 4, 5]) = 7
     Value([3]) = 3
     Value([3, 4]) = 7
     Value([3, 4, 5]) = 7
     Value([4]) = 4
     Value([4, 5]) = 5
     Value([5]) = 5
     Sum of all these values = 71

    Explanation 2:
     Sum of value of all sub-array is 110.
    */

    private static int solve(int[] A) {
        int n = A.length;
        int[] idx = new int[32];
        long answer = 0;
        for (int i = 1; i <= n; i++) {
            long tmp = A[i - 1];
            for (int j = 0; j <= 31; ++j) {
                long pow = 1 << j;
                if ((tmp & pow) != 0) { // if jth bit is set
                    answer += pow * i; // add its contribution in answer for all sub-arrays ending at index i
                    idx[j] = i;
                } else if (idx[j] != 0) { // if jth bit is not set
                    answer += pow * idx[j]; // add its contribution in answer for all sub-arrays ending at index i
                } // using the information of last element having jth bit set
            }
        }
        return (int) (answer % 1000000007);
    }

    public static void main(String[] args) {
        int[] A = {1, 2, 3, 4, 5};
        System.out.println(solve(A));
    }
}
