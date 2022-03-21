package com.jsm.scaler.intermediate.Arrays_Maths;

public class MajorityElement {
    /*
    Given an array of size N, find the majority element. The majority element is the element that appears more than floor(n/2) times.
    You may assume that the array is non-empty and the majority element always exists in the array.

    Problem Constraints
    1 <= N <= 5*105
    1 <= num[i] <= 109

    Input Format
    Only argument is an integer array.

    Output Format
    Return an integer.

    Example Input
    [2, 1, 2]

    Example Output
    2

    Example Explanation
    2 occurs 2 times which is greater than 3/2.
    */

    public static int majorityElement(int[] A) {
        int me = A[0];
        int freq = 1;
        for (int i = 1; i < A.length; i++) {
            if (A[i] == me) {
                freq++;
            } else {
                if (freq == 0) {
                    me = A[i];
                    freq = 1;
                } else {
                    freq--;
                }
            }
        }
        int count = 0;
        for (int i = 0; i < A.length; i++) {
            if (A[i] == me)
                count++;
        }
        if (count > A.length / 2) return me;
        return -1;
    }

    public static void main(String[] args) {
        int[] A = {3, 3, 4, 6, 1, 3, 2, 5, 3, 3, 3};
        System.out.println(majorityElement(A));
    }
}
