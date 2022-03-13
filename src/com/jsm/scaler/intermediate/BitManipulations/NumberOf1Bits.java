package com.jsm.scaler.intermediate.BitManipulations;

public class NumberOf1Bits {
    /*
    Write a function that takes an integer and returns the number of 1 bits it has.

    Problem Constraints
    1 <= A <= 109

    Input Format
    First and only argument contains integer A

    Output Format
    Return an integer as the answer
    */
    public static int numSetBits(int A) {
        String str = Integer.toBinaryString(A);
        return str.length() - str.replace("1", "").length();

        /*
        int total_ones = 0;
        while (A != 0) {
            A = A & (A - 1);
            total_ones++;
        }
        return total_ones;
        */
    }

    public static void main(String[] args) {
        int A = 11;
        System.out.println(numSetBits(A));
    }
}
