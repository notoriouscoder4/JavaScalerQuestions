package com.jsm.scaler.advance.PrimeNumbers;

import java.util.HashSet;
import java.util.Set;

public class DistinctPrimes {
    /*
    You have given an array A having N integers. Let say G is the product of all elements of A.
    You have to find the number of distinct prime divisors of G.

    Input Format
    The first argument given is an Array A, having N integers.

    Output Format
    Return an Integer, i.e. number of distinct prime divisors of G.

    Constraints
    1 <= N <= 1e5
    1 <= A[i] <= 1e5

    For Example
    Input:
        A = [1, 2, 3, 4]
    Output:
         2

    Explanation:
        here G = 1 * 2 * 3 * 4 = 24
        and distinct prime divisors of G are [2, 3]
    */

    private static int distinctPrimes(int[] A) {
        Set<Integer> set = new HashSet<>();
        for (int i = 0; i < A.length; i++) {
            int sq = (int) Math.floor(Math.sqrt(A[i]));
            for (int j = 2; j <= sq; j++) {
                if (A[i] % j == 0) {
                    set.add(j);
                    while (A[i] % j == 0) {
                        A[i] = (int) Math.floor(A[i] / j);
                    }
                }
            }
            if (A[i] > 1)
                set.add(A[i]);
        }
        return set.size();
    }

    public static void main(String[] args) {
        int[] A = {96, 98, 5, 41, 80};
        System.out.println(distinctPrimes(A));
    }
}
