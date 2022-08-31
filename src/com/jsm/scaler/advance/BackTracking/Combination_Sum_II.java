package com.jsm.scaler.advance.BackTracking;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

public class Combination_Sum_II {
    /*
    Given an array of size N of candidate numbers A and a target number B. Return all unique combinations in A where the candidate numbers sums to B.
    Each number in A may only be used once in the combination.

    Note:
    All numbers (including target) will be positive integers.
    Elements in a combination (a1, a2, … , ak) must be in non-descending order. (ie, a1 ≤ a2 ≤ … ≤ ak).
    The solution set must not contain duplicate combinations.

    Warning:
    DO NOT USE LIBRARY FUNCTION FOR GENERATING COMBINATIONS.
    Example : itertools.combinations in python. If you do, we will disqualify your submission and give you penalty points.

    Problem Constraints
    1 <= N <= 20

    Input Format
    First argument is an integer array A denoting the collection of candidate numbers.
    Second argument is an integer which represents the target number.

    Output Format
    Return all unique combinations in A where the candidate numbers sums to B.

    Example Input:
    Input 1:
     A = [10, 1, 2, 7, 6, 1, 5]
     B = 8

    Input 2:
     A = [2, 1, 3]
     B = 3

    Example Output:
    Output 1:
     [
      [1, 1, 6 ],
      [1, 2, 5 ],
      [1, 7 ],
      [2, 6 ]
     ]

    Output 2:
     [
      [1, 2 ],
      [3 ]
     ]

    Example Explanation:
    Explanation 1:
     1 + 1 + 6 = 8
     1 + 2 + 5 = 8
     1 + 7 = 8
     2 + 6 = 8
     All the above combinations sum to 8 and are arranged in ascending order.

    Explanation 2:
     1 + 2 = 3
     3 = 3
     All the above combinations sum to 3 and are arranged in ascending order.
    */

    private static ArrayList<ArrayList<Integer>> combinationSum(ArrayList<Integer> A, int B) {
        ArrayList<ArrayList<Integer>> ans = new ArrayList<>();
        Collections.sort(A);
        findCombination(0, A, B, ans, new ArrayList<>());
        return ans;
    }

    private static void findCombination(int index, ArrayList<Integer> A, int target, ArrayList<ArrayList<Integer>> ans, ArrayList<Integer> currList) {
        if (target == 0) {
            ans.add(new ArrayList<>(currList));
            return;
        }
        for (int i = index; i < A.size(); ++i) {
            // to avoid picking up same element twice and in doing so, we'll be avoiding picking up duplicate combinations
            if (i > index && A.get(i) == A.get(i - 1))
                continue;
            if (A.get(i) > target)
                break;
            currList.add(A.get(i));
            findCombination(i + 1, A, target - A.get(i), ans, currList);
            currList.remove(currList.size() - 1);
        }
    }

    public static void main(String[] args) {
        ArrayList<Integer> A = new ArrayList<>(Arrays.asList(10, 1, 2, 7, 6, 1, 5));
        int B = 8;

        System.out.println(combinationSum(A, B));
    }
}
