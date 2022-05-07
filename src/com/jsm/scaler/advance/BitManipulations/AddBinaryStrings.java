package com.jsm.scaler.advance.BitManipulations;

public class AddBinaryStrings {
    /*
    Given two binary strings, return their sum (also a binary string).

    Example:
    a = "100"
    b = "11"

    Return a + b = "111".
    */

    private static String addBinary(String A, String B) {
        int max_len = Math.max(A.length(), B.length());
        int carry = 0;
        String result = "";
        for (int i = 0; i < max_len; i++) {
            int p = i < A.length() ? A.charAt(A.length() - 1 - i) - '0' : 0;
            int q = i < B.length() ? B.charAt(B.length() - 1 - i) - '0' : 0;
            int sum = p + q + carry;
            carry = sum / 2; // dividing by 2 because base is 2
            result = sum % 2 + result; // 2 refer here the base value
        }
        return (carry == 0) ? result : "1" + result;

        /* Scaler Solution
        int nA, nB;
	    char res[];
	    int i, j, k;
	    nA = A.length();
	    nB = B.length();
	    res = new char[Math.max(nA, nB) + 1];
	    k = Math.max(nA, nB);
	    i = nA - 1;
	    j = nB - 1;
	    int sum = 0, carry = 0;
	    while (i >= 0 || j >= 0 || carry != 0) {
	        sum = carry;
	        if (i >= 0)
	            sum += (A.charAt(i) - '0');
	        if (j >= 0)
	            sum += (B.charAt(j) - '0');
	        res[k] = (char) ((sum % 2) + '0');
	        carry = sum / 2;
	        i--;
	        j--;
	        k--;
	    }
	    if (res[0] == '1')
	        return new String(res);
	    int len = Math.max(nA, nB);
	    return new String(res, 1, len);
        */
    }

    public static void main(String[] args) {
        String A = "100";
        String B = "11";
        System.out.println(addBinary(A, B));
    }
}
