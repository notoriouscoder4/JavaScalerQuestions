package com.jsm.scaler.advance.Stacks;

import java.util.Arrays;
import java.util.Stack;

public class LargestRectangleInHistogram {
    /*
    Given an array of integers A.
    A represents a histogram i.e A[i] denotes the height of the ith histogram's bar. Width of each bar is 1.
    Find the area of the largest rectangle formed by the histogram.

    Problem Constraints
    1 <= |A| <= 100000
    1 <= A[i] <= 1000000000

    Input Format
    The only argument given is the integer array A.

    Output Format
    Return the area of the largest rectangle in the histogram.

    Example Input
    Input 1:
     A = [2, 1, 5, 6, 2, 3]

    Input 2:
     A = [2]

    Example Output:
    Output 1:
     10

    Output 2:
     2

    Example Explanation:
    Explanation 1:
    The largest rectangle has area = 10 unit. Formed by A[3] to A[4].

    Explanation 2:
    Largest rectangle has area 2.
    */

    private static int largestRectangleArea(int[] A) {
        int[] nslIndex = NSLIndex(A);
        int[] nsrIndex = NSRIndex(A);

        int max_area = Integer.MIN_VALUE;
        for (int i = 0; i < A.length; ++i) {
            int width = nsrIndex[i] - nslIndex[i] - 1;
            int height = A[i];

            int area = width * height;
            max_area = Math.max(max_area, area);
        }
        return max_area;
    }

    private static int[] NSLIndex(int[] A) {
        int[] nslIndex = new int[A.length];
        Stack<Integer> stack = new Stack<>();

        for (int i = 0; i < A.length; ++i) {
            while (!stack.isEmpty() && A[stack.peek()] >= A[i])
                stack.pop();
            if (stack.isEmpty())
                nslIndex[i] = -1;
            else
                nslIndex[i] = stack.peek();
            stack.push(i);
        }
        return nslIndex;
    }

    private static int[] NSRIndex(int[] A) {
        int[] nsrIndex = new int[A.length];
        Stack<Integer> stack = new Stack<>();

        for (int i = A.length - 1; i >= 0; --i) {
            while (!stack.isEmpty() && A[stack.peek()] >= A[i])
                stack.pop();
            if (stack.isEmpty())
                nsrIndex[i] = A.length;
            else
                nsrIndex[i] = stack.peek();
            stack.push(i);
        }
        return nsrIndex;
    }

    public static void main(String[] args) {
        int[] A = {2, 1, 3, 5, 4, 3, 4, 3, 6, 2, 5};
        //int[] A = {1};
        System.out.println(largestRectangleArea(A));
    }
}
