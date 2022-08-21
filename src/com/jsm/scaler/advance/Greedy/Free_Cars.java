package com.jsm.scaler.advance.Greedy;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;

public class Free_Cars {
    /*
    Given two arrays, A and B of size N. A[i] represents the time by which you can buy the ith car without paying any money.
    B[i] represents the profit you can earn by buying the ith car. It takes 1 minute to buy a car, so you can only buy the ith car when the current time <= A[i] - 1.
    Your task is to find the maximum profit one can earn by buying cars considering that you can only buy one car at a time.

    NOTE:
    You can start buying from time = 0.
    Return your answer modulo 10^9 + 7.

    Problem Constraints
    1 <= N <= 10^5
    1 <= A[i] <= 10^9
    0 <= B[i] <= 10^9

    Input Format
    The first argument is an integer array A represents the deadline for buying the cars.
    The second argument is an integer array B represents the profit obtained after buying the cars.

    Output Format
    Return an integer denoting the maximum profit you can earn.

    Example Input:
    Input 1:
     A = [1, 3, 2, 3, 3]
     B = [5, 6, 1, 3, 9]

    Input 2:
     A = [3, 8, 7, 5]
     B = [3, 1, 7, 19]

    Example Output:
    Output 1:
     20

    Output 2:
     30

    Example Explanation:
    Explanation 1:
     At time 0, buy car with profit 5.
     At time 1, buy car with profit 6.
     At time 2, buy car with profit 9.
     At time = 3 or after , you can't buy any car, as there is no car with deadline >= 4.
     So, total profit that one can earn is 20.

    Explanation 2:
     At time 0, buy car with profit 3.
     At time 1, buy car with profit 1.
     At time 2, buy car with profit 7.
     At time 3, buy car with profit 19.
     We are able to buy all cars within their deadline. So, total profit that one can earn is 30.
    */

    private static class Deal {
        public int deadline;
        public int profit;

        public Deal(int deadline, int profit) {
            this.deadline = deadline;
            this.profit = profit;
        }
    }

    private static class CustomComparator implements Comparator<Deal> {
        @Override
        public int compare(Deal a, Deal b) {
            return a.deadline - b.deadline;
        }
    }

    private static int solve(ArrayList<Integer> A, ArrayList<Integer> B) {
        ArrayList<Deal> deals = new ArrayList<>(A.size());
        int mod = 1000000007;

        for (int i = 0; i < A.size(); ++i)
            deals.add(new Deal(A.get(i), B.get(i)));
        deals.sort(new CustomComparator());

        PriorityQueue<Integer> min_heap = new PriorityQueue<>();
        long ans = 0;
        int t = 0;

        for (int i = 0; i < deals.size(); ++i) {
            if (t < deals.get(i).deadline) {
                t++;
                min_heap.add(deals.get(i).profit);
                ans += deals.get(i).profit;
                ans %= mod;
            } else {
                if (deals.get(i).profit > min_heap.peek()) {
                    int min = min_heap.poll();
                    ans -= min;
                    ans %= mod;
                    min_heap.add(deals.get(i).profit);
                    ans += deals.get(i).profit;
                    ans %= mod;
                }
            }
        }
        return (int) (ans % mod);
    }

    public static void main(String[] args) {
        ArrayList<Integer> A = new ArrayList<>(Arrays.asList(1, 3, 2, 3, 3));
        ArrayList<Integer> B = new ArrayList<>(Arrays.asList(5, 6, 1, 3, 9));

        System.out.println(solve(A, B));
    }
}
