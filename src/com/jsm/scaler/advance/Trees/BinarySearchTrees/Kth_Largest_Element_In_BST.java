package com.jsm.scaler.advance.Trees.BinarySearchTrees;

import java.util.Stack;

public class Kth_Largest_Element_In_BST {
    /*
    Given a binary search tree represented by root A, write a function to find the Bth largest element in the tree.

    Problem Constraints
    1 <= Number of nodes in binary tree <= 100000
    0 <= node values <= 10^9

    Input Format
    First and only argument is head of the binary tree A.

    Output Format
    Return an integer, representing the Bth element.

    Example Input:
    Input 1:
                2
              /   \
             1    3
    B = 2

    Input 2:
                3
               /
              2
             /
            1
    B = 1

    Example Output:
    Output 1:
     2

    Output 2:
     3

    Example Explanation:
    Explanation 1:
    2nd element is 2.

    Explanation 2:
    1st element is 3.
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

    private static int kthlargest(TreeNode A, int B) {
        Stack<TreeNode> stack = new Stack<>();
        TreeNode node = A;
        int cnt = 0;
        while (true) {
            if (node != null) {
                stack.push(node);
                node = node.right;
            } else {
                if (stack.isEmpty()) {
                    break;
                }
                node = stack.pop();
                // inorder.add(node.val);
                cnt++;
                if (cnt == B) return node.val;
                node = node.left;
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(2);
        root.left = new TreeNode(1);
        root.right = new TreeNode(3);

        int B = 1;

        System.out.println(kthlargest(root, B));
    }
}
