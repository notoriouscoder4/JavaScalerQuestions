package com.jsm.scaler.intermediate.Arrays_Maths;

import java.util.Scanner;

public class NthMagicNumber {
    /*
    Given an integer A, find and return the Ath magic number.
    A magic number is defined as a number that can be expressed as a power of 5 or a sum of unique powers of 5.
    First few magic numbers are 5, 25, 30(5 + 25), 125, 130(125 + 5), ….

    Problem Constraints
    1 <= A <= 5000

    Input Format
    The only argument given is integer A.

    Output Format
    Return the Ath magic number.

    Example Input

    Example Input 1:
     A = 3

    Example Input 2:
     A = 10

    Example Output

    Example Output 1:
     30

    Example Output 2:
     650

    Example Explanation

    Explanation 1:
     Magic Numbers in increasing order are [5, 25, 30, 125, 130, ...]
     3rd element in this is 30

    Explanation 2:
     In the sequence shown in explanation 1, 10th element will be 650.
     */

    public static int solve(int A) {
        int x = 1, ans = 0;
        while (A > 0) {
            x = x * 5;
            if (A % 2 == 1)
                ans += x;
            A /= 2;
        }
        return ans;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int magicNumber = sc.nextInt();
        System.out.println(solve(magicNumber));
    }
}
