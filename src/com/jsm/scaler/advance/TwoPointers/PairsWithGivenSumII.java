package com.jsm.scaler.advance.TwoPointers;

public class PairsWithGivenSumII {
    /*
    Given a sorted array of integers (not necessarily distinct) A and an integer B,
    find and return how many pair of integers ( A[i], A[j] ) such that i != j have sum equal to B.

    Since the number of such pairs can be very large, return number of such pairs modulo (109 + 7).

    Problem Constraints
    1 <= |A| <= 100000
    1 <= A[i] <= 10^9
    1 <= B <= 10^9

    Input Format
    The first argument given is the integer array A.
    The second argument given is integer B.

    Output Format
    Return the number of pairs for which sum is equal to B modulo (10^9+7).

    Example Input
    Input 1:
    A = [1, 1, 1]
    B = 2

    Input 2:
    A = [1, 1]
    B = 2

    Example Output:
    Output 1:
     3

    Output 2:
     1

    Example Explanation:
    Explanation 1:
     Any two pairs sum up to 2.

    Explanation 2:
     only pair (1, 2) sums up to 2.
    */

    private static int solve(int[] A, int B) {
        int left = 0;
        int right = A.length - 1;
        int sum;
        long count_pairs = 0;

        int mod = 1000000007;
        while (left < right) {
            sum = A[left] + A[right];
            if (sum < B)
                left++;
            else if (sum > B)
                right--;
                // If sum is equal
            else {
                if (A[left] == A[right]) { // suppose A:{2,2,2,2}, B = 4
                    int x = right - left + 1; // count of elements in the array
                    count_pairs += (long) x * (x - 1) / 2; // xC2 = x!/ 2!*(x-2)! = x*(x-1)/2,
                    break;
                } else {
                    // Find the frequency of A[left]
                    int a = A[left];
                    int countI = 0;
                    while (left < A.length && A[left] == a) {
                        left++;
                        countI++;
                    }

                    // Find the frequency of A[right]
                    int b = A[right];
                    int countJ = 0;
                    while (right < A.length && A[right] == b) {
                        right--;
                        countJ++;
                    }
                    count_pairs = (count_pairs % mod) + ((long) (countI) * (countJ) % mod) % mod;
                }
            }
        }
        return (int) (count_pairs % mod);
    }

    public static void main(String[] args) {
        int[] A = {1, 1, 1};
        int B = 2;
        System.out.println(solve(A, B));
    }
}
