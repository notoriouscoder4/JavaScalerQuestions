package com.jsm.scaler.intermediate.BitManipulations;

public class AddBinaryStrings {
    /*
    Given two binary strings, return their sum (also a binary string).

    Example:

    a = "100"
    b = "11"

    Return a + b = "111".
    */

    public static String addBinary(String A, String B) {
        int idx1 = A.length() - 1;
        int idx2 = B.length() - 1;
        int carry = 0;
        StringBuilder sb = new StringBuilder();
        while (idx1 >= 0 || idx2 >= 0 || carry > 0) {
            int val = carry;
            if (idx1 >= 0)
                val += Character.getNumericValue(A.charAt(idx1--));
            if (idx2 >= 0)
                val += Character.getNumericValue(B.charAt(idx2--));
            carry = val > 1 ? 1 : 0;
            val = val > 1 ? (val == 2 ? 0 : 1) : val;
            sb.append(val);
        }
        return sb.reverse().toString();
    }

    public static void main(String[] args) {
        String A = "100";
        String B = "11";
        System.out.println(addBinary(A, B));
    }
}
