package com.jsm.scaler.advance.Trees.BinaryTrees;

import java.util.*;

public class Vertical_Order_Traversal_BFS {
    /*
    Given a binary tree, return a 2-D array with vertical order traversal of it. Go through the example and image for more details.

    NOTE: If 2 Tree Nodes shares the same vertical level then the one with lesser depth will come first.

    Problem Constraints
    0 <= number of nodes <= 10^5

    Input Format
    First and only argument is a pointer to the root node of binary tree, A.

    Output Format
    Return a 2D array denoting the vertical order traversal of tree as shown.

    Example Input:
    Input 1:
          6
        /   \
       3     7
      / \     \
     2   5     9

    Input 2:
          1
        /   \
       3     7
      /       \
     2         9

    Example Output:
    Output 1:
     [
        [2],
        [3],
        [6, 5],
        [7],
        [9]
     ]

    Output 2:
     [
        [2],
        [3],
        [1],
        [7],
        [9]
     ]

    Example Explanation:
    Explanation 1:
     First row represent the vertical line 1 and so on.
    */

    private static class TreeNode {
        public int val;
        public TreeNode left;
        public TreeNode right;

        public TreeNode(int val) {
            this.val = val;
            this.left = null;
            this.right = null;
        }
    }

    private static class NodeEntry {
        public TreeNode node;
        public int level;

        public NodeEntry(TreeNode node, int level) {
            this.node = node;
            this.level = level;
        }
    }

    private static ArrayList<ArrayList<Integer>> verticalOrderTraversal(TreeNode A) {
        if (A == null)
            return new ArrayList<>();

        ArrayList<ArrayList<Integer>> verticalOrderNodes = new ArrayList<>();
        HashMap<Integer, ArrayList<Integer>> nodeMap = new HashMap<>();
        Queue<NodeEntry> queue = new LinkedList<>();
        queue.add(new NodeEntry(A, 0)); // root node and initial level of root i.e. 0

        int minLevel = Integer.MAX_VALUE;
        int maxLevel = Integer.MIN_VALUE;

        while (!queue.isEmpty()) {
            NodeEntry entry = queue.poll();
            int level = entry.level;

            ArrayList<Integer> nodeList;

            if (nodeMap.containsKey(level))
                nodeList = nodeMap.get(level);
            else
                nodeList = new ArrayList<>();
            nodeList.add(entry.node.val);
            nodeMap.put(level, nodeList);

            TreeNode current = entry.node;
            if (current.left != null) {
                NodeEntry nodeEntry = new NodeEntry(current.left, level - 1);
                queue.add(nodeEntry);
            }
            if (current.right != null) {
                NodeEntry nodeEntry = new NodeEntry(current.right, level + 1);
                queue.add(nodeEntry);
            }
            minLevel = Math.min(minLevel, level);
            maxLevel = Math.max(maxLevel, level);
        }
        for (int i = minLevel; i <= maxLevel; ++i)
            verticalOrderNodes.add(nodeMap.get(i));
        return verticalOrderNodes;
    }


    public static void main(String[] args) {

    }
}
