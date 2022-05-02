package com.jsm.scaler.advance.Arrays;

public class EquilibriumIndex {
    /*
    You are given an array A of integers of size N.
    Your task is to find the equilibrium index of the given array
    The equilibrium index of an array is an index such that the sum of elements at lower indexes is equal to the sum of elements at higher indexes.
    NOTE:
    Array indexing starts from 0.
    If there is no equilibrium index then return -1.
    If there are more than one equilibrium indexes then return the minimum index.

    Problem Constraints
    1 <= N <= 105
    -105 <= A[i] <= 105

    Input Format
    First argument is an array A .

    Output Format
    Return the equilibrium index of the given array. If no such index is found then return -1.

    Example Input
    Input 1:
    A=[-7, 1, 5, 2, -4, 3, 0]

    Input 2:
    A=[1,2,3]

    Example Output
    Output 1:
    3

    Output 2:
    -1

    Example Explanation:
    Explanation 1:
    3 is an equilibrium index, because:
    A[0] + A[1] + A[2] = A[4] + A[5] + A[6]

    Explanation 2:
    There is no such index.
    */

    private static int solve(int[] A) {
        int sumLeft, sumRight;
        for (int i = 1; i < A.length; i++)
            A[i] = A[i - 1] + A[i];
        for (int i = 0; i < A.length; i++) {
            if (i == 0) {
                sumLeft = 0;
                sumRight = A[A.length - 1] - A[i];
                if (sumLeft == sumRight)
                    return i;
            } else if (i == A.length - 1) {
                sumRight = 0;
                sumLeft = A[i - 1];
                if (sumLeft == sumRight)
                    return i;
            } else {
                sumLeft = A[i - 1];
                sumRight = A[A.length - 1] - A[i];
                if (sumLeft == sumRight)
                    return i;
            }
        }
        return -1;

        /* Scaler Solution
        long sum1 = 0;
        for(int i = 0; i < A.length ; i++) sum1 += A[i];
        long sum2 = 0;
        int ans = Integer.MAX_VALUE;
        for(int i = 0 ; i < A.length ; i++){
            sum1 -= A[i];
            if(sum1 == sum2){
                ans = i;
                break;
            }
            sum2 += A[i];
        }
        if(ans == Integer.MAX_VALUE)ans =- 1;
        return ans;
        */
    }

    public static void main(String[] args) {
        int[] A = {-7, 1, 5, 2, -4, 3, 0};
        System.out.println(solve(A));
    }
}
