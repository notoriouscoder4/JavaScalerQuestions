package com.jsm.scaler.advance.Sorting;

public class KthSmallestElement {
    /*
    Find the Kth-smallest element in given array A .
    NOTE: Users should try to solve it in less than equal to B swaps.

    Problem Constraints
    1 <= |A| <= 100000
    1 <= B <= min(|A|, 500)
    1 <= A[i] <= 10^9



    Input Format
    The first argument is an integer array A.
    The second argument is integer B.

    Output Format
    Return the Kth-smallest element in given array.

    Example Input
    Input 1:
    A = [2, 1, 4, 3, 2]
    B = 3

    Input 2:
    A = [1, 2]
    B = 2

    Example Output:
    Output 1:
     2

    Output 2:
     2

    Example Explanation:
    Explanation 1:
     3rd element after sorting is 2.

    Explanation 2:
     2nd element after sorting is 2.
    */

    private static int kthSmallest(final int[] A, int K) {
        /* Selection Sort */
        for (int i = 0; i < K; i++) {
            int min = Integer.MAX_VALUE;
            int min_index = -1;
            for (int j = i; j < A.length; j++) {
                if (A[j] < min) {
                    min = A[j];
                    min_index = j;
                }
            }
            int temp = A[i];
            A[i] = A[min_index];
            A[min_index] = temp;
        }

        /* Selection Sort : TC: O(N^2), SC: O(1), Stable : No
        for (int i = 0; i < A.length; i++) {
            int min = A[i];
            int min_index = i;
            for (int j = i; j < A.length; j++) {
                if (A[j] < min) {
                    min = A[j];
                    min_index = j;
                }
            }
            int temp = A[i];
            A[i] = A[min_index];
            A[min_index] = temp;
        }
        */
        return A[K - 1];
    }

    public static void main(String[] args) {
        int[] A = {2, 1, 4, 3, 2};
        int K = 3;
        System.out.println(kthSmallest(A, K));
    }
}
