package com.jsm.scaler.advance.PrimeNumbers;

public class PrimeAddition {
    /*
    You are given an even number N and you need to represent the given number as the sum of primes.
    The prime numbers do not necessarily have to be distinct. It is guaranteed that at least one possible solution exists.

    You need to determine the minimum number of prime numbers needed to represent the given number.

    Input
    The first argument contains an integer N,the number you need to represent (3<=N<=10^9).

    Output
    Return an integer which is the minimum number of prime numbers needed to represent the given number N.

    Examples:
    Input
    26

    Output
    2

    Explanation:
    Testcase 1-
    You can represent 26 as: 13+13
    So we require minimum of 2 prime numbers to represent the number 26.
    */

    private static int primeAddition(int A) {
        if (A == 2)
            return 1;
        else return 2;
    }

    public static void main(String[] args) {
        int A = 26;
        System.out.println(primeAddition(A));
    }
}
