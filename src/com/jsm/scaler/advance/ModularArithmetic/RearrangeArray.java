package com.jsm.scaler.advance.ModularArithmetic;

import java.util.ArrayList;
import java.util.Arrays;

public class RearrangeArray {
    /*
    Rearrange a given array so that Arr[i] becomes Arr[Arr[i]] with O(1) extra space.

    Example:
    Input : [1, 0]
    Return : [0, 1]
    Lets say N = size of the array. Then, following holds true :

    All elements in the array are in the range [0, N-1]
    N * N does not overflow for a signed integer
    */

    private static void arrange(ArrayList<Integer> A) {
        int n = A.size();
        for (int i = 0; i < n; i++) {
            A.set(i, (A.get(i) * n));
        }
        for (int i = 0; i < n; i++) {
            int index = A.get(i) / n;
            int newValue = A.get(index) / n;
            A.set(i, A.get(i) + newValue);
            //A.set(i, A.get(i) + (A.get(A.get(i) / n) / n));
        }
        for (int i = 0; i < n; i++) {
            A.set(i, A.get(i) % n);
        }
    }

    public static void main(String[] args) {
        ArrayList<Integer> A = new ArrayList<>(Arrays.asList(3, 1, 4, 6, 5, 0, 2));
        System.out.println(A);
        arrange(A);
        System.out.println(A);
    }
}
