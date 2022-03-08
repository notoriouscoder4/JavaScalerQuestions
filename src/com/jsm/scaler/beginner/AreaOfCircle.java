package com.jsm.scaler.beginner;

import java.util.Scanner;

public class AreaOfCircle {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int r = sc.nextInt();
//        solve(r);
        System.out.println(solve(r));
    }

    public static int solve(int A) {
        double a;
        int area;
        a = (Math.PI * A * A);
        area = (int) Math.ceil(a);
        return area;
    }
}
