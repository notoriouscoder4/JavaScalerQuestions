package com.jsm.scaler.advance.Graphs;

import java.util.*;

public class Topological_Sort_BFS {
    /*
    Given a directed acyclic graph having A nodes.
    A matrix B of size M x 2 is given which represents the M edges such that there is an edge directed from node B[i][0] to node B[i][1].
    Topological sorting for Directed Acyclic Graph (DAG) is a linear ordering of vertices such that for every directed edge uv,
    vertex u comes before v in the ordering.
    Topological Sorting for a graph is not possible if the graph is not a DAG.

    Return the topological ordering of the graph and if it doesn't exist then return an empty array.
    If there is a solution return the correct ordering. If there are multiple solutions print the lexographically the smallest one.

    Ordering (a, b, c) is said to be lexographically smaller than ordering (e, f, g) if a < e or if(a==e) then b < f and so on.

    NOTE:
    There are no self-loops in the graph.
    There are no multiple edges between two nodes.
    The graph may or may not be connected.
    Nodes are numbered from 1 to A.
    Your solution will run on multiple test cases. If you are using global variables make sure to clear them.

    Problem Constraints
    2 <= A <= 10^4
    1 <= M <= min(100000,A*(A-1))
    1 <= B[i][0], B[i][1] <= A

    Input Format
    The first argument given is an integer A representing the number of nodes in the graph.
    The second argument given a matrix B of size M x 2 which represents the M edges such that there is an edge directed from node B[i][0] to node B[i][1].

    Output Format
    Return a one-dimensional array denoting the topological ordering of the graph, and it doesn't exist then return empty array.

    Example Input:
    Input 1:
     A = 6
     B = [  [6, 3]
            [6, 1]
            [5, 1]
            [5, 2]
            [3, 4]
            [4, 2] ]

    Input 2:
     A = 3
     B = [  [1, 2]
            [2, 3]
            [3, 1] ]

    Example Output:
    Output 1:
     [5, 6, 1, 3, 4, 2]

    Output 2:
     []

    Example Explanation:
    Explanation 1:
     The given graph contain no cycle so topological ordering exists which is [5, 6, 1, 3, 4, 2]

    Explanation 2:
     The given graph contain cycle so topological ordering not possible we will return empty array.
    */

    private static int[] solve(int A, int[][] B) {
        ArrayList<ArrayList<Integer>> adjList = new ArrayList<>(A + 1);
        for (int i = 0; i <= A; ++i) {
            adjList.add(new ArrayList<>());
        }
        for (int[] ints : B) {
            int u = ints[0];
            int v = ints[1];
            adjList.get(u).add(v);
        }

        return topologicalSort_Kahn_Algo(A, adjList);
    }

    /*
    Time Complexity: O(N+E)
    Space complexity: O(N)+O(N)
    */
    private static int[] topologicalSort_Kahn_Algo(int N, ArrayList<ArrayList<Integer>> adj) {
        int[] topologicalOrdering = new int[N];
        int[] incomingEdges = new int[N + 1];
        for (int i = 1; i <= N; ++i) {
            for (int j = 0; j < adj.get(i).size(); ++j) {
                int v = adj.get(i).get(j);
                incomingEdges[v]++;
            }
        }

        PriorityQueue<Integer> queue_zeroDependency = new PriorityQueue<>();
        for (int i = 1; i <= N; ++i) {
            if (incomingEdges[i] == 0) {
                queue_zeroDependency.add(i);
            }
        }

        int count = 0;
        int index = 0;
        while (!queue_zeroDependency.isEmpty()) {
            int node = queue_zeroDependency.poll();
            topologicalOrdering[index++] = node;
            count++;

            for (int i = 0; i < adj.get(node).size(); ++i) {
                int neighbour = adj.get(node).get(i);
                incomingEdges[neighbour]--;
                if (incomingEdges[neighbour] == 0) {
                    queue_zeroDependency.add(neighbour);
                }
            }
        }
        if (count < N) {
            return new int[]{};
        }
        return topologicalOrdering;
    }

    public static void main(String[] args) {
        int A = 8;
        int[][] B = {{1, 4}, {1, 2}, {4, 2}, {4, 3}, {3, 2}, {5, 2}, {3, 5}, {8, 2}, {8, 6}};
        System.out.println(Arrays.toString(solve(A, B)));
    }
}
