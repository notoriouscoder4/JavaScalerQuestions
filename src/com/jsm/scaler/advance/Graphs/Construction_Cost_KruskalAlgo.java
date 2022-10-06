package com.jsm.scaler.advance.Graphs;

import java.util.ArrayList;
import java.util.Comparator;

public class Construction_Cost_KruskalAlgo {
    /*
    Given a graph with A nodes and C weighted edges. Cost of constructing the graph is the sum of weights of all the edges in the graph.
    Find the minimum cost of constructing the graph by selecting some given edges such that we can reach every other node from the 1st node.

    NOTE: Return the answer modulo 10^9+7 as the answer can be large.

    Problem Constraints
    1 <= A <= 100000
    0 <= C <= 100000
    1 <= B[i][0], B[i][1] <= N
    1 <= B[i][2] <= 10^9

    Input Format
    First argument is an integer A.
    Second argument is a 2-D integer array B of size C*3 denoting edges. B[i][0] and B[i][1] are connected by ith edge with weight B[i][2]

    Output Format
    Return an integer denoting the minimum construction cost.

    Example Input:
    Input 1:
    A = 3
    B = [   [1, 2, 14]
            [2, 3, 7]
            [3, 1, 2]   ]

    Input 2:
    A = 3
    B = [   [1, 2, 20]
            [2, 3, 17]  ]

    Example Output:
    Output 1:
    9

    Output 2:
    37

    Example Explanation:
    Explanation 1:
    We can take only two edges (2 -> 3 and 3 -> 1) to construct the graph.
    we can reach the 1st node from 2nd and 3rd node using only these two edges.
    So, the total cost of construction is 9.

    Explanation 2:
    We have to take both the given edges so that we can reach the 1st node from 2nd and 3rd node.
    */

    private static class Node {
        int u;
        int v;
        int weight;

        public Node(int u, int v, int weight) {
            this.u = u;
            this.v = v;
            this.weight = weight;
        }

        public int getU() {
            return u;
        }

        public int getV() {
            return v;
        }

        public int getWeight() {
            return weight;
        }
    }

    private static class SortComparator implements Comparator<Node> {

        @Override
        public int compare(Node node1, Node node2) {
            return node1.getWeight() - node2.getWeight();
        }
    }

    private static int findParent(int u, int[] parent) {
        if (parent[u] == u)
            return u;
        parent[u] = findParent(parent[u], parent);
        return parent[u];
    }

    private static void union(int u, int v, int[] parent, int[] rank) {
        u = findParent(u, parent);
        v = findParent(v, parent);

        if (rank[u] < rank[v])
            parent[u] = v;
        else if (rank[v] < rank[u])
            parent[v] = u;
        else {
            parent[v] = u;
            rank[u]++;
        }
    }

    private static int kruskalAlgo(ArrayList<Node> adjLis, int N) {
        int mod = 1000000007;
        adjLis.sort(new SortComparator());
        int[] parent = new int[N + 1];
        int[] rank = new int[N + 1];

        for (int i = 1; i <= N; ++i) {
            parent[i] = i;
            rank[i] = 0;
        }

        int minCost = 0;
        for (Node it : adjLis) {
            if (findParent(it.getU(), parent) != findParent(it.getV(), parent)) {
                minCost = (minCost + it.getWeight()) % mod;
                union(it.getU(), it.getV(), parent, rank);
            }
        }
        return (minCost % mod);
    }

    private static int solve(int A, int[][] B) {
        ArrayList<Node> adjList = new ArrayList<>();
        for (int[] ints : B) {
            int u = ints[0];
            int v = ints[1];
            int weight = ints[2];
            adjList.add(new Node(u, v, weight));
        }
        return kruskalAlgo(adjList, A);
    }

    public static void main(String[] args) {
        int A = 3;
        int[][] B = {{1, 2, 14}, {2, 3, 7}, {3, 1, 2}};
        System.out.println("The minimum construction cost is: " + solve(A, B));
    }
}
