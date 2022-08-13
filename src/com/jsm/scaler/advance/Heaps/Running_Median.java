package com.jsm.scaler.advance.Heaps;

import java.util.Arrays;
import java.util.Collections;
import java.util.PriorityQueue;

public class Running_Median {
    /*
    Given an array of integers, A denoting a stream of integers. New arrays of integer B and C are formed.
    Each time an integer is encountered in a stream, append it at the end of B and append the median of array B at the C.

    Find and return the array C.

    NOTE:
    If the number of elements is N in B and N is odd, then consider the median as B[N/2] ( B must be in sorted order).
    If the number of elements is N in B and N is even, then consider the median as B[N/2-1]. ( B must be in sorted order).

    Problem Constraints
    1 <= length of the array <= 100000
    1 <= A[i] <= 10^9

    Input Format
    The only argument given is the integer array A.

    Output Format
    Return an integer array C, C[i] denotes the median of the first i elements.

    Example Input:
    Input 1:
     A = [1, 2, 5, 4, 3]

    Input 2:
     A = [5, 17, 100, 11]

    Example Output:
    Output 1:
     [1, 1, 2, 2, 3]

    Output 2:
     [5, 5, 17, 11]

    Example Explanation:
    Explanation 1:
     stream          median
     [1]             1
     [1, 2]          1
     [1, 2, 5]       2
     [1, 2, 5, 4]    2
     [1, 2, 5, 4, 3] 3

    Explanation 2:
     stream          median
     [5]              5
     [5, 17]          5
     [5, 17, 100]     17
     [5, 17, 100, 11] 11
    */

    private static int[] solve(int[] A) {
        int[] ans = new int[A.length];
        PriorityQueue<Integer> maxHeap = new PriorityQueue<>(Collections.reverseOrder());
        PriorityQueue<Integer> minHeap = new PriorityQueue<>();

        maxHeap.add(A[0]);
            ans[0] = A[0];

        for (int i = 1; i < A.length; ++i) {
            if (maxHeap.size() != 0 && A[i] < maxHeap.peek())
                maxHeap.add(A[i]);
            else
                minHeap.add(A[i]);

            if (maxHeap.size() < minHeap.size()) {
                // Transfer min from minHeap to maxHeap
                int ele = minHeap.peek();
                minHeap.poll();
                maxHeap.add(ele);
            } else if (Math.abs(maxHeap.size() - minHeap.size()) > 1) {
                // Transfer max from maxHeap to minHeap
                int ele = maxHeap.peek();
                maxHeap.poll();
                minHeap.add(ele);
            }
            int size = i + 1; // size of both heaps
            if (size % 2 == 0) {
                if (maxHeap.size() != 0 && minHeap.size() != 0)
                    ans[i] = (maxHeap.peek() + minHeap.peek()) / 2;
            } else {
                if (maxHeap.size() != 0)
                    ans[i] = maxHeap.peek();
            }
        }
        return ans;
    }

    public static void main(String[] args) {
        int[] A = new int[]{1, 1, 2, 2, 3};
        System.out.println(Arrays.toString(solve(A)));
    }
}