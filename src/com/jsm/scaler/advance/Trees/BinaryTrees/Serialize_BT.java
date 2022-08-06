package com.jsm.scaler.advance.Trees.BinaryTrees;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class Serialize_BT {
    /*
    Given the root node of a Binary Tree denoted by A. You have to Serialize the given Binary Tree in the described format.

    Serialize means encode it into an integer array denoting the Level Order Traversal of the given Binary Tree.

    NOTE:
    In the array, the NULL/None child is denoted by -1.
    For more clarification check the Example Input.

    Problem Constraints
    1 <= number of nodes <= 10^5

    Input Format
    Only argument is A denoting the root node of a Binary Tree.

    Output Format
    Return an integer array denoting the Level Order Traversal of the given Binary Tree.

    Example Input:
    Input 1:
               1
             /   \
            2     3
           / \
          4   5

    Input 2:
                1
              /   \
             2     3
            / \     \
           4   5     6

    Example Output:
    Output 1:
     [1, 2, 3, 4, 5, -1, -1, -1, -1, -1, -1]

    Output 2:
     [1, 2, 3, 4, 5, -1, 6, -1, -1, -1, -1, -1, -1]

    Example Explanation:
    Explanation 1:
     The Level Order Traversal of the given tree will be [1, 2, 3, 4, 5 , -1, -1, -1, -1, -1, -1].
     Since 3, 4 and 5 each has both NULL child we had represented that using -1.

    Explanation 2:
     The Level Order Traversal of the given tree will be [1, 2, 3, 4, 5, -1, 6, -1, -1, -1, -1, -1, -1].
     Since 3 has left child as NULL while 4 and 5 each has both NULL child.
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

    private static ArrayList<Integer> serializeBT(TreeNode A) {
        if (A == null)
            return new ArrayList<>();

        ArrayList<Integer> ans = new ArrayList<>();
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(A);

        while (!queue.isEmpty()) {
            TreeNode currentNode = queue.poll();
            if (currentNode == null)
                // if currentNode is null, insert -1 in output
                ans.add(-1);
            else {
                // if currentNode is not null, add left and right to queue
                // insert currentNode value in output
                ans.add(currentNode.val);
                queue.add(currentNode.left);
                queue.add(currentNode.right);
            }
        }
        return ans;
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        root.left.left = new TreeNode(4);
        root.left.right = new TreeNode(5);
        System.out.println(serializeBT(root));
    }
}
