package com.jsm.scaler.intermediate.TreesBasics;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Stack;

public class PostOrderTraversal {
    /*
    Given a binary tree, return the Postorder traversal of its nodes' values.
    NOTE: Using recursion is not allowed.

    Problem Constraints
    1 <= number of nodes <= 105

    Input Format
    First and only argument is root node of the binary tree, A.

    Output Format
    Return an integer array denoting the Postorder traversal of the given binary tree.

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
     [3, 2, 1]

    Output 2:
     [6, 3, 2, 1]

    Example Explanation

    Explanation 1:
     The Postorder Traversal of the given tree is [3, 2, 1].

    Explanation 2:
     The Postorder Traversal of the given tree is [6, 3, 2, 1].
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

    private static ArrayList<Integer> postOrderTraversal(TreeNode A) {
        ArrayList<Integer> res = new ArrayList<>();
        Stack<TreeNode> stack = new Stack<>();

        stack.push(A);
        while (!stack.isEmpty()) {
            TreeNode temp = stack.pop();
            res.add(temp.val);
            if (temp.left != null)
                stack.push(temp.left);
            if (temp.right != null)
                stack.push(temp.right);
        }
        Collections.reverse(res);
        return res;
    }

    public static void main(String[] args) {

    }
}
