package com.jsm.scaler.advance.Trie.Tries_Of_Characters;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;

public class Modified_Search {
    /*
    Given two arrays of strings A of size N and B of size M.
    Return a binary string C where C[i] = '1' if B[i] can be found in dictionary A using exactly one modification in B[i], Else C[i] = '0'.

    NOTE: modification is defined as converting a character into another character.

    Problem Constraints
    1 <= N <= 30000
    1 <= M <= 2500
    1 <= length of any string either in A or B <= 20

    strings contains only lowercase alphabets

    Input Format
    First argument is the string array A.
    Second argument is the string array B.

    Output Format
    Return a binary string C where C[i] = '1' if B[i] can be found in dictionary A using one modification in B[i], Else C[i] = '0'.

    Example Input:
    Input 1:
     A = [data, circle, cricket]
     B = [date, circel, crikket, data, circl]

    Input 2:
     A = [hello, world]
     B = [hella, pello, pella]

    Example Output:
    Output 1:
     "10100"

    Output 2:
     "110"

    Example Explanation:
    Explanation 1:
     1. date = dat*(can be found in A)
     2. circel =(cannot be found in A using exactly one modification)
     3. crikket = cri*ket(can be found in A)
     4. data = (cannot be found in A using exactly one modification)
     5. circl = (cannot be found in A using exactly one modification)

    Explanation 2:
     Only pella cannot be found in A using only one modification.
    */

    private static class TrieNode {
        public boolean isEnd;
        public HashMap<Character, TrieNode> map;

        public TrieNode() {
            this.isEnd = false;
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
            root = root.map.get(ch);
        }
        root.isEnd = true;
    }

    private static boolean search_Trie(String str, TrieNode root, boolean isModified, int index) {
        int n = str.length();
        //Only condition which is acceptable
        if (index == n && isModified && root.isEnd) {
            return true;
        }
        if (index >= n) {
            return false;
        }

        char ch = str.charAt(index);
        if (isModified) {
            //if one modification is already done, we can only proceed if we match current character
            if (root.map.containsKey(ch)) {
                return search_Trie(str, root.map.get(ch), isModified, index + 1);
            }
        } else {
            /* if modification not done, we can proceed in both ways
            i. current char found
            ii. current char not found, since one modification is allowed
            */
            for (char c : root.map.keySet()) {
                if (c == ch) {
                    if (search_Trie(str, root.map.get(c), isModified, index + 1))
                        return true;
                } else {
                    // Set isModified to true call further, since current character is not present
                    if (search_Trie(str, root.map.get(c), true, index + 1))
                        return true;
                }
            }
        }
        return false;
    }

    private static String solve(ArrayList<String> A, ArrayList<String> B) {
        StringBuilder C = new StringBuilder();
        TrieNode root = new TrieNode();

        for (String str : A) {
            insert_Trie(str, root);
        }

        for (String str : B) {
            C.append(search_Trie(str, root, false, 0) ? '1' : '0');
        }
        return C.toString();
    }

    public static void main(String[] args) {
        ArrayList<String> A = new ArrayList<>(Arrays.asList("hello", "world"));
        ArrayList<String> B = new ArrayList<>(Arrays.asList("hella", "pello", "pella"));

        System.out.println(solve(A, B));
    }
}
