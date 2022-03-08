package com.jsm.scaler.intermediate.CarryForwardArrays;

import java.util.Arrays;

public class ProductArray {
    /*
    Given an array of integers A, find and return the product array of the
    same size where the ith element of the product array will be equal to the
    product of all the elements divided by the ith element of the array.

    Note: It is always possible to form the product array with integer (32 bit) values.

    Input Format

    The only argument given is the integer array A.
    Output Format

    Return the product array.
    Constraints

    1 <= length of the array <= 1000
    1 <= A[i] <= 10
    */

    public static int[] solve(int[] A) {
        int prod = 1;
        for (int i : A) {
            prod *= i;
        }
        for (int i = 0; i < A.length; i++) {
            A[i] = prod / A[i];
        }
        return A;
    }

    public static void main(String[] args) {
        int[] A = {1, 2, 3, 4, 5};
        System.out.println(Arrays.toString(solve(A)));
    }
}
