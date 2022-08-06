package com.jsm.scaler.advance.Trees.BinaryTrees;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class LeftView_Level_Order_Traversal {
    /*
    Given a binary tree of integers. Return an array of integers representing the left view of the Binary tree.
    Left view of a Binary Tree is a set of nodes visible when the tree is visited from Left side

    NOTE: The value comes first in the array which have lower level.

    Problem Constraints
    1 <= Number of nodes in binary tree <= 100000
    0 <= node values <= 10^9

    Input Format
    First and only argument is a root node of the binary tree, A.

    Output Format
    Return an integer array denoting the left view of the Binary tree.

    Example Input
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

    Example Output
    Output 1:
     [1, 2, 4, 8]

    Output 2:
     [1, 2, 4, 5]

    Example Explanation:
    Explanation 1:
     The Left view of the binary tree is returned.
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

    private static ArrayList<Integer> leftView(TreeNode A) {
        if (A == null)
            return new ArrayList<>();
        ArrayList<Integer> ans = new ArrayList<>();
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(A);
        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int i = 0; i < size; ++i) {
                TreeNode temp = queue.poll();
                if (i == 0)
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
