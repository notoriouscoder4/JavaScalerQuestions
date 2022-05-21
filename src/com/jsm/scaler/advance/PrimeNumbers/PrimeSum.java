package com.jsm.scaler.advance.PrimeNumbers;

import java.util.ArrayList;
import java.util.Arrays;

public class PrimeSum {
    /*
    Given an even number A ( greater than 2 ), return two prime numbers whose sum will be equal to the given number.
    If there is more than one solution possible, return the lexicographically smaller solution.
    If [a, b] is one solution with a <= b, and [c,d] is another solution with c <= d, then
    [a, b] < [c, d], If a < c OR a==c AND b < d.
    NOTE: A solution will always exist. Read Goldbach's conjecture.

    Problem Constraints
    4 <= A <= 2*10^7

    Input Format
    First and only argument of input is an even number A.

    Output Format
    Return an integer array of size 2 containing primes whose sum will be equal to given number.

    Example Input
     4

    Example Output
     [2, 2]

    Example Explanation
     There is only 1 solution for A = 4.
    */

    private static ArrayList<Integer> primeSum(int A) {
        // Generate prime List less equal than N
        boolean[] prime = new boolean[A + 1];
        prime[0] = false;
        prime[1] = false;
        for (int i = 2; i <= A; i++)
            prime[i] = true;
        // Sieve of Eratosthenes
        for (int i = 2; i * i <= A; i++) {
            if (prime[i]) {
                for (int j = i * i; j <= A; j += i)
                    prime[j] = false;
            }
        }

        ArrayList<Integer> ans = new ArrayList<>();
        for (int i = 2; i <= A; i++) {
            if (prime[i] && prime[A - i]) {
                ans.add(i);
                ans.add(A - i);
                return ans;
            }
        }
        return ans;
    }

    public static void main(String[] args) {
        int A = 44;
        System.out.println(primeSum(A));
    }
}
