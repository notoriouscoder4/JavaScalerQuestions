package com.jsm.scaler.beginner.Strings;

import java.util.Scanner;

public class FirstOccurance {

    public static int solve(String A, String B) {
        int N = A.length();
        int M = B.length();

        int i;

        char[] a = A.toCharArray();
        char[] b = B.toCharArray();


        for ( i = 0; i < N - M; i++) {
            boolean flag = true;
            for (int j = 0; j < M; j++) {
                if (a[i + j] != b[j]) {
                    flag = false;
                    break;
                }
            }

            if (flag) {
                System.out.println(i);
                break;
            }
        }
        return i;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String A = sc.next();
        String B = sc.next();

        solve(A, B);
    }
}
