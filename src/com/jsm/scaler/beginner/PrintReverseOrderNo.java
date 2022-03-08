package com.jsm.scaler.beginner;

import java.util.Scanner;

public class PrintReverseOrderNo {

    static void printReverseOrderNo(int n) {
        if (n <= 0) {
            return;
        } else {
            System.out.print(n + " ");
            printReverseOrderNo(n - 1);
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        printReverseOrderNo(n);
    }
}
