package com.jsm.scaler.intermediate.BitManipulations;

public class UnsetXBitsFromRight {
    /*
    Given an integer A. Unset B bits from the right of A in binary.
    For eg:-
    A = 93, B = 4
    A in binary = 1011101
    A should become = 1010000 = 80. Therefore return 80.

    Problem Constraints
    1 <= A <= 1018
    1 <= B <= 60

    Input Format
    The first argument is a single integer A.
    The second argument is a single integer B.

    Output Format
    Return the number with B unset bits from the right.

    Example Input

    Input 1:-
    A = 25
    B = 3

    Input 2:-
    A = 37
    B = 3

    Example Output

    Output 1:-
    24

    Output 2:-
    32
    */

    public static long solve(long A, int B) {
        for (int i = 0; i < B; i++) {
            if ((A & (1L << i)) != 0) // if block to check that A & (1L << i) is not equal to zero
                A = A ^ (1L << i);  // this line is to toggle the ith bit, in this case i = 3
        }
        return A;
    }

    public static void main(String[] args) {
        long A = 93;
        int B = 4;
        System.out.println(solve(A, B));
    }
}
