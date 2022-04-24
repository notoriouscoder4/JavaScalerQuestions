package com.jsm.scaler.intermediate.SubsequenceAndSubset;

import java.util.ArrayList;
import java.util.Arrays;

public class OddEvenSubsequences {
    /*
    Given an array of integers A of size, N. Find the longest subsequence of A, which is odd-even.
    A subsequence is said to be odd-even in the following cases:
    The first element of the subsequence is odd; the second element is even, the third element is odd, and so on.
    For example: [5, 10, 5, 2, 1, 4], [1, 2, 3, 4, 5]
    The first element of the subsequence is even, the second element is odd, the third element is even, and so on.
    For example: [10, 5, 2, 1, 4, 7], [10, 1, 2, 3, 4]
    Return the maximum possible length of odd-even subsequence.

    Note: An array B is a subsequence of an array A if B can be obtained from A by deleting several (possibly, zero, or all) elements.

    Input Format
    The only argument given is the integer array A.

    Output Format
    Return the maximum possible length of odd-even subsequence.

    Constraints
    1 <= N <= 100000
    1 <= A[i] <= 10^9

    For Example

    Input 1:
        A = [1, 2, 2, 5, 6]
    Output 1:
        4
        Explanation 1:
            Maximum length odd even subsequence is [1, 2, 5, 6]

    Input 2:
        A = [2, 2, 2, 2, 2, 2]
    Output 2:
        1
        Explanation 2:
            Maximum length odd even subsequence is [2]
    */

    private static int solve(ArrayList<Integer> A) {
        int result = 0;
        boolean even = A.get(0) % 2 == 0; //check if first number is even
        boolean odd = A.get(0) % 2 != 0; //check if first number is odd

        for (int i = 0; i < A.size(); i++) {
            if (A.get(i) % 2 == 0 && even) {
                result += 1;
                even = false; //setting even flag to false implies that next element in the sub-sequence should be odd
                odd = true;
            } else if (A.get(i) % 2 != 0 && odd) {
                result += 1;
                odd = false; //setting odd flag to false implies that next element in the sub-sequence should be even
                even = true;
            }
        }
        return result;

        /* Scaler Solution
        int n=A.length;
        int ans1=0,ans2=0;
        int x=1,y=0;
        for(int i = 0; i < n; i++){
            int it = A[i];
            it=(it&1);
            if(it==x){
                ++ans1;
                x^=1;
            }
            if(it==y){
                y^=1;
                ++ans2;
            }
        }
        return Math.max(ans1,ans2);
        */
    }

    public static void main(String[] args) {
        ArrayList<Integer> A = new ArrayList<>(Arrays.asList(2, 2, 2, 2, 2, 2));
        System.out.println(solve(A));
    }
}
