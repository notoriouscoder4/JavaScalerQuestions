package com.jsm.scaler.intermediate.CarryForwardArrays;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;

public class LeadersInArray {
    /*
    Given an integer array A containing N distinct integers, you have to find all the leaders in the array A.
    An element is leader if it is strictly greater than all the elements to its right side.

    NOTE:The rightmost element is always a leader.

    Problem Constraints
    1 <= N <= 105
    1 <= A[i] <= 108

    Input Format
    First and only argument is an integer array A.

    Output Format
    Return an integer array denoting all the leader elements of the array.

    NOTE: Ordering in the output doesn't matter.
    */

    public static ArrayList<Integer> solve(ArrayList<Integer> A) {
        ArrayList<Integer> result = new ArrayList<>();
        result.add(A.get(A.size() - 1));

        int max_from_right = A.get(A.size() - 1);

        for (int i = A.size() - 2; i >= 0; i--) {
            if (max_from_right < A.get(i)) {
                max_from_right = A.get(i);
                result.add(max_from_right);
            }
        }

        return result;
    }

    public static void main(String[] args) {
        ArrayList<Integer> A = new ArrayList<>(Arrays.asList(16, 17, 4, 3, 5, 2));
        System.out.println(solve(A));
    }
}
