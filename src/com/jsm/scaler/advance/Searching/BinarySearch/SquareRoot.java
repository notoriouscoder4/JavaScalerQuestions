package com.jsm.scaler.advance.Searching.BinarySearch;

public class SquareRoot {
    /*
    Given an integer A.
    Compute and return the square root of A.
    If A is not a perfect square, return floor(sqrt(A)).
    DO NOT USE SQRT FUNCTION FROM THE STANDARD LIBRARY.

    NOTE: Do not use the sqrt function from the standard library. Users are expected to solve this in O(log(A)) time.

    Problem Constraints
    0 <= A <= 10^10

    Input Format
    The first and only argument given is the integer A.

    Output Format
    Return floor(sqrt(A))

    Example Input:
    Input 1:
     11

    Input 2:
     9

    Example Output:
    Output 1:
     3

    Output 2:
     3

    Example Explanation:
    Explanation:
     When A = 11 , square root of A = 3.316. It is not a perfect square, so we return the floor which is 3.
     When A = 9 which is a perfect square of 3, so we return 3.
    */

    private static int sqrt(int A) {
        if (A == 0 || A == 1)
            return A;
        int low = 1;
        int high = A;
        int ans = 0;
        while (low <= high) {
            int mid = (low + high) / 2;
            if (mid * mid == A)
                return mid;
            else if (mid * mid > A)
                high = mid - 1;
            else {
                low = mid + 1;
                ans = mid;
            }
        }
        return ans;
    }

    public static void main(String[] args) {
        int A = 11;
        System.out.println(sqrt(A));
    }
}
