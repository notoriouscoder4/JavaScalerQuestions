package com.jsm.scaler.intermediate.Hashing;

import java.util.ArrayList;
import java.util.Arrays;

public class IsDictionary {
    /*
    Surprisingly, in an alien language, they also use English lowercase letters, but possibly in a different order.
    The order of the alphabet is some permutation of lowercase letters.
    Given an array of words A of size N written in the alien language,
    and the order of the alphabet denoted by string B of size 26,
    return 1 if and only if the given words are sorted lexicographically in this alien language else, return 0.

    Problem Constraints
    1 <= N, length of each word <= 105
    Sum of the length of all words <= 2 * 106

    Input Format
    The first argument is a string array A of size N.
    The second argument is a string B of size 26, denoting the order.

    Output Format
    Return 1 if and only if the given words are sorted lexicographically in this alien language else, return 0.

    Example Input

    Input 1:
     A = ["hello", "scaler", "interviewbit"]
     B = "adhbcfegskjlponmirqtxwuvzy"

    Input 2:
     A = ["fine", "none", "no"]
     B = "qwertyuiopasdfghjklzxcvbnm"

    Example Output

    Output 1:
     1

    Output 2:
     0

    Example Explanation

    Explanation 1:
     The order shown in string B is: h < s < i for the given words. So return 1.

    Explanation 2:
     "none" should be present after "no". Return 0.
    */

    static int[] table; // table[alien] = order

    public static int solve(ArrayList<String> A, String B) {
        // Create the mapping table
        table = new int[26];
        for (int i = 0; i < B.length(); i++) {
            table[B.charAt(i) - 'a'] = i;
        }

        // Compare adjacent words
        for (int i = 0; i < A.size() - 1; i++) {
            if (isBigger(A.get(i), A.get(i + 1)))
                return 0;
        }
        return 1;

        /*  Scaler Solution
        int id[] = new int[26];
        for(int i = 0; i < B.length(); ++i){
            id[B.charAt(i)-'a'] = i;
        }
        for(int i = 0; i+1 < A.size(); ++i){
            String x = A.get(i);
            String y = A.get(i+1);
            int n = Math.min(x.length(), y.length());
            int fl = 0;
            for(int j = 0; j < n; ++j){
                int c1 = x.charAt(j)-'a';
                int c2 = y.charAt(j)-'a';
                if(c1 == c2){
                    continue;
                }
                if(id[c1] < id[c2]){
                    fl = 1;
                    break;
                }
                return 0;
            }
            if(fl == 0 && x.length() > y.length()){
                return 0;
            }
        }
        return 1;
        */
    }

    public static boolean isBigger(String s1, String s2) {
        // Compare the common parts
        int length = Math.min(s1.length(), s2.length());
        for (int i = 0; i < length; i++) {
            // Find the first difference
            char c1 = s1.charAt(i);
            char c2 = s2.charAt(i);
            if (c1 != c2) return table[c1 - 'a'] > table[c2 - 'a'];
        }

        // If no difference in common parts, check the length in case s1 = "apple", s2 = "app"
        return s1.length() > s2.length();
    }

    public static void main(String[] args) {
        ArrayList<String> A = new ArrayList<>(Arrays.asList("hello", "scaler", "interviewbit"));
        String B = "adhbcfegskjlponmirqtxwuvzy";
        System.out.println(solve(A, B));
    }
}
