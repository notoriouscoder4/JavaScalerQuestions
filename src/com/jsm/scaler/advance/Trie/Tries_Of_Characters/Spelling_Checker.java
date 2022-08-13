package com.jsm.scaler.advance.Trie.Tries_Of_Characters;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;

public class Spelling_Checker {
    /*
    Given an array of words A (dictionary) and another array B (which contain some words).

    You have to return the binary array (of length |B|) as the answer where 1 denotes that the word is present in the dictionary and 0 denotes it is not present.
    Formally, for each word in B, you need to return 1 if it is present in Dictionary and 0 if not.
    Such problems can be seen in real life when we work on any online editor (like Google Document), if the word is not valid it is underlined by a red line.

    NOTE: Try to do this in O(n) time complexity.

    Problem Constraints
    1 <= |A| <= 1000
    1 <= sum of all strings in A <= 50000
    1 <= |B| <= 1000

    Input Format
    First argument is array of strings A.
    First argument is array of strings B.

    Output Format
    Return the binary array of integers according to the given format.

    Example Input:
    Input 1:
    A = [ "hat", "cat", "rat" ]
    B = [ "cat", "ball" ]

    Input 2:
    A = [ "tape", "bcci" ]
    B = [ "table", "cci" ]

    Example Output:
    Output 1:
    [1, 0]

    Output 2:
    [0, 0]

    Example Explanation:
    Explanation 1:
    Only "cat" is present in the dictionary.

    Explanation 2:
    None of the words are present in the dictionary.
    */

    /* Trie implementation */
    private static class TrieNode {
        public boolean isEnd;
        public HashMap<Character, TrieNode> map;

        public TrieNode() {
            this.isEnd = false;
            this.map = new HashMap<>();
        }
    }

    private static void insert_Trie(String str, TrieNode r) {
        int n = str.length();
        for (int i = 0; i < n; ++i) {
            char ch = str.charAt(i);
            if (!r.map.containsKey(ch)) {
                TrieNode temp = new TrieNode();
                r.map.put(ch, temp);
            }
            r = r.map.get(ch);
        }
        r.isEnd = true;
    }

    private static boolean search_Trie(String str, TrieNode r) {
        int n = str.length();
        for (int i = 0; i < n; ++i) {
            char ch = str.charAt(i);
            if (!r.map.containsKey(ch))
                return false;
            else
                r = r.map.get(ch);
        }
        return r.isEnd;
    }

    private static ArrayList<Integer> solve(ArrayList<String> A, ArrayList<String> B) {
        ArrayList<Integer> ans = new ArrayList<>(B.size());
        TrieNode root = new TrieNode();

        // add N Strings in Trie
        for (String word : A) {
            insert_Trie(word, root);
        }

        // query or find Q Strings in Trie
        for (String word : B) {
            if (search_Trie(word, root))
                ans.add(1);
            else
                ans.add(0);
        }
        return ans;
    }

    public static void main(String[] args) {
        ArrayList<String> A = new ArrayList<>(Arrays.asList("hat", "cat", "rat"));
        ArrayList<String> B = new ArrayList<>(Arrays.asList("cat", "ball"));

        System.out.println(solve(A, B));
    }
}
