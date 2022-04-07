package com.jsm.scaler.intermediate.Hashing;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;

public class FirstRepeatingElement {
    /*
    Given an integer array A of size N, find the first repeating element in it.
    We need to find the element that occurs more than once and whose index of the first occurrence is the smallest.
    If there is no repeating element, return -1.

    Problem Constraints
    1 <= N <= 105
    1 <= A[i] <= 109

    Input Format
    The first and only argument is an integer array A of size N.

    Output Format
    Return an integer denoting the first repeating element.

    Example Input

    Input 1:
     A = [10, 5, 3, 4, 3, 5, 6]

    Input 2:
     A = [6, 10, 5, 4, 9, 120]

    Example Output

    Output 1:
     5

    Output 2:
     -1

    Example Explanation

    Explanation 1:
     5 is the first element that repeats

    Explanation 2:
     There is no repeating element, output -1
    */

    public static int solve(ArrayList<Integer> A) {
        HashMap<Integer, Integer> freqHashMap = new HashMap<>();
        for (int i = 0; i < A.size(); i++) {
            if (freqHashMap.containsKey(A.get(i))) {
                freqHashMap.put(A.get(i), freqHashMap.get(A.get(i)) + 1);
            } else {
                freqHashMap.put(A.get(i), 1);
            }
        }
        for (int i = 0; i < A.size(); i++) {
            if (freqHashMap.get(A.get(i)) > 1) {
                return A.get(i);
            }
        }
        return -1;

        /* Scaler Solution
        HashMap<Integer, Integer> vis = new HashMap<Integer, Integer>();
        int ans = -1;
        for(int i = A.size()-1; i >= 0; --i){
            if(vis.containsKey(A.get(i))){
                ans = A.get(i);
            }
            else{
                vis.put(A.get(i), 1);
            }
        }
        return ans;
        */
    }

    public static void main(String[] args) {
        ArrayList<Integer> A = new ArrayList<>(Arrays.asList(10, 5, 3, 4, 3, 5, 6));
        System.out.println(solve(A));
    }
}
