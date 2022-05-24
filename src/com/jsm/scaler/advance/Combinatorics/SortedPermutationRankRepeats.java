package com.jsm.scaler.advance.Combinatorics;

public class SortedPermutationRankRepeats {
    /*
    Given a string A, find the rank of the string amongst its permutations sorted lexicographically. Note that the characters might be repeated.
    If the characters are repeated, we need to look at the rank in unique permutations. Look at the example for more details.

    NOTE: The answer might not fit in an integer, so return your answer % 1000003 where 1000003 is a prime number.
    String A can consist of both lowercase and uppercase letters. Characters with lesser ASCII values are considered smaller, i.e., 'a' > 'Z'.

    Problem Constraints
    1 <= len(A) <= 1000000

    Input Format
    First argument is a string A.

    Output Format
    Return an integer denoting the rank.

    Example Input:
    Input 1:
     A = "aba"

    Input 2:
     A = "bca"

    Example Output:
    Output 1:
     2

    Output 2:
     4

    Example Explanation:
    Explanation 1:
     The order permutations with letters 'a', 'a', and 'b' :
        aab
        aba
        baa
     So, the rank is 2.

    Explanation 2:
     The order permutations with letters 'a', 'b', and 'c' :
        abc
        acb
        bac
        bca
        cab
        cba
     So, the rank is 4.
    */

    private static final int mod = 1000003;

    private static int findRank(String A) {
        if (A == null || A.length() == 0)
            return 0;
        int ans = 1;
        for (int i = 0; i < A.length(); i++) {
            int count = 0;
            // Count all the value less than current alphabet
            for (int j = i + 1; j < A.length(); j++) {
                if (A.charAt(j) < A.charAt(i))
                    count++;
            }
            // Find the freq of all the duplicate alphabet from the current element.
            int[] freq = new int[52];
            for (int j = i; j < A.length(); j++) {
                if (A.charAt(j) >= 'a' && A.charAt(j) <= 'z')
                    freq[A.charAt(j) - 'a']++;
                else
                    freq[A.charAt(j) - 'A' + 26]++;
            }
            long factVal = 1;
            //Take fact for the duplicate values
            for (int j : freq) {
                if (j > 1)
                    factVal = factVal * factorial(j) % mod;
            }
            //take Fermat mod on the total duplicate value
            long inverse = getFermatSolve(factVal, mod);
            ans = (int) ((ans % mod) + (count * factorial(A.length() - i - 1) * inverse) % mod);
        }
        return ans;
    }

    private static int factorial(int n) {
        if (n == 0 || n == 1) return 1;
        return (n * factorial(n - 1)) % mod;
    }

    private static int getFermatSolve(long A, long B) {
        int result = 1;
        long p = B - 2;
        long a = A;
        while (p > 0) {
            if (p % 2 == 1)
                result = (int) ((result * a) % mod);
            a = (a * a) % mod;
            p >>= 1;
        }
        return result;
    }

    public static void main(String[] args) {
        String A = "aba";
        System.out.println(findRank(A));
    }

    /*
    public class Solution {

    private int MOD = 1000003;
    public int findRank(String S) {

        // Initializations
        ArrayList<Integer> charCount = new ArrayList<Integer>(256);

        for(int i=0;i<256;i++) charCount.add(0);
        for (int i = 0; i < S.length(); i++) {
            int ch = (int)S.charAt(i);
            charCount.set(ch, charCount.get(ch)+1);
        }

        ArrayList<Integer> fact = new ArrayList<Integer>(); // fact[i] will contain i! % MOD
        initializeFactorials(S.length() + 1, fact);

        long rank =  1;

        for (int i = 0; i < S.length(); i++) {
            // find number of permutations placing character smaller than S[i] at ith position
            // among characters from i to S.length
            long less = 0;
            int remaining = S.length() - i - 1;
            for (int ch = 0; ch < S.charAt(i); ch++) {
                if (charCount.get(ch) == 0) continue;
                // Lets try placing ch as the first character in remaining characters
                // and check the number of permutation possible.
                charCount.set(ch, charCount.get(ch)-1);
                long numPermutation = fact.get(remaining);

                for (int c = 0; c < 128; c++) {
                    if (charCount.get(c) <= 1) continue;
                    numPermutation = (numPermutation * inverseNumber(fact.get(charCount.get(c)))) % MOD;
                }

                charCount.set(ch, charCount.get(ch)+1);
                less = (less + numPermutation) % MOD;
            }

            rank = (rank + less) % MOD;
            // remove the current character from the set.
            charCount.set((int)S.charAt(i), charCount.get(S.charAt(i))-1);
        }
        return (int)rank;

    }

    public void initializeFactorials(int totalLen, ArrayList<Integer> fact) {

        long factorial = 1;
        fact.add(1); // 0!= 1
        for (int curIndex = 1; curIndex < totalLen; curIndex++) {
            factorial = (factorial * curIndex) % MOD;
            fact.add((int)factorial);
        }
        return;
    }

    public long pow(long x, int y, int k){
        long result = 1;
        while(y > 0){
            if(y % 2 == 1) {
                result = (result * x) % k;
                y--;
            }
            y >>= 1;
            x = (x * x) % k;
        }
        return result;
    }
    long inverseNumber(int num) {

        // Inverse modulo : https://en.wikipedia.org/wiki/Modular_multiplicative_inverse
        // Calculate num ^ MOD-2  % MOD
        return pow(num, MOD-2 , MOD);
    }
}
    */
}
