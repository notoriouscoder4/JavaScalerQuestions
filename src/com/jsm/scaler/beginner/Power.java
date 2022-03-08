package com.jsm.scaler.beginner;

import java.util.Scanner;

public class Power {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int base = sc.nextInt();
        int exponent = sc.nextInt();

        int pow = power(base, exponent);
        System.out.println(pow);
    }

    private static int power(int base, int exponent) {
        int power = 1;

        for (int i = 1; i <= exponent; i++) {
            power = power * base;
        }
        return power;
    }
}
