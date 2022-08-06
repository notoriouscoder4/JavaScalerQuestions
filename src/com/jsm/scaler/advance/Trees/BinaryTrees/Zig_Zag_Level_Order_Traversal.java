package com.jsm.scaler.advance.Trees.BinaryTrees;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class Zig_Zag_Level_Order_Traversal {
    /*
    Given a binary tree, return the zigzag level order traversal of its nodes values.
    (ie, from left to right, then right to left for the next level and alternate between).

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
       [20, 9],
       [15, 7]
     ]

    Output 2:
     [
       [1]
       [2, 6]
       [3]
     ]

    Example Explanation:
    Explanation 1:
     Return the 2D array. Each row denotes the zigzag traversal of each level.
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

    private static ArrayList<ArrayList<Integer>> zigzagLevelOrder(TreeNode A) {
        if (A == null)
            return new ArrayList<>();

        ArrayList<ArrayList<Integer>> zigzagOrderNodes = new ArrayList<>();
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(A);

        boolean leftToRight = true;
        while (!queue.isEmpty()) {
            int size = queue.size();
            ArrayList<Integer> levelList = new ArrayList<>();
            for (int i = 0; i < size; ++i) {
                TreeNode temp = queue.poll();
                if (leftToRight)
                    levelList.add(temp.val);
                else
                    levelList.add(0, temp.val);
                if (temp.left != null)
                    queue.add(temp.left);
                if (temp.right != null)
                    queue.add(temp.right);
            }
            leftToRight = !leftToRight;
            zigzagOrderNodes.add(levelList);
        }
        return zigzagOrderNodes;
    }
}
