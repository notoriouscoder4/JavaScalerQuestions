package com.jsm.scaler.advance.Searching.BinarySearch;

public class AthMagicalNumber {
    /*
    You are given three positive integers, A, B, and C.
    Any positive integer is magical if divisible by either B or C.
    Return the Ath_smallest magical number. Since the answer may be very large, return modulo 10^9 + 7.

    Problem Constraints
    1 <= A <= 10^9
    2 <= B, C <= 40000

    Input Format
    The first argument given is an integer A.
    The second argument given is an integer B.
    The third argument given is an integer C.

    Output Format
    Return the Ath_smallest magical number. Since the answer may be very large, return modulo 10^9 + 7.

    Example Input:
    Input 1:
     A = 1
     B = 2
     C = 3

    Input 2:
     A = 4
     B = 2
     C = 3

    Example Output:
    Output 1:
     2

    Output 2:
     6

    Example Explanation:
    Explanation 1:
     1st magical number is 2.

    Explanation 2:
     First four magical numbers are 2, 3, 4, 6 so the 4th magical number is 6.
    */

    private static int athMagicalNumber(int A, int B, int C) {
        //low would be the first multiple of Minimum of B,C.
        long low = Math.min(B, C);
        //Ath element can not go beyond Ath multiple of Minimum of B,C.
        long high = (long) Math.min(B, C) * A;
        int mod = 1000000007;

        long lcm = (((long) B) * C) / gcd(B, C);
        long ans = low;
        //To calculate the Ath position divisible by B or C, we need to (imagine) think of the A multiples of B and C at least(say 5)
        // But we don't need to calculate the common multiple twice.
        //So we need to calculate lcm of B & C, to be able to reduce the common multiple of B and C.
        while (low <= high) {
            long mid = low + (high - low) / 2;
            long countMultipleOfB = mid / B;
            long countMultipleOfC = mid / C;
            long countMultipleOfBOrC = mid / lcm;
            long totalDivisibleTillMid = countMultipleOfB + countMultipleOfC - countMultipleOfBOrC;
            if (totalDivisibleTillMid >= A) {
                ans = mid;
                high = mid - 1;
            } else
                low = mid + 1;
        }
        if (ans < 0)
            ans += mod;
        return (int) (ans % mod);
    }

    private static int gcd(int A, int B) {
        if (A == 0) return B;
        return gcd(B % A, A);
    }

    public static void main(String[] args) {
        int A = 807414236;
        int B = 3788;
        int C = 38141;
        System.out.println(athMagicalNumber(A, B, C));
    }
}
