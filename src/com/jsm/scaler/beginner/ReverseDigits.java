package com.jsm.scaler.beginner;

import java.util.Scanner;

public class ReverseDigits {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        for (int i = 0; i < n; i++) {
            int rev = 0;
            int rem;
            int num = sc.nextInt();
            while (num > 0) {
                rem = num % 10;
                rev = rev * 10 + rem;
                num = num / 10;
            }
            System.out.println(rev);
        }
    }
}
