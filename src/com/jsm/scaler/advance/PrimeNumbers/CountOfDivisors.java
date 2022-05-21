package com.jsm.scaler.advance.PrimeNumbers;

import java.util.Arrays;

public class CountOfDivisors {
    /*
    Given an array of integers A, find and return the count of divisors of each element of the array.
    NOTE: The order of the resultant array should be the same as the input array.

    Problem Constraints
    1 <= length of the array <= 100000
    1 <= A[i] <= 106

    Input Format
    The only argument given is the integer array A.

    Output Format
    Return the count of divisors of each element of the array in the form of an array.

    Example Input:
    Input 1:
     A = [2, 3, 4, 5]
    Input 2:
     A = [8, 9, 10]

    Example Output:
    Output 1:
     [2, 2, 3, 2]
    Output 1:
     [4, 3, 4]

    Example Explanation:
    Explanation 1:
     The number of divisors of 2 : [1, 2], 3 : [1, 3], 4 : [1, 2, 4], 5 : [1, 5]
     So the count will be [2, 2, 3, 2].

    Explanation 2:
     The number of divisors of 8 : [1, 2, 4, 8], 9 : [1, 3, 9], 10 : [1, 2, 5, 10]
     So the count will be [4, 3, 4].
    */

    private static int[] countOfDivisors(int[] A) {
        int N = 1001001;
        int[] spf = new int[N + 1]; // Smallest Prime Factor Array
        for (int i = 2; i <= N; i++)
            spf[i] = i;
        // Sieve
        for (int i = 2; i * i <= N; i++) {
            if (spf[i] == i) {
                for (int j = i * i; j <= N; j += i) {
                    if (spf[j] == j)
                        spf[j] = i;
                }
            }
        }

        // divisors count
        int[] ans = new int[A.length];
        for (int i = 0; i < A.length; i++) {
            int temp = A[i];
            int divisors = 1;
            while (temp > 1) {
                int x = spf[temp];
                int power = 0;
                while (temp % x == 0) {
                    temp = temp / x;
                    power++;
                }
                divisors = divisors * (power + 1);
            }
            ans[i] = divisors;
        }
        return ans;
    }

    public static void main(String[] args) {
        int[] A = {2, 3, 4, 5};
        System.out.println(Arrays.toString(countOfDivisors(A)));
    }
}
