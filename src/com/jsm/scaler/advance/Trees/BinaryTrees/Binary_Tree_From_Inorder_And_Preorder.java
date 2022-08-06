package com.jsm.scaler.advance.Trees.BinaryTrees;

import java.util.HashMap;
import java.util.Map;

public class Binary_Tree_From_Inorder_And_Preorder {
    /*
    Given preorder and inorder traversal of a tree, construct the binary tree.

    NOTE: You may assume that duplicates do not exist in the tree.

    Problem Constraints
    1 <= number of nodes <= 10^5

    Input Format
    First argument is an integer array A denoting the preorder traversal of the tree.
    Second argument is an integer array B denoting the inorder traversal of the tree.

    Output Format
    Return the root node of the binary tree.

    Example Input
    Input 1:
     A = [1, 2, 3]
     B = [2, 1, 3]

    Input 2:
     A = [1, 6, 2, 3]
     B = [6, 1, 3, 2]

    Example Output:
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
        for (int i = 0; i < B.length; ++i)
            inorderMap.put(B[i], i);

        return buildTree(A, 0, A.length - 1, B, 0, B.length - 1, inorderMap);
    }

    private static TreeNode buildTree(int[] preorder, int preStart, int preEnd, int[] inorder, int inStart, int inEnd, Map<Integer, Integer> inMap) {
        if (preStart > preEnd || inStart > inEnd) return null;

        TreeNode root = new TreeNode(preorder[preStart]);
        int idx = inMap.get(preorder[preStart]); // finding index of root in inorder array
        int x = idx - inStart; // no. of elements in LST of inorder array
        root.left = buildTree(preorder, preStart + 1, preStart + x, inorder, inStart, idx - 1, inMap);
        root.right = buildTree(preorder, preStart + x + 1, preEnd, inorder, idx + 1, inEnd, inMap);
        return root;
    }

    public static void main(String[] args) {
        int[] preorder = {10, 20, 40, 50, 30, 60};
        int[] inorder = {40, 20, 50, 10, 60, 30};
        TreeNode root = buildTree(preorder, inorder);
        System.out.println(root);
    }
}
