package com.jsm.scaler.advance.Arrays;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

public class MaxDistance {
    /*
    Given an array A of integers of size N. Find the maximum value of j - i such that A[i] <= A[j].

    Problem Constraints
    1 <= N <= 105
    -109 <= A[i] <= 109

    Input Format
    First argument is an integer array A of size N.

    Output Format
    Return an integer denoting the maximum value of j - i.

    Example Input
    Input 1:
    A = [3, 5, 4, 2]

    Example Output:
    Output 1:
    2

    Example Explanation:
    Explanation 1:
    For A[0] = 3 and A[2] = 4, the ans is (2 - 0) = 2.
    */

    private static int maximumGap(final ArrayList<Integer> A) {
        ArrayList<ArrayList<Integer>> listOfLists = new ArrayList<>();
        // create a list containing value, index
        for (int i = 0; i < A.size(); i++) {
            ArrayList<Integer> temp = new ArrayList<>();
            temp.add(A.get(i));
            temp.add(i);
            listOfLists.add(new ArrayList<>(temp));
        }

        // sort listOfLists
        Collections.sort(listOfLists, (ArrayList<Integer> first, ArrayList<Integer> second) -> {
            if (first.get(0) < second.get(0))
                return -1;
            else if (first.get(0) == second.get(1) && first.get(1) < second.get(1))
                return -1;
            else return 1;
        });
        // every element on the right is greater than the current element, maintain the maximum index possible
        // from the right of the array.
        int max_index = -1, ans = 0;
        for (int i = A.size() - 1; i >= 0; i--) {
            ArrayList<Integer> temp = new ArrayList<>(listOfLists.get(i));
            int cur_index = temp.get(1);
            max_index = Math.max(max_index, cur_index);
            ans = Math.max(ans, max_index - cur_index);
        }
        return ans;
        /* c++ solution
        int Solution::maximumGap(const vector<int> &A) {
        vector<int> suffixMax (A.size(), 0);
        suffixMax[A.size() - 1] = A.back();

        for(int i = A.size() - 2; i >= 0; --i){
            suffixMax[i] = max(A[i], suffixMax[i + 1]);
        }

        int i = 0, j = 0;
        int ans = 0;
        while(i < A.size() && j < A.size()){
            if(A[i] <= suffixMax[j]){
                ans = max(ans, j - i);
                j++;
            }
            else i++;
        }
        return ans;
        }
        */
    }

    public static void main(String[] args) {
        ArrayList<Integer> A = new ArrayList<>(Arrays.asList(3, 5, 4, 2));
        System.out.println(maximumGap(A));
    }
}
