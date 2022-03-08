package com.jsm.scaler.beginner.Strings;

import java.util.Scanner;

public class TrimFromEnds {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String A = sc.next();
        char[] c = A.toCharArray();
        int start = 0, end = A.length() - 1;

        while (c[start] == '*' && start < A.length()) {
            start++;
        }

        if (start == A.length()) {
            return;
        }

        while (c[end] == '*' && end >=0 ) {
            end--;
        }

        System.out.println(A.substring(start, end));
    }
}
