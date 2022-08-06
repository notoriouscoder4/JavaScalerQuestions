package com.jsm.scaler.advance.Trees.BinaryTrees;

import java.util.*;

public class BottomView_Vertical_Order_Traversal {
    /*
    Given a binary tree of integers denoted by root A. Return an array of integers representing the bottom view of the Binary tree.
    The bottom view of a Binary Tree is a set of nodes visible when the tree is visited from the bottom.
    Return the nodes in any order.

    Problem Constraints
    1 <= Number of nodes in binary tree <= 100000
    0 <= node values <= 10^9

    Input Format
    First and only argument is head of the binary tree A.

    Output Format
    Return an array, representing the bottom view of the binary tree.

    Example Input:
    Input 1:
                1
              /   \
             2    3
            / \  / \
           4   5 6  7
          /
         8

    Input 2:
                1
               /  \
              2    3
               \
                4
                 \
                  5

    Example Output:
    Output 1:
     [8, 4, 5, 6, 7]

    Output 2:
     [2, 4, 5, 3]

    Example Explanation:
    Explanation 1:
    Bottom view is described.

    Explanation 2:
    Bottom view is described.
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

    private static ArrayList<Integer> bottomView(TreeNode root) {
        if (root == null)
            return new ArrayList<>();

        ArrayList<Integer> bottomViewNodes = new ArrayList<>();
        HashMap<Integer, ArrayList<Integer>> nodeMap = new HashMap<>();
        Queue<NodeEntry> queue = new LinkedList<>();
        queue.add(new NodeEntry(root, 0));

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
        // need to be done later
//        for (int i = minLevel; i <= maxLevel; ++i)
//            bottomViewNodes.add(nodeMap.get(i).get(size - 1));
        return bottomViewNodes;
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        root.left.left = new TreeNode(4);
        root.left.right = new TreeNode(5);
        root.right.left = new TreeNode(6);
        root.right.right = new TreeNode(7);
        root.left.left.left = new TreeNode(8);
        System.out.println(bottomView(root));
    }
}
