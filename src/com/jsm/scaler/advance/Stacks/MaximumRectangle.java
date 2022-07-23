package com.jsm.scaler.advance.Stacks;

import java.util.Stack;

public class MaximumRectangle {
    /*
    Given a 2D binary matrix of integers A containing 0's and 1's of size N x M.
    Find the largest rectangle containing only 1's and return its area.

    Note: Rows are numbered from top to bottom and columns are numbered from left to right.

    Input Format
    The only argument given is the integer matrix A.

    Output Format
    Return the area of the largest rectangle containing only 1's.

    Constraints
    1 <= N, M <= 1000
    0 <= A[i] <= 1

    For Example
    Input 1:
        A = [   [0, 0, 1]
                [0, 1, 1]
                [1, 1, 1]   ]

    Output 1:
        4

    Input 2:
        A = [   [0, 1, 0, 1]
                [1, 0, 1, 0]    ]
    Output 2:
        1
    */

    private static int solve(int[][] A) {
        int[] currRow = A[0];

        int max_area = maxHist(currRow);

        for (int i = 1; i < A.length; ++i) {
            for (int j = 0; j < A[0].length; ++j) {
                if (A[i][j] == 1)
                    currRow[j] += 1;
                else
                    currRow[j] = 0;
            }
            int currSum = maxHist(currRow);
            max_area = Math.max(max_area, currSum);
        }
        return max_area;
    }

    private static int maxHist(int[] row) {
        int[] nslIndex = NSLIndex(row);
        int[] nsrIndex = NSRIndex(row);

        int max_area = 0;
        for (int i = 0; i < row.length; ++i) {
            int width = nsrIndex[i] - nslIndex[i] - 1;
            int height = row[i];

            int area = width * height;
            max_area = Math.max(max_area, area);
        }
        //if (max_area < 0) max_area = max_area * (-1);
        return max_area;
    }

    private static int[] NSLIndex(int[] row) {
        int[] nslIndex = new int[row.length];
        Stack<Integer> stack = new Stack<>();

        for (int i = 0; i < row.length; ++i) {
            while (!stack.isEmpty() && row[stack.peek()] >= row[i])
                stack.pop();
            if (stack.isEmpty())
                nslIndex[i] = -1;
            else
                nslIndex[i] = stack.peek();
            stack.push(i);
        }
        return nslIndex;
    }

    private static int[] NSRIndex(int[] row) {
        int[] nsrIndex = new int[row.length];
        Stack<Integer> stack = new Stack<>();

        for (int i = row.length - 1; i >= 0; --i) {
            while (!stack.isEmpty() && row[stack.peek()] >= row[i])
                stack.pop();
            if (stack.isEmpty())
                nsrIndex[i] = row.length;
            else
                nsrIndex[i] = stack.peek();
            stack.push(i);
        }
        return nsrIndex;
    }

    public static void main(String[] args) {
        int[][] A = {{0, 0, 1}, {0, 1, 1}, {1, 1, 1}};
        System.out.println(solve(A));
    }
}
