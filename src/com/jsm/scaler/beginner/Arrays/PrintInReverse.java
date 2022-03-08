package com.jsm.scaler.beginner.Arrays;

import java.util.Scanner;

public class PrintInReverse {

    public static void main(String[] args) {
        int[] myArray = createArray();
        for (int i= myArray.length-1; i>=0; i--) {
            System.out.print(myArray[i] + " ");
        }
    }

    static int[] createArray() {
        //Take input N,create an array of size N and read it
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();

        int[] arr = new int[n];

        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }
        return arr;
    }
}
