package com.jsm.scaler.intermediate.SubArrays;

public class SumOfAllSubArrays {
    /*
    You are given an integer array A of length N.
    You have to find the sum of all subarray sums of A.
    More formally, a subarray is a defined as a contiguous part of an array,
    which we can obtain by deleting zero or more elements from either end of the array.
    A subarray sum denotes the sum of all the elements of that subarray.

    Problem Constraints
    1 <= N <= 105
    1 <= Ai <= 10 4


    Input Format
    The first argument is the integer array A.


    Output Format
    Return a single integer denoting the sum of all subarray sums of the given array.
    */

    public static long subarraySum(int[] A) {
        long sum = 0;
        for (int i = 0; i < A.length - 1; i++) {
            int s = i + 1;
            int e = A.length - i;
            sum += (long) s * e * A[i];
        }
        return sum;
    }

    public static void main(String[] args) {
        int[] A = {1, 2, 3};
        System.out.println(subarraySum(A));
    }
}
