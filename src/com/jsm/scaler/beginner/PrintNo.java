package com.jsm.scaler.beginner;

import java.util.Scanner;

public class PrintNo {

    static void printNo(int n) {
        if (n > 0) {
            printNo(n - 1);
            System.out.print(n + " ");
        }
        return;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        printNo(n);
    }
}
