package com.jsm.scaler.intermediate.introduction_to_problem_solving;

import java.util.Scanner;

public class MultiplicationTable {
    /*
    For a given number A, print its multiplication table having the first 10 multiples.

    Problem Constraints
    1 <= A <= 1000

    Input Format
    First line contains a single integer A.

    Output Format
    Print 10 lines, ith line containing ith multiple.
    */

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int A = sc.nextInt();

        for(int i=1; i<=10; i++) {
            System.out.println(A + " * " +  i + " = " + (A*i));
        }
    }
}
