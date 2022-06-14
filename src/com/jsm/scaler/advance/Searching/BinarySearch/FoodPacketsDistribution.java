package com.jsm.scaler.advance.Searching.BinarySearch;

public class FoodPacketsDistribution {
    /*
    The government wants to set up B distribution offices across N cities for the distribution of food packets.
    The population of the ith city is A[i]. Each city must have at least 1 office, and people can go to an office of their own city.
    We want to maximize the minimum number of people who can get food in any single office.

    Problem Constraints
    1 <= N <= 10^5
    1 <= A[i] <= 10^6
    1 <= B <= 5 x 10^5

    Input Format
    The first line of input contains an integer array A.
    The second line of input contains an integer B.

    Output Format
    Return one integer representing the maximum number of people who can get food in any single office.

    Example Input:
    Input 1:
      A = [10000, 20000, 30000]
      B = 6

    Input 2:
      A = [1, 1, 1]
      B = 4

    Example Output:
    Output 1:
      10000

    Output 2:
      0

    Example Explanation:
    Explanation 1:
      1 office can be opened in the first city,
      2 offices in the second city and
      3 in the third. This way ,
      10,000 people can get food in the office in the first city, and
      10,000 people can get food in each office in the second city and
      10,000 people can get food in third city.
      We will allot 10000 people in each office in the third city.
      Had we allotted more in some office, we had to allot lesser in some other office which will reduce the answer.

    Explanation 2:
      We will have to allot 2 offices to one city. And one of these offices would give food to 0 people.
    */

    private static int solve(int[] A, int B) {
        int low = 0;
        int high = Integer.MAX_VALUE;
        for (int num : A)
            high = Math.min(high, num);
        int ans = -1;
        while (low <= high) {
            int mid = low + (high - low) / 2;
            if (isMinimum(A, B, mid)) {
                ans = mid;
                low = mid + 1;
            } else
                high = mid - 1;
        }
        if (ans == -1)
            return 0;
        return ans;
    }

    private static boolean isMinimum(int[] A, int B, int mid) {
        int sum = 0;
        for (int num : A) {
            if (mid == 0)
                sum += num;
            else
                sum += (num / mid);
        }
        return sum >= B;
    }

    public static void main(String[] args) {
        int[] A = {10000, 20000, 30000};
        int B = 6;
        System.out.println(solve(A, B));
    }
}
