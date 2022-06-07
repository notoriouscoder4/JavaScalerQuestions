package com.jsm.scaler.advance.Sorting;

import java.util.Arrays;

public class LargestNumber {
    /*
    Given an array A of non-negative integers, arrange them such that they form the largest number.
    Note: The result may be very large, so you need to return a string instead of an integer.

    Problem Constraints
    1 <= len(A) <= 100000
    0 <= A[i] <= 2*10^9

    Input Format
    The first argument is an array of integers.

    Output Format
    Return a string representing the largest number.

    Example Input

    Input 1:
     A = [3, 30, 34, 5, 9]

    Input 2:
     A = [2, 3, 9, 0]

    Example Output

    Output 1:
     "9534330"

    Output 2:
     "9320"
    Example Explanation

    Explanation 1:
    Reorder the numbers to [9, 5, 34, 3, 30] to form the largest number.

    Explanation 2:
    Reorder the numbers to [9, 3, 2, 0] to form the largest number 9320.
    */

    private static String largestNumber(final int[] A) {
        StringBuilder sb = new StringBuilder();
        Node[] num = new Node[A.length];
        int i = 0;
        for (int n : A) {
            num[i] = new Node(n);
            i++;
        }
        Arrays.sort(num);
        for (Node n : num) {
            if (n.number == 0 && sb.length() != 0)
                continue;
            sb.append(n.number);
        }
        return sb.toString();
    }

    static class Node implements Comparable<Node> {
        int number;

        public Node(int number) {
            this.number = number;
        }

        @Override
        public int compareTo(Node o) {
            String first = this.number + String.valueOf(o.number);
            String second = o.number + String.valueOf(this.number);
            return second.compareTo(first);
        }
    }

    public static void main(String[] args) {
        int[] A = {3, 30, 34, 5, 9};
        System.out.println(largestNumber(A));
    }
}
