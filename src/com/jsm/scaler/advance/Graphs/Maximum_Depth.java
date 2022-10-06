package com.jsm.scaler.advance.Graphs;

import java.util.*;

public class Maximum_Depth {
    /*
    Given a Tree of A nodes having A-1 edges. Each node is numbered from 1 to A where 1 is the root of the tree.
    You are given Q queries. In each query, you will be given two integers L and X.
    Find the value of such node which lies at level L mod (MaxDepth + 1) and has value greater than or equal to X.

    Answer to the query is the smallest possible value or -1, if all the values at the required level are smaller than X.

    NOTE:
    1. Level and Depth of the root is considered as 0.
    2. It is guaranteed that each edge will be connecting exactly two different nodes of the tree.
    3. Please read the input format for more clarification.

    Problem Constraints
    2 <= A, Q(size of array E and F) <= 10^5
    1 <= B[i], C[i] <= A
    1 <= D[i], E[i], F[i] <= 10^6

    Input Format:
    The first argument is an integer A denoting the number of nodes.
    The second and third arguments are the integer arrays B and C where for each i (0 <= i < A-1), B[i] and C[i] are the nodes connected by an edge.
    The fourth argument is an integer array D, where D[i] denotes the value of the (i+1)th node
    The fifth and sixth arguments are the integer arrays E and F where for each i (0 <= i < Q), E[i] denotes L and F[i] denotes X for ith query.

    Output Format:
    Return an array of integers where the ith element denotes the answer to ith query.

    Example Input:
    Input 1:
     A = 5
     B = [1, 4, 3, 1]
     C = [5, 2, 4, 4]
     D = [7, 38, 27, 37, 1]
     E = [1, 1, 2]
     F = [32, 18, 26]

    Input 2:
     A = 3
     B = [1, 2]
     C = [3, 1]
     D = [7, 15, 27]
     E = [1, 10, 1]
     F = [29, 6, 26]

    Example Output:
    Output 1:
     [37, 37, 27]

    Output 2:
     [-1, 7, 27]

    Example Explanation:
    Explanation 1:
          1[7]
         /    \
       5[1]  4[37]
            /    \
           2[38]  3[27]

     Query 1:
        L = 1, X = 32
        Nodes for level 1 are 5, 4
        Value of Node 5 = 1 < 32
        Value of Node 4 = 37 >= 32
        Ans = 37

    Explanation 2:
          1[7]
         /    \
       2[15]  3[27]

     Query 1:
        L = 1, X = 6
        Nodes for level 1 are 2, 3 having value 15 and 27 respectively.
        Answer = -1 (Since no node is greater or equal to 29).
     Query 1:
        L = 10 % 2 = 0, X = 6
        Nodes for level 0 is 1 having value 7.
        Answer = 7.
    */

    private static class TreeNode {
        int node;
        int value;
        List<TreeNode> neighbours;

        public TreeNode(int node) {
            this.node = node;
            this.neighbours = new LinkedList<>();
        }
    }

    private static int[] solve(int A, int[] B, int[] C, int[] D, int[] E, int[] F) {
        // create adjacency list
        List<TreeNode> adjList = buildAdjacencyList(A, B, C, D);
        // level order traversal and get all elements in level
        List<List<Integer>> levels = performLevelOrderTraversal(A, adjList);
        // for each query get the ceil from respective level
        int[] output = new int[E.length];
        int totalLevels = levels.size();
        for (int i = 0; i < E.length; ++i) {
            int L = E[i] % totalLevels;
            int X = F[i];
            int ceil = getCeil(X, levels.get(L));
            output[i] = ceil;
        }
        return output;
    }

    private static List<TreeNode> buildAdjacencyList(int A, int[] B, int[] C, int[] D) {
        List<TreeNode> adjList = new ArrayList<>();
        for (int i = 0; i <= A; ++i) {
            adjList.add(new TreeNode(i));
            if (i > 0)
                adjList.get(i).value = D[i - 1];
        }
        for (int i = 0; i < B.length; ++i) {
            int u = B[i];
            int v = C[i];
            // undirected graph
            TreeNode sourceNode = adjList.get(u);
            TreeNode targetNode = adjList.get(v);
            sourceNode.neighbours.add(targetNode);
            targetNode.neighbours.add(sourceNode);
        }
        return adjList;
    }

    private static List<List<Integer>> performLevelOrderTraversal(int A, List<TreeNode> adjList) {
        boolean[] visited = new boolean[A + 1];
        TreeNode source = adjList.get(1);
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(source);
        queue.add(null);
        visited[source.node] = true;

        List<List<Integer>> levels = new ArrayList<>();
        levels.add(new ArrayList<>());

        List<Integer> currentLevel = levels.get(0);
        while (queue.size() > 1) {
            TreeNode x = queue.poll();
            if (x == null) {
                // end of current level
                // sort previous level
                Collections.sort(currentLevel);
                // add new level
                levels.add(new ArrayList<>());
                currentLevel = levels.get(levels.size() - 1);
                // add null to denote end of current level
                queue.add(null);
            } else {
                currentLevel.add(x.value);
                // add neighbours in queue
                List<TreeNode> neighbours = x.neighbours;
                for (TreeNode neighbour : neighbours) {
                    if (!visited[neighbour.node]) {
                        queue.add(neighbour);
                        visited[neighbour.node] = true;
                    }
                }
            }
        }
        // sort last level
        Collections.sort(currentLevel);
        return levels;
    }

    /*
     * Get Ceil of x using Binary Search
     */
    private static int getCeil(int x, List<Integer> list) {
        int start = 0;
        int end = list.size() - 1;
        int answer = -1;

        while (start <= end) {
            int mid = start + (end - start) / 2;
            int midValue = list.get(mid);
            if (midValue == x) {
                return x;
            } else if (x < midValue) {
                answer = midValue;
                end = mid - 1;
            } else {
                start = mid + 1;
            }
        }
        return answer;
    }

    public static void main(String[] args) {
        int A = 5;
        int[] B = {1, 4, 3, 1};
        int[] C = {5, 2, 4, 4};
        int[] D = {7, 38, 27, 37, 1};
        int[] E = {1, 1, 2};
        int[] F = {32, 18, 26};
        System.out.println(Arrays.toString(solve(A, B, C, D, E, F)));
    }
}
