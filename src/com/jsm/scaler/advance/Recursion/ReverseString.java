package com.jsm.scaler.advance.Recursion;

import java.util.Scanner;

public class ReverseString {
    /*
    Write a recursive function that, given a string S, prints the characters of S in reverse order.

    Problem Constraints
    1 <= |s| <= 1000

    Input Format
    First line of input contains a string S.

    Output Format
    Print the character of the string S in reverse order.

    Example Input

    Input 1:
     scaleracademy

    Input 2:
     cool


    Example Output

    Output 1:
     ymedacarelacs

    Output 2:
     looc

    Example Explanation

    Explanation 1:
     Print the reverse of the string in a single line.
    */

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String s = sc.nextLine();
        reverseString(s);
    }

    private static void reverseString(String s) {
        if (s == null || s.length() <= 1)
            System.out.print(s);
        else {
            System.out.print(s.charAt(s.length() - 1));
            reverseString(s.substring(0, s.length() - 1));
        }
    }
}
