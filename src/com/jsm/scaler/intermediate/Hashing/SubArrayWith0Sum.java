package com.jsm.scaler.intermediate.Hashing;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;

public class SubArrayWith0Sum {
    /*
    Given an array of integers A, find and return whether the given array contains a non-empty sub-array with a sum equal to 0.
    If the given array contains a sub-array with sum zero return 1, else return 0.

    Problem Constraints
    1 <= |A| <= 100000
    -10^9 <= A[i] <= 10^9

    Input Format
    The only argument given is the integer array A.

    Output Format
    Return whether the given array contains a sub-array with a sum equal to 0.

    Example Input

    Input 1:
     A = [1, 2, 3, 4, 5]

    Input 2:
     A = [-1, 1]

    Example Output

    Output 1:
     0

    Output 2:
     1

    Example Explanation

    Explanation 1:
     No sub-array has sum 0.

    Explanation 2:
     The array has sum 0.
    */
    public static int solve(ArrayList<Integer> A) {
        HashSet<Long> hashSet = new HashSet<>();
        long sum = 0;
        for (Integer integer : A) {
            sum += integer;
            if (integer == 0 || sum == 0 || hashSet.contains(sum))
                return 1;
            hashSet.add(sum);
        }
        return 0;

        /* Scaler Solution
        HashSet < Long > set = new HashSet < Long > ();
        long sum = 0;
        set.add(sum);
        for (int x: A) {
            sum += x;
            if (set.contains(sum)) return 1;
            else {
                set.add(sum);
            }
        }
        return 0;
        */
    }

    public static void main(String[] args) {
        ArrayList<Integer> A = new ArrayList<>(Arrays.asList(1, 2, 3, 4, 5));
        System.out.println(solve(A));
    }
}
