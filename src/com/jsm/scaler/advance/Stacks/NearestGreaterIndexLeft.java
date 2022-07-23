package com.jsm.scaler.advance.Stacks;

import java.util.Arrays;
import java.util.Stack;

public class NearestGreaterIndexLeft {

    private static int[] NGLIndex(int[] A) {
        int[] nglIndex = new int[A.length];
        Stack<Integer> stack = new Stack<>();

        for (int i = 0; i < A.length; ++i) {
            while (!stack.isEmpty() && A[stack.peek()] <= A[i])
                stack.pop();
            if (stack.isEmpty())
                nglIndex[i] = -1; // In this case insert Invalid Index
            else
                nglIndex[i] = stack.peek();
            stack.push(i);
        }
        return nglIndex;
    }

    public static void main(String[] args) {
        int[] A = {4, 5, 2, 10};
        System.out.println(Arrays.toString(NGLIndex(A)));
    }
}
