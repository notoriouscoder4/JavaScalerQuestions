package com.jsm.scaler.advance.Graphs;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;

public class Reversing_Edges {
    /*
    Given a directed graph with A nodes and M edges.
    Find the minimum number of edges that needs to be reversed in order to reach node A from node 1.

    Problem Constraints
    1 <= A, M <= 10^5
    1 <= B[i][0], B[i][1] <= A
    There can be multiple edges or self loops (B[i][0] = B[i][1])

    Input Format
    The first argument is an integer A, denoting the number of nodes in the graph.
    The second argument is a 2D integer array B, denoting the directed edges in the graph.

    Output Format
    Return a single integer denoting the minimum number of edges to be reversed.

    Example Input:
    Input 1:
    A = 5
    B = [[1, 2],
         [2, 3],
         [4, 3],
         [4, 5]]

    Input 2:
    A = 5
    B = [[1, 2],
         [2, 3],
         [3, 4],
         [4, 5]]

    Example Output:
    Output 1:
    1

    Output 2:
    0

    Example Explanation:
    Explanation 1:
    Reversing the edge (4, 3) is only required.

    Explanation 2:
    There already exists a path between 1 and A, so no edges need to be reversed.
    */

    private static class Pair {
        int vertex;
        int weight;

        public Pair(int vertex, int weight) {
            this.vertex = vertex;
            this.weight = weight;
        }
    }

    private static int minFlips(ArrayList<ArrayList<Pair>> adjList, int source, int n) {
        int[] distance = new int[n + 1];
        Arrays.fill(distance, Integer.MAX_VALUE);

        PriorityQueue<Pair> minHeap = new PriorityQueue<>(Comparator.comparing((a) -> a.weight));
        minHeap.add(new Pair(source, 0));

        while (!minHeap.isEmpty()) {
            Pair top = minHeap.poll();
            int vertex = top.vertex;
            int weight = top.weight;

            if (distance[vertex] != Integer.MAX_VALUE) continue; // Already Covered
            distance[vertex] = weight;
            for (Pair u : adjList.get(vertex)) {
                if (distance[u.vertex] != Integer.MAX_VALUE) continue;
                minHeap.add(new Pair(u.vertex, weight + u.weight));
            }
        }
        return distance[n];
    }

    private static int reverseEdges(int A, int[][] B) {
        ArrayList<ArrayList<Pair>> adjList = new ArrayList<>();
        for (int i = 0; i <= A; ++i) {
            adjList.add(new ArrayList<>());
        }
        for (int[] ints : B) {
            adjList.get(ints[0]).add(new Pair(ints[1], 0));
            adjList.get(ints[1]).add(new Pair(ints[0], 1)); // Adding opposite edge of weight 1
        }
        int reverseEdge = minFlips(adjList, 1, A);
        return reverseEdge == Integer.MAX_VALUE ? -1 : reverseEdge;
    }

    public static void main(String[] args) {
        int A = 5;
        int[][] B = {{1, 2}, {2, 3}, {4, 3}, {4, 5}};

        System.out.println(reverseEdges(A, B));
    }
}
