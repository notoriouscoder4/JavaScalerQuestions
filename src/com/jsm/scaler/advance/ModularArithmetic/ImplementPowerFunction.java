package com.jsm.scaler.advance.ModularArithmetic;

public class ImplementPowerFunction {
    /*
    Implement pow(A, B) % C.
    In other words, given A, B and C, Find (A^B % C).
    Note: The remainders on division cannot be negative. In other words, make sure the answer you return is non-negative.

    Problem Constraints
    -109 <= A <= 109
    0 <= B <= 109
    1 <= C <= 109

    Input Format
    Given three integers A, B, C.

    Output Format
    Return an integer.

    Example Input
    A = 2, B = 3, C = 3

    Example Output
    2

    Example Explanation
    23 % 3 = 8 % 3 = 2
    */

    private static int pow(int A, int B, int C) {
        if (A == 0)
            return 0;
        if (B == 0)
            return 1;
        if (A < 0 && B % 2 != 0)
            return A + C;
        else if (A < 0 && B % 2 == 0)
            return 1;
        else {
            int halfPow = pow(A, B / 2, C);
            int halfAns = (int) ((long) halfPow % C * halfPow % C) % C;
            if (B % 2 == 0)
                return halfAns % C;
            else {
                return (int) (((long) (A % C) * halfAns % C) % C);
            }
        }
        /* Scaler Solution
        if (A == 0) return 0;
        if (B == 0) return 1;
        long a = A;
        long res = 1L;
        while (B > 0) {
            if (B % 2 == 1) {
                res *= a;
                res %= C;
            }
            a *= a;
            a %= C;
            B = B >> 1;
        }
        res = (res + C) % C;
        return (int) res;
         */
    }

    public static void main(String[] args) {
        int A = 2, B = 3, C = 3;
        System.out.println(pow(A, B, B));
    }
}
