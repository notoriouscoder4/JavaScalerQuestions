package com.jsm.scaler.advance.BackTracking;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;

public class Number_Of_Squareful_Arrays {
    /*
    Given an array of integers A, the array is squareful if for every pair of adjacent elements, their sum is a perfect square.
    Find and return the number of permutations of A that are squareful. Two permutations A1 and A2 differ if and only if there is some index i such that A1[i] != A2[i].

    Problem Constraints
    1 <= length of the array <= 12
    1 <= A[i] <= 10^9

    Input Format
    The only argument given is the integer array A.

    Output Format
    Return the number of permutations of A that are squareful.

    Example Input:
    Input 1:
     A = [2, 2, 2]

    Input 2:
     A = [1, 17, 8]

    Example Output:
    Output 1:
     1

    Output 2:
     2

    Example Explanation:
    Explanation 1:
     Only permutation is [2, 2, 2], the sum of adjacent element is 4 and 4 and both are perfect square.

    Explanation 2:
     Permutation are [1, 8, 17] and [17, 8, 1].
    */

    private static int solve(ArrayList<Integer> A) {
        int n = A.size();
        if (n == 1) return 0;

        HashSet<ArrayList<Integer>> set = new HashSet<>();
        permute(A, 0, set);
        return set.size();
    }

    private static void permute(ArrayList<Integer> A, int index, HashSet<ArrayList<Integer>> set) {
        if (index == A.size()) {
            ArrayList<Integer> ds = new ArrayList<>(A);
            set.add(ds);
            return;
        }
        for (int i = index; i < A.size(); ++i) {
            Collections.swap(A, i, index);
            if (index == 0 || (index > 0 && isPerfectSquare(A.get(index - 1) + A.get(index))))
                permute(A, index + 1, set);
            Collections.swap(A, i, index);
        }
    }

    private static boolean isPerfectSquare(int num) {
        int x = (int) Math.sqrt(num);
        return (x * x == num);
    }

    public static void main(String[] args) {
        ArrayList<Integer> A = new ArrayList<>(Arrays.asList(2, 2, 2));
        System.out.println(solve(A));
    }
}
