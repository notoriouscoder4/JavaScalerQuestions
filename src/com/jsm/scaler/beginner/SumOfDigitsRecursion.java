package com.jsm.scaler.beginner;

import java.util.Scanner;

public class SumOfDigitsRecursion {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();

        for (int i = 0; i < n; i++) {
            int num = sc.nextInt();
            System.out.println(sumOfDigits(num));
        }
    }

    static int sumOfDigits(int n) {
        if (n == 0)
            return 0;
        return (n % 10 + sumOfDigits(n / 10));
    }
}
