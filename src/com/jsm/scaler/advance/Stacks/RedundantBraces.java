package com.jsm.scaler.advance.Stacks;

import java.util.Stack;

public class RedundantBraces {
    /*
    Given a string A denoting an expression. It contains the following operators '+', '-', '*', '/'.
    Check whether A has redundant braces or not.
    NOTE: A, will be always a valid expression and will not contain any white spaces.

    Problem Constraints
    1 <= |A| <= 10^5

    Input Format
    The only argument given is string A.

    Output Format
    Return 1 if A has redundant braces else, return 0.

    Example Input
    Input 1:
     A = "((a+b))"

    Input 2:
     A = "(a+(a+b))"

    Example Output
    Output 1:
     1

    Output 2:
     0

    Example Explanation:
    Explanation 1:
     ((a+b)) has redundant braces so answer will be 1.

    Explanation 2:
     (a+(a+b)) doesn't have have any redundant braces so answer will be 0.
    */

    private static int braces(String A) {
        Stack<Character> stack = new Stack<>();
        for (int i = 0; i < A.length(); ++i) {
            if (A.charAt(i) >= 'a' && A.charAt(i) <= 'z')
                continue;
            else if (A.charAt(i) == '(')
                stack.push(A.charAt(i));
            else if (A.charAt(i) == '+' || A.charAt(i) == '-' || A.charAt(i) == '*' || A.charAt(i) == '/')
                stack.push(A.charAt(i));
            else if (A.charAt(i) == ')') {
                if (stack.size() > 0 && stack.peek() == '(') {
                    stack.pop();
                    return 1;
                }
                while (stack.size() > 0 && stack.peek() != '(')
                    stack.pop();
                stack.pop(); //it will pop out the ')'
            }
        }
        return 0;
    }

    public static void main(String[] args) {
        String A = "(a+(a+b))";
        System.out.println(braces(A));
    }
}
