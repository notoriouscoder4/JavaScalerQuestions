package com.jsm.scaler.intermediate.Arrays;

import java.util.Scanner;

public class SearchElement {
    /*
    You are given an integer T (Number of test cases). For each test case,
    you are given array A and an integer B. You have to tell whether B is present in array A or not.

    Problem Constraints

    1 <= T <= 10
    1 <= |A| <= 105
    1 <= A[i], B <= 109

    Input Format

    First line of the input contains a single integer T.
    Next, each of the test case consists of 2 lines:
    First line begins with an integer |A| denoting the length of array, and then |A| integers denote the array elements.
    Second line contains a single integer B

    Output Format

    For each test case, print on a separate line 1 if the element exists, else print 0.
    */

    public static void main(String[] args) {
        // YOUR CODE GOES HERE
        // Please take input and print output to standard input/output (stdin/stdout)
        // DO NOT USE ARGUMENTS FOR INPUTS
        // E.g. 'Scanner' for input & 'System.out' for output
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();

        for (int i = 0; i < T; i++) {
            int N = sc.nextInt(); // length of array
            int[] A = new int[N]; // array of length N

            for (int j = 0; j < N; j++) {
                A[j] = sc.nextInt();
            }

            int B = sc.nextInt();
            int flag = 0;
            for (int k = 0; k < A.length; k++) {
                if (A[k] == B) {
                    flag = 1;
                    break;
                }
            }

            if (flag == 1) {
                System.out.println("1");
            } else {
                System.out.println("0");
            }
        }
    }
}
