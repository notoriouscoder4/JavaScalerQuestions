package com.jsm.scaler.advance.DP;

public class Ways_To_Have_Fun {
    /*
    Find the number of ways you can have fun in A days, given you can sleep every day,
    Pizza can be eaten every alternate day, and you can watch Tv shows every two days.
    Since the answer could be large, return answer % 10^9 + 7.

    Problem Constraints
    1 <= A <= 10^5

    Input Format
    First and only argument is an integer A denoting the number of days.

    Output Format
    Return an integer denoting the number of ways you can have fun in A days.

    Example Input:
    Input 1:
     A = 2

    Input 2:
     A = 3

    Example Output:
    Output 1:
     7

    Output 2:
     15

    Example Explanation:
    Explanation 1:
     There will be 7 ways to have fun:
     (SS), (SP), (ST), (PS), (PT), (TS), (TP).

    Explanation 2:
     There will be 15 ways to have fun.
    */

    private static long waysToHaveFun(int n, int[][] dp, int type) {
        long MOD = 1000000007;
        if (n == 0) return 0;
        if (n == 1) return 1;
        if (dp[type][n] != -1) return dp[type][n];
        long ans = 0;
        if (type == 0) {
            // sleep
            for (int i = 0; i < 3; ++i) {
                ans = (ans + waysToHaveFun(n - 1, dp, i)) % MOD;
            }
        }
        if (type == 1) {
            // pizza
            for (int i = 0; i < 3; ++i) {
                if (i == 1) continue;
                ans = (ans + waysToHaveFun(n - 1, dp, i)) % MOD;
            }
        }
        if (type == 2) {
            // TV Shows
            for (int i = 0; i < 3; ++i) {
                if (i == 2) continue;
                ans = (ans + waysToHaveFun(n - 1, dp, i)) % MOD;
            }
            ans = (ans - 2 * waysToHaveFun(n - 2, dp, type) % MOD) % MOD;
        }
        dp[type][n] = (int) ans;
        return ans;
    }

    private static int totalFunWaysIterative(int n) {
        long MOD = 1000000007;
        //State is n,type
        //dp[i][0] represents the maximum fun from 0–i with current opting as sleep
        long[][] dp = new long[3][2];
        for (int i = 0; i < 3; ++i) {
            dp[i][0] = 0;
            dp[i][1] = 1;
        }
        int flag = 0;
        for (int i = 2; i <= n; ++i) {
            // current Sleep
            dp[0][flag] = ((dp[0][flag ^ 1] + dp[1][flag ^ 1]) % MOD + dp[2][flag ^ 1]) % MOD;
            // current Pizza
            dp[1][flag] = (dp[0][flag ^ 1] + dp[2][flag ^ 1]) % MOD;
            /*
             * from n-2 will contribute to sleep and pizza in n-1 which should be negated
             * for TV in nth state therefore 2 times we will remove 1 for …TS & other for …TP
             */
            // current TV
            dp[2][flag] = ((dp[0][flag ^ 1] + dp[1][flag ^ 1]) % MOD - 2 * dp[2][flag]) % MOD;
            flag = flag ^ 1;
        }
        return (int) ((((dp[0][flag ^ 1] + dp[1][flag ^ 1]) % MOD + dp[2][flag ^ 1]) % MOD + MOD) % MOD);
    }

    private static int solve(int A) {
        long MOD = 1000000007;
        int[][] dp = new int[3][A + 1];
        for (int i = 0; i < 3; ++i) {
            for (int j = 0; j <= A; ++j) {
                dp[i][j] = -1;
            }
        }
        return (int) (((((waysToHaveFun(A, dp, 0) + waysToHaveFun(A, dp, 1)) % MOD + waysToHaveFun(A, dp, 2)) % MOD + MOD) % MOD));
    }

    public static void main(String[] args) {
        int A = 2;
        System.out.println(solve(A));
    }
}

/*
const int mod = 1e9 + 7;

int Solution::solve(int A) {
    long long dp[A+1][3];
    memset(dp,0,sizeof(dp));
    dp[1][0] = dp[1][1] = dp[1][2] = 1;
    for(int i = 2; i <= A; i++){
        dp[i][0] = (dp[i-1][0] + dp[i-1][1] + dp[i-1][2])%mod;
        dp[i][1] = (dp[i-1][0] + dp[i-1][2])%mod;
        dp[i][2] = dp[i-1][0] + dp[i-1][1] - 2*dp[i-2][2];
        dp[i][2] += mod;
        dp[i][2] %= mod;
    }
    int val = (dp[A][0] + dp[A][1] + dp[A][2])%mod;
    return val;
}
*/