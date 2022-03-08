package com.jsm.scaler.beginner;

import java.util.Scanner;

public class VolumeOfSphere {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int A = sc.nextInt();
        System.out.println(solve(A));
    }

    public static int solve(int A) {
        double v;
        int volume;
        v = (4 * Math.PI * A * A * A) / 3;
        volume = (int) Math.ceil(v);
        return volume;
    }
}
