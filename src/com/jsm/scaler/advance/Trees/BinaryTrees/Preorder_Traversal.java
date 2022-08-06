package com.jsm.scaler.advance.Trees.BinaryTrees;

import java.util.ArrayList;
import java.util.Stack;

public class Preorder_Traversal {
    /*
    Given a binary tree, return the preorder traversal of its nodes values.

    NOTE: Using recursion is not allowed.

    Problem Constraints
    1 <= number of nodes <= 10^5

    Input Format
    First and only argument is root node of the binary tree, A.

    Output Format
    Return an integer array denoting the preorder traversal of the given binary tree.

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
     [1, 2, 3]

    Output 2:
     [1, 6, 2, 3]

    Example Explanation:
    Explanation 1:
     The Preorder Traversal of the given tree is [1, 2, 3].

    Explanation 2:
     The Preorder Traversal of the given tree is [1, 6, 2, 3].
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

    private static ArrayList<Integer> preorderTraversal(TreeNode A) {
        if (A == null)
            return new ArrayList<>();

        ArrayList<Integer> preorderNodes = new ArrayList<>();
        Stack<TreeNode> stack = new Stack<>();
        stack.push(A);

        while (!stack.isEmpty()) {
            A = stack.peek();
            stack.pop();
            preorderNodes.add(A.val);
            /*
            Since we know that, in preorder traversal we traverse the tree in Root_Left_Right fashion,
            and since we are using Stack, and we will push the nodes in the Stack in Left_Right fashion
            after pushing the root then when we pop from the stack we will get in this fashion i.e. Right_Left,
            therefore we will reverse the process of pushing nodes in the stack i.e. Right_Left
            */
            if (A.right != null)
                stack.push(A.right);
            if (A.left != null)
                stack.push(A.left);
        }
        return preorderNodes;
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(11);
        root.left = new TreeNode(6);
        root.right = new TreeNode(15);
        root.left.left = new TreeNode(2);
        root.left.right = new TreeNode(9);
        root.right.left = new TreeNode(7);
        root.left.right.left = new TreeNode(13);

        System.out.println(preorderTraversal(root));
    }
}
