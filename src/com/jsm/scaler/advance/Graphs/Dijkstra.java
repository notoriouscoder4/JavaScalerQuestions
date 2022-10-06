package com.jsm.scaler.advance.Graphs;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;

public class Dijkstra {
    /*
    Given a weighted undirected graph having A nodes and M weighted edges, and a source node C.

    You have to find an integer array D of size A such that:
    => D[i] : Shortest distance form the C node to node i.
    => If node 'i' is not reachable from C then -1.

    Note:
    There are no self-loops in the graph.
    No multiple edges between two pair of vertices.
    The graph may or may not be connected.
    Nodes are numbered from 0 to A-1.
    Your solution will run on multiple testcases. If you are using global variables make sure to clear them.

    Problem Constraints
    1 <= A <= 1e5
    0 <= B[i][0],B[i][1] < A
    0 <= B[i][2] <= 1e3
    0 <= C < A

    Input Format
    The first argument given is an integer A, representing the number of nodes.
    The second argument given is the matrix B of size M x 3, where nodes B[i][0] and B[i][1] are connected with an edge of weight B[i][2].
    The third argument given is an integer C.

    Output Format
    Return the integer array D.

    Example Input:
    Input 1:
    A = 6
    B = [   [0, 4, 9]
            [3, 4, 6]
            [1, 2, 1]
            [2, 5, 1]
            [2, 4, 5]
            [0, 3, 7]
            [0, 1, 1]
            [4, 5, 7]
            [0, 5, 1] ]
    C = 4

    Input 2:
    A = 5
    B = [   [0, 3, 4]
            [2, 3, 3]
            [0, 1, 9]
            [3, 4, 10]
            [1, 3, 8]  ]
    C = 4

    Example Output:
    Output 1:
    D = [7, 6, 5, 6, 0, 6]

    Output 2:
    D = [14, 18, 13, 10, 0]

    Example Explanation:
    Explanation 1:
     All Paths can be considered from the node C to get the shortest path

    Explanation 2:
     All Paths can be considered from the node C to get the shortest path
    */

    private static int[] solve(int A, int[][] B, int C) {
        ArrayList<ArrayList<Node>> adj = new ArrayList<>();
        for (int i = 0; i < A; ++i) {
            adj.add(new ArrayList<>());
        }
        for (int[] ints : B) {
            int u = ints[0];
            int v = ints[1];
            int wt = ints[2];
            adj.get(u).add(new Node(v, wt));
            adj.get(v).add(new Node(u, wt));
        }
        return shortestPath(A, adj, C);
    }

    private static class Node implements Comparator<Node> {
        private int v;
        private int weight;

        public Node(int _v, int _w) {
            this.v = _v;
            this.weight = _w;
        }

        public Node() {

        }

        public int getV() {
            return v;
        }

        public int getWeight() {
            return weight;
        }

        @Override
        public int compare(Node node1, Node node2) {
            return Integer.compare(node1.weight, node2.weight);
        }
    }

    private static int[] shortestPath(int N, ArrayList<ArrayList<Node>> adj, int s) {
        int[] dist = new int[N];
        for (int i = 0; i < N; ++i)
            dist[i] = Integer.MAX_VALUE;
        dist[s] = 0;

        PriorityQueue<Node> pq = new PriorityQueue<>(N, new Node());
        pq.add(new Node(s, 0));

        while (pq.size() > 0) {
            Node node = pq.poll();

            for (Node it : adj.get(node.getV())) {
                if (dist[node.getV()] + it.getWeight() < dist[it.getV()]) {
                    dist[it.getV()] = dist[node.getV()] + it.getWeight();
                    pq.add(new Node(it.getV(), dist[it.getV()]));
                }
            }
        }
        for (int i = 0; i < dist.length; ++i) {
            if (dist[i] == Integer.MAX_VALUE) {
                dist[i] = -1;
            }
        }
        return dist;
    }

    public static void main(String[] args) {
        int A = 6;
        int[][] B = {{0, 4, 9}, {3, 4, 6}, {1, 2, 1}, {2, 5, 1}, {2, 4, 5}, {0, 3, 7}, {0, 1, 1}, {4, 5, 7}, {0, 5, 1}};
        int C = 4;

        System.out.println(Arrays.toString(solve(A, B, C)));
    }
}
