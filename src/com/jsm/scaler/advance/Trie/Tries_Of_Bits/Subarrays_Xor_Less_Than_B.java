package com.jsm.scaler.advance.Trie.Tries_Of_Bits;

import java.util.ArrayList;
import java.util.Arrays;

public class Subarrays_Xor_Less_Than_B {
    /*
    Given an array of integers A. Find and return the number of subarrays whose xor values is less than B.
    NOTE: As the answer can be very large, return the answer modulo (10^9+7).

    Problem Constraints
    1 <= length of the array <= 100000
    1 <= A[i] <= 10^5
    1 <= B <= 10^6

    Input Format
    The argument given is the integer array A
    Second argument is an integer B.

    Output Format
    Return an integer denoting the number of subarrays whose xor values is less than B.

    Example Input:
    Input 1:
     A = [8, 3, 10, 2, 6, 7, 6, 9, 3]
     B = 3

    Input 2:
     A = [9, 4, 3, 11]
     B = 7

    Example Output:
    Output 1:
     5

    Output 2:
     3

    Example Explanation:
    Explanation 1:
     Generate all the subarrays and their corresponding xor and there are only 5 such subaraays which have xor less than 3.

    Explanation 2:
     Subarrays with xor < 7 are : [9, 4, 3, 11], [4] and [3].
     So, the answer is 3.
    */

    private static final int MOD = 1000000007;

    private static class TrieNode {
        public int cnt;
        public TrieNode[] children = new TrieNode[2];

        public TrieNode() {
            this.cnt = 0;
            children[0] = null;
            children[1] = null;
        }
    }

    private static void insert_Trie(TrieNode root, int preXOR) {
        for (int i = 20; i >= 0; --i) {
            // ith bit in ele
            int e = (preXOR & (1 << i)) > 0 ? 1 : 0;
            if (root.children[e] == null)
                root.children[e] = new TrieNode();
            root = root.children[e];
            root.cnt++;
        }
    }

    private static int findXORLessThanB(TrieNode root, int pre_xor, int B) {
        int currAns = 0;

        for (int i = 20; root != null && i >= 0; --i) {
            int currentBitOfB = (B & (1 << i)) > 0 ? 1 : 0;
            int currentBitOfNumber = (pre_xor & (1 << i)) > 0 ? 1 : 0;

            if (currentBitOfB == 1) {
                if (root.children[currentBitOfNumber] != null)
                    currAns += root.children[currentBitOfNumber].cnt;
                root = root.children[1 - currentBitOfNumber];
            } else {
                root = root.children[currentBitOfNumber];
            }
        }
        return currAns;
    }

    private static int solve(ArrayList<Integer> A, int B) {
        long count = 0;
        int pre_xor = 0;

        TrieNode root = new TrieNode();
        insert_Trie(root, pre_xor);

        for (Integer a : A) {
            pre_xor ^= a;
            count += findXORLessThanB(root, pre_xor, B);
            count %= MOD;
            insert_Trie(root, pre_xor);
        }
        return (int) count;
    }

    public static void main(String[] args) {
        ArrayList<Integer> A = new ArrayList<>(Arrays.asList(8, 3, 10, 2, 6, 7, 6, 9, 3));
        int B = 3;

        System.out.println(solve(A, B));
    }
}
