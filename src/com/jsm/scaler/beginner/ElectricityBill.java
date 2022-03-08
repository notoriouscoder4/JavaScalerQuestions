package com.jsm.scaler.beginner;

import java.util.Scanner;

public class ElectricityBill {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int A = sc.nextInt();
        double bill = 0.0, totalAmt, surCharge;
        if (A <= 50) {
            bill = A * 0.50;
        } else if (A <= 150) {
            bill = 25 + ((A - 50) * 0.75);
        } else if (A <= 250) {
            bill = 100 + ((A - 150) * 1.20);
        } else {
            bill = 220 + ((A - 250) * 1.50);
        }

        surCharge = bill * 0.20;
        totalAmt = bill + surCharge;
        System.out.println((int) totalAmt);
    }
}
