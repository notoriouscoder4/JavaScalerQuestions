package com.jsm.scaler.advance.Trees.BinaryTrees;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Stack;

public class Postorder_Traversal {
    /*
    Given a binary tree, return the Postorder traversal of its nodes values.

    NOTE: Using recursion is not allowed.

    Problem Constraints
    1 <= number of nodes <= 10^5

    Input Format
    First and only argument is root node of the binary tree, A.

    Output Format
    Return an integer array denoting the Postorder traversal of the given binary tree.

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
     [3, 2, 1]

    Output 2:
     [6, 3, 2, 1]

    Example Explanation:
    Explanation 1:
     The Postorder Traversal of the given tree is [3, 2, 1].

    Explanation 2:
     The Postorder Traversal of the given tree is [6, 3, 2, 1].
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

    private static ArrayList<Integer> postorderTraversal(TreeNode A) {
        if (A == null)
            return new ArrayList<>();

        ArrayList<Integer> postorderNodes = new ArrayList<>();
        Stack<TreeNode> stack = new Stack<>();
        stack.push(A);

        while (!stack.isEmpty()) {
            A = stack.pop();
            postorderNodes.add(A.val);
            if (A.left != null)
                stack.push(A.left);
            if (A.right != null)
                stack.push(A.right);
        }
        Collections.reverse(postorderNodes);
        return postorderNodes;
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(11);
        root.left = new TreeNode(6);
        root.right = new TreeNode(15);
        root.left.left = new TreeNode(2);
        root.left.right = new TreeNode(9);
        root.right.left = new TreeNode(7);
        root.left.right.left = new TreeNode(13);
        System.out.println(postorderTraversal(root));
    }
}
