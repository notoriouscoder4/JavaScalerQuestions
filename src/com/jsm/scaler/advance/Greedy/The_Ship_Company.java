package com.jsm.scaler.advance.Greedy;

import java.util.Arrays;
import java.util.Collections;
import java.util.PriorityQueue;

public class The_Ship_Company {
    /*
    The local ship renting service has a special rate plan:

    It is up to a passenger to choose a ship.
    If the chosen ship has X (X > 0) vacant places at the given moment, then the ticket for such a ship costs X.
    The passengers buy tickets in turn, the first person in the queue goes first, then the second one, and so on up to A-th person.

    You need to tell the maximum and the minimum money that the ship company can earn if all A passengers buy tickets.

    Problem Constraints
    1 ≤ A ≤ 3000
    1 ≤ B ≤ 1000
    1 ≤ C[i] ≤ 1000
    It is guaranteed that there are at least A empty seats in total.

    Input Format
    First argument is an integer A denoting the number of passengers in the queue.
    Second argument is an integer B denoting the number of ships.
    Third argument is an integer array C of size B where C[i] denotes the number of empty seats in the i-th ship before the ticket office starts selling tickets.

    Output Format
    Return an array of size 2 denoting the maximum and minimum money that the ship company can earn.

    Example Input:
    Input 1:
     A = 4
     B = 3
     C = [2, 1, 1]

    Input 2:
     A = 4
     B = 3
     C = [2, 2, 2]

    Example Output:
    Output 1:
     [5, 5]

    Output 2:
     [7, 6]

    Example Explanation:
    Explanation 1:
     Maximum money can be earned if the passenger choose : 2(first ship) + 1(first ship) + 1(second ship) + 1(third ship).
     So, the cost will be 5.
     Minimum money can be earned if the passenger choose : 1(second ship) + 1(third ship) + 2(first ship) + 1(first ship).
     So, the cost will be 5.

    Explanation 2:
     Maximum money can be earned if the passenger choose : 2(first ship) + 2(second ship) + 2(third ship) + 1(first ship).
     So, the cost will be 7.
     Minimum money can be earned if the passenger choose : 2(first ship) + 1(first ship) + 2(second ship) + 1(second ship).
     So, the cost will be 6.
    */

    private static int[] solve(int A, int B, int[] C) {
        PriorityQueue<Integer> max_heap = new PriorityQueue<>(Collections.reverseOrder());
        PriorityQueue<Integer> min_heap = new PriorityQueue<>();

        for (int i = 0; i < B; ++i) {
            max_heap.add(C[i]);
            min_heap.add(C[i]);
        }

        int max_cost = 0;
        int temp = A;
        while (temp > 0) {
            int max = max_heap.poll();
            max_cost += max;
            if (max - 1 > 0)
                max_heap.add(max - 1);
            temp--;
        }

        int min_cost = 0;
        int temp_1 = A;
        while (temp_1 > 0) {
            int min = min_heap.poll();
            min_cost += min;
            if (min - 1 > 0)
                min_heap.add(min - 1);
            temp_1--;
        }

        int[] ans = new int[2];
        ans[0] = max_cost;
        ans[1] = min_cost;
        return ans;
    }

    public static void main(String[] args) {
        int A = 4;
        int B = 3;
        int[] C = {2, 2, 2};
        System.out.println(Arrays.toString(solve(A, B, C)));
    }
}
