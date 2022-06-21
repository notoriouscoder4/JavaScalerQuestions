package com.jsm.scaler.advance.TwoPointers;

public class AnotherCountRectangles {
    /*
    Given a sorted array of distinct integers A and an integer B,
    find and return how many rectangles with distinct configurations can be created using elements of this array
    as length and breadth whose area is lesser than B.

    (Note that a rectangle of 2 x 3 is different from 3 x 2 if we take configuration into view)

    Problem Constraints
    1 <= |A| <= 100000
    1 <= A[i] <= 10^9
    1 <= B <= 10^9

    Input Format
    The first argument given is the integer array A.
    The second argument given is integer B.

    Output Format
    Return the number of rectangles with distinct configurations with area less than B modulo (109 + 7).

    Example Input:
    Input 1:
     A = [1, 2]
     B = 5

    Input 2:
     A = [1, 2]
     B = 1

    Example Output:
    Output 1:
     4

    Output 2:
     0

    Example Explanation:
    Explanation 1:
     All 1X1, 2X2, 1X2 and 2X1 have area less than 5.

    Explanation 2:
     No Rectangle is valid.
    */
    private static int countRectangles(int[] A, int B) {
        /* TC: O(N), SC: O(1)*/
        int left = 0;
        int right = A.length - 1;
        int mod = 1000000007;

        long count = 0;
        while (left < A.length && right >= 0) {
            long area = (long) A[left] * (long) A[right];
            if (area < (long) B) {
                count = count + right + 1;
                left++;
            } else {
                right--;
            }
        }
        return (int) (count % mod);
    }

    public static void main(String[] args) {
        int[] A = {1, 2, 3, 4, 5};
        int B = 5;
        System.out.println(countRectangles(A, B));
    }
}
