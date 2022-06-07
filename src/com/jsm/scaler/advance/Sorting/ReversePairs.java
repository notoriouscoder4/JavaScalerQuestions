package com.jsm.scaler.advance.Sorting;

import java.util.ArrayList;

public class ReversePairs {
    /*
    Given an array of integers A, we call (i, j) an important reverse pair if i < j and A[i] > 2*A[j].
    Return the number of important reverse pairs in the given array A.

    Problem Constraints
    1 <= length of the array <= 105
    -2 * 109 <= A[i] <= 2 * 109

    Input Format
    The only argument given is the integer array A.

    Output Format
    Return the number of important reverse pairs in the given array A.

    Example Input:
    Input 1:
     A = [1, 3, 2, 3, 1]

    Input 2:
     A = [4, 1, 2]

    Example Output:
    Output 1:
     2

    Output 2:
     1

    Example Explanation:
    Explanation 1:
     There are two pairs which are important reverse i.e (3, 1) and (3, 1).

    Explanation 2:
     There is only one pair i.e (4, 1).
    */

    private static int solve(int[] A) {
        return reversePairs(A, 0, A.length - 1);
    }

    private static int reversePairs(int[] A, int start, int end) {
        if (start == end) return 0;
        int mid = (start + end) / 2;
        int leftReversePairs = reversePairs(A, start, mid);
        int rightReversePairs = reversePairs(A, mid + 1, end);
        int mergeReversePairs = mergeAndCountReversePairs(A, start, mid, end);
        return leftReversePairs + rightReversePairs + mergeReversePairs;
    }

    private static int mergeAndCountReversePairs(int[] A, int start, int mid, int end) {
        int count = 0;
        int j = mid + 1;
        for (int i = start; i <= mid; i++) {
            while (j <= end && A[i] > (2 * (long) A[j])) {
                j++;
            }
            count += (j - (mid + 1));
        }
        ArrayList<Integer> temp = new ArrayList<>();
        int left = start, right = mid + 1;
        while (left <= mid && right <= end) {
            if (A[left] <= A[right]) {
                temp.add(A[left++]);
            } else {
                temp.add(A[right++]);
            }
        }
        while (left <= mid) {
            temp.add(A[left++]);
        }
        while (right <= end) {
            temp.add(A[right++]);
        }
        for (int i = start; i <= end; i++) {
            A[i] = temp.get(i - start);
        }
        return count;
    }

    public static void main(String[] args) {
        int[] A = {14046, 57239, 78362, 99387, 27609, 55100, 65536, 62099, 40820, 33056, 88380, 78549, 57512, 33137, 81212, 32365, 42276, 65368, 52459, 74924, 25355, 76044, 78056, 45190, 94365, 58869, 20611};
        System.out.println(solve(A));
    }
}
