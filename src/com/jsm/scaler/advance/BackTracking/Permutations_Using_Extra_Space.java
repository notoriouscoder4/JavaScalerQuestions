package com.jsm.scaler.advance.BackTracking;

import java.util.ArrayList;
import java.util.Arrays;

public class Permutations_Using_Extra_Space {
    /*
    Given an integer array A of size N denoting collection of numbers, return all possible permutations.

    NOTE:
    1. No two entries in the permutation sequence should be the same.
    2. For the purpose of this problem, assume that all the numbers in the collection are unique.
    3. Return the answer in any order
    WARNING: DO NOT USE LIBRARY FUNCTION FOR GENERATING PERMUTATIONS.
    Example : next_permutations in C++ / itertools.permutations in python.
    If you do, we will disqualify your submission retroactively and give you penalty points.

    Problem Constraints
    1 <= N <= 9

    Input Format
    Only argument is an integer array A of size N.

    Output Format
    Return a 2-D array denoting all possible permutation of the array.

    Example Input:
    A = [1, 2, 3]

    Example Output:
    [ [1, 2, 3]
      [1, 3, 2]
      [2, 1, 3]
      [2, 3, 1]
      [3, 1, 2]
      [3, 2, 1] ]

    Example Explanation:
    All the possible permutation of array [1, 2, 3].
    */

    private static ArrayList<ArrayList<Integer>> permute(ArrayList<Integer> A) {
        ArrayList<ArrayList<Integer>> ans = new ArrayList<>();
        ArrayList<Integer> ds = new ArrayList<>();
        boolean[] freq = new boolean[A.size()];
        recurPermute(A, ds, ans, freq);
        return ans;
    }

    private static void recurPermute(ArrayList<Integer> A, ArrayList<Integer> ds, ArrayList<ArrayList<Integer>> ans, boolean[] freq) {
        if (ds.size() == A.size()) {
            ans.add(new ArrayList<>(ds));
            return;
        }
        for (int i = 0; i < A.size(); ++i) {
            if (!freq[i]) {
                ds.add(A.get(i));
                freq[i] = true;
                recurPermute(A, ds, ans, freq);
                ds.remove(ds.size() - 1);
                freq[i] = false;
            }
        }
    }

    public static void main(String[] args) {
        ArrayList<Integer> A = new ArrayList<>(Arrays.asList(1, 2, 3));
        System.out.println(permute(A));
    }
}
