package com.jsm.scaler.advance.Stacks;

import java.util.Arrays;
import java.util.Stack;

public class NearestGreaterIndexRight {

    private static int[] NGRIndex(int[] A) {
        int[] ngrIndex = new int[A.length];
        Stack<Integer> stack = new Stack<>();

        for (int i = A.length - 1; i >= 0; --i) {
            while (!stack.isEmpty() && A[stack.peek()] <= A[i])
                stack.pop();
            if (stack.isEmpty())
                ngrIndex[i] = A.length; // In this case insert Invalid Index
            else
                ngrIndex[i] = stack.peek();
            stack.push(i);
        }
        return ngrIndex;
    }

    public static void main(String[] args) {
        int[] A = {4, 5, 2, 10};
        System.out.println(Arrays.toString(NGRIndex(A)));
    }
}
