package com.jsm.scaler.advance.Trees.BinarySearchTrees;

public class Sorted_Array_To_Balanced_BST {
    /*
    Given an array where elements are sorted in ascending order, convert it to a height Balanced Binary Search Tree (BBST).
    Balanced tree : a height-balanced binary tree is defined as a binary tree in which the depth of the two subtrees of every node never differ by more than 1.

    Problem Constraints
    1 <= length of array <= 100000

    Input Format
    First argument is an integer array A.

    Output Format
    Return a root node of the Binary Search Tree.

    Example Input
    Input 1:
     A : [1, 2, 3]

    Input 2:
     A : [1, 2, 3, 5, 10]

    Example Output:
    Output 1:
          2
        /   \
       1     3

    Output 2:
          3
        /   \
       2     5
      /       \
     1         10

    Example Explanation:
    Explanation 1:
     You need to return the root node of the Binary Tree.
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

    private static TreeNode sortedArrayToBST(final int[] A) {
        if (A.length < 2) return new TreeNode(A[0]);

        return construct(A, 0, A.length - 1);
    }

    private static TreeNode construct(int[] A, int start, int end) {
        if (start > end) return null;
        int mid = (start + end) / 2;
        TreeNode node = new TreeNode(A[mid]);
        node.left = construct(A, start, mid - 1);
        node.right = construct(A, mid + 1, end);
        return node;
    }

    public static void main(String[] args) {
        int[] A = {1, 2, 3, 5, 10};
        System.out.println(sortedArrayToBST(A));
    }
}
