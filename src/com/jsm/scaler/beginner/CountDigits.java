package com.jsm.scaler.beginner;

import java.util.Scanner;

public class CountDigits {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();

        for (int i = 0; i < n; i++) {
            int num = sc.nextInt();
            int result = countDigits(num);
            System.out.println(result);
        }
    }

    private static int countDigits(int N) {
        int count = 0;
        if (N == 0) {
            count = 1;
            return count;
        }
        while (N != 0) {
            N = N / 10;
            count++;
        }
        return count;
    }
}
