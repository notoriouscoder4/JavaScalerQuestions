package com.jsm.scaler.advance.Stacks;

import java.util.Arrays;
import java.util.Stack;

public class NearestGreaterElementLeft {

    private static int[] NGL(int[] A) {
        int[] ngl = new int[A.length];
        Stack<Integer> stack = new Stack<>();

        for (int i = 0; i < A.length; ++i) {
            while (!stack.isEmpty() && stack.peek() <= A[i])
                stack.pop();
            if (stack.isEmpty())
                ngl[i] = -1;
            else
                ngl[i] = stack.peek();
            stack.push(A[i]);
        }
        return ngl;
    }

    public static void main(String[] args) {
        int[] A = {4, 5, 2, 10};
        System.out.println(Arrays.toString(NGL(A)));
    }
}
