package com.jsm.scaler.advance.TwoPointers;

import java.util.Arrays;

public class SortByColor {
    /*
    Given an array with N objects colored red, white, or blue, sort them so that objects of the same color are adjacent,
    with the colors in the order red, white, and blue.
    We will use the integers 0, 1, and 2 to represent red, white, and blue, respectively.

    Note: Using the library sort function is not allowed.

    Problem Constraints
    1 <= N <= 1000000
    0 <= A[i] <= 2

    Input Format
    First and only argument of input contains an integer array A.

    Output Format
    Return an integer array in asked order

    Example Input:
    Input 1 :
    A = [0 1 2 0 1 2]

    Input 2:
    A = [0]


    Example Output:
    Output 1:
    [0 0 1 1 2 2]

    Output 2:
    [0]

    Example Explanation:
    Explanation 1:
    [0 0 1 1 2 2] is the required order.
    */

    private static int[] sortColors(int[] A) {
        /* Dutch National Flag Algorithm:-
            A[0...low -1] -> 0
            A[high + 1...n] -> 2
            A[low...mid - 1] -> 1
        */
        int low = 0;
        int high = A.length - 1;
        int mid = 0;
        int temp;
        while (mid <= high) {
            switch (A[mid]) {
                // If the element is 0
                case 0 -> {
                    temp = A[low];
                    A[low] = A[mid];
                    A[mid] = temp;
                    low++;
                    mid++;
                }
                case 1 -> mid++;
                case 2 -> {
                    temp = A[mid];
                    A[mid] = A[high];
                    A[high] = temp;
                    high--;
                }
            }
        }
        return A;
    }

    public static void main(String[] args) {
        int[] A = {0, 1, 2, 0, 1, 2};
        System.out.println(Arrays.toString(sortColors(A)));
    }
}
