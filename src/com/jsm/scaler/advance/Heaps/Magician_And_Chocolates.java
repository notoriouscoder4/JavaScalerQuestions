package com.jsm.scaler.advance.Heaps;

import java.util.Collections;
import java.util.PriorityQueue;

public class Magician_And_Chocolates {
    /*
    Given N bags, each bag contains Bi chocolates. There is a kid and a magician.
    In a unit of time, the kid can choose any bag i, and eat Bi chocolates from it, then the magician will fill the ith bag with floor(Bi/2) chocolates.

    Find the maximum number of chocolates that the kid can eat in A units of time.

    NOTE:
    floor() function returns the largest integer less than or equal to a given number.
    Return your answer modulo 10^9+7

    Problem Constraints
    1 <= N <= 100000
    0 <= B[i] <= INT_MAX
    0 <= A <= 10^5

    Input Format
    The first argument is an integer A.
    The second argument is an integer array B of size N.

    Output Format
    Return an integer denoting the maximum number of chocolates the kid can eat in A units of time.

    Example Input:
    Input 1:
     A = 3
     B = [6, 5]

    Input 2:
     A = 5
     b = [2, 4, 6, 8, 10]

    Example Output:
    Output 1:
     14

    Output 2:
     33

    Example Explanation:
    Explanation 1:
     At t = 1 kid eats 6 chocolates from bag 0, and the bag gets filled by 3 chocolates.
     At t = 2 kid eats 5 chocolates from bag 1, and the bag gets filled by 2 chocolates.
     At t = 3 kid eats 3 chocolates from bag 0, and the bag gets filled by 1 chocolate.
     so, total number of chocolates eaten are 6 + 5 + 3 = 14

    Explanation 2:
     Maximum number of chocolates that can be eaten is 33.
    */

    private static int nchoc(int A, int[] B) {
        PriorityQueue<Integer> max_heap = new PriorityQueue<>(Collections.reverseOrder());
        for (int b : B)
            max_heap.add(b);

        long max_choc = 0, MOD = 1000000007;
        while (A > 0) {
            int choc = max_heap.peek();
            max_choc = (max_choc % MOD + choc % MOD) % MOD;
            max_heap.poll();
            max_heap.add(choc / 2);
            A--;
        }

        return (int) (max_choc % MOD);
    }

    public static void main(String[] args) {
        int A = 3;
        int[] B = new int[]{6, 5};

        System.out.println(nchoc(A, B));
    }
}
