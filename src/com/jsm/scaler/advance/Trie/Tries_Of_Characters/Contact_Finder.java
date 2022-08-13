package com.jsm.scaler.advance.Trie.Tries_Of_Characters;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;

public class Contact_Finder {
    /*
    We want to make a custom contacts finder applications as part of our college project.
    The application must perform two types of operations:

    Type 1: Add name B[i] ,denoted by 0 in vector A where B[i] is a string in vector B denoting a contact name.
    This must store B[i] as a new contact in the application.

    Type 2: Find partial for B[i] ,denoted by 1 in vector A where B[i] is a string in vector B denoting a partial name to search
    the application for. It must count the number of contacts starting with B[i].

    You have been given sequential add and find operations. You need to perform each operation in order.
    And return as an array of integers, answers for each query of type 2(denoted by 1 in A) .

    Problem Constraints
    1 <= |A| <= 10000
    1 <= |length of strings in B| <= 10

    Input Format
    First argument is the vector A, which denotes the type of query.
    Second argument is the vector B, which denotes the string for corresponding query.

    Output Format
    Return an array of integers, denoting answers for each query of type 1.

    Example Input:
    Input 1:
    A = [0, 0, 1, 1]
    B = ["hack", "hacker", "hac", "hak"]

    Input 2:
    A = [0, 1]
    B = ["abcde", "abc"]

    Example Output:
    Output 1:
    [2, 0]

    Output 2:
    [1]

    Example Explanation:
    Explanation 1:
    We perform the following sequence of operations:
    Add a contact named "hack".
    Add a contact named "hacker".
    Find the number of contact names beginning with "hac". There are currently two contact names in the application and both of them start with "hac", so we have 2.
    Find the number of contact names beginning with "hak". There are currently two contact names in the application but neither of them start with "hak", so we get0.

    Explanation 2:
    Add "abcde"
    Find words with prefix "abc". We have answer as 1.
    */

    private static class TrieNode {
        public boolean isEnd;
        public int freq;
        public HashMap<Character, TrieNode> map;

        public TrieNode() {
            this.isEnd = false;
            this.freq = 0;
            this.map = new HashMap<>();
        }
    }

    private static void insert_Trie(String str, TrieNode root) {
        int n = str.length();
        for (int i = 0; i < n; ++i) {
            char ch = str.charAt(i);
            if (!root.map.containsKey(ch)) {
                TrieNode temp = new TrieNode();
                root.map.put(ch, temp);
            }
            root.map.get(ch).freq++;
            root = root.map.get(ch);
        }
        root.isEnd = true;
    }

    private static int search_Trie(String str, TrieNode root) {
        int n = str.length();
        for (int i = 0; i < n; ++i) {
            char ch = str.charAt(i);
            if (!root.map.containsKey(ch))
                return 0;
            else
                root = root.map.get(ch);
        }
        return root.freq;
    }

    private static ArrayList<Integer> solve(ArrayList<Integer> A, ArrayList<String> B) {
        ArrayList<Integer> ans = new ArrayList<>();
        TrieNode root = new TrieNode();

        for (int i = 0; i < A.size(); ++i) {
            if (A.get(i) == 0) {
                insert_Trie(B.get(i), root);
            } else {
                int count = search_Trie(B.get(i), root);
                ans.add(count);
            }
        }
        return ans;
    }

    public static void main(String[] args) {
        ArrayList<Integer> A = new ArrayList<>(Arrays.asList(0, 1));
        ArrayList<String> B = new ArrayList<>(Arrays.asList("abcde", "abc"));
        System.out.println(solve(A, B));
    }
}
