package com.jsm.scaler.advance.Trees.BinaryTrees;

public class Diameter_BT {
    /*
    Given a Binary Tree A consisting of N integer nodes, you need to find the diameter of the tree.
    The diameter of a tree is the number of edges on the longest path between two nodes in the tree.

    Problem Constraints
    0 <= N <= 10^5

    Input Format
    First and only Argument represents the root of binary tree A.

    Output Format
    Return a single integer denoting the diameter of the tree.

    Example Input:
    Input 1:
               1
             /   \
            2     3
           / \
          4   5

    Input 2:
                1
              /   \
             2     3
            / \     \
           4   5     6

    Example Output:
    Output 1:
     3

    Output 2:
     4

    Example Explanation:
    Explanation 1:
     Longest Path in the tree is 4 -> 2 -> 1 -> 3 and the number of edges in this path is 3 so diameter is 3.

    Explanation 2:
     Longest Path in the tree is 4 -> 2 -> 1 -> 3 -> 6 and the number of edges in this path is 4 so diameter is 4.
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

    private static class TreeInfo {
        public int height;
        public int diameter;

        public TreeInfo(int ht, int dia) {
            this.height = ht;
            this.diameter = dia;
        }
    }

    private static TreeInfo dia(TreeNode root) {
        if (root == null)
            return new TreeInfo(-1, -1);
        TreeInfo l = dia(root.left);
        TreeInfo r = dia(root.right);
        return new TreeInfo(Math.max(l.height, r.height) + 1, Math.max(Math.max(l.diameter, r.diameter), l.height + r.height + 2));
    }

    private static int solve(TreeNode A) {
        return dia(A).diameter;
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        root.left.left = new TreeNode(4);
        root.left.right = new TreeNode(5);
        root.right.right = new TreeNode(6);

        System.out.println(solve(root));
    }
}
