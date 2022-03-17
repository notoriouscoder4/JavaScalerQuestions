package com.jsm.scaler.intermediate.ModularArithmetic;

public class LeastCommonMultiple {
    /*
    You are given two non-negative integers, A and B. Find the value of the Least Common Multiple (LCM) of A and B.
    LCM of two integers is the smallest positive integer divisible by both.

    Problem Constraints
    1 <= A, B <= 1000

    Input Format
    The first argument is an integer A.
    The second argument is an integer B.

    Output Format
    Return an integer.

    Example Input

    Input 1:
     A = 2
     B = 3

    Input 2:
     A = 9
     B = 6

    Input 3:
     A = 2
     B = 6

    Example Output

    Output 1:
     6
    Output 2:
     18

    Output 3:
     6
    */

    public static int LCM(int A, int B) {
        int G = 1;
        for (int i = 1; i <= Math.min(A, B); i++) {
            if (A % i == 0 && B % i == 0) {
                G = i;
            }
        }
        return (A * B) / G;
        // return (A / gcd(A, B)) * B;
    }

/*
    public static int gcd(int A, int B) {
        if (A == 0)
            return B;
        return gcd(B % A, A);
    }
*/

    public static void main(String[] args) {
        System.out.println(LCM(2, 3));
    }
}
