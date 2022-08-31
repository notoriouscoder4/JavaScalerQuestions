package com.jsm.scaler.advance.BackTracking;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

public class All_Unique_Permutations {
    /*
    Given an array A of size N denoting collection of numbers that might contain duplicates, return all possible unique permutations.

    NOTE: No 2 entries in the permutation sequence should be the same.

    WARNING: DO NOT USE LIBRARY FUNCTION FOR GENERATING PERMUTATIONS.
    Example : next_permutations in C++ / itertools.permutations in python.
    If you do, we will disqualify your submission retroactively and give you penalty points.

    Problem Constraints
    1 <= |A| <= 9
    0 <= A[i] <= 10

    Input Format
    Only argument is an integer array A of size N.

    Output Format
    Return a 2-D array denoting all possible unique permutation of the array.

    Example Input:
    Input 1:
    A = [1, 1, 2]

    Input 2:
    A = [1, 2]

    Example Output:
    Output 1:
    [ [1,1,2]
      [1,2,1]
      [2,1,1] ]

    Output 2:
    [ [1, 2]
      [2, 1] ]

    Example Explanation:
    Explanation 1:
     All the possible unique permutation of array [1, 1, 2].

    Explanation 2:
     All the possible unique permutation of array [1, 2].
    */

    private static ArrayList<ArrayList<Integer>> permute(ArrayList<Integer> A) {
        ArrayList<ArrayList<Integer>> ans = new ArrayList<>();
        recurPermute(0, A, ans);
        return ans;
    }

    private static void recurPermute(int index, ArrayList<Integer> A, ArrayList<ArrayList<Integer>> ans) {
        if (index == A.size()) {
            if (!ans.contains(A))
                ans.add(new ArrayList<>(A));
            return;
        }
        for (int i = index; i < A.size(); ++i) {
            Collections.swap(A, i, index);
            recurPermute(index + 1, A, ans);
            Collections.swap(A, i, index);
        }
    }

    public static void main(String[] args) {
        ArrayList<Integer> A = new ArrayList<>(Arrays.asList(1, 1, 2));
        System.out.println(permute(A)   );
    }
}
