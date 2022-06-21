package com.jsm.scaler.advance.TwoPointers;

public class ContainerWithMostWater {
    /*
    Given n non-negative integers A[0], A[1], ..., A[n-1] , where each represents a point at coordinate (i, A[i]).
    N vertical lines are drawn such that the two endpoints of line ith is at (i, A[i]) and (i, 0).
    Find two lines, which together with x-axis forms a container, such that the container contains the most water.

    Note: You may not slant the container.

    Problem Constraints
    0 <= N <= 10^5
    1 <= A[i] <= 10^5

    Input Format
    Single Argument representing a 1-D array A.

    Output Format
    Return single Integer denoting the maximum area you can obtain.

    Example Input:
    Input 1:
    A = [1, 5, 4, 3]

    Input 2:
    A = [1]

    Example Output:
    Output 1:
     6
    Output 2:
     0

    Example Explanation:
    Explanation 1:
    5 and 3 are distance 2 apart. So size of the base = 2. Height of container = min(5, 3) = 3.
    So total area = 3 * 2 = 6

    Explanation 2:
    No container is formed.
    */

    private static int maxArea(int[] A) {
        int p1 = 0;
        int p2 = A.length - 1;
        int maxArea = 0;
        while (p1 < p2) {
            int height = Math.min(A[p1], A[p2]);
            int width = p2 - p1;
            int area = height * width;
            maxArea = Math.max(maxArea, area);
            if (A[p1] < A[p2])
                p1++;
            else if (A[p1] == A[p2])
                p1++;
            else
                p2--;
        }
        return maxArea;
    }

    public static void main(String[] args) {
        int[] A = {3, 5, 4, 7, 3, 6, 5, 4, 1, 2};
        System.out.println(maxArea(A));
    }
}
