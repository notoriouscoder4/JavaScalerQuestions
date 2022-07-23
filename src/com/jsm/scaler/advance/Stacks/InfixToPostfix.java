package com.jsm.scaler.advance.Stacks;

import java.util.Stack;

public class InfixToPostfix {
    /*
    Given string A denoting an infix expression. Convert the infix expression into a postfix expression.

    String A consists of ^, /, *, +, -, (, ) and lowercase English alphabets where lowercase English alphabets are operands
    and ^, /, *, +, - are operators.

    Find and return the postfix expression of A.

    NOTE:
    ^ has the highest precedence.
    / and * have equal precedence but greater than + and -.
    + and - have equal precedence and lowest precedence among given operators.

    Problem Constraints
    1 <= length of the string <= 500000

    Input Format
    The only argument given is string A.

    Output Format
    Return a string denoting the postfix conversion of A.

    Example Input
    Input 1:
     A = "x^y/(a*z)+b"

    Input 2:
     A = "a+b*(c^d-e)^(f+g*h)-i"
    */

    private enum Precedence {
        POWER(4), DIVIDE(3), MULTIPLY(3), ADD(2), SUBTRACT(2), NONE(0), BRACKET(0), SYMBOL(0);

        private final int precedence;

        Precedence(int a) {
            this.precedence = a;
        }

        public int getPrecedence() {
            return this.precedence;
        }
    }

    private static int getPrecedence(char c) {
        if (c == '^') return Precedence.POWER.getPrecedence();
        if (c == '/') return Precedence.DIVIDE.getPrecedence();
        if (c == '*') return Precedence.MULTIPLY.getPrecedence();
        if (c == '+') return Precedence.ADD.getPrecedence();
        if (c == '-') return Precedence.SUBTRACT.getPrecedence();
        if (c == '(') return Precedence.BRACKET.getPrecedence();
        if (c == '@') return Precedence.SYMBOL.getPrecedence();

        return Precedence.NONE.getPrecedence();
    }

    private static boolean isOpenBracket(char c) {
        return c == '(';
    }

    private static boolean isClosedBracket(char c) {
        return c == ')';
    }

    private static boolean isBracket(char c) {
        return c == '(' || c == ')';
    }

    private static boolean isOperator(char c) {
        return c == '^' || c == '/' || c == '*' || c == '+' || c == '-';
    }

    private static String infixToPostfix(String A) {
        Stack<Character> expression = new Stack<>();
        expression.add('@'); // dummy character to avoid empty stack exceptions

        StringBuilder postfixString = new StringBuilder();

        for (Character a : A.toCharArray()) {
            if (isOperator(a) || isBracket(a)) {
                if (isClosedBracket(a)) {
                    //Pop from stack and append to output till we find the open bracket;
                    while (!isOpenBracket(expression.peek()))
                        postfixString.append(expression.pop());
                    expression.pop(); //Remove the brace
                } else {
                    if (isOpenBracket(a)) {
                        //Add open bracket directly to stack
                        expression.add(a);
                        continue;
                    }
                    if (getPrecedence(a) > getPrecedence(expression.peek())) {
                        //Just add to the stack
                        expression.add(a);
                    } else {
                        //Pop till precedence is of current char is less or equal
                        while (getPrecedence(a) <= getPrecedence(expression.peek()))
                            postfixString.append(expression.pop());
                        expression.add(a); //Add current operator to stack
                    }
                }
            } else {
                postfixString.append(a);
            }
        }

        while (expression.size() != 1)
            postfixString.append(expression.pop());

        return postfixString.toString();
    }

    public static void main(String[] args) {
        String A = "a+b*(c^d-e)^(f+g*h)-i";
        System.out.println(infixToPostfix(A));
    }
}
