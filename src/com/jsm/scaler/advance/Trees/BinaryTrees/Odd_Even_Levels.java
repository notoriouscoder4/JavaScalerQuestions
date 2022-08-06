package com.jsm.scaler.advance.Trees.BinaryTrees;

import java.util.LinkedList;
import java.util.Queue;

public class Odd_Even_Levels {
    /*
    Given a binary tree of integers. Find the difference between the sum of nodes at odd level and sum of nodes at even level.

    NOTE: Consider the level of root node as 1.

    Problem Constraints
    1 <= Number of nodes in binary tree <= 100000
    0 <= node values <= 10^9

    Input Format
    First and only argument is a root node of the binary tree, A

    Output Format
    Return an integer denoting the difference between the sum of nodes at odd level and sum of nodes at even level.

    Example Input:
    Input 1:
            1
          /   \
         2     3
        / \   / \
       4   5 6   7
      /
     8

    Input 2:
            1
           / \
          2   10
           \
            4

    Example Output:
    Output 1:
     10

    Output 2:
     -7

    Example Explanation:
    Explanation 1:
     Sum of nodes at odd level = 23
     Sum of nodes at even level = 13

    Explanation 2:
     Sum of nodes at odd level = 5
     Sum of nodes at even level = 12
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

    private static int solve(TreeNode A) {
        int oddEvenDiff = 0;
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(A);

        boolean isOddLevel = true;
        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int i = 0; i < size; ++i) {
                TreeNode temp = queue.poll();
                assert temp != null;
                if (isOddLevel) {
                    oddEvenDiff += temp.val;
                } else
                    oddEvenDiff -= temp.val;
                if (temp.left != null)
                    queue.add(temp.left);
                if (temp.right != null)
                    queue.add(temp.right);
            }
            isOddLevel = !isOddLevel;
        }
        return oddEvenDiff;
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        root.left.left = new TreeNode(4);
        root.left.right = new TreeNode(5);
        root.right.left = new TreeNode(6);
        root.right.right = new TreeNode(7);
        root.left.left.left = new TreeNode(8);
        System.out.println(solve(root));
    }
}
