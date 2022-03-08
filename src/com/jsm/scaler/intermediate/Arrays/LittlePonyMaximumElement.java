package com.jsm.scaler.intermediate.Arrays;

import java.util.Scanner;

public class LittlePonyMaximumElement {
    /*
    Little Ponny is given an array, A, of N integers. In a particular operation, he can set any element of the array equal to -1.
    He wants your help for finding out the minimum number of operations required
    such that the maximum element of the resulting array is B. If it is not possible then return -1.

    Problem Constraints

    1 <= |A| <= 105
    1 <= A[i] <= 109

    Input Format

    The first argument of input contains an integer array, A.
    The second argument of input contains an integer, B.

    Output Format

    Return an integer representing the answer.
    */

    public static int solve(int[] A, int B) {
        int count = 0;
        boolean flag = false;
        for (int i = 0; i < A.length; i++) {
            if (A[i] > B)
                count++;

            if (A[i] == B)
                flag = true;
        }

        if (flag && count != 0)
            return count;
        return -1;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int[] A = new int[N];
        for (int i = 0; i < N; i++) {
            A[i] = sc.nextInt();
        }

        System.out.println(solve(A, 3));
    }

}
