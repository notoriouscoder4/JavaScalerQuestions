package com.jsm.scaler.intermediate.SubsequenceAndSubset;

public class LittlePonyAnd2_Subsequence {
    /*
    Little Pony has been given a string A, and he wants to find out the lexicographically minimum subsequence from it of size >= 2. Can you help him?
    A string a is lexicographically smaller than string b, if the first different letter in a and b is smaller in a.
    For example, "abc" is lexicographically smaller than "acc" because the first different letter is 'b' and 'c' which is smaller in "abc".

    Problem Constraints
    1 <= |A| <= 105
    A only contains lowercase alphabets.

    Input Format
    The first and the only argument of input contains the string, A.

    Output Format
    Return a string representing the answer.

    Example Input

    Input 1:
     A = "abcdsfhjagj"

    Input 2:
     A = "ksdjgha"

    Example Output

    Output 1:
     "aa"

    Output 2:
     "da"

    Example Explanation

    Explanation 1:
     "aa" is the lexicographically minimum subsequence from A.

    Explanation 2:
     "da" is the lexicographically minimum subsequence from A.
    */

    private static String solve(String A) {
        int l = A.length();

        if (l == 2)
            return A;

        String ans = "";
        char min1, min2, x;
        min1 = A.charAt(0);
        min2 = A.charAt(1);
        for (int i = 1; i < l; i++) {
            x = A.charAt(i);
            if (i != l - 1 && x < min1) {
                min1 = x;
                min2 = 'z';
            } else if (x < min2)
                min2 = x;
        }
        ans += min1;
        ans += min2;
        return ans;

        /* Scaler Solution
        char minchar = 'z';
        int idx = 1000000000;
        for(int i = 0; i < A.length() - 1; i++){
            if(A.charAt(i) < minchar){
                minchar = A.charAt(i);
                idx = i;
            }
        }
        char minchar2 = 'z';
        for(int i = idx + 1; i < A.length(); i++)
            if(A.charAt(i) < minchar2)
                minchar2 = A.charAt(i);
        String ans = String.valueOf(minchar) + String.valueOf(minchar2);
        return ans;
        */
    }

    public static void main(String[] args) {

    }
}
