package com.jsm.scaler.advance.StringPatternMatching;

public class CyclicPermutations {
    /*
    Given two binary strings A and B, count how many cyclic permutations of B when taken XOR with A give 0.

    NOTE: If there is a string, S0, S1, ... Sn-1 , then it is a cyclic permutation is of the form Sk, Sk+1, ... Sn-1, S0, S1, ... Sk-1
    where k can be any integer from 0 to N-1.

    Problem Constraints
    1 ≤ length(A) = length(B) ≤ 10^5

    Input Format
    The first argument is a string A.
    The second argument is a string B.

    Output Format
    Return an integer denoting the required answer.

    Example Input
    Input 1:
     A = "1001"
     B = "0011"

    Input 2:
     A = "111"
     B = "111"

    Example Output:
    Output 1:
     1

    Output 2:
     3

    Example Explanation:
    Explanation 1:
     4 cyclic permutations of B exists: "0011", "0110", "1100", "1001".
     There is only one cyclic permutation of B i.e. "1001" which has 0 xor with A.

    Explanation 2:
     All cyclic permutations of B are same as A and give 0 when taken xor with A. So, the ans is 3.
    */

    private static int solve(String A, String B) {
        StringBuilder sb = new StringBuilder();
        sb.append(A);
        sb.append("$");
        sb.append(B);
        sb.append(B, 0, B.length() - 1);

        int[] lps = new int[sb.length()];
        lps = createLPS(sb.toString(), lps);

        int count = 0;
        for (int i = 0; i < lps.length; i++) {
            if (lps[i] == A.length())
                count++;
        }
        return count;
    }

    private static int[] createLPS(String A, int[] lps) {
        int n = A.length();
        lps = new int[n];
        lps[0] = 0;

        int x;
        for (int i = 1; i < n; i++) {
            x = lps[i - 1];
            while (A.charAt(x) != A.charAt(i)) {
                if (x == 0) {
                    x = -1;
                    break;
                }
                x = lps[x - 1];
            }
            lps[i] = x + 1;
        }
        return lps;
    }

    public static void main(String[] args) {
        String A = "1001";
        String B = "0011";
        System.out.println(solve(A, B));
    }
}
