package com.jsm.scaler.beginner;

import java.util.Scanner;

public class SumOfDigits {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        for (int i = 0; i < n; i++) {
            int sum = 0;
            int rem;
            int num = sc.nextInt();
            while (num > 0) {
                rem = num % 10;
                sum = sum + rem;
                num = num / 10;
            }
            System.out.println(sum);
        }
    }
}
