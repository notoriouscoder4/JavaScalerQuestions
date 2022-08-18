package com.jsm.scaler.advance.Heaps;

import java.util.Comparator;
import java.util.PriorityQueue;

public class Minimum_Largest_Element {
    /*
    Given an array A of N numbers, you have to perform B operations.
    In each operation, you have to pick any one of the N elements and
    add the original value(value stored at the index before we did any operations) to its current value.
    You can choose any of the N elements in each operation.

    Perform B operations in such a way that the largest element of the modified array(after B operations) is minimized.
    Find the minimum possible largest element after B operations.

    Problem Constraints
    1 <= N <= 10^6
    0 <= B <= 10^5
    -10^5 <= A[i] <= 10^5

    Input Format
    The first argument is an integer array A.
    The second argument is an integer B.

    Output Format
    Return an integer denoting the minimum possible largest element after B operations.

    Example Input:
    Input 1:
     A = [1, 2, 3, 4]
     B = 3

    Input 2:
     A = [5, 1, 4, 2]
     B = 5

    Example Output:
    Output 1:
     4

    Output 2:
     5

    Example Explanation:
    Explanation 1:
     Apply operation on element at index 0, the array would change to [2, 2, 3, 4]
     Apply operation on element at index 0, the array would change to [3, 2, 3, 4]
     Apply operation on element at index 0, the array would change to [4, 2, 3, 4]
     Minimum possible largest element after 3 operations is 4.

    Explanation 2:
     Apply operation on element at index 1, the array would change to [5, 2, 4, 2]
     Apply operation on element at index 1, the array would change to [5, 3, 4, 2]
     Apply operation on element at index 1, the array would change to [5, 4, 4, 2]
     Apply operation on element at index 1, the array would change to [5, 5, 4, 2]
     Apply operation on element at index 3, the array would change to [5, 5, 4, 4]
     Minimum possible largest element after 5 operations is 5.
    */

    private static class Pair {
        public int value;
        public int index;

        public Pair(int value, int index) {
            this.value = value;
            this.index = index;
        }
    }

    private static class CustomComp implements Comparator<Pair> {
        @Override
        public int compare(Pair a, Pair b) {
            return a.value - b.value;
        }
    }

    private static int minimumLargestElement(int[] A, int B) {
        PriorityQueue<Pair> min_heap = new PriorityQueue<>(new CustomComp());
        int[] state = new int[A.length];
        for (int i = 0; i < A.length; ++i) {
            state[i] = A[i];
        }
        for (int i = 0; i < A.length; ++i) {
            min_heap.add(new Pair(2 * A[i], i));
        }
        while (B-- > 0) {
            Pair top = min_heap.peek();
            state[top.index] = top.value;
            min_heap.poll();
            min_heap.add(new Pair(A[top.index] + top.value, top.index));
        }

        int max_ele = state[0];
        for (int i = 0; i < state.length; ++i) {
            max_ele = Math.max(max_ele, state[i]);
        }
        return max_ele;
    }

    public static void main(String[] args) {
        int[] A = {5, 1, 4, 2};
        int B = 5;
        System.out.println(minimumLargestElement(A, B));
    }
}
