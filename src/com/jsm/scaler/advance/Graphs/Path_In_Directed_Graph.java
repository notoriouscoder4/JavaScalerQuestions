package com.jsm.scaler.advance.Graphs;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class Path_In_Directed_Graph {
    /*
    Given a directed graph having A nodes labelled from 1 to A containing M edges given by matrix B of size M x 2, such that there is an edge directed from node
    B[i][0] to node B[i][1].

    Find whether a path exists from node 1 to node A.
    Return 1 if path exists else return 0.

    NOTE:
    1. There are no self-loops in the graph.
    2. There are no multiple edges between two nodes.
    3. The graph may or may not be connected.
    4. Nodes are numbered from 1 to A.
    5. Your solution will run on multiple test cases. If you are using global variables make sure to clear them.

    Problem Constraints
    2 <= A <= 10^5
    1 <= M <= min(200000,A*(A-1))
    1 <= B[i][0], B[i][1] <= A

    Input Format:
    The first argument given is an integer A representing the number of nodes in the graph.
    The second argument given a matrix B of size M x 2 which represents the M edges such that there is an edge directed from node B[i][0] to node B[i][1].

    Output Format:
    Return 1 if path exists between node 1 to node A else return 0.

    Example Input:
    Input 1:
     A = 5
     B = [  [1, 2]
            [4, 1]
            [2, 4]
            [3, 4]
            [5, 2]
            [1, 3] ]

    Input 2:
     A = 5
     B = [  [1, 2]
            [2, 3]
            [3, 4]
            [4, 5] ]

    Example Output:
    Output 1:
     0

    Output 2:
     1

    Example Explanation:
    Explanation 1:
     The given doesn't contain any path from node 1 to node 5, so we will return 0.

    Explanation 2:
     Path from node1 to node 5 is ( 1 -> 2 -> 3 -> 4 -> 5 ) so we will return 1.
    */

    private static int solve(int A, int[][] B) {
        return pathExist(A, B, A) ? 1 : 0;
    }

    // BFS Solution
    private static boolean pathExist(int N, int[][] B, int dest) {
        ArrayList<ArrayList<Integer>> g = new ArrayList<>(N + 1);
        for (int i = 0; i <= N; ++i) {
            g.add(new ArrayList<>());
        }
        for (int[] edge : B) {
            g.get(edge[0]).add(edge[1]);
        }
        Queue<Integer> q = new LinkedList<>();
        q.add(1);
        boolean[] vis = new boolean[N + 1];
        vis[1] = true;
        while (!q.isEmpty()) {
            int cu = q.peek();
            q.poll();
            for (int i = 0; i < g.get(cu).size(); ++i) {
                int neighbour = g.get(cu).get(i);
                if (neighbour == dest)
                    return true;
                if (!vis[neighbour]) {
                    q.add(neighbour);
                    vis[neighbour] = true;
                }
            }
        }
        return false;
    }

    public static void main(String[] args) {
        int A = 5;
        int[][] B = {{1, 2}, {2, 3}, {3, 4}, {4, 5}};

        System.out.println("Does path exist from 1 to A: " + solve(A, B));
    }
}
