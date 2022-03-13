package com.jsm.scaler.intermediate.BitManipulations;

public class BitCompression {
    /*
    Richard Hendricks, a mastermind in compression algorithms, is an employee of Hooli in Silicon Valley.
    One day, he finally decided to quit and work on his new idea of the middle-out compression algorithm.

    He needed to work at the bit - level to compress data. He, eventually, encountered this problem.
    There is an array A of N integers. He has to perform certain operations on the elements.
    In any one operation, two indices i and j (i < j) are chosen, and A[i] is replaced with A[i] & A[j],
    and A[j] is replaced with A[i] | A[j], where & represents the Bitwise AND operation and | represents the Bitwise OR operation.
    This operation is performed over all the pairs of integers in the array.

    Help Richard find the Bitwise XOR of all the elements after performing the operations.

    Problem Constraints
    1 <= N <= 105
    1 <= Ai <= 109

    Input Format
    The first argument is the integer array A.

    Output Format
    Return a single integer denoting the XOR of the elements after performing the operations.


    Example Input

    Input 1:
    A = [1, 3, 5]

    Input 2:
    A = [1, 1, 1]

    Example Output

    Output 1:
    7

    Output 2:
    1

    Example Explanation

    Explanation 1:
    After performing the operations, the array becomes [1, 1, 7].
    The XOR of all the elements of this array is 7.
    There can be other possible arrays, but we can prove that the XOR will always be 7.

    Explanation 2:
    Since all the elements are equal.
    Even after applying the operations in any order, the array will be [1, 1, 1].
    The XOR of all the elements of this array is 1.

    Important : a^b is same as (a|b)^(a&b)
    */

    public static int compressBits(int[] A) {
        int ans = A[0];
        for (int i = 1; i < A.length; i++) {
            ans = ans ^ A[i];
        }
        return ans;
    }

    public static void main(String[] args) {
        int[] A = {5, 30, 30, 5, 24, 21, 12, 4, 16, 4, 31};
        System.out.println(compressBits(A));
    }
}
