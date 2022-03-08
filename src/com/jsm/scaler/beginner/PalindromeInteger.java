package com.jsm.scaler.beginner;

import java.util.Scanner;

public class PalindromeInteger {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int num = sc.nextInt();
        int r, sum = 0, temp;

        temp = num;
        while (num > 0) {
            r = num % 10;
            sum = (sum * 10) + r;
            num = num / 10;
        }

        if (temp == sum) {
            System.out.println("Yes");
        } else {
            System.out.println("No");
        }
    }
}
