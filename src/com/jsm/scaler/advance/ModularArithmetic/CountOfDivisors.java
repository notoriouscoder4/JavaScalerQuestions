package com.jsm.scaler.advance.ModularArithmetic;

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

    //S[x] is the smallest prime factor of x
    static int[] S;
    static int NP = 1001001;

    private static void sieve() {
        int n = NP;
        S = new int[n];
        for (int i = 1; i < n; i++)
            S[i] = i;
        for (int i = 2; i * i <= n; i++) {
            if (S[i] != i)
                continue;
            for (int j = i * i; j < n; j += i) {
                if (S[j] == j)
                    S[j] = i;
            }
        }
    }

    private static int countDivisors(int x) {
        int ans = 1;
        while (S[x] > 1) {
            int cnt = 1, u = S[x];
            while (S[x] == u) {
                cnt++;
                x /= u;
            }
            ans = ans * cnt;
        }
        return ans;
    }

    private static int[] solve(int[] a) {
        sieve();
        int n = a.length;
        int[] ans = new int[n];
        for (int i = 0; i < n; i++)
            ans[i] = countDivisors(a[i]);
        return ans;
    }

    public static void main(String[] args) {
        int[] a = {2, 3, 4, 5};
        System.out.println(Arrays.toString(solve(a)));
    }
}

/* C++ solution
int spf[1000005];

vector<int> Solution::solve(vector<int> &A) {
    for(int i = 1; i <= 1000000; ++i) {
        spf[i] = i;
    }
    for(int i = 2; i * i <= 1000000; ++i) {
        if(spf[i] == i) {
            for(int j = i * i ; j <= 1000000; j += i) {
                if(spf[j] == j)
                   spf[j] = i;
            }
        }
    }

    vector<int> sol;
    for(int i = 0; i < A.size(); ++i) {
        int temp = A[i];
        int ans = 1;
        while(temp != 1) {
            int cnt = 1;
            int d = spf[temp];
            while(temp != 1 and temp % d == 0) {
                cnt++;
                temp = temp / d;
            }
            ans = ans * cnt;
        }
        sol.push_back(ans);
    }
    return sol;
}
*/
