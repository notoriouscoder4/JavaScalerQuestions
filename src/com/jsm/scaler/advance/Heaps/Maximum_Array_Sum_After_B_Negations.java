package com.jsm.scaler.advance.Heaps;

import java.util.PriorityQueue;

public class Maximum_Array_Sum_After_B_Negations {
    /*
    Given an array of integers A and an integer B. You must modify the array exactly B number of times.
    In a single modification, we can replace any one array element A[i] by -A[i].
    You need to perform these modifications in such a way that after exactly B modifications, sum of the array must be maximum.

    Problem Constraints
    1 <= length of the array <= 5*10^5
    1 <= B <= 5 * 10^6
    -100 <= A[i] <= 100

    Input Format
    The first argument given is an integer array A.
    The second argument given is an integer B.

    Output Format
    Return an integer denoting the maximum array sum after B modifications.

    Example Input:
    Input 1:
     A = [24, -68, -29, -9, 84]
     B = 4

    Input 2:
     A = [57, 3, -14, -87, 42, 38, 31, -7, -28, -61]
     B = 10

    Example Output:
    Output 1:
     196

    Output 2:
     362

    Example Explanation:
    Explanation 1:
     Final array after B modifications = [24, 68, 29, -9, 84]

    Explanation 2:
     Final array after B modifications = [57, -3, 14, 87, 42, 38, 31, 7, 28, 61]
    */

    private static int solve(int[] A, int B) {
        PriorityQueue<Integer> min_heap = new PriorityQueue<>();
        for (int a : A)
            min_heap.add(a);

        int sum = 0;
        while (B > 0) {
            int minVal = min_heap.peek();
            min_heap.poll();
            min_heap.add(-1 * minVal);
            B--;
        }
        while (min_heap.size() > 0) {
            sum += min_heap.peek();
            min_heap.poll();
        }
        return sum;
    }

    public static void main(String[] args) {
        int[] A = {57, 3, -14, -87, 42, 38, 31, -7, -28, -61};
        int B = 10;

        System.out.println(solve(A, B));
    }
}
