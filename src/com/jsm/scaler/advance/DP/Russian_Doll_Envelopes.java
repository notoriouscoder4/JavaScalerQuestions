package com.jsm.scaler.advance.DP;

import java.util.ArrayList;
import java.util.Collections;

public class Russian_Doll_Envelopes {
    /*
    Given a matrix of integers A of size N x 2 describing dimensions of N envelopes,
    where A[i][0] denotes the height of the ith envelope and A[i][1] denotes the width of the ith envelope.

    One envelope can fit into another if and only if both the width and height of one envelope is greater than the width and height of the other envelope.
    Find the maximum number of envelops you can put one inside others.

    Problem Constraints
    1 <= N <= 1000
    1 <= A[i][0], A[i][1] <= 10^9

    Input Format
    The only argument given is the integer matrix A.

    Output Format
    Return an integer denoting the maximum number of envelops you can put one inside others.

    Example Input:
    Input 1:
    A = [
         [5, 4]
         [6, 4]
         [6, 7]
         [2, 3]
     ]

    Input 2:
    A = [
         [8, 9]
         [8, 18]
     ]

    Example Output:
    Output 1:
    3

    Output 2:
    1

    Example Explanation:
    Explanation 1:
    Step 1: put [2, 3] inside [5, 4]
    Step 2: put [5, 4] inside [6, 7]
    3 envelopes can be put one inside others.

    Explanation 2:
    No envelopes can be put inside any other so answer is 1.
    */
    private static class Pair implements Comparable<Pair> {
        int height;
        int width;

        public Pair(int height, int width) {
            this.height = height;
            this.width = width;
        }

        @Override
        public int compareTo(Pair o) {
            return this.height - o.height;
        }
    }

    // Use The Longest Increasing Subsequence idea for one the property[height/width] after sorting
    // TC: O(NLogN + N^2) => O(N^2), SC: O(2N) => O(N)
    private static int solve(int[][] A) {
        // create Pair for each element in 2d matrix. this can be useful for sorting purpose
        ArrayList<Pair> list = new ArrayList<>();
        for (int i = 0; i < A.length; ++i) {
            list.add(new Pair(A[i][0], A[i][1]));
        }
        Collections.sort(list);

        int[] dp = new int[A.length];
        int ans = 1;
        for (int i = 0; i < list.size(); ++i) {
            dp[i] = 1;
            for (int j = 0; j < i; ++j) {
                // if both height and width are less, then envelope can be inserted
                if (list.get(i).height > list.get(j).height && list.get(i).width > list.get(j).width) {
                    // update dp array
                    dp[i] = Math.max(dp[i], 1 + dp[j]);
                    // update answer
                    ans = Math.max(ans, dp[i]);
                }
            }
        }
        return ans;
    }

    public static void main(String[] args) {
        int[][] A = {{5, 4}, {6, 4}, {6, 7}, {2, 3}};
        System.out.println(solve(A));
    }
}
