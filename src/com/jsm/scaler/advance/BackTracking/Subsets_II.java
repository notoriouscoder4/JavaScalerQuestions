package com.jsm.scaler.advance.BackTracking;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;

public class Subsets_II {
    /*
    Given a collection of integers denoted by array A of size N that might contain duplicates, return all possible subsets.

    NOTE:
    Elements in a subset must be in non-descending order.
    The solution set must not contain duplicate subsets.
    The subsets must be sorted lexicographically.

    Problem Constraints
    0 <= N <= 16

    Input Format
    Only argument is an integer array A of size N.

    Output Format
    Return a 2-D vector denoting all the possible subsets.

    Example Input:
    Input 1:
     A = [1, 2, 2]

    Input 2:
     A = [1, 1]

    Example Output:
    Output 1:
     [
        [],
        [1],
        [1, 2],
        [1, 2, 2],
        [2],
        [2, 2]
     ]

    Output 2:
     [
        [],
        [1],
        [1, 1]
     ]

    Example Explanation:
    Explanation 1:
    All the subsets of the array [1, 2, 2] in lexicographically sorted order.
    */

    private static ArrayList<ArrayList<Integer>> subsetsWithDup(ArrayList<Integer> A) {
        Collections.sort(A);
        ArrayList<ArrayList<Integer>> ans = new ArrayList<>();
        generateAllSubsets(0, A, ans, new ArrayList<>());
        return ans;
    }

    private static void generateAllSubsets(int index, ArrayList<Integer> A, ArrayList<ArrayList<Integer>> ans, ArrayList<Integer> ds) {
        ans.add(new ArrayList<>(ds));
        for (int i = index; i < A.size(); ++i) {
            if (i != index && A.get(i) == A.get(i - 1))
                continue;
            ds.add(A.get(i));
            generateAllSubsets(i + 1, A, ans, ds);
            ds.remove(ds.size() - 1);
        }
    }

    public static void main(String[] args) {
        ArrayList<Integer> A = new ArrayList<>(Arrays.asList(6, 6, 3, 3, 6, 5));
        System.out.println(subsetsWithDup(A));
    }
}
