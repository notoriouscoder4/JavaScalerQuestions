package com.jsm.scaler.beginner.Strings;

import java.util.Scanner;

public class ChangesInReverse {

    public static int countRev(String A) {
        int count = 0;
        char[] a = A.toCharArray();

        for (int i = 0; i < A.length(); i++) {
            if (a[i] != a[A.length() - i - 1])
                count++;
        }

        return count;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();
        String s = "";

        for (int i = 0; i < T; i++) {
            s = sc.next();
            System.out.println(countRev(s));
        }
    }
}
