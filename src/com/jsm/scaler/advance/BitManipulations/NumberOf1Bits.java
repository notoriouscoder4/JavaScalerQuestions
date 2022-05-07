package com.jsm.scaler.advance.BitManipulations;

public class NumberOf1Bits {
    /*
    Write a function that takes an integer and returns the number of 1 bits it has.

    Problem Constraints
    1 <= A <= 109

    Input Format
    First and only argument contains integer A

    Output Format
    Return an integer as the answer

    Example Input:
    Input1:
    11

    Example Output:
    Output1:
    3

    Example Explanation:
    Explanation1:
    11 is represented as 1011 in binary.
    */

    private static int numSetBits(int A) {
        int ans = 0;
        for (int i = 0; i < 32; i++) {
            if (checkBit(A, i))
                ans++;
        }
        return ans;

        /* Scaler Solution
        int total_ones = 0;
        while (A != 0) {
            A = A & (A - 1);
            total_ones++;
        }
        return total_ones;
        */
    }

    private static boolean checkBit(int num, int i) {
        // using left shift
        return (num & (1 << i)) != 0;
    }

    public static void main(String[] args) {
        int A = 11;
        System.out.println(numSetBits(A));
    }
}
