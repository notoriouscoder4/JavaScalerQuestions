package com.jsm.scaler.intermediate.Recursion;

public class PowerFunction {
    /*
    Implement pow(A, B) % C.
    In other words, given A, B and C, Find (AB % C).
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

    public static int pow(int A, int B, int C) {
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
        long a = x;
	    long res = 1L;
	    while (n > 0) {
	        if (n % 2 == 1) {
	            res *= a;
	            res %= d;
	        }
	        a *= a;
	        a %= d;
	        n = n >> 1;
	    }
	    res = (res + d) % d;
	    return (int) res;
	    }
        */
    }

    public static void main(String[] args) {
        int A = 0;
        int B = 0;
        int C = 1;
        System.out.println(pow(A, B, C));
    }
}
