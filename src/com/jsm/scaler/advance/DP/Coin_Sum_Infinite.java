package com.jsm.scaler.advance.DP;

import java.util.Arrays;

public class Coin_Sum_Infinite {
    /*
    You are given a set of coins A. In how many ways can you make sum B assuming you have infinite amount of each coin in the set.

    NOTE:
    1. Coins in set A will be unique. Expected space complexity of this problem is O(B).
    2. The answer can overflow. So, return the answer % (10^6 + 7).

    Problem Constraints
    1 <= A <= 500
    1 <= A[i] <= 1000
    1 <= B <= 50000

    Input Format
    First argument is an integer array A representing the set.
    Second argument is an integer B.

    Output Format
    Return an integer denoting the number of ways.

    Example Input:
    Input 1:
     A = [1, 2, 3]
     B = 4

    Input 2:
     A = [10]
     B = 10

    Example Output:
    Output 1:
     4

    Output 2:
     1

    Example Explanation:
    Explanation 1:
     The 4 possible ways are:
     {1, 1, 1, 1}
     {1, 1, 2}
     {2, 2}
     {1, 3}

    Explanation 2:
     There is only 1 way to make sum 10.
    */

    private static int coinChange2_spaceOptimized(int[] A, int B) {
        int[] num_ways = new int[B + 1];
        int Mod = 1000000 + 7;
        int i, j, m = A.length;
        Arrays.fill(num_ways, 0);
        num_ways[0] = 1;

        for (i = 0; i < m; i++) {
            for (j = A[i]; j <= B; j++) {
                num_ways[j] += num_ways[j - A[i]];
                num_ways[j] %= Mod;
            }
        }
        return num_ways[B];
    }
    
    public static void main(String[] args) {
        int[] A = {18, 24, 23, 10, 16, 19, 2, 9, 5, 12, 17, 3, 28, 29, 4, 13, 15, 8};
        int B = 458;
        System.out.println("The number of ways using coins to make sum B: " + coinChange2_spaceOptimized(A, B));
    }
}
