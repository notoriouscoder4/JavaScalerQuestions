package com.jsm.scaler.intermediate.TreesBasics;

import java.util.ArrayList;
import java.util.Stack;

public class PreOrderTraversal {
    /*
    Given a binary tree, return the preorder traversal of its nodes' values.
    NOTE: Using recursion is not allowed.

    Problem Constraints
    1 <= number of nodes <= 105

    Input Format
    First and only argument is root node of the binary tree, A.

    Output Format
    Return an integer array denoting the preorder traversal of the given binary tree.

    Example Input

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

    Example Output

    Output 1:
     [1, 2, 3]

    Output 2:
     [1, 6, 2, 3]

    Example Explanation

    Explanation 1:
     The Preorder Traversal of the given tree is [1, 2, 3].

    Explanation 2:
     The Preorder Traversal of the given tree is [1, 6, 2, 3].
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

    private static ArrayList<Integer> preOrderTraversal(TreeNode A) {
        ArrayList<Integer> res = new ArrayList<>();
        Stack<TreeNode> stack = new Stack<>();

        if (A == null)
            return res;
        stack.push(A);
        while (!stack.isEmpty()) {
            A = stack.pop();
            res.add(A.val);
            if (A.right != null)
                stack.push(A.right);
            if (A.left != null)
                stack.push(A.left);
        }
        return res;
    }

    public static void main(String[] args) {

    }
}
