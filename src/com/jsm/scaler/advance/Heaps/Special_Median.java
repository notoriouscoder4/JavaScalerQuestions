package com.jsm.scaler.advance.Heaps;

import java.util.*;

public class Special_Median {
    /*
    You are given an array A containing N numbers. This array is called special if it satisfies one of the following properties:

    There exists an element A[i] in the array such that A[i] is equal to the median of elements [A[0], A[1], ...., A[i-1]]
    There exists an element A[i] in the array such that A[i] is equal to the median of elements [A[i+1], A[i+2], ...., A[N-1]]
    The Median is the middle element in the sorted list of elements. If the number of elements is even then the median will be (sum of both middle elements) / 2.

    Return 1 if the array is special else return 0.

    NOTE:
    For A[0] consider only the median of elements [A[1], A[2], ..., A[N-1]] (as there are no elements to the left of it)
    For A[N-1] consider only the median of elements [A[0], A[1], ...., A[N-2]]

    Problem Constraints
    1 <= N <= 1000000.
    A[i] is in the range of a signed 32-bit integer.

    Input Format
    The first and only argument is an integer array A.

    Output Format
    Return 1 if the given array is special else return 0.

    Example Input:
    Input 1:
     A = [4, 6, 8, 4]

    Input 2:
     A = [2, 7, 3, 1]

    Example Output"
    Output 1:
     1

    Output 2:
     0

    Example Explanation:
    Explanation 1:
     Here, 6 is equal to the median of [8, 4].

    Explanation 2:
     No element satisfies any condition.
    */

    private static class CustomComp implements Comparator<Integer> {
        @Override
        public int compare(Integer a, Integer b) {
            return b - a;
        }
    }

    private static PriorityQueue<Integer> maxHeap;
    private static PriorityQueue<Integer> minHeap;

    private static int specialMedian(ArrayList<Integer> A) {
        int n = A.size();
        maxHeap = new PriorityQueue<>(new CustomComp());
        minHeap = new PriorityQueue<>();

        for (int i = 0; i < (n - 1); ++i) {
            add_number(A.get(i));
            if (A.get(i + 1) == find_median())
                return 1;
        }
        maxHeap = new PriorityQueue<>(new CustomComp());
        minHeap = new PriorityQueue<>();

        for (int i = n - 1; i > 0; --i) {
            add_number(A.get(i));
            if (A.get(i - 1) == find_median())
                return 1;
        }
        return 0;
    }

    private static void add_number(int num) {
        maxHeap.add(num);
        minHeap.add(maxHeap.peek());
        maxHeap.poll();
        if (maxHeap.size() < minHeap.size()) {
            maxHeap.add(minHeap.peek());
            minHeap.poll();
        }
    }

    private static int find_median() {
        if (maxHeap.size() > minHeap.size())
            return maxHeap.peek();
        else {
            int ans = maxHeap.peek() + minHeap.peek();
            if (ans % 2 != 0)
                return Integer.MAX_VALUE;
            else
                return ans / 2;
        }
    }

    public static void main(String[] args) {
        ArrayList<Integer> A = new ArrayList<>(Arrays.asList(2, 7, 3, 1));
        System.out.println(specialMedian(A));
    }
}
