package com.jsm.scaler.advance.Recursion;

public class AnotherSequenceProblem {
    /*
    Given a sequence f(A) = f(A-1) + f(A-2) + f(A-3) + A . Calculate the Ath term of the sequence.
    Given f(0)=1; f(1)=1; f(2)=2;

    Problem Constraints
    0<=n<=20

    Input Format
    First and only argument is an integer A.

    Output Format
    Return an integer denoting the Ath term of the sequence.

    Example Input:
    Input 1:
     3

    Input 2:
     2

    Example Output:
    Output 1:
     7

    Output 2:
     2

    Example Explanation:
    Explanation 1:
     f(3) = 2+1+1+3 = 7

    Explanation 2:
     f(2) = 2 as given.
    */

    private static int solve(int A) {
        /* Recursive approach TC: O(3^N), SC()*/
        if (A == 0 || A == 1)
            return 1;
        if (A == 2)
            return 2;
        return solve(A - 1) + solve(A - 2) + solve(A - 2) + A;

        /* Recursive Approach Using Dynamic Programming Solution:- TC: O(N), SC: O(N)
        int[] dp = new int[22];
        for (int i = 0; i < dp.length; i++
            dp[i] = -1;
        dp[0] = dp[1] = 1;
        dp[2] = 2;
        int solve(int A) {
            if (A == 2) return 2;
            else if (A == 0 || A == 1) return 1;
            if (dp[A] != -1)
                return dp[A];
            int ans = solve(A - 1) + solve(A - 2) + solve(A - 3) + A;
            dp[A] = ans;
            return ans;
        }
        */
    }

    public static void main(String[] args) {
        int A = 3;
        System.out.println(solve(A));
    }
}
