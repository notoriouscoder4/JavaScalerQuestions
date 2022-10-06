package com.jsm.scaler.advance.Graphs;

import java.util.ArrayList;

public class Cycle_Directed_Graph_DFS {
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
        ArrayList<ArrayList<Integer>> adjList = new ArrayList<>(A + 1);
        int[] visited = new int[A + 1];
        int[] dfsVisited = new int[A + 1];

        for (int i = 0; i <= A; ++i) {
            adjList.add(new ArrayList<>());
        }
        for (int[] ints : B) {
            int u = ints[0];
            int v = ints[1];
            adjList.get(u).add(v);
        }

        return isCycle(A, adjList, visited, dfsVisited) ? 1 : 0;
    }

    private static boolean isCycle(int V, ArrayList<ArrayList<Integer>> adjList, int[] visited, int[] dfsVisited) {
        for (int i = 1; i <= V; ++i) {
            if (visited[i] == 0) {
                if (checkCycle(i, adjList, visited, dfsVisited)) {
                    return true;
                }
            }
        }
        return false;
    }

    private static boolean checkCycle(int node, ArrayList<ArrayList<Integer>> adjList, int[] visited, int[] dfsVisited) {
        visited[node] = 1;
        dfsVisited[node] = 1;

        for (Integer it : adjList.get(node)) {
            if (visited[it] == 0) {
                if (checkCycle(it, adjList, visited, dfsVisited)) {
                    return true;
                }
            } else if (dfsVisited[it] == 1) {
                return true;
            }
        }
        dfsVisited[node] = 0;
        return false;
    }

    public static void main(String[] args) {
        int A = 5;
        int[][] B = {{1, 2}, {4, 1}, {2, 4}, {3, 4}, {5, 2}, {1, 3}};
        System.out.println("The graph contains a cycle: " + solve(A, B));
    }
}
