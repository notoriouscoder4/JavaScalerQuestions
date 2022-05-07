package com.jsm.scaler.advance.BitManipulations;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

public class MinXORValue {
    /*
    Given an integer array A of N integers, find the pair of integers in the array which have minimum XOR value. Report the minimum XOR value.

    Problem Constraints
    2 <= length of the array <= 100000
    0 <= A[i] <= 109

    Input Format
    First and only argument of input contains an integer array A.

    Output Format
    Return a single integer denoting minimum xor value.

    Example Input:
    Input 1:
     A = [0, 2, 5, 7]

    Input 2:
     A = [0, 4, 7, 9]


    Example Output:
    Output 1:
     2

    Output 2:
     3

    Example Explanation:
    Explanation 1:
     0 xor 2 = 2
    */

    private static int findMinXor(ArrayList<Integer> A) {
        Collections.sort(A);
        int min = A.get(0) ^ A.get(1);
        for (int i = 2; i < A.size(); i++) {
            min = Math.min(min, A.get(i) ^ A.get(i - 1));
        }
        return min;
    }

    public static void main(String[] args) {
        ArrayList<Integer> A = new ArrayList<>(Arrays.asList(0, 2, 5, 7));
        System.out.println(findMinXor(A));
    }
}
