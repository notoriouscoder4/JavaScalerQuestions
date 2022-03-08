package com.jsm.scaler.beginner.Arrays;

import java.util.Scanner;

public class ArrayRemovalAtPosition {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();

        int[] A = new int[n+2];

        for (int i=1; i<=n; i++) {
            A[i] = sc.nextInt();
        }

        int x = sc.nextInt();
        n--;

        for (int i=x; i<=n; i++) {
            A[i] = A[i+1];
        }

        for (int i=1; i<=n; i++) {
            System.out.print(A[i] + " ");
        }
    }
}
