package com.jsm.scaler.advance.Graphs;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class Construct_Roads_Bipartite {
    /*
    A country consist of N cities connected by N - 1 roads.
    King of that country want to construct maximum number of roads such that the new country formed remains bipartite country.

    Bipartite country is a country, whose cities can be partitioned into 2 sets in such a way,
    that for each road (u, v) that belongs to the country, u and v belong to different sets.
    Also, there should be no multiple roads between two cities and no self loops.

    Return the maximum number of roads king can construct. Since the answer could be large return answer % 10^9 + 7.

    NOTE: All cities can be visited from any city.

    Problem Constraints
    1 <= A <= 10^5
    1 <= B[i][0], B[i][1] <= N

    Input Format
    First argument is an integer A denoting the number of cities, N.
    Second argument is a 2D array B of size (N-1) x 2 denoting the initial roads i.e. there is a road between cities B[i][0] and B[1][1] .

    Output Format
    Return an integer denoting the maximum number of roads king can construct.

    Example Input:
    Input 1:
     A = 3
     B = [
           [1, 2]
           [1, 3]
         ]

    Input 2:
     A = 5
     B = [
           [1, 3]
           [1, 4]
           [3, 2]
           [3, 5]
         ]

    Example Output:
    Output 1:
     0

    Output 2:
     2

    Example Explanation:
    Explanation 1:
     We can't construct any new roads such that the country remains bipartite.

    Explanation 2:
     We can add two roads between cities (4, 2) and (4, 5).
    */

    private static long count_0 = 0, count_1 = 0;

    private static int solve(int A, int[][] B) {
        long mod = 1000000007;
        ArrayList<ArrayList<Integer>> adj = new ArrayList<>();
        for (int i = 0; i <= A; ++i) {
            adj.add(new ArrayList<>());
        }

        for (int i = 0; i < B.length; i++) {
            int u = B[i][0];
            int v = B[i][1];
            adj.get(u).add(v);
            adj.get(v).add(u);
        }
        bipartiteCountryBfs(1, adj, A);
        return (int) ((((count_0 % mod * count_1 % mod) % mod) - (A - 1) + mod) % mod);
    }

    private static void bipartiteCountryBfs(int src, ArrayList<ArrayList<Integer>> adj, int N) {
        Queue<Integer> q = new LinkedList<>();
        int[] color = new int[N + 1];
        for (int i = 0; i <= N; ++i) {
            color[i] = -1;
        }

        q.add(src);
        color[src] = 1;
        count_1++;
        while (!q.isEmpty()) {
            int u = q.poll();

            for (Integer it : adj.get(u)) {
                if (color[it] == -1) {
                    color[it] = 1 - color[u];
                    if (color[it] == 1) {
                        count_1++;
                    } else {
                        count_0++;
                    }
                    q.add(it);
                }
            }
        }
    }

    public static void main(String[] args) {
        int A = 15;
        int[][] B = {{7, 5},
                {15, 14},
                {11, 2},
                {8, 7},
                {10, 3},
                {5, 3},
                {4, 2},
                {6, 4},
                {13, 2},
                {3, 2},
                {14, 11},
                {12, 9},
                {2, 1},
                {9, 2}};
        System.out.println("The maximum number of roads king can construct: " + solve(A, B));
    }
}
