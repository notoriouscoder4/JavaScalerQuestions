package com.jsm.scaler.advance.Graphs;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class Bipartite_Graph_BFS {
    /*
    Given an undirected graph having A nodes. A matrix B of size M x 2 is given which represents the edges such that there is an edge between B[i][0] and B[i][1].
    Find whether the given graph is bipartite or not.
    A graph is bipartite if we can split it's set of nodes into two independent subsets A and B such that every edge in the graph has one node in A and another node in B

    Note:
    There are no self-loops in the graph.
    No multiple edges between two pair of vertices.
    The graph may or may not be connected.
    Nodes are Numbered from 0 to A-1.
    Your solution will run on multiple testcases. If you are using global variables make sure to clear them.

    Problem Constraints
    1 <= A <= 100000
    1 <= M <= min(A*(A-1)/2,200000)
    0 <= B[i][0],B[i][1] < A

    Input Format
    The first argument given is an integer A.
    The second argument given is the matrix B.

    Output Format
    Return 1 if the given graph is bipartite else return 0.

    Example Input:
    Input 1:
    A = 2
    B = [ [0, 1] ]

    Input 2:
    A = 3
    B = [ [0, 1], [0, 2], [1, 2] ]

    Example Output:
    Output 1:
    1

    Output 2:
    0

    Example Explanation:
    Explanation 1:
    Put 0 and 1 into 2 different subsets.

    Explanation 2:
    It is impossible to break the graph down to make two different subsets for bipartite matching
    */

    private static int solve(int A, int[][] B) {
        ArrayList<ArrayList<Integer>> adj = new ArrayList<>(A);
        for (int i = 0; i < A; ++i) {
            adj.add(new ArrayList<>());
        }
        for (int[] ints : B) {
            int u = ints[0];
            int v = ints[1];
            adj.get(u).add(v);
            adj.get(v).add(u);
        }
        return checkBipartite(adj, A) ? 1 : 0;
    }

    private static boolean checkBipartite(ArrayList<ArrayList<Integer>> adj, int n) {
        int[] color = new int[n];
        for (int i = 0; i < n; ++i) {
            color[i] = -1;
        }
        for (int i = 0; i < n; ++i) {
            if (color[i] == -1) {
                if (!bfsCheck(adj, i, color)) {
                    return false;
                }
            }
        }
        return true;
    }

    private static boolean bfsCheck(ArrayList<ArrayList<Integer>> adj, int node, int[] color) {
        Queue<Integer> q = new LinkedList<>();
        q.add(node);
        color[node] = 1;
        while (!q.isEmpty()) {
            Integer n = q.peek();
            q.poll();

            for (Integer it : adj.get(n)) {
                if (color[it] == -1) {
                    color[it] = 1 - color[n];
                    q.add(it);
                } else if (color[it] == color[n]) {
                    return false;
                }
            }
        }
        return true;
    }

    public static void main(String[] args) {
        int A = 3;
        int[][] B = {{0, 1}, {0, 2}, {1, 2}};

        System.out.println(solve(A, B));
    }
}
