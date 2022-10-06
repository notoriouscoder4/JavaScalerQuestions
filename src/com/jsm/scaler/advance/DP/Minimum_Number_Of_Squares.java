package com.jsm.scaler.advance.DP;

public class Minimum_Number_Of_Squares {
    /*
    Given an integer A. Return minimum count of numbers, sum of whose squares are equal to A.

    Problem Constraints
    1 <= A <= 10^5

    Input Format
    First and only argument is an integer A.

    Output Format
    Return an integer denoting the minimum count.

    Example Input:
    Input 1:
     A = 6

    Input 2:
     A = 5

    Example Output:
    Output 1:
     3

    Output 2:
     2

    Example Explanation:
    Explanation 1:
     Possible combinations are : (1^2 + 1^2 + 1^2 + 1^2 + 1^2 + 1^2) and (1^2 + 1^2 + 2^2).
     Minimum count of numbers, sum of whose squares are 6 is 3.

    Explanation 2:
     We can represent 5 using only 2 numbers i.e. 1^2 + 2^2 = 5
    */

    private static int countMinSquares(int A) {
        int[] dp = new int[A + 1];
        dp[0] = 0;
        for (int i = 1; i <= A; ++i) {
            int ans = i;
            for (int j = 1; j * j <= i; ++j) {
                ans = Math.min(ans, 1 + dp[i - (j * j)]);
            }
            dp[i] = ans;
        }
        return dp[A];
    }

    public static void main(String[] args) {
        int A = 6;
        System.out.println(countMinSquares(A));
    }
}
