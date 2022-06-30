package com.jsm.scaler.advance.Hashing;

import java.util.HashSet;
import java.util.Set;

public class LongestConsecutiveSequence {
    /*
    Given an unsorted integer array A of size N.
    Find the length of the longest set of consecutive elements from array A.

    Problem Constraints
    1 <= N <= 10^6
    -10^6 <= A[i] <= 10^6

    Input Format
    First argument is an integer array A of size N.

    Output Format
    Return an integer denoting the length of the longest set of consecutive elements from the array A.

    Example Input:
    Input 1:
    A = [100, 4, 200, 1, 3, 2]

    Input 2:
    A = [2, 1]

    Example Output
    Output 1:
     4

    Output 2:
     2

    Example Explanation:
    Explanation 1:
     The set of consecutive elements will be [1, 2, 3, 4].

    Explanation 2:
     The set of consecutive elements will be [1, 2].
    */

    private static int longestConsecutive(final int[] A) {
        Set<Integer> integerSet = new HashSet<>();
        for (int a : A)
            integerSet.add(a);

        int longestSequence = Integer.MIN_VALUE;
        // iterating through set to decrease redundant iterations because
        // Ex: A = {6,6,6,6,6,6,7,8,9,10,11}, for this type of case, we will use iterations more than 2N
        for (int i = 0; i < integerSet.size(); i++) {
            // For any A[i], if A[i] - 1 is present in the set then there is no need to check for A[i]
            // because the larger sequence will start from A[i] - 1.
            int length = 1; // local variable to check length of the longest sequence
            // nextElement is to check if a sequence is present or not
            int nextElement = A[i] + 1;
            if (!integerSet.contains(A[i] - 1)) {
                while (integerSet.contains(nextElement)) {
                    length++;
                    nextElement++;
                }
            }
            longestSequence = Math.max(longestSequence, length);
        }
        return longestSequence;
    }

    public static void main(String[] args) {
        int[] A = {0, 0, -1};
        System.out.println(longestConsecutive(A));
    }
}
