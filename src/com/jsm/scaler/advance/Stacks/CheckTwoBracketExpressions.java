package com.jsm.scaler.advance.Stacks;

import java.util.Stack;

public class CheckTwoBracketExpressions {
    /*
    Given two strings A and B. Each string represents an expression consisting of lowercase English alphabets, '+', '-', '(' and ')'.
    The task is to compare them and check if they are similar. If they are identical, return 1 else, return 0.

    NOTE: It may be assumed that there are at most 26 operands from ‘a’ to ‘z’, and every operand appears only once.

    Problem Constraints
    1 <= length of each String <= 100

    Input Format
    The given arguments are string A and string B.

    Output Format
    Return 1 if they represent the same expression else return 0.

    Example Input
    Input 1:
     A = "-(a+b+c)"
     B = "-a-b-c"

    Input 2:
     A = "a-b-(c-d)"
     B = "a-b-c-d"

    Example Output
    Output 1:
     1

    Output 2:
     0

    Example Explanation:
    Explanation 1:
     The expression "-(a+b+c)" can be written as "-a-b-c" which is equal as B.

    Explanation 2:
     Both the expression are different.
    */

    private static int solve(String A, String B) {
        int[] first = eval(A);
        int[] second = eval(B);
        for (int i = 0; i < 26; ++i)
            if (first[i] != second[i]) //Exit on any single mismatch
                return 0;
        return 1;
    }

    private static int[] eval(String str) {
        int[] ans = new int[26];
        Stack<Boolean> stack = new Stack<>();
        stack.push(true);

        for (int i = 0; i < str.length(); ++i) {
            char ch = str.charAt(i);

            if (ch == '+' || ch == '-') //skip local sign until alphabet is found
                continue;
            if (ch == '(' && i > 0) { //push next global sign
                if (str.charAt(i - 1) == '-')
                    stack.push(!stack.peek());
                else
                    stack.push(stack.peek());
                continue;
            }

            if (ch >= 'a' && ch <= 'z') { //evaluating alphabets
                if (i > 0 && str.charAt(i - 1) == '-')
                    ans[ch - 'a'] = stack.peek() ? -1 : 1;
                else
                    ans[ch - 'a'] = stack.peek() ? 1 : -1;
                continue;
            }

            if (ch == ')') //end of previous global sign, hence pop it.
                stack.pop();
        }
        return ans;
    }

    public static void main(String[] args) {
        String A = "a-b-(c-d)";
        String B = "a-b-c-d";
        System.out.println(solve(A, B));
    }
}
