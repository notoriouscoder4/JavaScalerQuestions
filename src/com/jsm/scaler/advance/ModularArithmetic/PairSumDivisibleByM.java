package com.jsm.scaler.advance.ModularArithmetic;

import java.util.HashMap;
import java.util.Map;

public class PairSumDivisibleByM {
    /*
    Given an array of integers A and an integer B, find and return the number of pairs in A whose sum is divisible by B.
    Since the answer may be large, return the answer modulo (10^9 + 7).

    Problem Constraints
    1 <= length of the array <= 100000
    1 <= A[i] <= 109
    1 <= B <= 106

    Input Format
    The first argument given is the integer array A.
    The second argument given is the integer B.

    Output Format
    Return the total number of pairs for which the sum is divisible by B modulo (109 + 7).

    Example Input:
    Input 1:
     A = [1, 2, 3, 4, 5]
     B = 2

    Input 2:
     A = [5, 17, 100, 11]
     B = 28

    Example Output:
    Output 1:
     4

    Output 2:
     1

    Example Explanation:
    Explanation 1:
     All pairs which are divisible by 2 are (1,3), (1,5), (2,4), (3,5).
     So total 4 pairs.
    */

    private static int pairSumDivisibleByM(int[] A, int B) {
        Map<Integer, Long> map = new HashMap<>();
        for (int i = 0; i < A.length; i++) {
            int val = 0;
            if (A[i] > 0) val = A[i] % B;
            else val = (A[i] % B) + B;
            if (map.containsKey(val))
                map.put(val, map.get(val) + 1L);
            else
                map.put(val, 1L);
        }

        long ans = 0;
        int mod = 1000000007;
        if (map.get(0) != null) {
            long a = map.get(0);
            a = a % mod;
            ans += (a * (a - 1)) / 2;
        }

        int i = 1, j = B - 1;
        while (i < j) {
            if (map.get(i) != null && map.get(j) != null)
                ans += map.get(i) * map.get(j);
            i++;
            j--;
        }

        if (B % 2 == 0) {
            if (map.get(B / 2) != null) {
                long b = map.get(B / 2);
                b = b % mod;
                ans += (b * (b - 1)) / 2;
            }
        }

        if (ans < 0)
            return (int) (ans + mod) % mod;
        return (int) ans % mod;
    }

    public static void main(String[] args) {
        int[] A = {1, 2, 3, 4, 5};
        int B = 2;
        System.out.println(pairSumDivisibleByM(A, B));
    }
}
