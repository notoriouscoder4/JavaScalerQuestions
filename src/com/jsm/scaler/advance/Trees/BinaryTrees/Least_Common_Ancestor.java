package com.jsm.scaler.advance.Trees.BinaryTrees;

public class Least_Common_Ancestor {
    /*
    Find the lowest common ancestor in an unordered binary tree A, given two values, B and C, in the tree.
    Lowest common ancestor: the lowest common ancestor (LCA) of two nodes and w in a tree or directed acyclic graph (DAG) is the lowest (i.e., deepest) node that has both v and w as descendants.

    Problem Constraints
    1 <= size of tree <= 100000
    1 <= B, C <= 10^9

    Input Format
    First argument is head of tree A.
    Second argument is integer B.
    Third argument is integer C.

    Output Format
    Return the LCA.

    Example Input:
    Input 1:
          1
         /  \
        2    3
    B = 2
    C = 3

    Input 2:
          1
         /  \
        2    3
       / \
      4   5
    B = 4
    C = 5

    Example Output:
    Output 1:
     1

    Output 2:
     2

    Example Explanation:
    Explanation 1:
     LCA is 1.

    Explanation 2:
     LCA is 2.
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

    private static TreeNode lcaNode;
    private static boolean isBpresent, isCpresent;
    ;

    private static int lca(TreeNode A, int B, int C) {
        checkNodespresent(A, B, C);
        if (isBpresent && isCpresent) {
            lcaNode = lowestCommonAncestor(A, B, C);
            return lcaNode.val;
        }
        return -1;
    }

    private static void checkNodespresent(TreeNode A, int B, int C) {
        if (A == null) return;
        checkNodespresent(A.left, B, C);
        checkNodespresent(A.right, B, C);
        if (A.val == B) isBpresent = true;
        if (A.val == C) isCpresent = true;
    }

    private static TreeNode lowestCommonAncestor(TreeNode root, int B, int C) {
        if (root == null) return null;
        if (root.val == B || root.val == C) return root;
        TreeNode left = lowestCommonAncestor(root.left, B, C);
        TreeNode right = lowestCommonAncestor(root.right, B, C);
        if (left == null)
            return right;
        else if (right == null)
            return left;
        else
            return root;
    }

    public static void main(String[] args) {

    }
}
