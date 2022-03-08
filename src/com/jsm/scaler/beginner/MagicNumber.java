package com.jsm.scaler.beginner;

import java.util.Scanner;

public class MagicNumber {

    static int solve(int A) {
        int x = 1;
        int ans = 0;

        while (A > 0) {
            x = x * 5;
            if (A % 2 == 1)
                ans += x;
            A /= 2;
        }
        return ans;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int magicNumber = sc.nextInt();
        System.out.println(solve(magicNumber));
    }
}
