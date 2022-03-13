package com.jsm.scaler.intermediate.ArraysInterviewProblems;

import java.util.Scanner;

public class StarPatternI {
    /*
    Write a program to input an integer N from user and print hollow diamond star pattern series of N lines.
    See example for clarifications over the pattern.

    Problem Constraints
    1 <= N <= 1000

    Input Format
    First line is an integer N

    Output Format
    N lines conatining only char '*' as per the question.

    Example Input

    Input 1:
    4

    Input 2:
    6

    Example Output

    Output 1:
    ********
    ***  ***
    **    **
    *      *
    *      *
    **    **
    ***  ***
    ********

    Output 2:
    ************
    *****  *****
    ****    ****
    ***      ***
    **        **
    *          *
    *          *
    **        **
    ***      ***
    ****    ****
    *****  *****
    ************

    */

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();

        for (int i = 1; i <= n; i++) {

            for (int j = 1; j <= n + 1 - i; j++) {
                System.out.print("*");
            }

            for (int k = 1; k < (2 * i - 1); k++) {
                System.out.print(" ");
            }

            for (int j = 1; j <= n + 1 - i; j++) {
                System.out.print("*");
            }

            System.out.println();
        }

        for (int i = n; i >= 1; i--) {

            for (int j = n; j >= i; j--) {
                System.out.print("*");
            }

            for (int k = 1; k < (2 * i - 1); k++) {
                System.out.print(" ");
            }

            for (int j = n; j >= i; j--) {
                System.out.print("*");
            }

            System.out.println();
        }
    }
}
