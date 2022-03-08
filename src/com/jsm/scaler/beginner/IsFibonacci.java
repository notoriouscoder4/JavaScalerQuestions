package com.jsm.scaler.beginner;

import java.util.Scanner;

public class IsFibonacci {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();
        int sum = 0, a = 0, b = 1;

        for (int i = 0; i <= T; i++) {
            int num = sc.nextInt();

            if (num == 0 || num == 1) {
                System.out.println("Yes");
            } else {
                while (sum < num) {
                    sum = a + b;
                    a = b;
                    b = sum;
                }
                if (sum == num) {
                    System.out.println("Yes");
                } else {
                    System.out.println("No");
                }
            }
        }
    }
}
