package com.jsm.scaler.intermediate.TreesBasics;

public class SymmetricBinaryTrees {
    /*
    Given a binary tree, check whether it is a mirror of itself (i.e., symmetric around its center).

    Problem Constraints
    1 <= number of nodes <= 105

    Input Format
    First and only argument is the root node of the binary tree.

    Output Format
    Return 0 / 1 ( 0 for false, 1 for true ).

    Example Input
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

    Example Output

    Output 1:
     1

    Output 2:
     0

    Example Explanation

    Explanation 1:
     The above binary tree is symmetric.

    Explanation 2:
    The above binary tree is not symmetric.
    */

    private static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int val) {
            this.val = val;
            this.left = null;
            this.right = null;
        }
    }

    private static int isSymmetric(TreeNode A) {
        if (A == null)
            return 1;
        if (A.left == null && A.right == null)
            return 1;
        if (A.left == null || A.right == null)
            return 0;
        if (A.left.val == A.right.val)
            return 1;
        return (isSymmetric(A.left) == 1 && isSymmetric(A.right) == 1 ? 1 : 0);
    }

    public static void main(String[] args) {

    }
}
