package com.jsm.scaler.advance.TwoPointers;

public class ThreePointers {
    /*
    You are given 3 sorted arrays A, B and C.
    Find i, j, k such that : max(abs(A[i] - B[j]), abs(B[j] - C[k]), abs(C[k] - A[i])) is minimized.
    Return the minimum max(abs(A[i] - B[j]), abs(B[j] - C[k]), abs(C[k] - A[i])).

    Problem Constraints
    0 <= len(A), len(B), len(c) <= 10^6
    0 <= A[i], B[i], C[i] <= 10^7

    Input Format
    First argument is an integer array A.
    Second argument is an integer array B.
    Third argument is an integer array C.

    Output Format
    Return a single integer denoting the minimum max(abs(A[i] - B[j]), abs(B[j] - C[k]), abs(C[k] - A[i])).

    Example Input:
    Input 1:
     A = [1, 4, 10]
     B = [2, 15, 20]
     C = [10, 12]

    Input 2:
     A = [3, 5, 6]
     B = [2]
     C = [3, 4]

    Example Output:
    Output 1:
     5

    Output 2:
     1

    Example Explanation:
    Explanation 1:
     With 10 from A, 15 from B and 10 from C.

    Explanation 2:
     With 3 from A, 2 from B and 3 from C.
    */

    private static int minimize(final int[] A, final int[] B, final int[] C) {
        int ans = Integer.MAX_VALUE;
        int p1 = 0, p2 = 0, p3 = 0;
        while (p1 < A.length && p2 < B.length && p3 < C.length) {
            int max = Math.max(A[p1], Math.max(B[p2], C[p3]));
            int min = Math.min(A[p1], Math.min(B[p2], C[p3]));
            ans = Math.min(ans, max - min);
            int compare = Math.min(A[p1], Math.min(B[p2], C[p3]));
            if (compare == A[p1])
                p1++;
            else if (compare == B[p2])
                p2++;
            else
                p3++;
        }
        return ans;
    }

    public static void main(String[] args) {
        int[] A = {3, 14, 16, 20, 29, 40};
        int[] B = {-6, 23, 24, 30, 35, 50};
        int[] C = {-15, 15, 26, 31, 39, 42};
        System.out.println(minimize(A, B, C));
    }
}
