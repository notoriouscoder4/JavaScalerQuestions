package com.jsm.scaler.advance.Trees.BinaryTrees;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class Level_Order_Traversal_BFS {
    /*
    Given a binary tree, return the level order traversal of its nodes' values. (i.e., from left to right, level by level).

    Problem Constraints
    1 <= number of nodes <= 10^5

    Input Format
    First and only argument is root node of the binary tree, A.

    Output Format
    Return a 2D integer array denoting the zigzag level order traversal of the given binary tree.

    Example Input:
    Input 1:
        3
       / \
      9  20
        /  \
       15   7

    Input 2:
       1
      / \
     6   2
        /
       3

    Example Output:
    Output 1:
     [
       [3],
       [9, 20],
       [15, 7]
     ]

    Output 2:
     [
       [1]
       [6, 2]
       [3]
     ]

    Example Explanation:
    Explanation 1:
     Return the 2D array. Each row denotes the traversal of each level.
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

    private static ArrayList<ArrayList<Integer>> levelOrder(TreeNode A) {
        if (A == null)
            return new ArrayList<>();

        ArrayList<ArrayList<Integer>> levelOrderNodes = new ArrayList<>();
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(A);

        while (!queue.isEmpty()) {
            int size = queue.size(); // size of current queue
            ArrayList<Integer> level = new ArrayList<>(); // list of any particular level
            for (int i = 0; i < size; ++i) {
                TreeNode temp = queue.poll();
                level.add(temp.val);
                if (temp.left != null)
                    queue.add(temp.left);
                if (temp.right != null)
                    queue.add(temp.right);
            }
            levelOrderNodes.add(level);
        }
        return levelOrderNodes;
    }

    public static void main(String[] args) {

    }
}
