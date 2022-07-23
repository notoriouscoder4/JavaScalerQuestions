package com.jsm.scaler.advance.Queues;

import java.util.LinkedList;
import java.util.Queue;

public class PerfectNumbers {
    /*
    Given an integer A, you have to find the Ath Perfect Number.

    A Perfect Number has the following properties:

    It comprises only 1 and 2.
    The number of digits in a Perfect number is even.
    It is a palindrome number.

    For example, 11, 22, 112211 are Perfect numbers, where 123, 121, 782, 1 are not.

    Problem Constraints
    1 <= A <= 100000

    Input Format
    The only argument given is an integer A.

    Output Format
    Return a string that denotes the Ath Perfect Number.

    Example Input:
    Input 1:
     A = 2

    Input 2:
     A = 3

    Example Output:
    Output 1:
     22

    Output 2:
     1111

    Example Explanation:
    Explanation 1:
    First four perfect numbers are:
    1. 11
    2. 22
    3. 1111
    4. 1221

    Explanation 2:
    First four perfect numbers are:
    1. 11
    2. 22
    3. 1111
    4. 1221
    */

    private static String solve(int A) {
        Queue<Long> queue = new LinkedList<>();
        int count = 0;

        if (A == 1) return "11";
        if (A == 2) return "22";

        count += 2;

        queue.add(1L);
        queue.add(2L);

        while (count <= A) {
            long x = queue.poll();
            x = x * 10;
            queue.add(x + 1);
            queue.add(x + 2);
            count += 1;
        }
        StringBuilder sb = new StringBuilder();
        sb.append(queue.poll());

        return sb.toString() + sb.reverse();
    }

    public static void main(String[] args) {
        int A = 5;
        System.out.println(solve(A));
    }
}
