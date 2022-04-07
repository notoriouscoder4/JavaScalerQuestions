package com.jsm.scaler.intermediate.Hashing;

import java.util.*;

public class CommonElements {
    /*
    Given two integer arrays, A and B of size N and M, respectively. Your task is to find all the common elements in both the array.
    NOTE: Each element in the result should appear as many times as it appears in both arrays. The result can be in any order.

    Problem Constraints
    1 <= N, M <= 105
    1 <= A[i] <= 109

    Input Format
    First argument is an integer array A of size N.
    Second argument is an integer array B of size M.

    Output Format
    Return an integer array denoting the common elements.

    Example Input

    Input 1:
     A = [1, 2, 2, 1]
     B = [2, 3, 1, 2]

    Input 2:
     A = [2, 1, 4, 10]
     B = [3, 6, 2, 10, 10]

    Example Output

    Output 1:
     [1, 2, 2]

    Output 2:
     [2, 10]

    Example Explanation

    Explanation 1:
     Elements (1, 2, 2) appears in both the array. Note 2 appears twice in both the array.

    Explanation 2:
     Elements (2, 10) appears in both the array.
    */

    public static ArrayList<Integer> solve(ArrayList<Integer> A, ArrayList<Integer> B) {
        ArrayList<Integer> result = new ArrayList<>();

        if (A.size() > 0 && B.size() > 0) {
            Map<Integer, Integer> a = new HashMap();
            for (int i = 0; i < A.size(); i++) {
                a.put(A.get(i), a.getOrDefault(A.get(i), 0) + 1);
            }

            for (int j = 0; j < B.size(); j++) {
                if (a.containsKey(B.get(j)) && a.get(B.get(j)) > 0) {
                    result.add(B.get(j));
                    a.put(B.get(j), a.get(B.get(j)) - 1);
                }
            }
        }
        return result;

        /* Scaler Solution

        HashMap<Integer, Integer> a = new HashMap<Integer, Integer>();
        HashMap<Integer, Integer> b = new HashMap<Integer, Integer>();
        for(int x: A){
            a.put(x, a.getOrDefault(x, 0)+1);
        }
        for(int x: B){
            b.put(x, b.getOrDefault(x, 0)+1);
        }
        ArrayList<Integer> ans = new ArrayList<Integer>();
        for(int k: a.keySet()){
            if(b.containsKey(k)){
                for(int i = 0; i < Math.min(a.get(k), b.get(k)); ++i){
                    ans.add(k);
                }
            }
        }
        return ans;
        */
    }

    public static void main(String[] args) {
        ArrayList<Integer> A = new ArrayList<>(Arrays.asList(2, 1, 4, 10));
        ArrayList<Integer> B = new ArrayList<>(Arrays.asList(3, 6, 2, 10, 10));
        System.out.println(solve(A, B));
    }
}
