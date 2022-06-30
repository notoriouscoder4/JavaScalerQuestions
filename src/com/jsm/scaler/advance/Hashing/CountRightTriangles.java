package com.jsm.scaler.advance.Hashing;

import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class CountRightTriangles {
    /*
    Given two arrays of integers A and B of size N each, where each pair (A[i], B[i]) for 0 <= i < N
    represents a unique point (x, y) in 2D Cartesian plane.

    Find and return the number of unordered triplets (i, j, k) such that (A[i], B[i]), (A[j], B[j]) and (A[k], B[k])
    form a right-angled triangle with the triangle having one side parallel to the x-axis and one side parallel to the y-axis.

    NOTE: The answer may be large so return the answer modulo (10^9 + 7).

    Problem Constraints
    1 <= N <= 10^5
    0 <= A[i], B[i] <= 10^9

    Input Format
    The first argument given is an integer array A.
    The second argument given is the integer array B.

    Output Format
    Return the number of unordered triplets that form a right-angled triangle modulo (109 + 7).

    Example Input:
    Input 1:
     A = [1, 1, 2]
     B = [1, 2, 1]

    Input 2:
     A = [1, 1, 2, 3, 3]
     B = [1, 2, 1, 2, 1]

    Example Output:
    Output 1:
     1

    Output 2:
     6

    Example Explanation:
    Explanation 1:
     All three points make a right-angled triangle. So return 1.

    Explanation 2:
     6 triplets which make a right-angled triangle are:    (1, 1), (1, 2), (2, 2)
                                                           (1, 1), (3, 1), (1, 2)
                                                           (1, 1), (3, 1), (3, 2)
                                                           (2, 1), (3, 1), (3, 2)
                                                           (1, 1), (1, 2), (3, 2)
                                                           (1, 2), (3, 1), (3, 2)
    */

    private static int countRightTriangles(int[] A, int[] B) {
        int mod = 1000000007;
        HashMap<Integer, Integer> mapX = new HashMap<>();
        HashMap<Integer, Integer> mapY = new HashMap<>();
        for (int i = 0; i < A.length; i++) {
            mapX.put(A[i], mapX.getOrDefault(A[i], 0) + 1);
            mapY.put(B[i], mapY.getOrDefault(B[i], 0) + 1);
        }

        int count = 0;
        for (int i = 0; i < B.length; i++) {
            // count = (n - 1) * (m - 1)
            // where n is freq of x-co-ordinate in (x,y) in mapX
            // where m is freq of y-co-ordinate in (x,y) in mapY
            count = (int) ((count + ((long) (mapX.get(A[i]) - 1) * (mapY.get(B[i]) - 1)) % mod) % mod);
        }
        return count;
    }

    public static void main(String[] args) {
        int[] A = {1, 1, 2, 3, 3};
        int[] B = {1, 2, 1, 2, 1};
        System.out.println(countRightTriangles(A, B));
    }
}
