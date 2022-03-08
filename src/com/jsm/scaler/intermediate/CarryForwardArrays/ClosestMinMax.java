package com.jsm.scaler.intermediate.CarryForwardArrays;

public class ClosestMinMax {

    /*
    Given an array A. Find the size of the smallest subarray such that it
    contains atleast one occurrence of the maximum value of the array
    and atleast one occurrence of the minimum value of the array.

    Problem Constraints
    1 <= |A| <= 2000
    */

    public static int minArray(int[] arr) {
        if (arr == null || arr.length == 0) {
            throw new IllegalArgumentException("Invalid Input");
        }

        int min = arr[0];
        for (int i = 1; i < arr.length; i++) {
            if (arr[i] < min) {
                min = arr[i];
            }
        }
        return min;
    }

    public static int maxArray(int[] arr) {
        if (arr == null || arr.length == 0) {
            throw new IllegalArgumentException("Invalid Input");
        }

        int max = arr[0];
        for (int i = 1; i < arr.length; i++) {
            if (arr[i] > max) {
                max = arr[i];
            }
        }
        return max;
    }

    public static int solve(int[] A) {
        int min = minArray(A);
        int max = maxArray(A);

        if (min == max)
            return 1;

        int latestMin = -1;
        int latestMax = -1;
        int ans = A.length;

        for (int i = 0; i < A.length; i++) {
            if (A[i] == max) {
                latestMax = i;
            } else if (A[i] == min) {
                latestMin = i;
            }

            if ((latestMax >= 0) && (latestMin >= 0)) {
                if (latestMax > latestMin) {
                    if ((latestMax - latestMin) < ans)
                        ans = latestMax - latestMin + 1;
                }

                if (latestMin > latestMax) {
                    if ((latestMin - latestMax) < ans) {
                        ans = latestMin - latestMax + 1;
                    }
                }
            }
        }

        return ans;
    }

    public static void main(String[] args) {
        int[] A = {1, 3};
        System.out.println(solve(A));
    }
}
