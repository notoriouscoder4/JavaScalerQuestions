package com.jsm.scaler.advance.Trees.BinarySearchTrees;

public class Valid_BST {
    /*
    You are given a binary tree represented by root A.

    Assume a BST is defined as follows:
    1) The left subtree of a node contains only nodes with keys less than the node's key.
    2) The right subtree of a node contains only nodes with keys greater than the node's key.
    3) Both the left and right subtrees must also be binary search trees.

    Problem Constraints
    1 <= Number of nodes in binary tree <= 105
    0 <= node values <= 10^9

    Input Format
    First and only argument is head of the binary tree A.

    Output Format
    Return 0 if false and 1 if true.

    Example Input:
    Input 1:
      1
    /  \
   2    3

    Input 2:
     2
    / \
   1   3

    Example Output:
    Output 1:
    0

    Output 2:
    1

    Example Explanation:
    Explanation 1:
    2 is not less than 1 but is in left subtree of 1.

    Explanation 2:
    Satisfies all conditions.
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

    private static boolean isValidBSTHelper(TreeNode root, long min, long max) {
        if (root == null) return true;
        if (root.val <= min || root.val >= max) return false;
        return isValidBSTHelper(root.left, min, root.val) && isValidBSTHelper(root.right, root.val, max);
    }

    private static int isValidBST(TreeNode A) {
        return isValidBSTHelper(A, Long.MIN_VALUE, Long.MAX_VALUE) ? 1 : 0;
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        System.out.println(isValidBST(root));
    }
}
