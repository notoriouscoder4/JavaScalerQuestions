package com.jsm.scaler.intermediate.Hashing;

import java.util.*;

public class DiffkII {
    /*
    Given an array A of integers and another non-negative integer k, find if there exists 2 indices i and j such that A[i] - A[j] = k, i != j.

    Example :

    Input :
    A : [1 5 3]
    k : 2

    Output :
    1
    as 3 - 1 = 2

    Return 0 / 1 for this problem.
    */

    public static int diffPossible(final List<Integer> A, int B) {
        Set<Integer> set = new HashSet<>();
        if (A.size() == 1)
            return 0;

        for (int i = 0; i < A.size(); i++) {
            if (set.contains(A.get(i) - B) || set.contains(A.get(i) + B))
                return 1;
            set.add(A.get(i));
        }
        return 0;
    }

    public static void main(String[] args) {
        List<Integer> A = new ArrayList<>(Arrays.asList(1, 5, 3));
        int B = 2;
        System.out.println(diffPossible(A, B));
    }
}
