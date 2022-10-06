package com.jsm.scaler.advance.Graphs;

import java.util.ArrayList;
import java.util.Arrays;

public class Cycle_Undirected_Graph_DFS {
    /*
    Given an undirected graph having A nodes labelled from 1 to A with M edges given in a form of matrix B of size M x 2
    where (B[i][0], B[i][1]) represents two nodes B[i][0] and B[i][1] connected by an edge.
    Find whether the graph contains a cycle or not, return 1 if cycle is present else return 0.

    NOTE:
    1. The cycle must contain at least three nodes.
    2. There are no self-loops in the graph.
    3. There are no multiple edges between two nodes.
    4. The graph may or may not be connected.
    5. Nodes are numbered from 1 to A.
    Your solution will run on multiple test cases. If you are using global variables make sure to clear them.

    Problem Constraints
    1 <= A, M <= 3*10^5
    1 <= B[i][0], B[i][1] <= A

    Input Format
    The first argument given is an integer A representing the number of nodes in the graph.
    The second argument given is a matrix B of size M x 2 which represents the M edges such that there is an edge between node B[i][0] and node B[i][1].

    Output Format
    Return 1 if cycle is present else return 0.

    Example Input:
    Input 1:
     A = 5
     B = [  [1, 2]
            [1, 3]
            [2, 3]
            [1, 4]
            [4, 5]
         ]

    Input 2:
     A = 3
     B = [  [1, 2]
            [1, 3]
         ]

    Example Output:
    Output 1:
     1

    Output 2:
     0

    Example Explanation:
    Explanation 1:
     There is a cycle in the graph i.e 1 -> 2 -> 3 -> 1 so we will return 1

    Explanation 2:
     No cycle present in the graph, so we will return 0.
    */

    private static int solve(int A, int[][] B) {
        ArrayList<ArrayList<Integer>> adj = new ArrayList<>(A + 1);
        boolean[] vis = new boolean[A + 1];
        Arrays.fill(vis, false);

        for (int i = 0; i <= A; ++i) {
            adj.add(new ArrayList<>());
        }

        for (int[] ints : B) {
            int u = ints[0];
            int v = ints[1];
            adj.get(u).add(v);
            adj.get(v).add(u);
        }

        return isCycle(A, adj, vis) ? 1 : 0;
    }

    private static boolean isCycle(int V, ArrayList<ArrayList<Integer>> adj, boolean[] vis) {
        for (int i = 1; i <= V; ++i) {
            if (!vis[i]) {
                if (checkForCycle_DFS(i, -1, adj, vis)) {
                    return true;
                }
            }
        }
        return false;
    }

    private static boolean checkForCycle_DFS(int node, int parent, ArrayList<ArrayList<Integer>> adj, boolean[] vis) {
        vis[node] = true;
        for (Integer it : adj.get(node)) {
            if (!vis[it]) {
                if (checkForCycle_DFS(it, node, adj, vis)) {
                    return true;
                }
            } else if (it != parent) {
                return true;
            }
        }
        return false;
    }

    public static void main(String[] args) {
        int A = 5;
        int[][] B = {{1, 2}, {1, 3}, {2, 3}, {1, 4}, {1, 5}};
        System.out.println("The Undirected Graph has Cycle using DFS: " + solve(A, B));
    }
}
