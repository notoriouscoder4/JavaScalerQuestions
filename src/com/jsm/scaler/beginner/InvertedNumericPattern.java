package com.jsm.scaler.beginner;

import java.util.Scanner;

public class InvertedNumericPattern {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();

        for (int i = n; i >= 1; i--) {
            for (int col = 1; col <= i; ++col) {
                System.out.print(col);
                if (col < i) {
                    System.out.print(" ");
                }
            }
            System.out.println();
        }
    }
}
