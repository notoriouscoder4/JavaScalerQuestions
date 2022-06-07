package com.jsm.scaler.advance.Sorting;

public class InversionCount {
    /*
    Given an array of integers A. If i < j and A[i] > A[j], then the pair (i, j) is called an inversion of A. Find the total number of inversions of A modulo (109 + 7).

    Problem Constraints
    1 <= length of the array <= 100000
    1 <= A[i] <= 10^9

    Input Format
    The only argument given is the integer array A.

    Output Format
    Return the number of inversions of A modulo (109 + 7).

    Example Input:
    Input 1:
    A = [3, 2, 1]

    Input 2:
    A = [1, 2, 3]

    Example Output:
    Output 1:
    3

    Output 2:
    0

    Example Explanation:
    Explanation 1:
     All pairs are inversions.

    Explanation 2:
     No inversions.
    */

    private static int solve(int[] A) {
        return inversionCount(A, 0, A.length - 1);
    }

    private static int inversionCount(int[] A, int s, int e) {
        int MOD = 1000000007;
        if (s == e) return 0;
        int mid = (s + e) / 2;
        int l = inversionCount(A, s, mid) % MOD;
        int r = inversionCount(A, mid + 1, e) % MOD;
        int z = mergeAndCount(A, s, mid, e) % MOD;
        return (l + r + z) % MOD;
    }

    private static int mergeAndCount(int[] A, int s, int mid, int e) {
        int MOD = 1000000007;
        int[] C = new int[e - s + 1];
        int count = 0;
        int i = s, j = mid + 1;
        int k = 0;
        while (i <= mid && j <= e) {
            if (A[i] > A[j]) {
                count += (mid - i + 1) % MOD;
                C[k] = A[j];
                j++;
            } else {
                C[k] = A[i];
                i++;
            }
            k++;
        }
        while (i <= mid) {
            C[k] = A[i];
            i++;
            k++;
        }
        while (j <= e) {
            C[k] = A[j];
            j++;
            k++;
        }
        for (int m = 0; m <= e - s; m++) {
            A[s + m] = C[m];
        }
        return count % MOD;
    }

    public static void main(String[] args) {
        int[] A = {3, 2, 1};
        System.out.println(solve(A));
    }
}
