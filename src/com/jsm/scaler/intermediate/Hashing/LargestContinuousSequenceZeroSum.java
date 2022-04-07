package com.jsm.scaler.intermediate.Hashing;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class LargestContinuousSequenceZeroSum {
    /*
    Given an array A of N integers.
    Find the largest continuous sequence in an array which sums to zero.

    Problem Constraints
    1 <= N <= 106
    -107 <= A[i] <= 107

    Input Format
    Single argument which is an integer array A.

    Output Format
    Return an array denoting the longest continuous sequence with total sum of zero.

    NOTE : If there are multiple correct answers, return the sequence which occurs first in the array.

    Example Input
    A = [1,2,-2,4,-4]

    Example Output
    [2,-2,4,-4]

    Example Explanation
    [2,-2,4,-4] is the longest sequence with total sum of zero.
    */
    public static ArrayList<Integer> isZero(ArrayList<Integer> A) {
        ArrayList<Integer> result = new ArrayList<>();
        Map<Integer, Integer> map = new HashMap<>();
        map.put(0, -1);

        int start = -1;
        int end = -1;
        int sum = 0;
        int maxLen = -1;

        for (int i = 0; i < A.size(); i++) {
            sum += A.get(i);
            if (map.containsKey(sum)) {
                if (maxLen < (i - map.get(sum))) {
                    start = map.get(sum) + 1;
                    end = i;
                    maxLen = i - map.get(sum);
                }
            } else {
                map.put(sum, i);
            }
        }
        if (start >= 0) {
            for (int i = start; i <= end; i++) {
                result.add(A.get(i));
            }
        }
        return result;
    }

    public static void main(String[] args) {
        ArrayList<Integer> A = new ArrayList<>(Arrays.asList(1, 2, -2, 4, -4));
        System.out.println(isZero(A));
    }
}
