package com.jsm.scaler.advance.Trees.BinaryTrees;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class RightView_Level_Order_Traversal {
    /*
    Given a binary tree of integers denoted by root A. Return an array of integers representing the right view of the Binary tree.
    Right view of a Binary Tree is a set of nodes visible when the tree is visited from Right side.

    Problem Constraints
    1 <= Number of nodes in binary tree <= 100000
    0 <= node values <= 10^9

    Input Format
    First and only argument is head of the binary tree A.

    Output Format
    Return an array, representing the right view of the binary tree.

    Example Input:
    Input 1:
                1
              /   \
             2    3
            / \  / \
           4   5 6  7
          /
         8

    Input 2:
                1
               /  \
              2    3
               \
                4
                 \
                  5

    Example Output:
    Output 1:
     [1, 3, 7, 8]

    Output 2:
     [1, 3, 4, 5]

    Example Explanation:
    Explanation 1:
    Right view is described.

    Explanation 2:
    Right view is described.
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

    private static ArrayList<Integer> rightView(TreeNode A) {
        if (A == null)
            return new ArrayList<>();
        ArrayList<Integer> ans = new ArrayList<>();
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(A);
        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int i = 0; i < size; ++i) {
                TreeNode temp = queue.poll();
                if (i == size - 1)
                    ans.add(temp.val);
                if (temp.left != null)
                    queue.add(temp.left);
                if (temp.right != null)
                    queue.add(temp.right);
            }
        }
        return ans;
    }

    public static void main(String[] args) {

    }
}
