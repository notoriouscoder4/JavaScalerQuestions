package com.jsm.scaler.advance.Greedy;

public class Distribute_Candy {
    /*
    N children are standing in a line. Each child is assigned a rating value.
    You are giving candies to these children subjected to the following requirements:

    Each child must have at least one candy.
    Children with a higher rating get more candies than their neighbors.
    What is the minimum number of candies you must give?

    Problem Constraints
    1 <= N <= 10^5
    -10^9 <= A[i] <= 10^9

    Input Format
    The first and only argument is an integer array A representing the rating of children.

    Output Format
    Return an integer representing the minimum candies to be given.

    Example Input:
    Input 1:
     A = [1, 2]

    Input 2:
     A = [1, 5, 2, 1]

    Example Output:
    Output 1:
     3

    Output 2:
     7

    Example Explanation:
    Explanation 1:
     The candidate with 1 rating gets 1 candy and candidate with rating 2 cannot get 1 candy as 1 is its neighbor.
     So rating 2 candidate gets 2 candies. In total, 2 + 1 = 3 candies need to be given out.

    Explanation 2:
     Candies given = [1, 3, 2, 1]
    */

    /*
    This problem can be solved using the fact that candy distribution is based on the fact that,
    we should see for both left and right neighbor in order to calculate minimum number of candies given to each candidate.
    For left neighbor, A[i] > A[i-1] => C[i] = C[i-1]+1, else C[i] = 1, for this we will iterate from left to right.
    For right neighbor, A[i] > A[i+1] => C[i] = C[i+1]+1, else C[i] = 1, for this we will iterate from right to left.
    And, finally we need to merge both left and right result, and get max from both of them to add that into the ans.
    */
    private static int candy(int[] A) {
        int n = A.length;
        int ans = 0;

        /*
        Assign candies based on left neighbor ratings.
        Distribution based on left neighbor
        */
        int[] candyLeft = new int[n];
        candyLeft[0] = 1;

        /*
        Assign candies based on right neighbor ratings
        Distribution based on right neighbor
        */
        int[] candyRight = new int[n];
        candyRight[n - 1] = 1;

        for (int i = 1; i < n; ++i) {
            if (A[i] > A[i - 1]) {
                candyLeft[i] = candyLeft[i - 1] + 1;
            } else {
                candyLeft[i] = 1;
            }
        }

        for (int i = n - 2; i >= 0; --i) {
            if (A[i] > A[i + 1]) {
                candyRight[i] = candyRight[i + 1] + 1;
            } else {
                candyRight[i] = 1;
            }
        }

        /*
        After creating arrays candyLeft and candyRight, we need to merge them into single candy array.
        After that we need to iterate through candy array to find max from arrays candyLeft and candyRight.
        So, instead creating candy array we can directly find max of arrays candyLeft and candyRight and add the max to ans.
        */
        for (int i = 0; i < n; ++i) {
            ans = ans + (Math.max(candyLeft[i], candyRight[i]));
        }
        return ans;
    }

    public static void main(String[] args) {
        int[] A = {3, 4, 1, 5, 2, 1, 7, 2};
        System.out.println("The minimum number of candies: " + candy(A));
    }
}
