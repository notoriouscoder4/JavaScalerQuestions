package com.jsm.scaler.intermediate.Arrays;

import java.util.Scanner;

public class MaxMinArray {
    /*
    Write a program to print maximum and minimum elements of the input array A of size N
    where you have to take integer N and further N elements as input from user.

    Problem Constraints

    1 <= N <= 1000

    1 <= A <= 1000

    Input Format

    A single line representing N followed by N integers of the array A

    Output Format

    A single line containing two space separated integers representing maximum and minimum elements of the input array.
    */

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int[] A = new int[N];
        for (int i = 0; i < N; i++) {
            A[i] = sc.nextInt();
        }

        System.out.println(maxArray(A) + " " + minArray(A));
    }

    public static int minArray(int[] arr) {
        if (arr == null || arr.length == 0) {
            throw new IllegalArgumentException("Invalid Input");
        }

        int min = arr[0];
        for (int i = 1; i < arr.length; i++) {
            if (arr[i] < min) {
                min = arr[i];
            }
        }
        return min;
    }

    public static int maxArray(int[] arr) {
        if (arr == null || arr.length == 0) {
            throw new IllegalArgumentException("Invalid Input");
        }

        int max = arr[0];
        for (int i = 1; i < arr.length; i++) {
            if (arr[i] > max) {
                max = arr[i];
            }
        }
        return max;
    }
}
