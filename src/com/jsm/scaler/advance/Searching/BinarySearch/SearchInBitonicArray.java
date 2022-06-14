package com.jsm.scaler.advance.Searching.BinarySearch;

public class SearchInBitonicArray {
    /*
    Given a bitonic sequence A of N distinct elements, write a program to find a given element B in the bitonic sequence in O(logN) time.

    NOTE:
    A Bitonic Sequence is a sequence of numbers which is first strictly increasing then after a point strictly decreasing.

    Problem Constraints
    3 <= N <= 10^5
    1 <= A[i], B <= 10^8

    Given array always contain a bitonic point.
    Array A always contain distinct elements.

    Input Format
    First argument is an integer array A denoting the bitonic sequence.
    Second argument is an integer B.

    Output Format
    Return a single integer denoting the position (0 index based) of the element B in the array A if B doesn't exist in A return -1.

    Example Input:
    Input 1:
     A = [3, 9, 10, 20, 17, 5, 1]
     B = 20

    Input 2:
     A = [5, 6, 7, 8, 9, 10, 3, 2, 1]
     B = 30

    Example Output:
    Output 1:
     3

    Output 2:
     -1

    Example Explanation:
    Explanation 1:
     B = 20 present in A at index 3

    Explanation 2:
     B = 30 is not present in A
    */

    private static int solve(int[] A, int B) {
        int low = 0;
        int high = A.length - 1;
        int ans = -1;
        if (A.length == 1)
            return 0;
        int bitonicPoint = findBitonicPoint(A, low, high);
        if (B == A[bitonicPoint])
            return bitonicPoint;
        if (B < A[bitonicPoint] && B >= A[0])
            ans = ascendingBinarySearch(A, low, bitonicPoint, B);
        if (B < A[bitonicPoint] && B >= A[A.length - 1] && ans == -1)
            ans = descendingBinarySearch(A, bitonicPoint + 1, A.length - 1, B);
        return ans;
    }

    private static int findBitonicPoint(int[] A, int low, int high) {
        // Find the bitonic point in the given array, i.e the maximum element in the given bitonic array.
        // This can be done in log(n) time by modifying the binary search algorithm.
        while (low <= high) {
            int mid = (low + high) / 2;
            if (A[mid] > A[mid - 1] && A[mid] > A[mid + 1]) {
                return mid;
            } else if (A[mid] > A[mid - 1] && A[mid] < A[mid + 1])
                low = mid + 1;
            else
                high = mid - 1;
        }
        return low;
    }

    private static int ascendingBinarySearch(int[] A, int low, int high, int B) {
        while (low <= high) {
            int mid = (low + high) / 2;
            if (A[mid] == B)
                return mid;
            else if (B < A[mid])
                high = mid - 1;
            else
                low = mid + 1;
        }
        return -1;
    }

    private static int descendingBinarySearch(int[] A, int low, int high, int B) {
        while (low <= high) {
            int mid = (low + high) / 2;
            if (A[mid] == B)
                return mid;
            else if (B < A[mid])
                low = mid + 1;
            else
                high = mid - 1;
        }
        return -1;
    }

    public static void main(String[] args) {
        int[] A = {5, 6, 7, 8, 9, 10, 3, 2, 1};
        int B = 20;
        System.out.println(solve(A, B));
    }
}
