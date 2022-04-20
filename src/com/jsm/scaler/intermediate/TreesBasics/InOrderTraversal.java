package com.jsm.scaler.intermediate.TreesBasics;

import java.util.ArrayList;
import java.util.Stack;

public class InOrderTraversal {
    /*
    Given a binary tree, return the inorder traversal of its nodes' values.
    NOTE: Using recursion is not allowed.

    Problem Constraints
    1 <= number of nodes <= 105

    Input Format
    First and only argument is root node of the binary tree, A.

    Output Format
    Return an integer array denoting the inorder traversal of the given binary tree.

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
     [1, 3, 2]

    Output 2:
     [6, 1, 3, 2]

    Example Explanation

    Explanation 1:
     The Inorder Traversal of the given tree is [1, 3, 2].

    Explanation 2:
     The Inorder Traversal of the given tree is [6, 1, 3, 2].
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


    private static ArrayList<Integer> inOrderTraversal(TreeNode A) {
        ArrayList<Integer> res = new ArrayList<>();
        Stack<TreeNode> stack = new Stack<>();

        while (A != null || !stack.isEmpty()) {
            if (A != null) {
                stack.push(A);
                A = A.left;
            } else {
                A = stack.pop();
                res.add(A.val);
                A = A.right;
            }
        }
        return res;

        /* Scaler Solution
        TreeNode current, node;
	    ArrayList<Integer> res = new ArrayList<>();
	    current = A;
	    while (current != null) {
	        if (current.left == null) {
	            res.add(current.val);
	            current = current.right;
	        } else {
	            node = current.left;
	            while (node.right != null && !current.equals(node.right))
	                node = node.right;

	            if (node.right == null) {
	                node.right = current;
	                current = current.left;
	            } else {
	                current = node.right;
	                node.right = null;
	                res.add(current.val);
	                current = current.right;
	            }
	        }
	    }
	    return res;
        */
    }

    public static void main(String[] args) {

    }
}
