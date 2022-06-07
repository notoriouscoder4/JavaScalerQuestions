package com.jsm.scaler.advance.Sorting;

import java.util.ArrayList;
import java.util.Arrays;

public class MaximumUnsortedSubarray {
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

    private static class Index {
        public int start;
        public int end;

        public Index(int start, int end) {
            this.start = start;
            this.end = end;
        }
    }

    private static Index mergeSortedSub(ArrayList<Integer> A, int start, int end) {
        if (start == end)
            return new Index(Integer.MAX_VALUE, -1);
        int mid = (start + end) / 2;
        Index leftSub = mergeSortedSub(A, start, mid);
        Index rightSub = mergeSortedSub(A, mid + 1, end);
        Index mergeSub = merge(A, start, mid, end);
        return new Index(Math.min(leftSub.start, Math.min(mergeSub.start, rightSub.start))
                , Math.max(leftSub.end, Math.max(rightSub.end, mergeSub.end)));
    }

    private static Index merge(ArrayList<Integer> A, int start, int mid, int end) {
        int left = start;
        int right = mid + 1;
        ArrayList<Integer> temp = new ArrayList<>();
        int sIndex = Integer.MAX_VALUE;
        int eIndex = -1;
        while (left <= mid && right <= end) {
            int l = A.get(left);
            int m = A.get(mid);
            int m1 = A.get(mid + 1);
            int r = A.get(right);
            if (r < m)
                eIndex = Math.max(right, eIndex);
            if (l > m1)
                sIndex = Math.min(left, sIndex);
            if (l <= r)
                temp.add(A.get(left++));
            else
                temp.add(A.get(right++));
        }
        while (left <= mid)
            temp.add(A.get(left++));
        while (right <= end)
            temp.add(A.get(right++));
        for (int i = 0; i < temp.size(); i++)
            A.set(start + i, temp.get(i));
        return new Index(sIndex, eIndex);
    }

    private static ArrayList<Integer> subUnsort(ArrayList<Integer> A) {
        ArrayList<Integer> ans = new ArrayList<>();
        Index index = mergeSortedSub(A, 0, A.size() - 1);
        if (index.start == Integer.MAX_VALUE || index.end == -1) {
            ans.add(-1);
            return ans;
        }
        ans.add(index.start);
        ans.add(index.end);
        return ans;
    }

    public static void main(String[] args) {
        ArrayList<Integer> A = new ArrayList<>(Arrays.asList(1, 2, 3, 4, 5));
        System.out.println(subUnsort(A));
    }
}
