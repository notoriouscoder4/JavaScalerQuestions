package com.jsm.scaler.advance.Trie.Tries_Of_Bits;

import java.util.ArrayList;
import java.util.Arrays;

public class Maximum_XOR {
    /*
    Given an array of integers A, find and return the maximum result of A[i] XOR A[j], where i, j are the indexes of the array.

    Problem Constraints
    1 <= length of the array <= 100000
    0 <= A[i] <= 10^9

    Input Format
    The only argument given is the integer array A.

    Output Format
    Return an integer denoting the maximum result of A[i] XOR A[j].

    Example Input:
    Input 1:
     A = [1, 2, 3, 4, 5]

    Input 2:
     A = [5, 17, 100, 11]

    Example Output:
    Output 1:
     7

    Output 2:
     117

    Example Explanation:
    Explanation 1:
     Maximum XOR occurs between element of indices(0-based) 1 and 4 i.e. 2 ^ 5 = 7.

    Explanation 2:
     Maximum XOR occurs between element of indices(0-based) 1 and 2 i.e. 17 ^ 100 = 117.
    */

    private static class TrieNode {
        public TrieNode[] children = new TrieNode[2];

        public TrieNode() {
            children[0] = null;
            children[1] = null;
        }
    }

    private static int getMaxElement(ArrayList<Integer> A) {
        int maxElement = A.get(0);
        for (int i = 1; i < A.size(); ++i)
            maxElement = Math.max(maxElement, A.get(i));
        return maxElement;
    }

    private static int getMaxBits(int maxElement) {
        return Integer.toBinaryString(maxElement).length();
    }

    private static boolean checkBit(int N, int i) {
        return ((N >> i) & 1) == 1;
    }

    private static void insert(TrieNode root, int ele, int b) {
        for (int i = b; i >= 0; --i) {
            // ith bit in ele
            int e = checkBit(ele, i) ? 1 : 0;
            if (root.children[e] == null) {
                root.children[e] = new TrieNode();
            }
            root = root.children[e];
        }
    }

    private static int query(TrieNode root, int ele, int b) {
        int ans = 0;
        for (int i = b; i >= 0; --i) {
            // ith bit in ele
            int e = checkBit(ele, i) ? 1 : 0;
            // If e -> 0 => we need 1 and if e -> 1 => we need 0 i.e. (1 - e)
            if (root.children[1 - e] != null) {
                // we can set ith bit in ans
                ans = ans + (1 << i);
                root = root.children[1 - e];
            } else {
                root = root.children[e];
            }
        }
        return ans;
    }

    private static int maxXOR(ArrayList<Integer> A) {
        // find max element from array
        int maxElement = getMaxElement(A);
        // find max no of bits
        int maxHeight = getMaxBits(maxElement);

        TrieNode root = new TrieNode();
        for (Integer a : A) {
            insert(root, a, maxHeight);
        }
        int maxXOR = 0;
        // fix element A.get(i) and get max XOR
        for (Integer a : A) {
            maxXOR = Math.max(maxXOR, query(root, a, maxHeight));
        }
        return maxXOR;
    }

    public static void main(String[] args) {
        ArrayList<Integer> A = new ArrayList<>(Arrays.asList(5, 17, 100, 11));
        System.out.println(maxXOR(A));
    }
}
