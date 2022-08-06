package com.jsm.scaler.advance.Trees.BinaryTrees;

public class Symmetric_BT {
    /*
    Given a binary tree, check whether it is a mirror of itself (i.e., symmetric around its center).

    Problem Constraints
    1 <= number of nodes <= 10^5

    Input Format
    First and only argument is the root node of the binary tree.

    Output Format
    Return 0 / 1 ( 0 for false, 1 for true ).

    Example Input:
    Input 1:
        1
       / \
      2   2
     / \ / \
    3  4 4  3

    Input 2:
        1
       / \
      2   2
       \   \
       3    3

    Example Output:
    Output 1:
     1

    Output 2:
     0

    Example Explanation:
    Explanation 1:
     The above binary tree is symmetric.

    Explanation 2:
    The above binary tree is not symmetric.
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

    private static boolean symmetric(TreeNode p, TreeNode q) {
        if (p == null && q == null)
            return true;
        if (p == null || q == null)
            return false;
        if (p.val != q.val)
            return false;
        return symmetric(p.left, q.right) && symmetric(p.right, q.left);
    }

    private static int isSymmetric(TreeNode A) {
        if (A == null)
            return 1;
        return symmetric(A.left, A.right) ? 1:0;
    }


    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(2);
        root.left.left = new TreeNode(3);
        root.left.right = new TreeNode(4);
        root.right.left = new TreeNode(4);
        root.right.right = new TreeNode(3);

        System.out.println(isSymmetric(root));
    }
}
