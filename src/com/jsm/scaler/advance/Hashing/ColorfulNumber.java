package com.jsm.scaler.advance.Hashing;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

public class ColorfulNumber {
    /*
    Given a number A, find if it is COLORFUL number or not.
    If number A is a COLORFUL number return 1 else, return 0.

    What is a COLORFUL Number:
    A number can be broken into different contiguous sub-subsequence parts.
    Suppose, a number 3245 can be broken into parts like 3 2 4 5 32 24 45 324 245.
    And this number is a COLORFUL number, since product of every digit of a contiguous subsequence is different.

    Problem Constraints
    1 <= A <= 2 * 109

    Input Format
    The first and only argument is an integer A.

    Output Format
    Return 1 if integer A is COLORFUL else return 0.

    Example Input

    Input 1:
     A = 23

    Input 2:
     A = 236

    Example Output

    Output 1:
     1

    Output 2:
     0

    Example Explanation

    Explanation 1:

     Possible Sub-sequences: [2, 3, 23] where
     2 -> 2
     3 -> 3
     23 -> 6  (product of digits)
     This number is a COLORFUL number since product of every digit of a sub-sequence are different.

    Explanation 2:

     Possible Sub-sequences: [2, 3, 6, 23, 36, 236] where
     2 -> 2
     3 -> 3
     6 -> 6
     23 -> 6  (product of digits)
     36 -> 18  (product of digits)
     236 -> 36  (product of digits)
     This number is not a COLORFUL number since the product sequence 23  and sequence 6 is same.
    */

    private static int colorful(int A) {
        ArrayList<Integer> digits = new ArrayList<>();
        while (A > 0) {
            digits.add(A % 10);
            A /= 10;
        }
        Collections.reverse(digits);
        Set<Integer> s = new HashSet<>();
        for (int i = 0; i < digits.size(); i++) {
            int product = 1;
            for (int j = i; j < digits.size(); j++) {
                product *= digits.get(j);
                if (s.contains(product))
                    return 0;
                s.add(product);
            }
        }
        return 1;
    }

    public static void main(String[] args) {
        int A = 3245;
        System.out.println(colorful(A));
    }
}
