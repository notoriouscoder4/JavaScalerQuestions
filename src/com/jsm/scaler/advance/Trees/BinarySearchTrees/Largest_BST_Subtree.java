package com.jsm.scaler.advance.Trees.BinarySearchTrees;

public class Largest_BST_Subtree {
    /*
    You are given a Binary Tree A with N nodes.
    Write a function that returns the size of the largest subtree, which is also a Binary Search Tree (BST).
    If the complete Binary Tree is BST, then return the size of the whole tree.

    NOTE:
    The largest subtree is the subtree with the maximum number of nodes.

    Problem Constraints
    1 <= N <= 10^5

    Input Format
    First and only argument is a pointer to root of the binary tree A.

    Output Format
    Return a single integer denoting the size of the largest subtree which is also a BST.

    Example Input:
    Input 1:
         10
        / \
       5  15
      / \   \
     1   8   7

    Input 2:
         5
        / \
       3   8
      / \ / \
     1  4 7  9

    Example Output:
    Output 1:
     3

    Output 2:
     7

    Example Explanation:
    Explanation 1:
     Largest BST subtree is
                                5
                               / \
                              1   8

    Explanation 2:
     Given binary tree itself is BST.
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

    private static class NodeValue {
        public int maxNode, minNode, maxSize;

        NodeValue(int minNode, int maxNode, int maxSize) {
            this.maxNode = maxNode;
            this.minNode = minNode;
            this.maxSize = maxSize;
        }
    }

    private static NodeValue largestBSTSubtree(TreeNode root) {
        // An empty tree is a BST of size 0.
        if (root == null)
            return new NodeValue(Integer.MAX_VALUE, Integer.MIN_VALUE, 0);

        // Get values from left and right subtree of current tree.
        NodeValue left = largestBSTSubtree(root.left);
        NodeValue right = largestBSTSubtree(root.right);

        // Current node is greater than max in left AND smaller than min in right, it is a BST.
        if (left.maxNode < root.val && root.val < right.minNode)
            // It is a BST.
            return new NodeValue(Math.min(root.val, left.minNode), Math.max(root.val, right.maxNode),
                    left.maxSize + right.maxSize + 1);

        // Otherwise, return [-inf, inf] so that parent can't be valid BST
        return new NodeValue(Integer.MIN_VALUE, Integer.MAX_VALUE, Math.max(left.maxSize, right.maxSize));
    }

    private static int solve(TreeNode A) {
        return largestBSTSubtree(A).maxSize;
    }

    public static void main(String[] args) {

    }
}
