package com.jsm.scaler.advance.Arrays;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

public class MinimumSwaps2 {
    /*
    Given an array of integers A of size N that is a permutation of [0, 1, 2, ..., (N-1)].
    It is allowed to swap any two elements (not necessarily consecutive).
    Find the minimum number of swaps required to sort the array in ascending order.

    Problem Constraints
    1 <= N <= 100000
    0 <= A[i] < N

    Input Format
    The only argument given is the integer array A.

    Output Format
    Return the minimum number of swaps.

    Example Input:
    Input 1:
    A = [1, 2, 3, 4, 0]

    Input 2:
    A = [2, 0, 1, 3]


    Example Output:
    Output 1:
    4

    Output 2:
    2

    Example Explanation:
    Explanation 1:
     If you swap (1, 2) -> (2, 3) -> (4, 0) -> (3, 0). You will get a sorted array.
     You cannot sort it with lesser swaps.

    Explanation 2:
     You cannot sort it with lesser than 2 swaps.
    */

    private static int solve(int[] A) {
        int swaps = 0;
        int low = 0, high = A.length;
        while (low < high) {
            if (A[low] == low)
                low++;
            else {
                swap(A, low, A[low]);
                swaps++;
            }
        }
        return swaps;

        /* Scaler Solution
        int ans = 0;
        for(int i = 0 ; i < A.size() ; i++ ){
            while(A.get(i) != i){
                ans++;
                Collections.swap(A, i, A.get(i));
            }
        }
        return ans;
        */
    }

    private static void swap(int[] A, int idxI, int idxJ) {
        int temp = A[idxI];
        A[idxI] = A[idxJ];
        A[idxJ] = temp;
    }

    public static void main(String[] args) {
        int[] A = {1, 2, 3, 4, 0};
        System.out.println(solve(A));
    }
}
