package com.jsm.scaler.advance.Stacks;

import java.util.Stack;

public class DoubleCharacterTrouble {
    /*
    You are given a string A.

    An operation on the string is defined as follows:
    Remove the first occurrence of the same consecutive characters. e.g. for a string "abbcd", the first occurrence of same consecutive characters is "bb".

    Therefore, the string after this operation will be "acd".
    Keep performing this operation on the string until there are no more occurrences of the same consecutive characters and return the final string.

    Problem Constraints
    1 <= |A| <= 100000

    Input Format
    First and only argument is string A.

    Output Format
    Return the final string.

    Example Input:
    Input 1:
     A = abccbc

    Input 2:
     A = ab

    Example Output:
    Output 1:
     "ac"

    Output 2:
     "ab"

    Example Explanation:
    Explanation 1:
    Remove the first occurrence of same consecutive characters. e.g. for a string "abbc",
    the first occurrence of same consecutive characters is "bb".
    Therefore, the string after this operation will be "ac".

    Explanation 2:
     No removals are to be done.
    */

    private static String solve(String A) {
        StringBuilder res = new StringBuilder();
        Stack<Character> sChar = new Stack<>();
        sChar.push(A.charAt(0));

        for (int i = 1; i < A.length(); i++) {
            if (sChar.size() > 0 && A.charAt(i) == sChar.peek())
                sChar.pop();
            else
                sChar.push(A.charAt(i));
        }

        while (sChar.size() > 0) {
            res.append(sChar.peek());
            sChar.pop();
        }

        return res.reverse().toString();
    }

    public static void main(String[] args) {
        String A = "abccbc";
        System.out.println(solve(A));
    }
}
