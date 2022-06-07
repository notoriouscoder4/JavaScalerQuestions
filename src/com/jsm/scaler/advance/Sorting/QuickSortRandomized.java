package com.jsm.scaler.advance.Sorting;

import java.util.Arrays;

public class QuickSortRandomized {
    /*
    Given an integer array A, sort the array using QuickSort.

    Problem Constraints
    1 <= |A| <= 10^5
    1 <= A[i] <= 10^9

    Input Format
    First argument is an integer array A.

    Output Format
    Return the sorted array.

    Example Input:
    Input 1:
     A = [1, 4, 10, 2, 1, 5]

    Input 2:
     A = [3, 7, 1]

    Example Output:
    Output 1:
     [1, 1, 2, 4, 5, 10]

    Output 2:
     [1, 3, 7]

    Example Explanation:
    Explanation 1:
     Return the sorted array.
    */

    private static int[] solve(int[] A) {
        quickSortRandomized(A, 0, A.length - 1);
        return A;
    }

    private static void quickSortRandomized(int[] A, int start, int end) {
        if (start >= end) return;

        int randomIndex = (int) (Math.random() * (end - start + 1)) + start;
        swap(A, start, randomIndex);

        int pivot = partition(A, start, end);
        quickSortRandomized(A, start, pivot - 1);
        quickSortRandomized(A, pivot + 1, end);
    }

    private static int partition(int[] A, int start, int end) {
        int left = start + 1;
        int right = end;
        while (left <= right) {
            if (A[left] <= A[start])
                left++;
            else if (A[right] > A[start])
                right--;
            else {
                swap(A, left, right);
                left++;
                right--;
            }
        }
        swap(A, start, right);
        return right;
    }

    private static void swap(int[] A, int a, int b) {
        if (a == b)
            return;
        int temp = A[a];
        A[a] = A[b];
        A[b] = temp;
    }

    public static void main(String[] args) {
        int[] A = {3, 7, 1};
        System.out.println(Arrays.toString(solve(A)));
    }
}
