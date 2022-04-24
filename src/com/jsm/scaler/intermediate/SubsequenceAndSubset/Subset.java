package com.jsm.scaler.intermediate.SubsequenceAndSubset;

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

    static ArrayList<ArrayList<Integer>> ans;

    private static ArrayList<ArrayList<Integer>> subsets(ArrayList<Integer> A) {
        Collections.sort(A);
        ans = new ArrayList<>();
        ArrayList<Integer> curr = new ArrayList<>();
        solve(0, curr, A);
        // sort list of list
        ans.sort((ArrayList<Integer> first, ArrayList<Integer> second) -> {
            for (int i = 0; i < first.size() && i < second.size(); i++) {
                if (first.get(i) < second.get(i))
                    return -1;
                if (first.get(i) > second.get(i))
                    return 1;
            }
            if (first.size() > second.size())
                return 1;
            return -1;
        });
        return ans;
    }

    private static void solve(int idx, ArrayList<Integer> curr, ArrayList<Integer> A) {
        if (idx == A.size()) {
            ans.add(new ArrayList<>(curr));
            return;
        }
        solve(idx + 1, curr, A); // not take
        int element = A.get(idx);
        curr.add(element); // Do
        solve(idx + 1, curr, A); // take
        curr.remove(curr.size() - 1); // UNDO
    }

    public static void main(String[] args) {
        ArrayList<Integer> A = new ArrayList<>(Arrays.asList(1, 2, 3));
        System.out.println(subsets(A));
    }
}
