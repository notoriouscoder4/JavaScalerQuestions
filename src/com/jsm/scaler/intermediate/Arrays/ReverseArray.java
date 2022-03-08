package com.jsm.scaler.intermediate.Arrays;

import java.util.Arrays;

public class ReverseArray {
    public static int[] solve(int[] A) {
        int start = 0;
        int end = A.length - 1;

        while (start < end) {
            int temp = A[start];
            A[start] = A[end];
            A[end] = temp;
            start++;
            end--;
        }

        return A;
    }

    public static void main(String[] args) {
        int[] A = {1,1,10};
        System.out.println(Arrays.toString(solve(A)));
    }
}
