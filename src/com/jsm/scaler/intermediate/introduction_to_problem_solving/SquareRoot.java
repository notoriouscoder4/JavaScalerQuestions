package com.jsm.scaler.intermediate.introduction_to_problem_solving;

public class SquareRoot {
    /*
    Given a number A. Return square root of the number if it is perfect square otherwise return -1.

    Problem Constraints
    1 <= A <= 108

    Input Format
    First argument is an integer A.

    Output Format
    Return an integer which is the square root of A if A is perfect square otherwise return -1.
    */

    public int solve(int A) {

        if(A == 0 || A == 1) {
            return A;
        }
        long left = 1, right = A;

        while(left <= right) {
            long middle = (left + right) / 2;
            if(middle * middle == A) {
                return (int) middle;
            }
            if(middle * middle < A) {
                left = middle + 1;
            } else {
                right = middle - 1;
            }
        }
        return -1;
    }

    public static void main(String[] args) {

    }
}
