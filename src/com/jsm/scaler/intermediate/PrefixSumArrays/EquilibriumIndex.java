package com.jsm.scaler.intermediate.PrefixSumArrays;

public class EquilibriumIndex {
    /*
    You are given an array A of integers of size N.
    Your task is to find the equilibrium index of the given array
    Equilibrium index of an array is an index such that the sum of elements at lower indexes is equal to the sum of elements at higher indexes.

    NOTE:

    Array indexing starts from 0.
    If there is no equilibrium index then return -1.
    If there are more than one equilibrium indexes then return the minimum index.

    Problem Constraints
    1<=N<=1e5
    -1e5<=A[i]<=1e5

    Input Format

    First arugment contains an array A .

    Output Format

    Return the equilibrium index of the given array. If no such index is found then return -1.
    */


    public static int solve(int[] A) {

        int sumLeft, sumRight;

        for (int i = 1; i < A.length; i++) {
            A[i] = A[i - 1] + A[i];
        }

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
    }

    public static void main(String[] args) {
        int[] A = {-7, 1, 5, 2, -4, 3, 0};
        System.out.println(solve(A));
    }

}
