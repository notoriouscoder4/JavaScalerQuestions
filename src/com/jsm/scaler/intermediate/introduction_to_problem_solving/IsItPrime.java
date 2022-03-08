package com.jsm.scaler.intermediate.introduction_to_problem_solving;

import java.util.Scanner;

public class IsItPrime {
    /*
    Given an integer A, you have to tell whether it is a prime number or not.

    A prime number is a natural number greater than 1 which is divisible only by 1 and itself.

    Problem Constraints
    1 <= A <= 106

    Input Format
    First and only line of the input contains a single integer A.

    Output Format
    Print YES if A is a prime, else print NO.
    */

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int A = sc.nextInt();
        int c = 0;

        for(int i=1; i * i <= A; i++) {
            if(A % i == 0) {
                if(i * i == A) {
                    c++;
                } else {
                    c+=2;
                }
            }
        }

        if(c == 2) {
            System.out.println("YES");
        } else {
            System.out.println("NO");
        }
    }
}
