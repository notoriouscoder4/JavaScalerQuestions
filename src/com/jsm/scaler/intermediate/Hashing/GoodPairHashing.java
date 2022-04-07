package com.jsm.scaler.intermediate.Hashing;

import java.util.HashSet;
import java.util.Set;

public class GoodPairHashing {
    /*
    Given an array A and a integer B. A pair(i,j) in the array is a good pair
    if i!=j and (A[i]+A[j]==B). Check if any good pair exist or not.

    Problem Constraints

    1 <= A.size() <= 104
    1 <= A[i] <= 109
    1 <= B <= 109

    Input Format

    First argument is an integer array A.
    Second argument is an integer B.

    Output Format

    Return 1 if good pair exist otherwise return 0.
    */

    public static int goodPairHashing(int[] A, int B) {
        Set<Integer> set = new HashSet<>();
        for (int i = 0; i < A.length; i++) {
            if (set.contains(B - A[i]))
                return 1;
            set.add(A[i]);
        }
        return 0;
    }

    public static void main(String[] args) {
        int[] A = {3, -2, 1, 4, 3, 6, 8};
        int B = 10;
        System.out.println(goodPairHashing(A, B));
    }
}
