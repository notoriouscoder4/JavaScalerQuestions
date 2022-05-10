package com.jsm.scaler.advance.ModularArithmetic;

public class VeryLargePower {
    /*
    Given two Integers A, B. You have to calculate (A ^ (B!)) % (1e9 + 7).
    "^" means power,
    "%" means "mod", and
    "!" means factorial.

    Problem Constraints
    1 <= A, B <= 5e5

    Input Format
    First argument is the integer A
    Second argument is the integer B

    Output Format
    Return one integer, the answer to the problem

    Example Input:
    Input 1:
    A = 1
    B = 1
    Input 2:
    A = 2
    B = 2

    Example Output:
    Output 1:
    1
    Output 2:
    4

    Example Explanation:
    Explanation 1:
     1! = 1. Hence 1^1 = 1.

    Explanation 2:
     2! = 2. Hence 2^2 = 4.
    */

    private static int veryLargePower(int A, int B) {
        long fact = 1;
        long mod = (long) (1e9 + 7);
        // calculating factorial of B
        for (long i = 2; i <= B; i += 1) {
            fact = (fact * i) % (mod - 1);      // (mod-1) is used according to Fermat Little theorem.
        }
        return fast_power(A, fact, mod);
    }

    static int fast_power(long A, long B, long mod) {
        long ans = 1;
        while (B > 0) {
            if ((B & 1) == 1) {
                ans = (ans * A) % mod;
            }
            A = (A % mod * A % mod) % mod;
            B = B >> 1;
        }
        return (int) (ans % mod);
    }

    public static void main(String[] args) {
        int A = 1;
        int B = 1;
        System.out.println(veryLargePower(A, B));
    }
}
