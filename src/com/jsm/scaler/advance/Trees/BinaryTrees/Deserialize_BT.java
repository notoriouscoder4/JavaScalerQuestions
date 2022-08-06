package com.jsm.scaler.advance.Trees.BinaryTrees;

import java.util.*;

public class Deserialize_BT {
    /*
    You are given an integer array A denoting the Level Order Traversal of the Binary Tree.
    You have to Deserialize the given Traversal in the Binary Tree and return the root of the Binary Tree.

    NOTE:
    In the array, the NULL/None child is denoted by -1.
    For more clarification check the Example Input.

    Problem Constraints
    1 <= number of nodes <= 10^5
    -1 <= A[i] <= 10^5

    Input Format
    Only argument is an integer array A denoting the Level Order Traversal of the Binary Tree.

    Output Format
    Return the root node of the Binary Tree.

    Example Input:
    Input 1:
     A = [1, 2, 3, 4, 5, -1, -1, -1, -1, -1, -1]

    Input 2:
     A = [1, 2, 3, 4, 5, -1, 6, -1, -1, -1, -1, -1, -1]

    Example Output:
    Output 1:

               1
             /   \
            2     3
           / \
          4   5

    Output 2:
                1
              /   \
             2     3
            / \ .   \
           4   5 .   6

    Example Explanation:
    Explanation 1:
     Each element of the array denotes the value of the node. If the val is -1 then it is the NULL/None child.
     Since 3, 4 and 5 each has both NULL child we had represented that using -1.

    Explanation 2:
     Each element of the array denotes the value of the node. If the val is -1 then it is the NULL/None child.
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

    private static TreeNode deserializeBT(ArrayList<Integer> A) {
        TreeNode root = new TreeNode(A.get(0));
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);

        int index = 1;
        while (!queue.isEmpty()) {
            TreeNode curr = queue.poll();
            if (curr == null)
                continue;
            int val_left = A.get(index);
            int val_right = A.get(index + 1);
            index += 2;

            if (val_left == -1)
                curr.left = null;
            else
                curr.left = new TreeNode(val_left);

            if (val_right == -1)
                curr.right = null;
            else
                curr.right = new TreeNode(val_right);

            queue.add(curr.left);
            queue.add(curr.right);
        }
        return root;
    }

    public static void main(String[] args) {
        ArrayList<Integer> A = new ArrayList<>(Arrays.asList(1, 2, 3, 4, 5, -1, -1, -1, -1, -1, -1));
        System.out.println(deserializeBT(A));
    }
}
