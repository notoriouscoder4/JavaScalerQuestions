package com.jsm.scaler.intermediate.StacksAndQueues;

import java.util.Stack;

public class BalancedParentheses {
    /*
    Given a string A consisting only of '(' and ')'.
    You need to find whether parentheses in A are balanced or not, if it is balanced then return 1 else return 0.

    Problem Constraints
    1 <= |A| <= 105

    Input Format
    First argument is a string A.

    Output Format
    Return 1 if parentheses in string are balanced else return 0.

    Example Input

    Input 1:
     A = "(()())"

    Input 2:
     A = "(()"

    Example Output

    Output 1:
     1

    Output 2:
     0

    Example Explanation

    Explanation 1:
     Given string is balanced, so we return 1.

    Explanation 2:
     Given string is not balanced, so we return 0.
    */

    public static int solve(String A) {
        Stack<Character> bal = new Stack<>();

        for (int i = 0; i < A.length(); i++) {
            if (A.charAt(i) == '(') {
                bal.push(A.charAt(i));
            } else if (bal.isEmpty()) {
                return 0;
            } else {
                bal.pop();
            }
        }

        if (bal.isEmpty())
            return 1;
        return 0;
    }

    public static void main(String[] args) {
        String A = "(()())";
        System.out.println(solve(A));
    }
}
