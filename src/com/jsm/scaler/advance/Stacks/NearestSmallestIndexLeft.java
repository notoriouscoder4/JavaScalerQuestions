package com.jsm.scaler.advance.Stacks;

import java.util.Arrays;
import java.util.Stack;

public class NearestSmallestIndexLeft {

    private static int[] NSLIndex(int[] A) {
        int[] nslIndex = new int[A.length];
        Stack<Integer> stack = new Stack<>();

        for (int i = 0; i < A.length; ++i) {
            while (!stack.isEmpty() && A[stack.peek()] >= A[i])
                stack.pop();
            if (stack.isEmpty())
                nslIndex[i] = -1; // In this case insert Invalid Index
            else
                nslIndex[i] = stack.peek();
            stack.push(i);
        }
        return nslIndex;
    }

    public static void main(String[] args) {
        int[] A = {4, 5, 2, 10, 18, 2};
        System.out.println(Arrays.toString(NSLIndex(A)));
    }
}
