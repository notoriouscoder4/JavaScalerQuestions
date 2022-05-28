package com.jsm.scaler.advance.Recursion;

public class ImplementPowerFunction {
    /*
    Implement pow(A, B) % C.
    In other words, given A, B and C, Find (A^B % C).
    Note: The remainders on division cannot be negative. In other words, make sure the answer you return is non-negative.

    Problem Constraints
    -10^9 <= A <= 10^9
    0 <= B <= 10^9
    1 <= C <= 10^9

    Input Format
    Given three integers A, B, C.

    Output Format
    Return an integer.

    Example Input
    A = 2, B = 3, C = 3

    Example Output
    2

    Example Explanation
    2^3 % 3 = 8 % 3 = 2
    */

    private static int pow(int A, int B, int C) {
        if (A == 0) return 0;
        if (B == 0) return 1;
        if (A < 0 && B % 2 != 0) return A + C;
        else if (A < 0 && B % 2 == 0) return 1;
        else {
            int halfPow = pow(A, B / 2, C);
            int halfAns = (int) ((long) halfPow % C * halfPow % C) % C;
            if (B % 2 == 0)
                return halfAns;
            return (int) (((long) (A % C) * halfAns % C) % C);
        }
    }

    public static void main(String[] args) {
        int A = -1, B = 2, C = 20;
        System.out.println(pow(A, B, C));
    }
}
