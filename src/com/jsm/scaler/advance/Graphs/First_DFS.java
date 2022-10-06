package com.jsm.scaler.advance.Graphs;

import java.util.ArrayList;

public class First_DFS {
    /*
    You are given N towns (1 to N). All towns are connected via unique directed path as mentioned in the input.
    Given 2 towns find whether you can reach the first town from the second without repeating any edge.

    B C : query to find whether B is reachable from C.

    Input contains an integer array A of size N and 2 integers B and C ( 1 <= B, C <= N ).
    There exist a directed edge from A[i] to i+1 for every 1 <= i < N. Also, it's guaranteed that A[i] <= i for every 1 <= i < N.

    NOTE: Array A is 0-indexed. A[0] = 1 which you can ignore as it doesn't represent any edge.

    Problem Constraints
    1 <= N <= 100000

    Input Format
    First argument is vector A
    Second argument is integer B
    Third argument is integer C

    Output Format
    Return 1 if reachable, 0 otherwise.

    Example Input:
    Input 1:
     A = [1, 1, 2]
     B = 1
     C = 2

    Input 2:
     A = [1, 1, 2]
     B = 2
     C = 1

    Example Output:
    Output 1:
     0

    Output 2:
     1

    Example Explanation:
    Explanation 1:
     Tree is 1--> 2--> 3 and hence 1 is not reachable from 2.

    Explanation 2:
     Tree is 1--> 2--> 3 and hence 2 is reachable from 1.
    */

    private static int solve(int[] A, final int B, final int C) {
        return isPath(A, C, B) ? 1 : 0;
    }

    private static boolean isPath(int[] A, int src, int dest) {
        int N = A.length;
        ArrayList<ArrayList<Integer>> g = new ArrayList<>(N + 1);
        boolean[] vis = new boolean[N + 1];
        for (int i = 0; i <= N; ++i) {
            g.add(new ArrayList<>());
        }

        for (int i = 1; i < N; ++i) {
            g.get(A[i]).add(i + 1);
        }

        dfs(g, vis, src);
        return vis[dest];
    }

    private static void dfs(ArrayList<ArrayList<Integer>> g, boolean[] vis, int src) {
        if (vis[src])
            return;
        vis[src] = true;
        for (int i = 0; i < g.get(src).size(); ++i) {
            int v = g.get(src).get(i);
            dfs(g, vis, v);
        }
    }

    public static void main(String[] args) {
        int[] A = {1, 1, 2};
        int B = 2;
        int C = 1;
        System.out.println(solve(A, B, C));
    }
}
