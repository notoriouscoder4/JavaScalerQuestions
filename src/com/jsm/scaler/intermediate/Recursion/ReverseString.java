package com.jsm.scaler.intermediate.Recursion;

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
        String S = sc.nextLine();
        reverseString(S);
    }

    public static void reverseString(String S) {
        if ((S == null) || (S.length() <= 1)) {
            System.out.print(S);
            ;
        } else {
            System.out.print(S.charAt(S.length() - 1));
            reverseString(S.substring(0, S.length() - 1));
        }
    }
}
