package com.jsm.scaler.advance.Trie.Tries_Of_Bits;

import java.util.Stack;

public class Flatten_BT_To_LL {
    /*
    Given a binary tree A, flatten it to a linked list in-place.
    The left child of all nodes should be NULL.

    Problem Constraints
    1 <= size of tree <= 100000

    Input Format
    First and only argument is the head of tree A.

    Output Format
    Return the linked-list after flattening.

    Example Input:
    Input 1:
         1
        / \
       2   3

    Input 2:
             1
            / \
           2   5
          / \   \
         3   4   6

    Example Output:
    Output 1:
    1
     \
      2
       \
        3

    Output 2:
    1
     \
      2
       \
        3
         \
          4
           \
            5
             \
              6

    Example Explanation:
    Explanation 1:
     Tree flattening looks like this.

    Explanation 2:
     Tree flattening looks like this.
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


    private static TreeNode flatten(TreeNode a) {
        return recursiveFlatten(a);
    }


    private static TreeNode prev = null;

    /* Recursive - TC: O(N), SC: O(N)*/
    private static TreeNode recursiveFlatten(TreeNode root) {
        if (root == null)
            return null;
        recursiveFlatten(root.right);
        recursiveFlatten(root.left);

        root.right = prev;
        root.left = null;
        prev = root;
        return root;
    }

    /* Iterative - TC: O(N), SC: O(N)*/
    private static TreeNode iterativeFlatten(TreeNode root) {
        Stack<TreeNode> stack = new Stack<>();
        stack.push(root);

        while (!stack.isEmpty()) {
            TreeNode curr = stack.peek();
            stack.pop();

            if (curr.right != null)
                stack.push(curr.right);
            if (curr.left != null)
                stack.push(curr.left);
            if (!stack.isEmpty())
                curr.right = stack.peek();
            curr.left = null;
        }
        return root;
    }

    private static TreeNode iterativeFlatten_(TreeNode root) {
        /* Iterative - TC: O(N), SC: O(1)*/
        TreeNode curr = root;
        while (curr != null) {
            if (curr.left != null) {
                TreeNode prev = curr.left;
                while (prev.right != null)
                    prev = prev.right;
                prev.right = curr.right;
                curr.right = curr.left;
                curr.left = null;
            }
            curr = curr.right;
        }
        return root;
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        System.out.println(flatten(root));
    }
}
