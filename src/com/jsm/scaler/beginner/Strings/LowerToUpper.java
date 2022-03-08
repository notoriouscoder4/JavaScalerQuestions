package com.jsm.scaler.beginner.Strings;

public class LowerToUpper {

    public static String lowerToUpper(String A) {

        String result = "";
        char ch = ' ';

        for (int i = 0; i < A.length(); i++) {
            if (A.charAt(i) >= 'a' && A.charAt(i) <= 'z') {
                ch = (char) (A.charAt(i) - 32);
            } else {
                ch = (char) (A.charAt(i));
            }
            result += ch;
        }
        return result;
    }

    public static void main(String[] args) {
        System.out.println(lowerToUpper("interviewbit"));
    }
}
