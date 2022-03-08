package com.jsm.scaler.beginner;

import java.util.Scanner;

public class Prime1ToN {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int num = 0;
        //Empty String
        String primeNumbers = "";
        int n = scanner.nextInt();
        scanner.close();
        for (int i = 1; i <= n; i++) {
            int counter = 0;
            for (num = i; num >= 1; num--) {
                if (i % num == 0) {
                    counter = counter + 1;
                }
            }
            if (counter == 2) {
                //Appended the Prime number to the String
//                primeNumbers = primeNumbers + i + " ";
                System.out.println(primeNumbers + i);
            }
        }

    }
}
