package com.jsm.scaler.advance.Searching.BinarySearch;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class MedianOfArray {
    /*
    There are two sorted arrays A and B of sizes N and M respectively.
    Find the median of the two sorted arrays ( The median of the array formed by merging both the arrays ).

    NOTE:
    The overall run time complexity should be O(log(m+n)).
    IF the number of elements in the merged array is even, then the median is the average of (n/2)th and (n/2+1)th element.
    For example, if the array is [1 2 3 4], the median is (2 + 3) / 2.0 = 2.5.

    Problem Constraints
    1 <= N, M <= 10^6

    Input Format
    The first argument is an integer array A of size N.
    The second argument is an integer array B of size M.

    Output Format
    Return a decimal value denoting the median of two sorted arrays.

    Example Input:
    Input 1:
     A = [1, 4, 5]
     B = [2, 3]

    Input 2:
     A = [1, 2, 3]
     B = [4]

    Example Output:
    Output 1:
     3.0

    Output 2:
     2.5

    Example Explanation:
    Explanation 1:
     The median of both the sorted arrays will be 3.0.

    Explanation 2:
     The median of both the sorted arrays will be (2+3)/2 = 2.5.
    */

    private static double findMedianSortedArrays(final List<Integer> a, final List<Integer> b) {
        int n = a.size();
        int m = b.size();
        if (n > m)
            return findMedianSortedArrays(b, a); // ensuring that binary search happens on minimum size array
        int low = 0;
        int high = n;
        while (low <= high) {
            int cut1 = (low + high) / 2;
            int cut2 = (n + m + 1) / 2 - cut1;

            int l1 = (cut1 == 0) ? Integer.MIN_VALUE : a.get(cut1 - 1);
            int l2 = (cut2 == 0) ? Integer.MIN_VALUE : b.get(cut2 - 1);
            int r1 = (cut1 == n) ? Integer.MAX_VALUE : a.get(cut1);
            int r2 = (cut2 == m) ? Integer.MIN_VALUE : b.get(cut2);

            if (l1 <= r2 && l2 <= r1) {
                if ((n + m) % 2 == 0)
                    return (Math.max(l1, l2) + Math.min(r1, r2)) / 2.0;
                else
                    return Math.max(l1, l2);
            } else if (l1 > r2)
                high = cut1 - 1;
            else
                low = cut1 + 1;
        }
        return 0.0;
    }

    public static void main(String[] args) {
        List<Integer> a = new ArrayList<>(Arrays.asList(7, 12, 14, 15, 16));
        List<Integer> b = new ArrayList<>(Arrays.asList(1, 2, 3, 4, 9, 11));
        System.out.println(findMedianSortedArrays(a, b));
    }
}
