package com.jsm.scaler.intermediate.ArraysInterviewProblems;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

public class MaximumPositivity {
    /*
    Given an array of integers A, of size N.
    Return the maximum size subarray of A having only non-negative elements.
    If there are more than one such subarray, return the one having the smallest starting index in A.

    NOTE: It is guaranteed that an answer always exists.

    Problem Constraints
    1 <= N <= 105
    -109 <= A[i] <= 109

    Input Format
    The first and only argument given is the integer array A.

    Output Format
    Return maximum size subarray of A having only non-negative elements.
    If there are more than one such subarrays, return the one having earliest starting index in A.

    Example Input

    Input 1:
     A = [5, 6, -1, 7, 8]

    Input 2:
     A = [1, 2, 3, 4, 5, 6]

    Example Output

    Output 1:
     [5, 6]

    Output 2:
     [1, 2, 3, 4, 5, 6]
    */

    public static int[] solve(int[] A) {
        ArrayList<Integer> leftArr = new ArrayList<>();
        ArrayList<Integer> rightArr = new ArrayList<>();

        ArrayList<Integer> arr = new ArrayList<>();

        int N = A.length;
        int left = 0;
        int right = 0;

        for (int i = 1; i < N; i++) {
            if (A[i] < 0) {
                left = 0;
                leftArr = new ArrayList<>();

                for(int j = i - 1; j >=0; j--) {
                    if (A[j] > 0) {
                        leftArr.add(A[j]);
                        left++;
                    } else {
                        break;
                    }
                }
                Collections.reverse(leftArr);
                right = 0;
                rightArr = new ArrayList<>();
                for (int j = i + 1; j <= N - 1; j++) {
                    if (A[j] > 0) {
                        rightArr.add(A[j]);
                        right++;
                    } else {
                        break;
                    }
                }
            }
            if (left >= right && arr.size() < leftArr.size()) {
                arr = leftArr;
            } else {
                if (arr.size() < rightArr.size()) {
                    arr = rightArr;
                }
            }
        }
        int[] ans = new int[arr.size()];
        for (int i = 0; i < arr.size(); i++) {
            ans[i] = arr.get(i);
        }
        return ans;
    }

    public static void main(String[] args) {
        int[] A = {5, 6, -1, 7, 8};
        System.out.println(Arrays.toString(solve(A)));
    }
}
