package com.jsm.scaler.advance.Queues;

import java.util.ArrayDeque;
import java.util.Deque;

public class SumMinMax {
    /*
    Given an array A of both positive and negative integers.
    Your task is to compute the sum of minimum and maximum elements of all sub-array of size B.

    NOTE: Since the answer can be very large, you are required to return the sum modulo 109 + 7.

    Problem Constraints
    1 <= size of array A <= 10^5
    -10^9 <= A[i] <= 10^9
    1 <= B <= size of array

    Input Format
    The first argument denotes the integer array A.
    The second argument denotes the value B

    Output Format
    Return an integer that denotes the required value.

    Example Input:
    Input 1:
     A = [2, 5, -1, 7, -3, -1, -2]
     B = 4

    Input 2:
     A = [2, -1, 3]
     B = 2

    Example Output:
    Output 1:
     18

    Output 2:
     3

    Example Explanation:
    Explanation 1:
     Sub-arrays of size 4 are :
        [2, 5, -1, 7],   min + max = -1 + 7 = 6
        [5, -1, 7, -3],  min + max = -3 + 7 = 4
        [-1, 7, -3, -1], min + max = -3 + 7 = 4
        [7, -3, -1, -2], min + max = -3 + 7 = 4
        Sum of all min & max = 6 + 4 + 4 + 4 = 18

    Explanation 2:
     Sub-arrays of size 2 are :
        [2, -1],   min + max = -1 + 2 = 1
        [-1, 3],   min + max = -1 + 3 = 2
        Sum of all min & max = 1 + 2 = 3
    */

    private static int solve(int[] A, int B) {
        long MOD = 1000000007;
        Deque<Integer> min_deque = new ArrayDeque<>();
        Deque<Integer> max_deque = new ArrayDeque<>();

        for (int i = 0; i < B; ++i) {
            while (!min_deque.isEmpty() && A[i] < A[min_deque.getLast()])
                min_deque.removeLast();
            min_deque.addLast(i);

            while (!max_deque.isEmpty() && A[i] > A[max_deque.getLast()])
                max_deque.removeLast();
            max_deque.addLast(i);
        }

        long sum = A[min_deque.getFirst()] + A[max_deque.getFirst()];

        for (int i = B; i < A.length; ++i) {
            if (i - B == min_deque.getFirst())
                min_deque.removeFirst();
            if (i - B == max_deque.getFirst())
                max_deque.removeFirst();

            while (!min_deque.isEmpty() && A[i] < A[min_deque.getLast()])
                min_deque.removeLast();
            min_deque.addLast(i);

            while (!max_deque.isEmpty() && A[i] > A[max_deque.getLast()])
                max_deque.removeLast();
            max_deque.addLast(i);

            sum = sum + A[min_deque.getFirst()] + A[max_deque.getFirst()];
            sum = sum % MOD;
        }
        sum = sum + MOD;
        sum = sum % MOD;
        return (int) sum;
    }

    public static void main(String[] args) {
        int[] A = {2, 5, -1, 7, -3, -1, -2};
        int B = 4;
        System.out.println(solve(A, B));
    }
}
