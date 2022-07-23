package com.jsm.scaler.advance.Stacks;

import java.util.Arrays;
import java.util.Stack;

public class NearestSmallerElementRight {

    private static int[] NSR(int[] A) {
        int[] nsr = new int[A.length];
        Stack<Integer> stack = new Stack<>();

        for (int i = A.length - 1; i >= 0; --i) {
            while (!stack.isEmpty() && stack.peek() <= A[i])
                stack.pop();
            if (stack.isEmpty())
                nsr[i] = -1;
            else
                nsr[i] = stack.peek();
            stack.push(A[i]);
        }
        return nsr;
    }

    public static void main(String[] args) {
        int[] A = {4, 5, 2, 10};
        System.out.println(Arrays.toString(NSR(A)));
    }
}
