package com.jsm.scaler.advance.Trees.BinaryTrees;

import java.util.HashMap;
import java.util.Map;

public class Binary_Tree_From_Inorder_And_Postorder {
    /*
    Given the inorder and postorder traversal of a tree, construct the binary tree.
    NOTE: You may assume that duplicates do not exist in the tree.

    Problem Constraints
    1 <= number of nodes <= 10^5

    Input Format
    First argument is an integer array A denoting the inorder traversal of the tree.
    Second argument is an integer array B denoting the postorder traversal of the tree.

    Output Format
    Return the root node of the binary tree.

    Example Input
    Input 1:
     A = [2, 1, 3]
     B = [2, 3, 1]

    Input 2:
     A = [6, 1, 3, 2]
     B = [6, 3, 2, 1]

    Example Output
    Output 1:
       1
      / \
     2   3

    Output 2:
       1
      / \
     6   2
        /
       3

    Example Explanation:
    Explanation 1:
     Create the binary tree and return the root node of the tree.
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

    private static TreeNode buildTree(int[] A, int[] B) {
        HashMap<Integer, Integer> inorderMap = new HashMap<>();
        for (int i = 0; i < A.length; ++i)
            inorderMap.put(A[i], i);
        return buildTree(A, 0, A.length - 1, B, 0, B.length - 1, inorderMap);
    }

    private static TreeNode buildTree(int[] inorder, int inStart, int inEnd, int[] postorder, int postStart, int postEnd, Map<Integer, Integer> inorderMap) {
        if (inStart > inEnd || postStart > postEnd) return null;

        TreeNode root = new TreeNode(postorder[postEnd]);
        int idx = inorderMap.get(postorder[postEnd]); // finding index of root in inorder array
        int x = idx - inStart; // no. of elements in LST of inorder array
        root.left = buildTree(inorder, inStart, idx - 1, postorder, postStart, postStart + x - 1, inorderMap);
        root.right = buildTree(inorder, idx + 1, inEnd, postorder, postStart + x, postEnd - 1, inorderMap);
        return root;
    }

    public static void main(String[] args) {
        int[] inorder = {4, 8, 2, 5, 1, 6, 3, 7};
        int[] postorder = {8, 4, 5, 2, 6, 7, 3, 1};
        TreeNode root = buildTree(inorder, postorder);
        System.out.println(root);
    }
}
