package com.jsm.scaler.advance.Arrays;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class RainWaterTrapped {
    /*
    Given a vector A of non-negative integers representing an elevation map where the width of each bar is 1,
    compute how much water it is able to trap after raining.

    Problem Constraints
    1 <= |A| <= 100000

    Input Format
    First and only argument is the vector A

    Output Format
    Return one integer, the answer to the question

    Example Input:
    Input 1:
    A = [0, 1, 0, 2]

    Input 2:
    A = [1, 2]

    Example Output:
    Output 1:
    1

    Output 2:
    0

    Example Explanation:
    Explanation 1:
    1 unit is trapped on top of the 3rd element.

    Explanation 2:
    No water is trapped.
    */

    private static int trap(final List<Integer> A) {
        // Two Pointers Approach
        int n = A.size();
        int left = 0, right = n - 1;
        int res = 0;
        int maxLeft = 0, maxRight = 0;
        while (left <= right) {
            if (A.get(left) <= A.get(right)) {
                if (A.get(left) >= maxLeft)
                    maxLeft = A.get(left);
                else
                    res += maxLeft - A.get(left);
                left++;
            } else {
                if (A.get(right) >= maxRight)
                    maxRight = A.get(right);
                else
                    res += maxRight - A.get(right);
                right--;
            }
        }
        return res;
    }

    public static void main(String[] args) {
        List<Integer> A = new ArrayList<>(Arrays.asList(0, 1, 0, 2));
        System.out.println(trap(A));
    }
}
