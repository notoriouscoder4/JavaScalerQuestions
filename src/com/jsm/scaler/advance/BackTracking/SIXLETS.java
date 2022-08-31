package com.jsm.scaler.advance.BackTracking;

import java.util.ArrayList;
import java.util.Arrays;

public class SIXLETS {
    /*
    Given an array of integers A of size N and an integer B.
    Return number of non-empty subsequences of A of size B having sum <= 1000.

    Problem Constraints
    1 <= N <= 20
    1 <= A[i] <= 1000
    1 <= B <= N

    Input Format
    The first argument given is the integer array A.
    The second argument given is the integer B.

    Output Format
    Return number of subsequences of A of size B having sum <= 1000.

    Example Input:
    Input 1:
        A = [1, 2, 8]
        B = 2

    Input 2:
        A = [5, 17, 1000, 11]
        B = 4

    Example Output:
    Output 1:
    3

    Output 2:
    0

    Example Explanation:
    Explanation 1:
     {1, 2}, {1, 8}, {2, 8}

    Explanation 1:
     No valid subsequence
    */

    private static int solve(ArrayList<Integer> A, int B) {
        return count_sixlets(A, B, 0, 0, new ArrayList<>());
    }

    private static int count_sixlets(ArrayList<Integer> A, int size, int sum, int index, ArrayList<Integer> ds) {
        if (ds.size() == size)
            return sum <= 1000 ? 1 : 0;
        if (index == A.size())
            return 0;
        // pick an ele
        ds.add(A.get(index));
        sum = sum + A.get(index);
        int count_from_pick = count_sixlets(A, size, sum, index + 1, ds);

        // not picking an ele
        ds.remove(ds.size() - 1);
        sum = sum - A.get(index);
        int count_from_non_pick = count_sixlets(A, size, sum, index + 1, ds);

        return count_from_pick + count_from_non_pick;
    }

    public static void main(String[] args) {
        ArrayList<Integer> A = new ArrayList<>(Arrays.asList(1, 2, 8));
        int B = 2;

        System.out.println(solve(A, B));
    }
}
