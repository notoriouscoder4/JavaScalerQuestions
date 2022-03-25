package com.jsm.scaler.intermediate.Sorting;

import java.util.ArrayList;
import java.util.Collections;

public class NobleInteger {
    /*
    Given an integer array A, find if an integer p exists in the array such that the number of integers greater than p in the array equals p.

    Problem Constraints
    1 <= |A| <= 2*105
    1 <= A[i] <= 107

    Input Format
    First and only argument is an integer array A.

    Output Format
    Return 1 if any such integer p is present else, return -1.

    Example Input

    Input 1:
     A = [3, 2, 1, 3]

    Input 2:
     A = [1, 1, 3, 3]

    Example Output

    Output 1:
     1

    Output 2:
     -1

    Example Explanation

    Explanation 1:
     For integer 2, there are 2 greater elements in the array..

    Explanation 2:
     There exist no integer satisfying the required conditions.
    */
    public static int solve(ArrayList<Integer> A) {
        Collections.sort(A);
        int size = A.size();
        for (int i = 0; i < size; i++) {
            while (i + 1 < size && A.get(i) == A.get(i + 1))
                i++;
            if (A.get(i) == size - 1 - i)
                return 1;
        }
        return -1;
    }

    /* C++

    int Solution::solve(vector<int> &A) {
    sort(A.begin(), A.end());
    if (A[A.size() - 1] == 0)
        return 1;
    for (int i = 0; i < A.size(); i++) {
        if (A[i] != A[i + 1]) {
            int count = A.size() - i - 1;
            if (count == A[i])
                return 1;
        }
    }
    return -1;
    }
    */

    public static void main(String[] args) {

    }
}
