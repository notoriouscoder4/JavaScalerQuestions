package com.jsm.scaler.intermediate.introduction_to_problem_solving;

import java.util.Scanner;

public class ArmStrongNumber {
    /*
    You are given an integer N you need to print all the Armstrong Numbers between 1 to N.
    If sum of cubes of each digit of the number is equal to the number itself, then the number is called an Armstrong number.
    For example, 153 = ( 1 * 1 * 1 ) + ( 5 * 5 * 5 ) + ( 3 * 3 * 3 ).

    Problem Constraints
    1 <= N <= 500

    Input Format
    First and only line of input contains an integer N.

    Output Format
    Output all the Armstrong numbers in range [1,N] each in a new line.
    */

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();

        for(int i=1; i< N; i++) {
            if(isArmstrong(i)) {
                System.out.println(i);
            }
        }
    }

    private static boolean isArmstrong(int num) {
        int sum = 0, rightDigit, temp;
        temp = num;
        while(temp != 0) {
            rightDigit = temp % 10;
            sum = sum + (rightDigit * rightDigit * rightDigit);
            temp = temp / 10;
        }

        return sum == num;
    }
}
