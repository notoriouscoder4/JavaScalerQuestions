package com.jsm.scaler.advance.TwoPointers;

import java.util.*;

public class ThreeSumZero {
    /*
    Given an array A of N integers, are there elements a, b, c in S such that a + b + c = 0
    Find all unique triplets in the array which gives the sum of zero.

    Note:
    Elements in a triplet (a,b,c) must be in non-descending order. (ie, a ≤ b ≤ c) The solution set must not contain duplicate triplets.

    Problem Constraints
    0 <= N <= 7000
    -10^8 <= A[i] <= 10^8

    Input Format
    Single argument representing a 1-D array A.

    Output Format
    Output a 2-D vector where each row represent a unique triplet.

    Example Input
    A = [-1,0,1,2,-1,4]

    Example Output
    [ [-1,0,1],
      [-1,-1,2] ]

    Example Explanation
    Out of all the possible triplets having total sum zero,only the above two triplets are unique.
    */

    private static ArrayList<ArrayList<Integer>> threeSumZero(ArrayList<Integer> A) {
        ArrayList<ArrayList<Integer>> res = new ArrayList<>();
        ArrayList<Integer> list = new ArrayList<>();

        Collections.sort(A);

        for (int low = 0; low < A.size() - 2; low++) {
            if (low == 0 || A.get(low).intValue() != A.get(low - 1).intValue()) { // if we find duplicates for a then we will ignore all duplicates and step forward

                int a = A.get(low);
                int mid = low + 1;
                int high = A.size() - 1;
                // sum = -a;
                int sum = -A.get(low);

                while (mid < high) {
                    int b = A.get(mid);
                    int c = A.get(high);
                    int pairSum = b + c;
                    // since, a + b + c = 0, so it can be like,
                    // b + c = -a
                    if (pairSum == sum) {
                        list.add(a);
                        list.add(b);
                        list.add(c);
                        res.add(new ArrayList<>(list));
                        list.clear();

                        // ignore duplicates from left side
                        while (mid < high && A.get(mid).intValue() == A.get(mid + 1).intValue())
                            mid++;

                        // ignore duplicates from right side
                        while (mid < high && A.get(high).intValue() == A.get(high - 1).intValue())
                            high--;
                        mid++;
                        high--;
                    } else if (pairSum < sum)
                        mid++;
                    else
                        high--;
                }
            }
        }
        return res;
    }

    public static void main(String[] args) {
        ArrayList<Integer> A = new ArrayList<>(Arrays.asList(1, -4, 0, 0, 5, -5, 1, 0, -2, 4, -4, 1, -1, -4, 3, 4, -1, -1, -3));
        // sorted A = {-5, -4, -4, -4, -3, -2, -1, -1, -1, 0, 0, 0, 1, 1, 1, 3, 4, 4, 5}
        // since we know that, a + b + c = 0, so what if I keep 'a' as constant so in that way I will get b + c = -a;
        // So I can find b and c using the two pointer technique, and I will get my triplets.
        // So 'a' will point to first element of sorted array i.e. a = A[0] and
        // low pointer will point to extreme left of sorted array i.e. low = i + 1, and
        // high pointer will point to extreme right of sorted array i.e. high = A.length - 1
        System.out.println(threeSumZero(A));
    }
}
