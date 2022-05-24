package com.jsm.scaler.advance.Combinatorics;

public class nCrmodulop {
    /*
    Given three integers A, B, and C, where A represents n, B represents r, and C represents p and p is a prime number greater than equal to n,
    find and return the value of nCr % p where nCr % p = (n! / ((n-r)! * r!)) % p.
    x! means factorial of x i.e. x! = 1 * 2 * 3... * x.

    NOTE: For this problem, we are considering 1 as a prime.

    Problem Constraints
    1 <= A <= 10^6
    1 <= B <= A
    A <= C <= 10^9+7

    Input Format
    The first argument given is the integer A ( = n).
    The second argument given is the integer B ( = r).
    The third argument given is the integer C ( = p).

    Output Format
    Return the value of nCr % p.

    Example Input:
    Input 1:
     A = 5
     B = 2
     C = 13

    Input 2:
     A = 6
     B = 2
     C = 13

    Example Output:
    Output 1:
     10

    Output 2:
     2

    Example Explanation:
    Explanation 1:
     nCr( n=5 and r=2) = 10.
     p=13. Therefore, nCr%p = 10.
    */

    private static int solve(int A, int B, int C) {
        if (A < B) return 0;
        if (B == 0) return 1;
        // As considering 1 as prime
        if (C == 1) return 0;

        long aFact = fact(A, C);
        int bFact = (int) fact(B, C);
        int aminusbFact = (int) fact(A - B, C);
        long y = ((long) inverseMod(bFact, C) % C * inverseMod(aminusbFact, C) % C) % C;
        return (int) ((aFact % C * y) % C);
    }

    private static int power(int A, int B, int C) {
        if (A == 0) return 0;
        if (B == 0) return 1;
        if (B == 1) return A % C;
        int halfPower = power(A, B / 2, C);
        int halfAns = (int) ((long) halfPower % C * halfPower % C) % C;
        if (B % 2 == 0)
            return halfAns % C;
        else
            return (int) (((long) (A % C) * halfAns % C) % C);
    }

    private static int inverseMod(int A, int m) {
        return power(A, m - 2, m);
    }

    private static long fact(int n, long mod) {
        if (n == 0) return 1;
        long facto = 1;
        for (int i = 1; i <= n; i++) {
            facto = (facto * i) % mod;
        }
        return facto % mod;
    }

    public static void main(String[] args) {
        int A = 5;
        int B = 2;
        int C = 13;
        System.out.println(solve(A, B, C));
    }
}
