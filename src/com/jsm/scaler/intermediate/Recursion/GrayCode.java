package com.jsm.scaler.intermediate.Recursion;

import java.util.ArrayList;
import java.util.Arrays;

public class GrayCode {
    /*
    The gray code is a binary numeral system where two successive values differ in only one bit.
    Given a non-negative integer A representing the total number of bits in the code, print the sequence of gray code.
    A gray code sequence must begin with 0.

    Problem Constraints
    1 <= A <= 16

    Input Format
    The first argument is an integer A.

    Output Format
    Return an array of integers representing the gray code sequence.

    Example Input

    Input 1:
    A = 2

    Input 1:
    A = 1

    Example Output

    output 1:
    [0, 1, 3, 2]

    output 2:
    [0, 1]

    Example Explanation

    Explanation 1:
    for A = 2 the gray code sequence is:
        00 - 0
        01 - 1
        11 - 3
        10 - 2
    So, return [0,1,3,2].

    Explanation 1:
    for A = 1 the gray code sequence is:
        00 - 0
        01 - 1
    So, return [0, 1].
    */

    public static ArrayList<Integer> grayCode(int a) {
        ArrayList<Integer> result = new ArrayList<>();
        result.add(0);
        for (int i = 0; i < a; i++) {
            int curSize = result.size();
            // push back all element in result in reverse order
            for (int j = curSize - 1; j >= 0; j--) {
                result.add(result.get(j) + (1 << i));
            }
        }
        return result;
    }

    public static void main(String[] args) {
        int a = 3;
        System.out.println(grayCode(a));
    }
}
