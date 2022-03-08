package com.jsm.scaler.intermediate.ArraysInterviewProblems;

public class LengthOfLongestConsecutiveOnes {
    /*
    Given a binary string A. It is allowed to do at most one swap between any 0 and 1.
    Find and return the length of the longest consecutive 1’s that can be achieved.

    Input Format:-
    The only argument given is string A.

    Output Format:-
    Return the length of the longest consecutive 1’s that can be achieved.

    Constraints
    1 <= length of string <= 1000000
    A contains only characters 0 and 1.

    For Example

    Input 1:
    A = "111000"
    Output 1:
    3

    Input 2:
    A = "111011101"
    Output 2:
    7
    */

    public static int solve(String A) {
        int countOfOne = 0;
        for (int i = 0; i < A.length(); i++) {
            if (A.charAt(i) == '1') {
                countOfOne++;
            }
        }

        if (countOfOne == A.length()) {
            return A.length();
        }
        int ans = 0, len = 0;
        for (int i = 0; i < A.length(); i++) {
            if (A.charAt(i) == '0') {
                int left = 0;
                for (int j = i - 1; j >= 0; j--) {
                    if (A.charAt(j) == '1')
                        left++;
                    else
                        break;
                }
                int right = 0;
                for (int j = i + 1; j < A.length(); j++) {
                    if (A.charAt(j) == '1')
                        right++;
                    else
                        break;
                }
                if (countOfOne > (left + right))
                    len = left + right + 1;
                else
                    len = left + right;
            }
            ans = Math.max(ans, len);
        }
        return ans;
    }

    public static void main(String[] args) {
        String A = "1111";
        System.out.println(solve(A));
    }
}
