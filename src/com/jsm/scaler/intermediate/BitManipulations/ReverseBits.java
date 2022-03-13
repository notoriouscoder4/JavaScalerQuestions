package com.jsm.scaler.intermediate.BitManipulations;

public class ReverseBits {
    /*
    Reverse the bits of an 32 bit unsigned integer A.

    Problem Constraints
    0 <= A <= 232

    Input Format
    First and only argument of input contains an integer A.

    Output Format
    Return a single unsigned integer denoting the decimal value of reversed bits.

    Example Input

    Input 1:
     0

    Input 2:
     3

    Example Output

    Output 1:
     0

    Output 2:
     3221225472

     Example Explanation

    Explanation 1:
            00000000000000000000000000000000
    =>      00000000000000000000000000000000

    Explanation 2:
            00000000000000000000000000000011
    =>      11000000000000000000000000000000
    */

    public static long reverse(long a) {
        long result = 0;
        int i = 31;
        while (a > 0) {
            result += (a % 2) * Math.pow(2, i);
            i--;
            a /= 2;
        }
        return result;
    }

    public static void main(String[] args) {
        long a = 3;
        System.out.println(reverse(a));
    }
}
