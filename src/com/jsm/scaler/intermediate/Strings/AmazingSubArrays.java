package com.jsm.scaler.intermediate.Strings;

public class AmazingSubArrays {
    /*
    You are given a string S, and you have to find all the amazing substrings of S.
    An amazing Substring is one that starts with a vowel (a, e, i, o, u, A, E, I, O, U).

    Input
    Only argument given is string S.

    Output
    Return a single integer X mod 10003, here X is the number of Amazing Substrings in given the string.

    Constraints
    1 <= length(S) <= 1e6
    S can have special characters

    Example

    Input
        ABEC

    Output
        6

    Explanation
        Amazing substrings of given string are :
        1. A
        2. AB
        3. ABE
        4. ABEC
        5. E
        6. EC
        here number of substrings are 6 and 6 % 10003 = 6.
    */

    public static final int MOD = 10003;

    public static int solve(String A) {
        int count = 0;
        int n = A.length();
        for (int i = 0; i < n; i++) {
            if (isVowel(A.charAt(i)))
                count += n - i;
        }
        return count % MOD;

        /*
        TreeSet<Character> se = new TreeSet<>();
        se.add('a'); se.add('e'); se.add('i'); se.add('o'); se.add('u');
        se.add('A'); se.add('E'); se.add('I'); se.add('O'); se.add('U');

        int n = A.length();
        long ans = 0;
        for(int i = 0; i < n; i++){
            if(se.contains(A.charAt(i))){
                ans += (n - i);
            }
        }
        return (int)(ans%10003);
        */
    }

    public static boolean isVowel(char A) {
        return switch (A) {
            case 'a', 'A', 'e', 'E', 'i', 'I', 'o', 'O', 'u', 'U' -> true;
            default -> false;
        };
    }

    public static void main(String[] args) {
        String A = "ABEC";
        System.out.println(solve(A));
    }
}
