package com.jsm.scaler.beginner.Strings;

import java.util.Scanner;

public class VowelsConsonants {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();
        String s = "";

        for (int i = 0; i < T; i++) {
            s = sc.next();

            int vow = 0, cons = 0;
            String ref = "aeiouAEIOU";

            for (int j = 0; j < s.length(); j++) {
                if ((s.charAt(j) >= 'A' && s.charAt(j) <= 'Z') || (s.charAt(j) >= 'a' && s.charAt(j) <= 'z')) {
                    if (ref.indexOf(s.charAt(j)) != -1)
                        vow++;
                    else
                        cons++;
                }
            }
            System.out.println("Number of Vowels = " + vow
                    + "\nNumber of Consonants = "
                    + cons);
        }
    }
}
