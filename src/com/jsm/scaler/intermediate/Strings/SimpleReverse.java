package com.jsm.scaler.intermediate.Strings;

public class SimpleReverse {
    /*
    Given a string A, you are asked to reverse the string and return the reversed string.

    Problem Constraints
    1 <= |A| <= 105
    String A consist only of lowercase characters.

    Input Format
    First and only argument is a string A.

    Output Format
    Return a string denoting the reversed string.

    Example Input

    Input 1:
     A = "scaler"

    Input 2:
     A = "academy"

    Example Output

    Output 1:
     "relacs"

    Output 2:
     "ymedaca"

    Example Explanation

    Explanation 1:
     Reverse the given string.
    */

    public static String reverse(String A) {
        StringBuilder result = new StringBuilder();
        char ch;
        for (int i = 0; i < A.length(); i++) {
            ch = A.charAt(i);
            result.insert(0, ch);
        }
        return result.toString();

        /*
        char[] s = A.toCharArray();
        int n = A.length();
        for(int i = 0; i < n/2; i++){
            char tmp = s[i];
            s[i] = s[n-1-i];
            s[n-1-i] = tmp;
        }
        return new String(s);
        */
    }

    public static void main(String[] args) {
        String A = "scaler";
        System.out.println(reverse(A));
    }
}
