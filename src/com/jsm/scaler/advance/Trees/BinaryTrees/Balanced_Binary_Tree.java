package com.jsm.scaler.advance.Trees.BinaryTrees;

public class Balanced_Binary_Tree {
    /*
    Given a root of binary tree A, determine if it is height-balanced.
    A height-balanced binary tree is defined as a binary tree in which the depth of the two subtrees of every node never differ by more than 1.

    Problem Constraints
    1 <= size of tree <= 100000

    Input Format
    First and only argument is the root of the tree A.

    Output Format
    Return 0 / 1 ( 0 for false, 1 for true ) for this problem.

    Example Input:
    Input 1:
        1
       / \
      2   3

    Input 2:
           1
          /
         2
        /
       3

    Example Output:
    Output 1:
    1

    Output 2:
    0

    Example Explanation:
    Explanation 1:
    It is a complete binary tree.

    Explanation 2:
    Because for the root node, left subtree has depth 2 and right subtree has depth 0.
    Difference = 2 > 1.
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
        public boolean isBal;

        public TreeInfo(int height, boolean isBal) {
            this.height = height;
            this.isBal = isBal;
        }
    }

    private static TreeInfo isBalance(TreeNode root) {
        if (root == null)
            // null tree is always balanced, but it's height will be -1
            return new TreeInfo(-1, true);
        TreeInfo leftInfo = isBalance(root.left);
        TreeInfo rightInfo = isBalance(root.right);

        if (leftInfo.isBal && rightInfo.isBal && Math.abs(leftInfo.height - rightInfo.height) <= 1)
            return new TreeInfo(Math.max(leftInfo.height, rightInfo.height) + 1, true);
        else
            return new TreeInfo(Math.max(leftInfo.height, rightInfo.height) + 1, false);
    }

    private static int isBalanced(TreeNode A) {
        boolean isBal = isBalance(A).isBal;
        return isBal ? 1 : 0;
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        System.out.println(isBalanced(root));
    }
}
