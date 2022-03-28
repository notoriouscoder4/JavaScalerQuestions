package com.jsm.scaler.intermediate.Strings;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class StringOperations {
    /*
    Akash likes playing with strings. One day he thought of applying following operations on the string in the given order:
    Concatenate the string with itself.
    Delete all the uppercase letters.
    Replace each vowel with '#'.
    You are given a string A of size N consisting of lowercase and uppercase alphabets.
    Return the resultant string after applying the above operations.

    NOTE: 'a' , 'e' , 'i' , 'o' , 'u' are defined as vowels.

    Problem Constraints
    1<=N<=100000

    Input Format
    First argument is a string A of size N.

    Output Format
    Return the resultant string.

    Example Input
    A="AbcaZeoB"

    Example Output
    "bc###bc###"

    Example Explanation
    First concatenate the string with itself so string A becomes "AbcaZeoBAbcaZeoB".
    Delete all the uppercase letters so string A becomes "bcaeobcaeo".
    Now replace vowel with '#'.
    A becomes "bc###bc###".
    */

    public static String solve(String A) {
        /*
        String B = A.concat(A);
        String regex = "[A-Z]";
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(B);
        return  matcher.replaceAll("").replaceAll("[aeiou]", "#");
        */
        StringBuilder res = new StringBuilder();
        for (int i = 0; i < A.length(); i++) {
            if (A.charAt(i) >= 'a' && A.charAt(i) <= 'z') {
                if (A.charAt(i) == 'a' || A.charAt(i) == 'e' || A.charAt(i) == 'i' || A.charAt(i) == 'o' || A.charAt(i) == 'u') {
                    res.append("#");
                } else {
                    res.append(A.charAt(i));
                }
            }
        }
        res.append(res);
        return res.toString();
    }

    public static void main(String[] args) {
        String A = "AbcaZeoB";
        System.out.println(solve(A));
    }
}
