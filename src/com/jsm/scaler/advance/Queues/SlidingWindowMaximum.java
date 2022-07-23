package com.jsm.scaler.advance.Queues;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Deque;
import java.util.LinkedList;

public class SlidingWindowMaximum {
    /*
    Given an array of integers A. There is a sliding window of size B, moving from the very left of the array to the very right.
    You can only see the B numbers in the window. Each time the sliding window moves rightwards by one position.
    You have to find the maximum for each window.

    Return an array C, where C[i] is the maximum value in the array from A[i] to A[i+B-1].
    Refer to the given example for clarity.

    NOTE: If B > length of the array, return 1 element with the max of the array.

    Problem Constraints
    1 <= |A|, B <= 106

    Input Format
    The first argument given is the integer array A.
    The second argument given is the integer B.

    Output Format
    Return an array C, where C[i] is the maximum value of from A[i] to A[i+B-1].

    Example Input
    Input 1:
     A = [1, 3, -1, -3, 5, 3, 6, 7]
     B = 3

    Input 2:
     A = [1, 2, 3, 4, 2, 7, 1, 3, 6]
     B = 6

    Example Output
    Output 1:
     [3, 3, 5, 5, 6, 7]

    Output 2:
     [7, 7, 7, 7]

    Example Explanation:
    Explanation 1:
     Window position     | Max
     --------------------|-------
     [1 3 -1] -3 5 3 6 7 | 3
     1 [3 -1 -3] 5 3 6 7 | 3
     1 3 [-1 -3 5] 3 6 7 | 5
     1 3 -1 [-3 5 3] 6 7 | 5
     1 3 -1 -3 [5 3 6] 7 | 6
     1 3 -1 -3 5 [3 6 7] | 7

    Explanation 2:
     Window position     | Max
     --------------------|-------
     [1 2 3 4 2 7] 1 3 6 | 7
     1 [2 3 4 2 7 1] 3 6 | 7
     1 2 [3 4 2 7 1 3] 6 | 7
     1 2 3 [4 2 7 1 3 6] | 7
    */

    private static ArrayList<Integer> slidingMaximum(final ArrayList<Integer> A, int B) {
        Deque<Integer> deque = new LinkedList<>();
        ArrayList<Integer> ans = new ArrayList<>();

        for (int i = 0; i < B; ++i) {
            while (deque.size() > 0 && deque.peekLast() < A.get(i))
                deque.removeLast();
            deque.addLast(A.get(i));
        }

        ans.add(deque.peekFirst());
        int index = 0;
        for (int i = B; i < A.size(); ++i) {
            if (A.get(index) == deque.peekFirst())
                deque.removeFirst();
            while (deque.size() > 0 && deque.peekLast() < A.get(i))
                deque.removeLast();
            deque.addLast(A.get(i));
            ans.add(deque.peekFirst());
            index++;
        }
        return ans;
    }

    public static void main(String[] args) {
        ArrayList<Integer> A = new ArrayList<>(Arrays.asList(1, 2, 3, 4, 2, 7, 1, 3, 6));
        int B = 6;
        System.out.println(slidingMaximum(A, B));
    }
}
