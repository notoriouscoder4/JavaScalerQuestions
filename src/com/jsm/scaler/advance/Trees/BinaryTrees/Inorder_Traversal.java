package com.jsm.scaler.advance.Trees.BinaryTrees;

import java.util.ArrayList;
import java.util.Stack;

public class Inorder_Traversal {
    /*
    Given a binary tree, return the inorder traversal of its nodes' values.

    NOTE: Using recursion is not allowed.

    Problem Constraints
    1 <= number of nodes <= 10^5

    Input Format
    First and only argument is root node of the binary tree, A.

    Output Format
    Return an integer array denoting the inorder traversal of the given binary tree.

    Example Input:
    Input 1:
       1
        \
         2
        /
       3

    Input 2:
       1
      / \
     6   2
        /
       3

    Example Output:
    Output 1:
     [1, 3, 2]

    Output 2:
     [6, 1, 3, 2]

    Example Explanation:
    Explanation 1:
     The Inorder Traversal of the given tree is [1, 3, 2].

    Explanation 2:
     The Inorder Traversal of the given tree is [6, 1, 3, 2].
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

    private static ArrayList<Integer> inorderTraversal(TreeNode A) {
        if (A == null)
            return new ArrayList<>();

        ArrayList<Integer> inorderNodes = new ArrayList<>();
        Stack<TreeNode> stack = new Stack<>();

        while (A != null || !stack.isEmpty()) {
            // iterate until left node
            if (A != null) {
                stack.push(A);
                A = A.left;
            } else {
                // traverse on the right node
                A = stack.peek();
                stack.pop();
                inorderNodes.add(A.val);
                A = A.right;
            }
        }
        return inorderNodes;
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(11);
        root.left = new TreeNode(6);
        root.right = new TreeNode(15);
        root.left.left = new TreeNode(2);
        root.left.right = new TreeNode(9);
        root.right.left = new TreeNode(7);
        root.left.right.left = new TreeNode(13);
        System.out.println(inorderTraversal(root));
    }
}
