package com.jsm.scaler.advance.Stacks;

import java.util.Arrays;
import java.util.Stack;

public class NearestSmallestIndexRight {

    private static int[] NSRIndex(int[] A) {
        int[] nsrIndex = new int[A.length];
        Stack<Integer> stack = new Stack<>();

        for (int i = A.length - 1; i >= 0; --i) {
            while (!stack.isEmpty() && A[stack.peek()] >= A[i])
                stack.pop();
            if (stack.isEmpty())
                nsrIndex[i] = A.length; // In this case insert Invalid Index
            else
                nsrIndex[i] = stack.peek();
            stack.push(i);
        }
        return nsrIndex;
    }

    public static void main(String[] args) {
        int[] A = {4, 5, 2, 10, 18, 2};
        System.out.println(Arrays.toString(NSRIndex(A)));
    }

}
