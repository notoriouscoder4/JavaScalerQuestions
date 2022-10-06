package com.jsm.scaler.advance.Graphs;

import java.util.ArrayList;
import java.util.Comparator;

public class Commutable_Islands_KruskalAlgo {
    /*
    There are A islands and there are M bridges connecting them. Each bridge has some cost attached to it.
    We need to find bridges with minimal cost such that all islands are connected.

    It is guaranteed that input data will contain at least one possible scenario in which all islands are connected with each other.

    Problem Constraints
    1 <= A, M <= 6*10^4
    1 <= B[i][0], B[i][1] <= A
    1 <= B[i][2] <= 10^3

    Input Format
    The first argument contains an integer, A, representing the number of islands.
    The second argument contains an 2-d integer matrix, B, of size M x 3 where Island B[i][0] and B[i][1] are connected using a bridge of cost B[i][2].

    Output Format
    Return an integer representing the minimal cost required.

    Example Input:
    Input 1:
     A = 4
     B = [  [1, 2, 1]
            [2, 3, 4]
            [1, 4, 3]
            [4, 3, 2]
            [1, 3, 10]  ]

    Input 2:
     A = 4
     B = [  [1, 2, 1]
            [2, 3, 2]
            [3, 4, 4]
            [1, 4, 3]   ]

    Example Output:
    Output 1:
     6

    Output 2:
     6

    Example Explanation:
    Explanation 1:
     We can choose bridges (1, 2, 1), (1, 4, 3) and (4, 3, 2), where the total cost incurred will be (1 + 3 + 2) = 6.

    Explanation 2:
     We can choose bridges (1, 2, 1), (2, 3, 2) and (1, 4, 3), where the total cost incurred will be (1 + 2 + 3) = 6.
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

    private static int kruskalAlgo(ArrayList<Node> adjList, int N) {
        adjList.sort(new SortComparator());
        int[] parent = new int[N + 1];
        int[] rank = new int[N + 1];

        for (int i = 1; i <= N; ++i) {
            parent[i] = i;
            rank[i] = 0;
        }

        int minCost = 0;
        for (Node it : adjList) {
            if (findParent(it.getU(), parent) != findParent(it.getV(), parent)) {
                minCost = minCost + it.getWeight();
                union(it.getU(), it.getV(), parent, rank);
            }
        }
        return minCost;
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
        int A = 4;
        int[][] B = {{1, 2, 1}, {2, 3, 2}, {3, 4, 4}, {1, 4, 3}};

        System.out.println("The minimal cost required is: " + solve(A, B));
    }
}
