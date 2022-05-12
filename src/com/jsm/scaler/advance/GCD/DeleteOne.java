package com.jsm.scaler.advance.GCD;

public class DeleteOne {
    /*
    Given an integer array A of size N. You have to delete one element such that the GCD(the Greatest Common Divisor) of the remaining array is maximum.
    Find the maximum value of GCD.

    Problem Constraints
    2 <= N <= 105
    1 <= A[i] <= 109

    Input Format
    First argument is an integer array A.

    Output Format
    Return an integer denoting the maximum value of GCD.

    Example Input:
    Input 1:
     A = [12, 15, 18]
    Input 2:
     A = [5, 15, 30]


    Example Output:
    Output 1:
     6
    Output 2:
     15

    Example Explanation:
    Explanation 1:
     If you delete 12, gcd will be 3.
     If you delete 15, gcd will be 6.
     If you delete 18, gcd will 3.
     Maximum value of gcd is 6.

    Explanation 2:
     If you delete 5, gcd will be 15.
     If you delete 15, gcd will be 5.
     If you delete 30, gcd will be 5.
    */

    private static int solve(int[] A) {
        int n = A.length, ans = 1;
        int[] suf = new int[n];
        int g = 0;
        for (int i = n - 1; i >= 0; i--) {
            g = gcd(g, A[i]);
            suf[i] = g;
        }
        int curGcd = 0;
        for (int i = 0; i < n; i++) {
            if (i != n - 1)
                ans = Math.max(ans, gcd(suf[i + 1], curGcd));
            else
                ans = Math.max(ans, curGcd);
            curGcd = gcd(curGcd, A[i]);
        }
        return ans;

        /*
        int N = A.length;
        int[] pre = new int[N];
        int[] suf = new int[N];
        pre[0] = A[0];
        suf[N-1] = A[N-1];
        for(int i = 1; i < N; i++) {
            pre[i] = gcd(pre[i-1], A[i]);
        }
        for(int i = N-2; i>=0; i--) {
            suf[i] = gcd(A[i], suf[i+1]);
        }
        int result = suf[1];
        // calculate gcd for each element
        for(int i = 1; i<N; i++) {
            if(i == N-1) {
                result = Math.max(result, pre[N-2]);
            }
            else {
                result = Math.max(result, gcd(pre[i-1], suf[i+1]));
            }
        }
        return result;
        */
    }

    private static int gcd(int a, int b) {
        if (a == 0) return b;
        return gcd(b % a, a);
    }

    public static void main(String[] args) {
        int[] A = {12, 15, 18};
        System.out.println(solve(A));
    }
}
