package com.jsm.scaler.advance.Searching.BinarySearch;

public class KthPrice {
    /*
    Given the price list at which tickets for a flight were purchased, figure out the kth smallest price for the flight.
    kth smallest price is the minimum possible n such that there are at least k price elements in the price list with value <= n.
    In other words, if the price list was sorted, then A[k-1] ( k is 1 based, while the array is 0 based ).

    NOTE You are not allowed to modify the price list ( The price list is read only ). Try to do it using constant extra space.

    Example:

    A : [2 1 4 3 2]
    k : 3

    Answer : 2
    Constraints :

    1 <= number of elements in the price list <= 1000000
    1 <= k <= number of elements in the price list
    */

    private static int kthPrice(final int[] A, int B) {
        int min = Integer.MAX_VALUE;
        int max = Integer.MIN_VALUE;
        for (int num : A) {
            min = Math.min(min, num);
            max = Math.max(max, num);
        }
        int ans = max;
        while (min <= max) {
            int mid = min + (max - min) / 2;
            int count = findCount(A, mid);
            if (count >= B) {
                ans = mid;
                max = mid - 1;
            } else
                min = mid + 1;
        }
        return ans;
    }

    private static int findCount(int[] A, int max) {
        int count = 0;
        for (int num : A) {
            if (num <= max)
                count++;
        }
        return count;
    }

    public static void main(String[] args) {
        int[] A = {2, 1, 4, 3, 2};
        int B = 3;
        System.out.println(kthPrice(A, B));
    }
}
