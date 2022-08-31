package com.jsm.scaler.advance.BackTracking;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;

public class Combination_Sum {
    /*
    Given an array of candidate numbers A and a target number B, find all unique combinations in A where the candidate numbers sums to B.
    The same repeated number may be chosen from A unlimited number of times.

    Note:
    1) All numbers (including target) will be positive integers.
    2) Elements in a combination (a1, a2, … , ak) must be in non-descending order. (ie, a1 ≤ a2 ≤ … ≤ ak).
    3) The combinations themselves must be sorted in ascending order.
    4) CombinationA > CombinationB iff (a1 > b1) OR (a1 = b1 AND a2 > b2) OR ... (a1 = b1 AND a2 = b2 AND ... ai = bi AND ai+1 > bi+1)
    5) The solution set must not contain duplicate combinations.

    Problem Constraints
    1 <= |A| <= 20
    1 <= A[i] <= 50
    1 <= B <= 500

    Input Format
    The first argument is an integer array A.
    The second argument is integer B.

    Output Format
    Return a vector of all combinations that sum up to B.

    Example Input:
    Input 1:
    A = [2, 3]
    B = 2

    Input 2:
    A = [2, 3, 6, 7]
    B = 7

    Example Output:
    Output 1:
    [ [2] ]

    Output 2:
    [ [2, 2, 3] , [7] ]

    Example Explanation:
    Explanation 1:
    All possible combinations are listed.

    Explanation 2:
    All possible combinations are listed.
    */

    private static ArrayList<ArrayList<Integer>> combinationSum(ArrayList<Integer> A, int B) {
        ArrayList<ArrayList<Integer>> ans = new ArrayList<>();
        Collections.sort(A);
        if (A.size() == 0)
            return ans;
        findCombinations(0, A, B, ans, new ArrayList<>(), new HashSet<>());
        return ans;
    }

    private static void findCombinations(int index, ArrayList<Integer> A, int target, ArrayList<ArrayList<Integer>> ans, ArrayList<Integer> currList, HashSet<ArrayList<Integer>> hs) {
        if (index == A.size()) {
            if (hs.add(new ArrayList<>(currList)))
                if (target == 0)
                    ans.add(new ArrayList<>(currList));
            return;
        }

        // Include A[index] in the combinations
        if (A.get(index) <= target) {
            currList.add(A.get(index));
            findCombinations(index, A, target - A.get(index), ans, currList, hs);
            // Exclude A[index] from the combinations
            currList.remove(currList.size() - 1);
        }
        findCombinations(index + 1, A, target, ans, currList, hs);
    }

    public static void main(String[] args) {
        ArrayList<Integer> A = new ArrayList<>(Arrays.asList(8, 10, 6, 11, 1, 16, 8));
        int B = 28;

        System.out.println(combinationSum(A, B));
    }
}
