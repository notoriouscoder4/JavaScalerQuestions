package com.jsm.scaler.advance.GCD;

public class DivisorGame {
    /*
    Scooby has 3 three integers A, B, and C.
    Scooby calls a positive integer special if it is divisible by B, and it is divisible by C. You need to tell the number of special integers less than or equal to A.

    Problem Constraints
    1 <= A, B, C <= 10^9

    Input Format
    First argument is a positive integer A
    Second argument is a positive integer B
    Third argument is a positive integer C

    Output Format
    One integer corresponding to the number of special integers less than or equal to A.

    Example Input:
    Input 1:
     A = 12
     B = 3
     C = 2
    Input 2:
     A = 6
     B = 1
     C = 4

    Example Output:
    Output 1:
     2
    Output 2:
     1

    Example Explanation:
    Explanation 1:
     The two integers divisible by 2 and 3 and less than or equal to 12 are 6,12.

    Explanation 2:
     Only 4 is a positive integer less than equal to 6 which is divisible by 1 and 4.
    */

    private static int divisorGame(int A, int B, int C) {
        /* gcd(B, C) * lcm(B, C) = B * C */
        int lcm = (B * C) / gcd(B, C);
        return Math.abs(A / lcm);
    }

    private static int gcd(int A, int B) {
        if (A == 0) return B;
        return gcd(B % A, A);
    }

    public static void main(String[] args) {
        int A = 100;
        int B = 2;
        int C = 4;
        System.out.println(divisorGame(A, B, C));
    }
}
