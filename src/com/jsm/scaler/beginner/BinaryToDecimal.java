package com.jsm.scaler.beginner;

import java.util.Scanner;

public class BinaryToDecimal {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        long A = sc.nextLong();

        int bit = 0, ans = 0;

        while (A != 0) {
            int digit = (int) (A % 10);
            A = A / 10;
            ans = ans + (pow(2, bit) * digit);
            bit++;
        }
        System.out.println(ans);
    }

    public static int pow(int base, int exponent) {
        int power = 1;

        for (int i = 1; i <= exponent; i++) {
            power = power * base;
        }
        return power;
    }
}
