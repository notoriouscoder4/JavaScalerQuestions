package com.jsm.scaler.advance.Arrays;

import java.util.ArrayList;
import java.util.Arrays;

public class PickFromBothSides {
    /*
    You are given an integer array A of size N.
    You have to pick B elements in total. Some (possibly 0) elements from left end of array A
    and some (possibly 0) from the right end of array A to get the maximum sum.
    Find and return this maximum possible sum.
    NOTE: Suppose B = 4, and array A contains 10 elements, then
    You can pick the first four elements or can pick the last four elements, or can pick 1 from front and 3 from the back, etc.
    You need to return the maximum possible sum of elements you can pick.

    Problem Constraints
    1 <= N <= 105
    1 <= B <= N
    -103 <= A[i] <= 103

    Input Format
    First argument is an integer array A.
    Second argument is an integer B.

    Output Format
    Return an integer denoting the maximum possible sum of elements you picked.

    Example Input
    Input 1:
     A = [5, -2, 3 , 1, 2]
     B = 3

    Input 2:
     A = [1, 2]
     B = 1


    Example Output:
    Output 1:
     8

    Output 2:
     2

    Example Explanation:
    Explanation 1:
     Pick element 5 from front and element (1, 2) from back so we get 5 + 1 + 2 = 8

    Explanation 2:
     Pick element 2 from end as this is the maximum we can get
    */

    private static int solve(ArrayList<Integer> A, int B) {
        int currSum = 0;
        for (int i = 0; i < B; i++)
            currSum += A.get(i);
        int maxSum = currSum;
        int inc = A.size() - 1, exc = B - 1;
        while (inc >= 0 && exc >= 0) {
            currSum += A.get(inc--);
            currSum -= A.get(exc--);
            maxSum = Math.max(maxSum, currSum);
        }
        return maxSum;

        /* Scaler Solution
        int n = A.length;
        int []suff = new int[n + 1];
        suff[n] = 0;
        suff[n - 1] = A[n - 1];
        for(int i = n - 2; i >= 0; i--){
            suff[i] = A[i] + suff[i + 1];
        }
        int pref_sum = 0;
        int ans = suff[n - B];
        for(int i = 0; i < B; i++){
            pref_sum = pref_sum + A[i];
            int suff_sum = suff[n - B + (i + 1)];
            ans = Math.max(ans, pref_sum + suff_sum);
        }
        return ans;
        */
    }

    public static void main(String[] args) {
        ArrayList<Integer> A = new ArrayList<>(Arrays.asList(5, -2, 3, 1, 2));
        int B = 3;
        System.out.println(solve(A, B));
    }
}
