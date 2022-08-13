package com.jsm.scaler.advance.Trie.Tries_Of_Characters;

import java.util.*;

public class Auto_Complete {
    /*
    There is a dictionary A of N words, and ith word has a unique weight Wi.

    Another string array B of size M contains the prefixes. For every prefix B[i], output atmost 5 words from the dictionary A that start with the same prefix.
    Output the words in decreasing order of their weight.

    NOTE: If there is no word that starts with the given prefix output -1.

    Problem Constraints
    1 <= T <= 5
    1 <= N <= 20000
    1 <= M <= 10000
    1 <= Wi <= 10^6
    1 <= length of any string either in A or B <= 30

    Input Format
    First line is an integer T denoting the number of test cases.
    For each test case,

    1. First line denotes two space separated integer N and M.
    2. Second line denotes N space separated strings denoting the words in dictionary.
    3. Third line denotes N space separated integers denoting the weight of each word in the dictionary.
    4. Fourth line denotes M space separated integers denoting the prefixes.

    Output Format
    For every prefix B[i], print the space separated output on a new line.

    NOTE: After every output there should be a space.

    Example Input:
    Input 1:
     1
     6 3
     abcd aecd abaa abef acdcc acbcc
     2 1 3 4 6 5
     ab abc a

    Input 2:
     1
     5 3
     aaaa aacd abaa abaa aadcc
     3 4 1 2 6
     aa aba abc

    Example Output:
    Output 1:
     abef abaa abcd
     abcd
     acdcc acbcc abef abaa abcd

    Output 2:
     aadcc aacd aaaa
     abaa abaa
     -1

    Example Explanation:
    Explanation 1:
     For the prefix "ab" 3 words in the dictionary have same prefix: ("abcd" : 2, "abaa" : 3, "abef" : 4). Ouput them in decreasing order of weight.
     For the prefix "abc" only 1 word in the dictionary have same prefix: ("abcd" : 2).
     For the prefix "a" all 6 words in the dictionary have same prefix: ("abcd" : 2, "aecd" : 1, "abaa" : 3, "abef" : 4, "acdcc" : 6, "acbcc" : 5).
     Since we can output atmost 5 words. Output top 5 weighted words in decreasing order of weight.

    Explanation 2:
     For the prefix "aa" 3 words in the dictionary have same prefix: ("aaaa" : 3, "aacd" : 4, "aadcc" : 6). Ouput them in decreasing order of weight.
     For the prefix "aba" 2 words in the dictionary have same prefix: ("abaa" : 1, "abaa" : 2).
     For the prefix "abc" there is no word in the dictionary which have same prefix. So print -1.
    */

    private static class WordInfo {
        public String word;
        public int weight;

        public WordInfo(String word, int weight) {
            this.word = word;
            this.weight = weight;
        }
    }

    private static class TrieNode {
        public ArrayList<Integer> wordIndices;
        public HashMap<Character, TrieNode> children;

        public TrieNode() {
            this.wordIndices = new ArrayList<>();
            this.children = new HashMap<>();
        }
    }

    private static void insert_Trie(TrieNode root, WordInfo[] info) {
        for (int j = 0; j < info.length; ++j) {
            TrieNode curr = root;
            String word = info[j].word;
            for (int i = 0; i < word.length(); ++i) {
                char ch = word.charAt(i);
                if (!curr.children.containsKey(ch)) {
                    TrieNode temp = new TrieNode();
                    curr.children.put(ch, temp);
                }
                curr = curr.children.get(ch);
                if (curr.wordIndices.size() < 5)
                    curr.wordIndices.add(j);
            }
        }
    }

    private static ArrayList<String> query_Trie(TrieNode root, String query, WordInfo[] info) {
        TrieNode curr = root;
        for (int i = 0; i < query.length(); ++i) {
            char ch = query.charAt(i);
            if (!curr.children.containsKey(ch))
                return new ArrayList<>();
            else
                curr = curr.children.get(ch);
        }
        ArrayList<String> res = new ArrayList<>(5);
        for (int i = 0; i < curr.wordIndices.size(); ++i) {
            res.add(info[curr.wordIndices.get(i)].word);
        }
        return res;
    }

    public static void main(String[] args) {
        // YOUR CODE GOES HERE
        // Please take input and print output to standard input/output (stdin/stdout)
        // DO NOT USE ARGUMENTS FOR INPUTS
        // E.g. 'Scanner' for input & 'System.out' for output
        Scanner sc = new Scanner(System.in);
        int testCases = sc.nextInt();

        while (testCases > 0) {
            TrieNode root = new TrieNode();
            int dictionarySize = sc.nextInt();
            int querySize = sc.nextInt();

            String[] dict = new String[dictionarySize];
            int[] weight = new int[dictionarySize];
            String[] queries = new String[querySize];

            for (int i = 0; i < dictionarySize; i++)
                dict[i] = sc.next();

            for (int i = 0; i < dictionarySize; i++)
                weight[i] = sc.nextInt();

            for (int i = 0; i < querySize; ++i)
                queries[i] = sc.next();

            WordInfo[] info = new WordInfo[dictionarySize];
            for (int i = 0; i < dictionarySize; i++)
                info[i] = new WordInfo(dict[i], weight[i]);

            Arrays.sort(info, (WordInfo first, WordInfo second) -> {
                if (first.weight < second.weight)
                    return 1;
                else
                    return -1;
            });

            insert_Trie(root, info);

            for (int i = 0; i < querySize; ++i) {
                ArrayList<String> res = query_Trie(root, queries[i], info);
                if (res.size() == 0)
                    System.out.println(-1 + " ");
                else {
                    for (String result : res) {
                        if (result != null)
                            System.out.print(result + " ");
                    }
                    System.out.println();
                }
            }
            testCases--;
        }
    }
}
