package com.jsm.scaler.beginner;

import java.util.Scanner;

public class PercentageOfSubjects {
    public static void main(String[] args) {
        int total, percentage;
        Scanner sc = new Scanner(System.in);
        int A = sc.nextInt();
        int B = sc.nextInt();
        int C = sc.nextInt();
        int D = sc.nextInt();
        int E = sc.nextInt();

        total = A + B + C + D + E;
        percentage = total / 5;

        if (percentage >= 90) {
            System.out.println(percentage + " A");
        } else if (percentage >= 80) {
            System.out.println(percentage + " B");
        } else if (percentage >= 70) {
            System.out.println(percentage + " C");
        } else if (percentage >= 60) {
            System.out.println(percentage + " D");
        } else if (percentage >= 40) {
            System.out.println(percentage + " E");
        } else {
            System.out.println(percentage + " F");
        }
    }
}
