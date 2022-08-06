package com.jsm.scaler.advance.Trees.BinaryTrees;

public class Balanced_BT {
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

    private static int isBalance = 1;

    private static int isBalanced(TreeNode A) {
        isBalancedHelper(A);
        return isBalance;
    }

    private static int isBalancedHelper(TreeNode root) {
        if (root == null) return 0;
        if (isBalance == 0) return 0;
        int left_height = isBalancedHelper(root.left);
        int right_height = isBalancedHelper(root.right);
        if (Math.abs(left_height - right_height) > 1)
            isBalance = 0;
        return 1 + Math.max(left_height, right_height);
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);

        System.out.println(isBalanced(root));
    }
}
