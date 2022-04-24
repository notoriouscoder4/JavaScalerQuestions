package com.jsm.scaler.intermediate.SubsequenceAndSubset;

public class FIndSubsequence {
    /*
    Given two strings A and B, find if A is a subsequence of B.
    Return "YES" if A is a subsequence of B, else return "NO".

    Input Format:
    The first argument given is the string A.
    The second argument given is the string B.

    Output Format:
    Return "YES" if A is a subsequence of B, else return "NO".

    Constraints
    1 <= lenght(A), length(B) <= 100000
    'a' <= A[i], B[i] <= 'z'

    For Example

    Input 1:
        A = "bit"
        B = "dfbkjijgbbiihbmmt"
    Output 1:
        YES

    Input 2:
        A = "apple"
        B = "appel"
    Output 2:
        "NO"
    */

    private static String solve(String A, String B) {
        int m = A.length();
        int n = B.length();
        int i = 0, j = 0;
        while (i < m && j < n) {
            if (A.charAt(i) == B.charAt(j))
                i++;
            j++;
        }
        if (i == m) {
            return "YES";
        }
        return "NO";
        /*if (A.length() > B.length())
            return "NO";
        int prevIdx = -1;
        boolean isSubSeq = true;
        for (int i = 0; i < A.length(); i++) {
            if (!isSubSeq)
                break;
            int currIdx = B.indexOf(A.charAt(i), prevIdx);
            if (currIdx > -1) {
                if (currIdx >= prevIdx)
                    prevIdx = currIdx;
                else
                    isSubSeq = false;
            } else
                isSubSeq = false;
        }
        return isSubSeq ? "YES" : "NO";*/
    }

    public static void main(String[] args) {
        String A = "bit";
        String B = "dfbkjijgbbiihbmmt";
        System.out.println(solve(A, B));
    }
}
