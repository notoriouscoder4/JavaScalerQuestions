package com.jsm.scaler.advance.Trie.Tries_Of_Bits;

import java.util.ArrayList;
import java.util.Arrays;

public class XOR_TRIPLETS {
    /*
    Given an array of integers A of size N.
    A triplet (i, j, k), i <= j <= k is called a power triplet if A[i] ^ A[i+1] ^....A[j-1] = A[j] ^.....^A[k].
    Where, ^ denotes bitwise xor.

    Return the count of all possible power triplets. Since the answer could be large return answer % 109 +7.

    Problem Constraints
    1 <= N <= 100000
    1 <= A[i] <= 100000

    Input Format
    The first argument given is the integer array A.

    Output Format
    Return the count of all possible power triplets % 109 + 7.

    Example Input:
    Input 1:
     A = [5, 2, 7]

    Input 2:
     A = [1, 2, 3]

    Example Output:
    Output 1:
     2

    Output 2:
     2

    Example Explanation:
    Explanation 1:
     All possible power triplets are:
        1. (1, 2, 3) ->  A[1] = A[2] ^ A[3]
        2. (1, 3, 3) ->  A[1] ^ A[2] = A[3]

    Explanation 2:
     All possible power triplets are:
        1. (1, 2, 3) ->  A[1] = A[2] ^ A[3]
        2. (1, 3, 3) ->  A[1] ^ A[2] = A[3]
    */

    private static class TrieNode {
        public int numberOfIndex;
        public int sumOfIndex;
        public TrieNode[] t = new TrieNode[2];

        public TrieNode() {
            this.numberOfIndex = 0;
            this.sumOfIndex = 0;
            this.t[0] = null;
            this.t[1] = null;
        }
    }

    private static void addNumber(int pre_xor, TrieNode root, int index) {
        for (int i = 31; i >= 0; --i) {
            int bit = (pre_xor & (1 << i)) >= 1 ? 1 : 0;
            if (root.t[bit] == null)
                root.t[bit] = new TrieNode();
            root = root.t[bit];
        }
        root.numberOfIndex++;
        root.sumOfIndex += index;
    }

    private static long calculatePair(int pre_xor, TrieNode root, int index) {
        for (int i = 31; i >= 0; --i) {
            int bit = (pre_xor & (1 << i)) >= 1 ? 1 : 0;
            if (root.t[bit] == null)
                return 0;
            root = root.t[bit];
        }
        return (((long) (root.numberOfIndex) * index) - (long) (root.sumOfIndex));
    }

    private static int solve(ArrayList<Integer> A) {
        long ans, MOD = 1000000007, number_of_triplets = 0;
        int cumulativeXOR = 0;
        TrieNode root = new TrieNode();

        for (int i = 0; i < A.size(); ++i) {
            addNumber(cumulativeXOR, root, i);
            cumulativeXOR ^= A.get(i);

            number_of_triplets += calculatePair(cumulativeXOR, root, i);
            number_of_triplets %= MOD;
        }
        ans = number_of_triplets % MOD;
        return (int) ((ans < 0) ? (ans + MOD) : ans);
    }

    public static void main(String[] args) {
        ArrayList<Integer> A = new ArrayList<>(Arrays.asList(5, 2, 7));
        System.out.println(solve(A));
    }
}
