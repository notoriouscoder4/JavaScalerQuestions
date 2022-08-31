package com.jsm.scaler.advance.BackTracking;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

public class Subset {
    /*
    Given a set of distinct integers A, return all possible subsets.

    NOTE:
    Elements in a subset must be in non-descending order.
    The solution set must not contain duplicate subsets.
    Also, the subsets should be sorted in ascending ( lexicographic ) order.
    The list is not necessarily sorted.

    Problem Constraints
    1 <= |A| <= 16
    INT_MIN <= A[i] <= INT_MAX

    Input Format
    First and only argument of input contains a single integer array A.

    Output Format
    Return a vector of vectors denoting the answer.

    Example Input:
    Input 1:
    A = [1]

    Input 2:
    A = [1, 2, 3]

    Example Output:
    Output 1:
    [
        []
        [1]
    ]

    Output 2:
    [
     []
     [1]
     [1, 2]
     [1, 2, 3]
     [1, 3]
     [2]
     [2, 3]
     [3]
    ]

    Example Explanation:
    Explanation 1:
     You can see that these are all possible subsets.

    Explanation 2:
    You can see that these are all possible subsets.
    */

    private static ArrayList<ArrayList<Integer>> subsets(ArrayList<Integer> A) {
        ArrayList<ArrayList<Integer>> ans = new ArrayList<>();
        ans.add(new ArrayList<>());
        ArrayList<Integer> currList = new ArrayList<>();
        generateAllSubsets(0, A.size(), currList, A, ans);
        return ans;
    }

    private static void generateAllSubsets(int index, int n, ArrayList<Integer> currList, ArrayList<Integer> A, ArrayList<ArrayList<Integer>> ans) {
        if (index == n) {
            return;
        }
        // Include A[index] in the currList
        currList.add(A.get(index));
        ans.add(new ArrayList<>(currList)); // to return the subsets in sorted in ascending ( lexicographic ) order.
        generateAllSubsets(index + 1, n, currList, A, ans);
        // Exclude A[index] in the currList
        currList.remove(currList.size() - 1);
        generateAllSubsets(index + 1, n, currList, A, ans);
    }

    public static void main(String[] args) {
        ArrayList<Integer> A = new ArrayList<>(Arrays.asList(1, 2, 3));
        System.out.println(subsets(A));
    }
}
