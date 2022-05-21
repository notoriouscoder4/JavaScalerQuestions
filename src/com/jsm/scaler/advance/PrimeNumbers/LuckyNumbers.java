package com.jsm.scaler.advance.PrimeNumbers;

public class LuckyNumbers {
    /*
    A lucky number is a number that has exactly 2 distinct prime divisors.
    You are given a number A, and you need to determine the count of lucky numbers between the range 1 to A (both inclusive).

    Problem Constraints
    1 <= A <= 50000

    Input Format
    The first and only argument is an integer A.

    Output Format
    Return an integer i.e. the count of lucky numbers between 1 and A, both inclusive.

    Example Input:
    Input 1:
     A = 8
    Input 2:
     A = 12

    Example Output:
    Output 1:
     1
    Output 2:
     3

    Example Explanation:
    Explanation 1:
     Between [1, 8] there is only 1 lucky number i.e 6.
     6 has 2 distinct prime factors i.e 2 and 3.

    Explanation 2:
     Between [1, 12] there are 3 lucky number: 6, 10 and 12.
    */

    private static int luckyNumbers(int A) {
        boolean[] prime = new boolean[A + 1];
        prime[0] = false;
        prime[1] = false;
        for (int i = 2; i <= A; i++)
            prime[i] = true;
        // Sieve of Eratosthenes
        for (int i = 2; i <= A; i++) {
            if (prime[i]) {
                for (int j = i * i; j <= A; j += i) {
                    prime[j] = false;
                }
            }
        }

        int N = A + 1;
        int[] count = new int[N];
        for (int i = 0; i < N; i++)
            count[i] = 0;
        for (int i = 1; i <= A; i++) {
            for (int j = 1; j * j <= i; j++) {
                if (i % j == 0) {
                    if (prime[j])
                        count[i]++;
                    if ((i / j) != j && prime[i / j])
                        count[i]++;
                }
            }
        }

        int ans = 0;
        for (int i = 1; i <= A; i++) {
            if (count[i] == 2)
                ans++;
        }
        return ans;
    }

    public static void main(String[] args) {
        int A = 8;
        System.out.println(luckyNumbers(A));
    }
}
