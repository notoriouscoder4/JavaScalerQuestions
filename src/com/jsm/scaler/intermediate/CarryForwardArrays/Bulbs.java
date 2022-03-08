package com.jsm.scaler.intermediate.CarryForwardArrays;

public class Bulbs {
    /*
    N light bulbs are connected by a wire.
    Each bulb has a switch associated with it, however due to faulty wiring,
    a switch also changes the state of all the bulbs to the right of current bulb.
    Given an initial state of all bulbs, find the minimum number of switches you have to press to turn on all the bulbs.
    You can press the same switch multiple times.

    Note: 0 represents the bulb is off and 1 represents the bulb is on.

    Problem Constraints

    1 <= N <= 5*105
    0 <= A[i] <= 1

    Input Format
    The first and the only argument contains an integer array A, of size N.

    Output Format
    Return an integer representing the minimum number of switches required.
    */

    public static int bulbs(int[] A) {
        int switchPress = 0;
        int currentState;
        for (int i = 0; i < A.length; i++) {
            if (switchPress % 2 == 0) {
                currentState = A[i];
            } else {
                if (A[i] == 0)
                    currentState = 1;
                else
                    currentState = 0;
                // OR
                // currentState = 1 - A[i]
            }
            if (currentState == 0)
                switchPress++;
        }
        return switchPress;
    }

    public static void main(String[] args) {
        int[] A = {0,1,0,1};
        System.out.println(bulbs(A));
    }
}
