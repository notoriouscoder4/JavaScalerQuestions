package com.jsm.scaler.advance.BitManipulations;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class SingleNumberII {
    /*
    Given an array of integers, every element appears thrice except for one, which occurs once.
    Find that element that does not appear thrice.
    NOTE: Your algorithm should have a linear runtime complexity.
    Could you implement it without using extra memory?

    Problem Constraints
    2 <= A <= 5*106
    0 <= A <= INT_MAX

    Input Format
    First and only argument of input contains an integer array A.

    Output Format
    Return a single integer.

    Example Input
    Input 1:
     A = [1, 2, 4, 3, 3, 2, 2, 3, 1, 1]

    Input 2:
     A = [0, 0, 0, 1]


    Example Output:
    Output 1:
     4

    Output 2:
     1

    Example Explanation:
    Explanation 1:
     4 occurs exactly once in Input 1.
     1 occurs exactly once in Input 2.
    */

    private static int singleNumber(final List<Integer> A) {
        int ans = 0;
        for (int i = 0; i < 32; i++) {
            // count the no. of set bits at ith position
            int count = 0;
            for (int j = 0; j < A.size(); j++) {
                if (checkBit(A.get(j), i))
                    count++;
            }
            if (count % 3 != 0)
                ans = ans | (1 << i);
        }
        return ans;

        /* Scaler Solution
        int[] bits = new int[32];
        for (int num: A) {
            for (int i = 0; i < 32; i++) {
                bits[i] += (1 & (num >> i));
                bits[i] %= 3;
            }
        }
        int number = 0;
        for (int i = 31; i >= 0; i--) {
            number = number * 2 + bits[i];
        }
        return number;
        */
    }

    private static boolean checkBit(int N, int i) {
        // using left shift
        // return (N & (1 << i)) != 0;

        // using right shift
        // return ((N >> i) & 1) ==1;
        return ((N >> i) & 1) > 0;
    }

    public static void main(String[] args) {
        List<Integer> A = new ArrayList<>(Arrays.asList(1, 2, 4, 3, 3, 2, 2, 3, 1, 1));
        System.out.println(singleNumber(A));
    }
}
