package com.jsm.scaler.beginner;

import java.util.Scanner;

public class DaysInMonth {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int A = sc.nextInt();

        if (A == 1 || A == 3 || A == 5 || A == 7 || A == 8 || A == 10 || A == 12) {
            System.out.println(31);
        } else if (A == 2) {
            System.out.println(28);
        } else {
            System.out.println(30);
        }
    }
}
