package com.jsm.scaler.intermediate.Arrays;

import java.util.Scanner;

public class SeparateOddEven {
    /*
    You are given an integer T denoting the number of test cases. For each test case, you are given an integer array A.
    You have to put the odd and even elements of array A in 2 separate arrays and print the new arrays.

    NOTE: Array elements should have same relative order as in A.

    Problem Constraints

    1 <= T <= 10
    1 <= |A| <= 105
    1 <= A[i] <= 109

    Input Format

    First line of the input contains a single integer T.

    For each test case:

    First line consists of a single integer |A| denoting the length of array.
    Second line consists of |A| space separated integers denoting the elements of array A.

    Output Format

    For each test case:

    First line should contain an array of space separated integers containing all the odd elements of array A
    Second line should contain an array of space separated integers containing all the even elements of array A
    */

    private static void printArray(int[] arr) {
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + " ");
        }
        System.out.println();
    }

    public static int[] removeEven(int[] arr) {
        int oddCount = 0;
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] % 2 != 0) {
                oddCount++;
            }
        }

        int[] resultOdd = new int[oddCount];
        int idx = 0;
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] % 2 != 0) {
                resultOdd[idx] = arr[i];
                idx++;
            }
        }
        return resultOdd;
    }

    public static int[] removeOdd(int[] arr) {
        int evenCount = 0;
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] % 2 == 0) {
                evenCount++;
            }
        }

        int[] resultEven = new int[evenCount];
        int idx = 0;
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] % 2 == 0) {
                resultEven[idx] = arr[i];
                idx++;
            }
        }
        return resultEven;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();

        for (int i = 0; i < T; i++) {
            int N = sc.nextInt();
            int[] A = new int[N];

            for (int j = 0; j < A.length; j++) {
                A[j] = sc.nextInt();
            }

            int[] resultOdd = removeEven(A);
            printArray(resultOdd);

            int[] resultEven = removeOdd(A);
            printArray(resultEven);

        }
    }
}
