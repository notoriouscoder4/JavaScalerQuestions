package com.jsm.scaler.intermediate.introduction_to_problem_solving;

import java.util.Scanner;

public class SummationGame {
    /*
    Write a program to find sum all Natural numbers from 1 to N where you have to take N as input from user

    Problem Constraints
    1 <= N <= 1000

    Input Format
    A single line representing N

    Output Format
    A single integer showing sum of all Natural numbers from 1 to N
    */

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int sum = 0;

        for (int i = 1; i <= N; i++) {
            sum = i * (i + 1) / 2;
        }

        System.out.println(sum);
    }
}
