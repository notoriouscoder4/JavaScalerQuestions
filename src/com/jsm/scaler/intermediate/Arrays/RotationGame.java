package com.jsm.scaler.intermediate.Arrays;

import java.util.Scanner;

public class RotationGame {
    /*
    You are given an integer array A and an integer B. You have to print the same array after rotating it B times towards right.

    NOTE: You can use extra memory.

    Problem Constraints

    1 <= |A| <= 106
    1 <= A[i] <= 109
    1 <= B <= 109

    Input Format

    First line begins with an integer |A| denoting the length of array, and then |A| integers denote the array elements.
    Second line contains a single integer B

    Output Format

    Print an array of integers which is the Bth right rotation of input array A, on a separate line.
    */
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int[] A = new int[N];
        for (int i = 0; i < N; i++) {
            A[i] = sc.nextInt();
        }

        printArray(A);

        int B = sc.nextInt();
        while (B >= A.length) {
            B = B % A.length;
        }
        reversePart(A, 0, A.length - 1);
        printArray(A);
        reversePart(A, 0, B - 1);
        printArray(A);
        reversePart(A, B, A.length - 1);
        printArray(A);
    }

    public static void reversePart(int[] arr, int s, int e) {
        while (s < e) {
            int temp = arr[s];
            arr[s] = arr[e];
            arr[e] = temp;
            s++;
            e--;
        }
    }

    public static void printArray(int[] arr) {
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + " ");
        }
        System.out.println();
    }
}
