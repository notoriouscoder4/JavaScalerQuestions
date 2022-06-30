package com.jsm.scaler.advance.Hashing;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;

public class CommonElements {
    /*
    Given two integer arrays, A and B of size N and M, respectively. Your task is to find all the common elements in both the array.

    NOTE:
    Each element in the result should appear as many times as it appears in both arrays.
    The result can be in any order.

    Problem Constraints
    1 <= N, M <= 10^5
    1 <= A[i] <= 10^9

    Input Format
    First argument is an integer array A of size N.
    Second argument is an integer array B of size M.

    Output Format
    Return an integer array denoting the common elements.

    Example Input:
    Input 1:
     A = [1, 2, 2, 1]
     B = [2, 3, 1, 2]

    Input 2:
     A = [2, 1, 4, 10]
     B = [3, 6, 2, 10, 10]

    Example Output:
    Output 1:
     [1, 2, 2]

    Output 2:
     [2, 10]

    Example Explanation:
    Explanation 1:
     Elements (1, 2, 2) appears in both the array. Note 2 appears twice in both the array.

    Explanation 2:
     Elements (2, 10) appears in both the array.
    */

    private static int[] commonElements(int[] A, int[] B) {
        // TC: O(N), SC: O(N)
        HashMap<Integer, Integer> mapA = new HashMap<>();
        ArrayList<Integer> list = new ArrayList<>();

        // counting elements present in array A using HashMap.
        for (int a : A) {
            if (mapA.containsKey(a))
                mapA.put(a, mapA.getOrDefault(a, 0) + 1);
            else
                mapA.put(a, 1);
        }

        // finding common elements from B array.
        for (int b : B) {
            if (mapA.containsKey(b) && mapA.get(b) != 0) {
                list.add(b);
                mapA.put(b, mapA.get(b) - 1); // decrease freq of elements which are present in B
            }
        }

        // returning array
        int[] ans = new int[list.size()];
        for (int i = 0; i < list.size(); i++) {
            ans[i] = list.get(i);
        }
        return ans;
    }

    public static void main(String[] args) {
        int[] A = {2, 1, 4, 10};
        int[] B = {3, 6, 2, 10, 10};
        System.out.println(Arrays.toString(commonElements(A, B)));
    }
}
