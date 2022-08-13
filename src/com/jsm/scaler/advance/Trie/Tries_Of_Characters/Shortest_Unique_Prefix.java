package com.jsm.scaler.advance.Trie.Tries_Of_Characters;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;

public class Shortest_Unique_Prefix {
    /*
    Given a list of N words, find the shortest unique prefix to represent each word in the list.

    NOTE: Assume that no word is the prefix of another. In other words, the representation is always possible

    Problem Constraints
    1 <= Sum of length of all words <= 10^6

    Input Format
    First and only argument is a string array of size N.

    Output Format
    Return a string array B where B[i] denotes the shortest unique prefix to represent the ith word.

    Example Input:
    Input 1:
     A = ["zebra", "dog", "duck", "dove"]

    Input 2:
    A = ["apple", "ball", "cat"]

    Example Output:
    Output 1:
     ["z", "dog", "du", "dov"]

    Output 2:
     ["a", "b", "c"]

    Example Explanation:
    Explanation 1:
     Shortest unique prefix of each word is:
     For word "zebra", we can only use "z" as "z" is not any prefix of any other word given.
     For word "dog", we have to use "dog" as "d" and "do" are prefixes of "dov".
     For word "duck", we have to use "du" as "d" is prefix of "dove" and "dog".
     For word "dove", we have to use "dov" as "d" and "do" are prefixes of "dog".

    Explanation 2:
     "a", "b" and c" are not prefixes of any other word. So, we can use of first letter of each to represent.
    */

    private static class TrieNode {
        public int freq;
        public boolean isEnd;
        public HashMap<Character, TrieNode> children;

        public TrieNode() {
            this.freq = 0;
            this.isEnd = false;
            this.children = new HashMap<>();
        }
    }

    private static void insert_Trie(String str, TrieNode root) {
        int n = str.length();
        for (int i = 0; i < n; ++i) {
            char ch = str.charAt(i);
            if (!root.children.containsKey(ch)) {
                TrieNode temp = new TrieNode();
                root.children.put(ch, temp);
            }
            root.freq++;
            root = root.children.get(ch);
        }
        root.isEnd = true;
    }

    private static String findShortestPrefix(String str, TrieNode root) {
        StringBuilder ans = new StringBuilder();
        int n = str.length();
        for (int i = 0; i < n; ++i) {
            if (root.freq == 1)
                return ans.toString();
            char ch = str.charAt(i);
            ans.append(ch);
            root = root.children.get(ch);
        }
        return ans.toString();
    }

    private static ArrayList<String> prefix(ArrayList<String> A) {
        ArrayList<String> ans = new ArrayList<>();
        TrieNode root = new TrieNode();

        for (String str : A) {
            insert_Trie(str, root);
        }

        for (String str : A) {
            ans.add(findShortestPrefix(str, root));
        }
        return ans;
    }

    public static void main(String[] args) {
        ArrayList<String> A = new ArrayList<>(Arrays.asList("zebra", "dog", "duck", "dove"));
        System.out.println(prefix(A));
    }
}
