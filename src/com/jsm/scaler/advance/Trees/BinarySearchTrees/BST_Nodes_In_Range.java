package com.jsm.scaler.advance.Trees.BinarySearchTrees;

public class BST_Nodes_In_Range {
    /*
    Given a binary search tree of integers. You are given a range B and C.
    Return the count of the number of nodes that lie in the given range.

    Problem Constraints
    1 <= Number of nodes in binary tree <= 100000
    0 <= B < = C <= 10^9

    Input Format:
    First argument is a root node of the binary tree, A.
    Second argument is an integer B.
    Third argument is an integer C.

    Output Format:
    Return the count of the number of nodes that lies in the given range.

    Example Input:
    Input 1:
                15
              /    \
            12      20
            / \    /  \
           10  14  16  27
          /
         8

         B = 12
         C = 20

    Input 2:
                8
               / \
              6  21
             / \
            1   7

         B = 2
         C = 20

    Example Output:
    Output 1:
     5

    Output 2:
     3

    Example Explanation:
    Explanation 1:
     Nodes which are in range [12, 20] are : [12, 14, 15, 20, 16]

    Explanation 2:
     Nodes which are in range [2, 20] are : [8, 6, 7]
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

    private static int solve(TreeNode A, int B, int C) {
        if (A == null)
            return 0;
        if (A.val < B)
            return solve(A.right, B, C);
        else if (A.val > C)
            return solve(A.left, B, C);
        else
            // B <= A.val <= C where B = low and C = high
            return (1 + solve(A.left, B, C) + solve(A.right, B, C));
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(15);
        root.left = new TreeNode(12);
        root.right = new TreeNode(20);
        root.left.left = new TreeNode(10);
        root.left.right = new TreeNode(14);
        root.right.left = new TreeNode(16);
        root.right.right = new TreeNode(27);
        root.left.left.left = new TreeNode(8);

        int B = 12;
        int C = 20;

        System.out.println(solve(root, B, C));
    }
}
