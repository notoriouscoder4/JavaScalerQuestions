package com.jsm.scaler.beginner.Strings;

import java.util.Scanner;

public class PalindromeString {

    static boolean isPalindrome(String str) {
        int i = 0, j = str.length() - 1;

        while (i < j) {
            if (str.charAt(i) != str.charAt(j))
                return false;
            i++;
            j--;
        }
        return true;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();
        String s;

        for (int i = 0; i < T; i++) {
            s = sc.next();

            if(isPalindrome(s)) {
                System.out.println("1");
            } else {
                System.out.println("0");
            }
        }
    }
}
