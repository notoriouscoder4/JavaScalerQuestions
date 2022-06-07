package com.jsm.scaler.advance.Sorting;

import java.util.Arrays;

public class MaximumUnsortedSubarrayScalerSolution {
    /*
    Given an array A of non-negative integers of size N. Find the minimum sub-array A[l], A[l+1] ,..., A[r] such that
    if we sort(in ascending order) that sub-array, then the whole array should get sorted. If A is already sorted, output -1.

    Problem Constraints
    1 <= N <= 1000000
    1 <= A[i] <= 1000000

    Input Format
    First and only argument is an array of non-negative integers of size N.

    Output Format
    Return an array of length two where the first element denotes the starting index(0-based) and the second element
    denotes the ending index(0-based) of the sub-array. If the array is already sorted, return an array containing only one element i.e. -1.

    Example Input:
    Input 1:
    A = [1, 3, 2, 4, 5]

    Input 2:
    A = [1, 2, 3, 4, 5]

    Example Output:
    Output 1:
    [1, 2]

    Output 2:
    [-1]

    Example Explanation:
    Explanation 1:
    If we sort the sub-array A1, A2, then the whole array A gets sorted.

    Explanation 2:
    A is already sorted.
    */

    private static int[] subUnsort(int[] A) {
        int n = A.length;
        int i = 0, j = n - 1;
        while (i < n - 1 && A[i] <= A[i + 1])
            i++;
        while (j > 0 && A[j] >= A[j - 1])
            j--;
        if (i == n - 1) { // if array is already sorted, output -1
            int[] ans = new int[1];
            ans[0] = -1;
            return ans;
        }
        int mn = A[i + 1], mx = A[i + 1];
        for (int k = i; k <= j; k++) {
            mx = Math.max(mx, A[k]);
            mn = Math.min(mn, A[k]);
        }
        int l = 0, r = n - 1;
        while (A[l] <= mn && l <= i)
            l++;
        while (A[r] >= mx && r >= j)
            r--;
        int[] ans = new int[2];
        ans[0] = l;
        ans[1] = r;
        return ans;
    }

    public static void main(String[] args) {
        int[] A = {1, 3, 2, 4, 5};
        System.out.println(Arrays.toString(subUnsort(A)));
    }
}
