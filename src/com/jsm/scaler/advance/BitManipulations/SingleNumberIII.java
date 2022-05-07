package com.jsm.scaler.advance.BitManipulations;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

public class SingleNumberIII {
    /*
    Given an array of positive integers A, two integers appear only once, and all the other integers appear twice.
    Find the two integers that appear only once.

    Problem Constraints
    2 <= |A| <= 100000
    1 <= A[i] <= 109

    Input Format
    The first argument is an array of integers of size N.

    Output Format
    Return an array of two integers that appear only once.

    Example Input:
    Input 1:
    A = [1, 2, 3, 1, 2, 4]

    Input 2:
    A = [1, 2]

    Example Output:
    Output 1:
    [3, 4]

    Output 2:
    [1, 2]


    Example Explanation:
    Explanation 1:
    3 and 4 appear only once.

    Explanation 2:
    1 and 2 appear only once.
    */

    private static ArrayList<Integer> solve(ArrayList<Integer> A) {
        int xor = 0;
        int ans1 = 0, ans2 = 0, pos = 0;

        // Take xor of all elements will cancel the pairs but the xor of the two numbers will remain
        for (int i : A) {
            xor ^= i;
        }

        // In the Xor of all elements check for a set bit and store it in pos
        for (int i = 0; i < 32; i++) {
            if (checkBit(xor, i)) {
                pos = i;
                break;
            }
        }

        // Segregate the Numbers in the array into two groups depending on if that bit is set or not and take XOR of each group which will give us the two Numbers
        for (int i : A) {
            if (checkBit(i, pos)) {
                ans1 = ans1 ^ i;
            } else {
                ans2 = ans2 ^ i;
            }
        }
        ArrayList<Integer> ans = new ArrayList<>();
        ans.add(ans1);
        ans.add(ans2);
        Collections.sort(ans);
        return ans;
    }

    private static boolean checkBit(int num, int i) {
        return (num & (1 << i)) != 0;
    }

    public static void main(String[] args) {
        ArrayList<Integer> A = new ArrayList<>(Arrays.asList(1, 2, 3, 1, 2, 4));
        System.out.println(solve(A));
    }
}
