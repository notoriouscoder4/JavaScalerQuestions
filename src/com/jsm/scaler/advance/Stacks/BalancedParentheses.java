package com.jsm.scaler.advance.Stacks;

import java.util.Stack;

public class BalancedParentheses {
    /*
    Given an expression string A, examine whether the pairs and the orders of “{“,”}”, ”(“,”)”, ”[“,”]” are correct in A.
    Refer to the examples for more clarity.

    Problem Constraints
    1 <= |A| <= 100

    Input Format
    The first and the only argument of input contains the string A having the parenthesis sequence.

    Output Format
    Return 0 if the parenthesis sequence is not balanced.
    Return 1 if the parenthesis sequence is balanced.

    Example Input
    Input 1:
     A = {([])}

    Input 2:
     A = (){

    Input 3:
     A = ()[]

    Example Output
    Output 1:
     1

    Output 2:
     0

    Output 3:
     1

    Example Explanation
    You can clearly see that the first and third case contain valid parenthesis.
    In the second case, there is no closing bracket for {, thus the parenthesis sequence is invalid.
    */

    private static int solve(String A) {
        Stack<Character> s = new Stack<>();
        for (Character c : A.toCharArray()) {
            if (c == '{' || c == '(' || c == '[') {
                s.push(c);
                continue;
            }
            if (s.isEmpty()) return 0;
            if (c == '}' && s.pop() != '{') return 0;
            if (c == ')' && s.pop() != '(') return 0;
            if (c == ']' && s.pop() != '[') return 0;
        }
        return s.isEmpty() ? 1 : 0;
    }

    public static void main(String[] args) {
        String A = "{([])}";
        System.out.println(solve(A));
    }
}
