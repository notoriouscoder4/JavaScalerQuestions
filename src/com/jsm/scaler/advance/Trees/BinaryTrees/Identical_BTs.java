package com.jsm.scaler.advance.Trees.BinaryTrees;

public class Identical_BTs {
    /*
    Given two binary trees, check if they are equal or not.
    Two binary trees are considered equal if they are structurally identical and the nodes have the same value.

    Problem Constraints
    1 <= number of nodes <= 10^5

    Input Format
    The first argument is a root node of the first tree, A.
    The second argument is a root node of the second tree, B.

    Output Format
    Return 0 / 1 ( 0 for false, 1 for true ) for this problem.

    Example Input:
    Input 1:
       1       1
      / \     / \
     2   3   2   3

    Input 2:
       1       1
      / \     / \
     2   3   3   3

    Example Output:
    Output 1:
     1

    Output 2:
     0

    Example Explanation:
    Explanation 1:
     Both trees are structurally identical and the nodes have the same value.

    Explanation 2:
     Values of the left child of the root node of the trees are different.
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

    private static int isSameTree(TreeNode A, TreeNode B) {
        if (A == null && B == null) return 1; // base condition. If both are null they are equal
        if (A == null || B == null) return 0; // if either are null, they are unequal
        if (A.val != B.val) return 0; // A and B have un-equal values.
        return isSameTree(A.left, B.left) & isSameTree(A.right, B.right);
    }

    public static void main(String[] args) {

    }
}
