package com.jsm.scaler.advance.Trees.BinarySearchTrees;

public class Distance_Between_Nodes_Of_BST {
    /*
    Given a binary search tree.
    Return the distance between two nodes with given two keys B and C. It may be assumed that both keys exist in BST.

    NOTE: Distance between two nodes is number of edges between them.

    Problem Constraints
    1 <= Number of nodes in binary tree <= 1000000
    0 <= node values <= 10^9

    Input Format
    First argument is a root node of the binary tree, A.
    Second argument is an integer B.
    Third argument is an integer C.

    Output Format
    Return an integer denoting the distance between two nodes with given two keys B and C

    Example Input:
    Input 1:
             5
           /   \
          2     8
         / \   / \
        1   4 6   11
     B = 2
     C = 11

    Input 2:
             6
           /   \
          2     9
         / \   / \
        1   4 7   10
     B = 2
     C = 6

    Example Output:
    Output 1:
     3

    Output 2:
     1

    Example Explanation:
    Explanation 1:
     Path between 2 and 11 is: 2 -> 5 -> 8 -> 11. Distance will be 3.

    Explanation 2:
     Path between 2 and 6 is: 2 -> 6. Distance will be 1
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

    private static int distanceFromRoot(TreeNode root, int x) {
        if (root.val == x)
            return 0;
        else if (root.val > x)
            return 1 + distanceFromRoot(root.left, x);
        return 1 + distanceFromRoot(root.right, x);
    }

    private static int distanceBetween2(TreeNode root, int a, int b) {
        if (root == null)
            return 0;
        // Both keys lie in left
        if (root.val > a && root.val > b)
            return distanceBetween2(root.left, a, b);

        // Both keys lie in right
        if (root.val < a && root.val < b)
            return distanceBetween2(root.right, a, b);

        // Lie in opposite directions (Root is LCA of two nodes)
        if (root.val >= a && root.val <= b)
            return distanceFromRoot(root, a) + distanceFromRoot(root, b);
        return 0;
    }

    private static int solve(TreeNode A, int B, int C) {
        // just to make sure that B <= C
        if (B > C) {
            int temp = B;
            B = C;
            C = temp;
        }
        return distanceBetween2(A, B, C);
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(5);
        root.left = new TreeNode(2);
        root.right = new TreeNode(8);
        root.left.left = new TreeNode(1);
        root.left.right = new TreeNode(4);
        root.right.left = new TreeNode(6);
        root.right.right = new TreeNode(11);

        int B = 2;
        int C = 11;

        System.out.println(solve(root, B, C));
    }
}
