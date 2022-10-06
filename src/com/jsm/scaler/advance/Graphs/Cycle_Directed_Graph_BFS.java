package com.jsm.scaler.advance.Graphs;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class Cycle_Directed_Graph_BFS {
    /*
    Given a directed graph having A nodes.
    A matrix B of size M x 2 is given which represents the M edges such that there is an edge directed from node B[i][0] to node B[i][1].
    Find whether the graph contains a cycle or not, return 1 if cycle is present else return 0.

    NOTE:
    The cycle must contain at least two nodes.
    There are no self-loops in the graph.
    There are no multiple edges between two nodes.
    The graph may or may not be connected.
    Nodes are numbered from 1 to A.
    Your solution will run on multiple test cases. If you are using global variables make sure to clear them.

    Problem Constraints
    2 <= A <= 10^5
    1 <= M <= min(200000,A*(A-1))
    1 <= B[i][0], B[i][1] <= A

    Input Format
    The first argument given is an integer A representing the number of nodes in the graph.
    The second argument given a matrix B of size M x 2 which represents the M edges such that there is an edge directed from node B[i][0] to node B[i][1].

    Output Format
    Return 1 if cycle is present else return 0.

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
     1

    Output 2:
     0

    Example Explanation:
    Explanation 1:
     The given graph contain cycle 1 -> 3 -> 4 -> 1 or the cycle 1 -> 2 -> 4 -> 1

    Explanation 2:
     The given graph doesn't contain any cycle.
    */

    private static int solve(int A, int[][] B) {
        ArrayList<ArrayList<Integer>> adj = new ArrayList<>(A + 1);
        for (int i = 0; i <= A; ++i) {
            adj.add(new ArrayList<>());
        }
        for (int[] ints : B) {
            int u = ints[0];
            int v = ints[1];
            adj.get(u).add(v);
        }

        return isCyclic(A, adj) ? 1 : 0;
    }

    private static boolean isCyclic(int N, ArrayList<ArrayList<Integer>> adj) {
        int[] incomingEdges = new int[N + 1];
        for (int i = 1; i <= N; ++i) {
            for (int j = 0; j < adj.get(i).size(); ++j) {
                int v = adj.get(i).get(j);
                incomingEdges[v]++;
            }
        }

        Queue<Integer> queue_zeroDependency = new LinkedList<>();
        for (int i = 1; i <= N; ++i) {
            if (incomingEdges[i] == 0) {
                queue_zeroDependency.add(i);
            }
        }

        int count = 0;
        while (!queue_zeroDependency.isEmpty()) {
            int node = queue_zeroDependency.poll();
            count++;

            for (int i = 0; i < adj.get(node).size(); ++i) {
                int neighbour = adj.get(node).get(i);
                incomingEdges[neighbour]--;
                if (incomingEdges[neighbour] == 0) {
                    queue_zeroDependency.add(neighbour);
                }
            }
        }
        return count != N;
    }

    public static void main(String[] args) {
        int A = 5;
        int[][] B = {{1, 2}, {4, 1}, {2, 4}, {3, 4}, {5, 2}, {1, 3}};
        System.out.println("The graph contains a cycle: " + solve(A, B));
    }
}
