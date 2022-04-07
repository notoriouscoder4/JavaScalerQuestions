package com.jsm.scaler.intermediate.Hashing;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class PairsWithGivenXor {
    /*
    Given an integer array A containing N distinct integers.
    Find the number of unique pairs of integers in the array whose XOR is equal to B.
    NOTE:
    Pair (a, b) and (b, a) is considered to be the same and should be counted once.

    Problem Constraints
    1 <= N <= 105
    1 <= A[i], B <= 107

    Input Format
    The first argument is an integer array A.
    The second argument is an integer B.

    Output Format
    Return a single integer denoting the number of unique pairs of integers in the array A whose XOR is equal to B.

    Example Input

    Input 1:
     A = [5, 4, 10, 15, 7, 6]
     B = 5

    Input 2:
     A = [3, 6, 8, 10, 15, 50]
     B = 5

    Example Output

    Output 1:
     1

    Output 2:
     2

    Example Explanation

    Explanation 1:
     (10 ^ 15) = 5

    Explanation 2:
     (3 ^ 6) = 5 and (10 ^ 15) = 5
    */

    public static int solve(ArrayList<Integer> A, int B) {
        Map<Integer, Integer> map = new HashMap<>(A.size());
        int ans = 0;
        for (int i = 0; i < A.size(); i++) {
            int j = A.get(i);
            int k = A.get(i) ^ B;
            if (map.containsKey(k)) {
                ans++;
            } else {
                map.put(j, i);
            }
        }
        return ans;

        /* Scaler Solution
        HashMap<Integer, Integer> mp = new HashMap<Integer, Integer>();
        int ans = 0;
        for(int x: A){
            if(mp.containsKey(x^B)){
                ++ans;
            }
            mp.put(x, 1);
        }
        return ans;
        */
    }

    public static void main(String[] args) {
        ArrayList<Integer> A = new ArrayList<>(Arrays.asList(3, 6, 8, 10, 15, 50));
        int B = 5;
        System.out.println(solve(A, B));
    }
}
