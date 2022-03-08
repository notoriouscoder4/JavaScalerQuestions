package com.jsm.scaler.intermediate.PrefixSumArrays;

import java.util.ArrayList;
import java.util.Arrays;

public class RangeSumQuery {
    /*
    You are given an integer array A of length N.
    You are also given a 2D integer array B with dimensions M x 2, where each row denotes a [L, R] query.
    For each query, you have to find the sum of all elements from L to R indices in A (1 - indexed).
    More formally, find A[L] + A[L + 1] + A[L + 2] +... + A[R - 1] + A[R] for each query.

    Problem Constraints
    1 <= N, M <= 105
    1 <= A[i] <= 109
    1 <= L <= R <= N

    Input Format
    The first argument is the integer array A.
    The second argument is the 2D integer array B.


    Output Format
    Return an integer array of length M where ith element is the answer for ith query in B.
    */
    public static long[] rangeSum(int[] A, int[][] B) {
        ArrayList<Long> arrayList = new ArrayList<>();
        long[] ps = new long[A.length];
        ps[0] = A[0];
        for (int i = 1; i < A.length; i++) {
            ps[i] = ps[i - 1] + A[i];
        }

        for (int[] arr : B) {
            if (arr[0] == arr[1]) {
                arrayList.add((long) A[arr[1] - 1]);
            } else if (arr[0] - 1 == 0) {
                arrayList.add(ps[arr[1] - 1]);
            } else {
                arrayList.add(ps[arr[1] - 1] - ps[arr[0] - 2]);
            }
        }
        return arrayList.stream().mapToLong(i -> i).toArray();
    }

    public static void main(String[] args) {
        int[] A = {1, 2, 3, 4, 5};
        int[][] B = {{1, 4}, {2, 3}};
        System.out.println(Arrays.toString(rangeSum(A, B)));
    }
}
