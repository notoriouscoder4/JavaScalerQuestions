package com.jsm.scaler.advance.Trie.Tries_Of_Bits;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;

public class Maximum_XOR_Subarray {
    /*
    Given an array, A of integers of size N. Find the subarray AL, AL+1, AL+2, ... AR with 1<=L<=R<=N, which has maximum XOR value.

    NOTE: If there are multiple subarrays with the same maximum value, return the subarray with minimum length.
    If the length is the same, return the subarray with the minimum starting index.

    Problem Constraints
    1 <= N <= 100000
    0 <= A[i] <= 10^9

    Input Format
    First and only argument is an integer array A.

    Output Format
    Return an integer array B of size 2. B[0] is the starting index(1-based) of the subarray and B[1] is the ending index(1-based) of the subarray.

    Example Input:
    Input 1:
     A = [1, 4, 3]

    Input 2:
     A = [8]

    Example Output:
    Output 1:
     [2, 3]

    Output 2:
     [1, 1]

    Example Explanation:
    Explanation 1:
     There are 6 possible subarrays of A:
     subarray            XOR value
     [1]                     1
     [4]                     4
     [3]                     3
     [1, 4]                  5 (1^4)
     [4, 3]                  7 (4^3)
     [1, 4, 3]               6 (1^4^3)

     [4, 3] subarray has maximum XOR value. So, return [2, 3].

    Explanation 2:
     There is only one element in the array. So, the maximum XOR value is equal to 8 and the only possible subarray is [1, 1].
    */

    private static class TrieNode {
        public TrieNode[] children = new TrieNode[2];

        public TrieNode() {
            this.children[0] = null;
            this.children[1] = null;
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

    private static void insert_Trie(TrieNode root, int pre_xor, int b) {
        for (int i = b; i >= 0; --i) {
            // ith bit in pre_xor
            int e = checkBit(pre_xor, i) ? 1 : 0;
            if (root.children[e] == null)
                root.children[e] = new TrieNode();
            root = root.children[e];
        }
    }

    private static int search_Trie(TrieNode root, int ele, int b) {
        int ans = 0;
        int bit;
        for (int i = b; i >= 0; --i) {
            int e = checkBit(ele, i) ? 1 : 0;
            bit = e ^ 1;
            if (root.children[bit] != null) {
                // we can set ith bit in ans
                ans = ans + (1 << i);
                root = root.children[bit];
            } else {
                root = root.children[e];
            }
        }
        return ans;
    }

    private static ArrayList<Integer> getSubArray(ArrayList<Integer> prefixXOR, int ans) {
        HashMap<Integer, Integer> map = new HashMap<>();
        int left, right, left_index = -1, right_index = -1;
        int curr_len = 1;
        int minLen = Integer.MAX_VALUE;
        ArrayList<Integer> res = new ArrayList<>(2);
        for (int i = 0; i < prefixXOR.size(); ++i) {
            //if present in map find length of subarray
            if (map.containsKey(prefixXOR.get(i) ^ ans)) {
                left = map.get(prefixXOR.get(i) ^ ans) + 1;
                right = i;
                curr_len = right - left + 1;
                //update min length also update L and R value for the subarray
                if (curr_len < minLen) {
                    left_index = left;
                    right_index = right;
                    minLen = curr_len;
                }
                //update L and R value if current l is minimum
                if (curr_len == minLen && left < left_index) {
                    left_index = left;
                    right_index = right;
                }
            }
            map.put(prefixXOR.get(i), i);
        }
        res.add(0, left_index);
        res.add(1, right_index);
        return res;
    }

    private static ArrayList<Integer> solve(ArrayList<Integer> A) {
        // find max element from array
        int maxElement = getMaxElement(A);

        // find max no of bits
        int maxHeight = getMaxBits(maxElement);

        ArrayList<Integer> prefixXOR = new ArrayList<>(A.size() + 1);
        prefixXOR.add(0);

        for (int i = 0; i < A.size(); ++i) {
            prefixXOR.add(prefixXOR.get(i) ^ A.get(i));
        }

        TrieNode root = new TrieNode();
        insert_Trie(root, prefixXOR.get(0), maxHeight);

        ArrayList<Integer> res = new ArrayList<>(2);
        int ans = 0, max = Integer.MIN_VALUE;

        for (int i = 0; i < prefixXOR.size(); ++i) {
            ans = search_Trie(root, prefixXOR.get(i), maxHeight);
            max = Math.max(max, ans);
            insert_Trie(root, prefixXOR.get(i), maxHeight);
        }

        return getSubArray(prefixXOR, max);
    }

    /* XOR(L, R) = XOR(1, R) ^ XOR(1, L - 1)
       XOR(3, 5) = XOR(1, 5) ^ XOR(1, 2)
    */
    public static void main(String[] args) {
        ArrayList<Integer> A = new ArrayList<>(Arrays.asList(1, 4, 3));
        System.out.println(solve(A));
    }
}
