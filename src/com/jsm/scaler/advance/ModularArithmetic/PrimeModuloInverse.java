package com.jsm.scaler.advance.ModularArithmetic;

public class PrimeModuloInverse {
    /*
    Given two integers A and B. Find the value of A^-1 mod B where B is a prime number and gcd(A, B) = 1.
    A-1 mod B is also known as modular multiplicative inverse of A under modulo B.

    Problem Constraints
    1 <= A <= 109
    1 <= B <= 109
    B is a prime number

    Input Format
    First argument is an integer A.
    Second argument is an integer B.

    Output Format
    Return an integer denoting the modular inverse

    Example Input:
    Input 1:
     A = 3
     B = 5

    Input 2:
     A = 6
     B = 23

    Example Output:
    Output 1:
     2

    Output 2:
     4

    Example Explanation:
    Explanation 1:
     Let's say A-1 mod B = X, then (A * X) % B = 1.
     3 * 2 = 6, 6 % 5 = 1.

    Explanation 2:
     Similarly, (6 * 4) % 23 = 1.
    */

    private static int primeModuloInverse(int A, int B) {
        return power(A, B - 2, B);
    }

    private static int power(int a, int n, int m) {
        if (a == 0) return 0;
        if (n == 0) return 1;
        if (a < 0 && n % 2 != 0) return a + m;
        else if (a < 0 && n % 2 == 0) return 1;
        else {
            int halfPow = power(a, n / 2, m);
            int halfAns = (int) ((long) halfPow % m * halfPow % m) % m;
            if (n % 2 == 0) return halfAns % m;
            else return (int) (((long) (a % m) * halfAns % m) % m);
        }
    }

    public static void main(String[] args) {
        int A = 3;
        int B = 5;
        System.out.println(primeModuloInverse(A, B));
    }
}
