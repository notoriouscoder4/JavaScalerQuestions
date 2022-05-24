package com.jsm.scaler.advance.Combinatorics;

public class SortedPermutationRank {
    /*
    Given a string A. Find the rank of the string amongst its permutations sorted lexicographically.
    Assume that no characters are repeated.
    Note: The answer might not fit in an integer, so return your answer % 1000003

    Problem Constraints
    1 <= |A| <= 1000

    Input Format
    First argument is a string A.

    Output Format
    Return an integer denoting the rank of the given string.

    Example Input:
    Input 1:
    A = "acb"

    Input 2:
    A = "a"

    Example Output:
    Output 1:
    2

    Output 2:
    1


    Example Explanation:
    Explanation 1:
    Given A = "acb".
    The order permutations with letters 'a', 'c', and 'b' :
    abc
    acb
    bac
    bca
    cab
    cba
    So, the rank of A is 2.

    Explanation 2:
    Given A = "a".
    Rank is clearly 1.
    */

    private static final int mod = 1000003;

    private static int findRank(String A) {
        int ans = 0;
        int n = A.length();
        for (int i = 0; i < n; i++) {
            int count = 0;
            for (int j = i + 1; j < n; j++)
                if (A.charAt(j) < A.charAt(i))
                    count++;
            ans += (count * fact(n - i - 1)) % mod;
        }
        return (ans + 1) % mod;
    }

    private static int fact(int n) {
        if (n == 0 || n == 1) return 1;
        return (n * fact(n - 1)) % mod;
    }

    public static void main(String[] args) {
        String A = "debcf";
        System.out.println(findRank(A));
    }
}
