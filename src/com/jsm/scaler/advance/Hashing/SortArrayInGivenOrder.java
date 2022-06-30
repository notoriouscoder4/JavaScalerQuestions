package com.jsm.scaler.advance.Hashing;

import java.util.Map;
import java.util.TreeMap;

public class SortArrayInGivenOrder {
    /*
    Given two arrays of integers A and B, Sort A in such a way that the relative order among the elements will be the same as those are in B.
    For the elements not present in B, append them at last in sorted order.

    Return the array A after sorting from the above method.

    NOTE: Elements of B are unique.

    Problem Constraints
    1 <= length of the array A <= 100000
    1 <= length of the array B <= 100000
    -10^9 <= A[i] <= 10^9

    Input Format
    The first argument given is the integer array A.
    The second argument given is the integer array B.

    Output Format
    Return the array A after sorting as described.

    Example Input:
    Input 1:
    A = [1, 2, 3, 4, 5]
    B = [5, 4, 2]

    Input 2:
    A = [5, 17, 100, 11]
    B = [1, 100]

    Example Output:
    Output 1:
    [5, 4, 2, 1, 3]

    Output 2:
    [100, 5, 11, 17]

    Example Explanation:
    Explanation 1:
     Simply sort as described.

    Explanation 2:
     Simply sort as described.
    */

    private static int[] solve(int[] A, int[] B) {

        Map<Integer, Integer> freq = new TreeMap<>();

        // 1. add freq to map
        for (int a : A) {
            freq.put(a, freq.getOrDefault(a, 0) + 1);
        }

        /* 2. iterated array B and look for elem present in B and add them accordingly
         to sorted_A as per elem freq in A
        */

        int j = 0;
        for (int b : B) {
            if (freq.containsKey(b)) {
                int noOfElem = freq.get(b);
                while (noOfElem > 0) {
                    A[j++] = b;
                    noOfElem--;
                }
                freq.remove(b);
            }
        }

        /* 3. Add remaining elem in A at the end after sorted elem as is */
        for (Integer key : freq.keySet()) {
            if (freq.containsKey(key)) {
                int noOfElem = freq.get(key);
                while (noOfElem > 0) {
                    A[j++] = key;
                    noOfElem--;
                }
            }
        }
        return A;
    }
}
