package com.jsm.scaler.intermediate.ModularArithmetic;

public class TwoRectanglesOverlap {
    /*
    Eight integers A, B, C, D, E, F, G, and H represent two rectangles in a 2D plane.
    For the first rectangle, its bottom left corner is (A, B),
    and the top right corner is (C, D), and for the second rectangle
    , its bottom left corner is (E, F), and the top right corner is (G, H).
    Find and return whether the two rectangles overlap or not.

    Problem Constraints
    -10000 <= A < C <= 10000
    -10000 <= B < D <= 10000
    -10000 <= E < G <= 10000
    -10000 <= F < H <= 10000

    Input Format
    The eight arguments are integers A, B, C, D, E, F, G, and H.

    Output Format
    Return 1 if the two rectangles overlap else, return 0.

    Example Input

    Input 1:
    A = 0   B = 0
    C = 4   D = 4
    E = 2   F = 2
    G = 6   H = 6

    Input 2:
    A = 0   B = 0
    C = 4   D = 4
    E = 2   F = 2
    G = 3   H = 3

    Example Output

    Output 1:
    1

    Output 2:
    1
     */

    public static int solve(int A, int B, int C, int D, int E, int F, int G, int H) {
        // If one rectangle is on left side of other
        if (A >= G || E >= C)
            return 0;

        // If one rectangle is above other
        if (B >= H || F >= D)
            return 0;

        return 1;

        /*
        int xs = Math.max(A, E), xe = Math.min(C, G);
        int ys = Math.max(B, F), ye = Math.min(D, H);
        if (xs < xe && ys < ye)
            return 1;
        else
            return 0;
        */
    }

    public static void main(String[] args) {
        System.out.println(solve(0, 0, 4, 4, 2, 2, 3, 3));
    }
}
