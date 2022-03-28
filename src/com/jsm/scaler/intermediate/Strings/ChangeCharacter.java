package com.jsm.scaler.intermediate.Strings;

import java.util.Arrays;

public class ChangeCharacter {
    /*
    Given a string A of size N consisting of lowercase alphabets.
    You can change at most B characters in the given string to any other
    lowercase alphabet such that the number of distinct characters in the string is minimized.
    Find the minimum number of distinct characters in the resulting string.

    Problem Constraints
    1 <= N <= 100000
    0 <= B < N

    Input Format
    First argument is a string A.
    Second argument is an integer B.

    Output Format
    Return an integer denoting the minimum number of distinct characters in the string.

    Example Input
    A = "abcabbccd"
    B = 3

    Example Output
    2

    Example Explanation
    We can change both 'a' and one 'd' into 'b'.So the new string becomes "bbcbbbccb".
    So the minimum number of distinct character will be 2.
    */

    public static int solve(String A, int B) {
        int[] freq = new int[26];
        int n = A.length();
        int distinctness = 0;
        for (int i = 0; i < n; i++) {
            int x = A.charAt(i) - 'a';
            freq[x]++;
            if (freq[x] == 1)
                distinctness++;
        }
        Arrays.sort(freq);
        int i = 0;
        while (i < 26 && B > 0) {
            if (freq[i] > 0 && B >= freq[i]) {
                B = B - freq[i];
                distinctness--;
            }
            i++;
        }
        return distinctness;

        /*
        int cnt[] = new int[26];
        for(int i = 0; i < A.length(); ++i){
            ++cnt[A.charAt(i)-'a'];
        }
        ArrayList<Integer> C = new ArrayList<Integer>();
        for(int i = 0; i < 26; ++i){
            if(cnt[i] > 0){
                C.add(cnt[i]);
            }
        }
        Collections.sort(C);
        for(int i = 0; i < C.size(); ++i){
            B -= C.get(i);
            if(B < 0){
                return C.size() - i;
            }
        }
        return 1;
        */
    }

    public static void main(String[] args) {
        String A = "abcabbccd";
        int B = 3;
        System.out.println(solve(A, B));
    }
}
