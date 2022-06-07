package com.jsm.scaler.advance.Sorting;

public class ArrayWithConsecutiveElements {
    /*
    Given an array of positive integers A, check and return whether the array elements are consecutive or not.
    NOTE: Try this with O(1) extra space.

    Problem Constraints
    1 <= length of the array <= 100000
    1 <= A[i] <= 10^9

    Input Format
    The only argument given is the integer array A.

    Output Format
    Return 1 if the array elements are consecutive else return 0.

    Example Input:
    Input 1:
     A = [3, 2, 1, 4, 5]

    Input 2:
     A = [1, 3, 2, 5]

    Example Output:
    Output 1:
     1

    Output 2:
     0

    Example Explanation:
    Explanation 1:
     As you can see all the elements are consecutive, so we return 1.

    Explanation 2:
     Element 4 is missing, so we return 0.
    */

    private static int solve(int[] A) {
        /*
        This method is O(n) time complexity and O(1) extra space, but it changes the original array, and it works only if all numbers are positive.
        We can get the original array by adding an extra step though.
           1) max – min + 1 = n where max is the maximum element in the array, min is the minimum element in the array and n is the number of elements in the array.
           2) All elements are distinct.
           The idea is to traverse the array and for each index i (where 0 ≤ i < n), make arr[arr[i] – min]] as a negative value. If we see a negative value again then there is repetition.
         */
        int n = A.length;
        if (n < 1)
            return 0;
        int min = getMin(A);
        int max = getMax(A);
        if (max - min + 1 == n) {
            for (int i = 0; i < n; i++) {
                int j;
                if (A[i] < 0)
                    j = -A[i] - min;
                else
                    j = A[i] - min;
                if (A[j] > 0)
                    A[j] = -A[j];
                else
                    return 0;
            }
            return 1;
        }
        return 0;
    }

    private static int getMin(int[] arr) {
        int min = arr[0];
        for (int i = 1; i < arr.length; i++) {
            if (arr[i] < min)
                min = arr[i];
        }
        return min;
    }

    private static int getMax(int[] arr) {
        int max = arr[0];
        for (int i = 1; i < arr.length; i++) {
            if (arr[i] > max)
                max = arr[i];
        }
        return max;
    }

    public static void main(String[] args) {
        int[] A = {1, 3, 2, 5};
        System.out.println(solve(A));
    }
}
