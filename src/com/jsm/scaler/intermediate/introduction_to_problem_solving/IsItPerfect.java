package com.jsm.scaler.intermediate.introduction_to_problem_solving;

import java.util.Scanner;

public class IsItPerfect {
    /*
    You are given N positive integers.
    For each given integer A, you have to tell whether it is a perfect number or not.
    Perfect number is a positive integer which is equal to the sum of its proper positive divisors.

    Problem Constraints

    1 <= N <= 10
    1 <= A <= 106

    Input Format
    First line of the input contains a single integer N.
    Each of the next N lines contains a single integer A.

    Output Format
    In a seperate line, print YES if a given integer is perfect, else print NO.
    */

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        long N = sc.nextLong();
        long A;

        for(long i=1; i<=N; i++) {
            A = sc.nextLong();
            if(isPerfect(A)) {
                System.out.println("YES");
            } else {
                System.out.println("NO");
            }
        }
    }

    static boolean isPerfect(long n) {
        if(n == 1) return false;
        long sum = 1;

        for(long i = 2; i * i <= n; i++) {
            if(n % i == 0) {
                if( i * i == n)
                    sum += i;
                else
                    sum += i + (n / i);
            }
        }

        if(sum == n) return true;

        return false;
    }
}
