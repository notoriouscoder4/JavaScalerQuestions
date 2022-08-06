package com.jsm.scaler.advance.Trees.BinaryTrees;

public class Invert_BT {
    /*
    Given a binary tree A, invert the binary tree and return it.
    Inverting refers to making the left child the right child and vice versa.

    Problem Constraints
    1 <= size of tree <= 100000

    Input Format
    First and only argument is the head of the tree A.

    Output Format
    Return the head of the inverted tree.

    Example Input:
    Input 1:
         1
       /   \
      2     3

    Input 2:
         1
       /   \
      2     3
     / \   / \
    4   5 6   7

    Example Output:
    Output 1:
         1
       /   \
      3     2

    Output 2:
         1
       /   \
      3     2
     / \   / \
    7   6 5   4

    Example Explanation:
    Explanation 1:
    Tree has been inverted.

    Explanation 2:
    Tree has been inverted.
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

    private static TreeNode invertTree(TreeNode A) {
        if (A == null)
            return null;
        TreeNode left = invertTree(A.left);
        TreeNode right = invertTree(A.right);

        A.right = left;
        A.left = right;

        return A;
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        root.left.left = new TreeNode(4);
        root.left.right = new TreeNode(5);
        root.right.left = new TreeNode(6);
        root.right.right = new TreeNode(7);

        System.out.println(invertTree(root));
    }
}
