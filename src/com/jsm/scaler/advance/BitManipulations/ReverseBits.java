package com.jsm.scaler.advance.BitManipulations;

public class ReverseBits {
    /*
    Reverse the bits of an 32-bit unsigned integer A.

    Problem Constraints
    0 <= A <= 232

    Input Format
    First and only argument of input contains an integer A.

    Output Format
    Return a single unsigned integer denoting the decimal value of reversed bits.

    Example Input:
    Input 1:
     0

    Input 2:
     3

    Example Output:
    Output 1:
     0

    Output 2:
     3221225472

    Example Explanation:
    Explanation 1:
            00000000000000000000000000000000
    =>      00000000000000000000000000000000

    Explanation 2:
            00000000000000000000000000000011
    =>      11000000000000000000000000000000
    */

    private static long reverse(long A) {
        long result = 0;
        int i = 31;
        while (A > 0) {
            result = result + (A % 2) * (1L << i);
            i--;
            A /= 2;
        }
        return result;
    }

    public static void main(String[] args) {
        int A = 3;
        System.out.println(reverse(A));
    }
}