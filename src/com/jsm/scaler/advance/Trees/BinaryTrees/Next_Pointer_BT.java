package com.jsm.scaler.advance.Trees.BinaryTrees;

public class Next_Pointer_BT {
    /*
    Given a binary tree,
    Populate each next pointer to point to its next right node. If there is no next right node, the next pointer should be set to NULL.
    Initially, all next pointers are set to NULL.
    Assume perfect binary tree and try to solve this in constant extra space.

    Problem Constraints
    1 <= Number of nodes in binary tree <= 100000
    0 <= node values <= 10^9

    Input Format
    First and only argument is head of the binary tree A.

    Output Format
    Return the head of the binary tree after the changes are made.

    Example Input:
    Input 1:
     1
    /  \
    2    3

    Input 2:
        1
       /  \
      2    5
     / \  / \
    3  4  6  7

    Example Output:
    Output 1:
        1 -> NULL
       /  \
      2 -> 3 -> NULL

    Output 2:
         1 -> NULL
       /  \
      2 -> 5 -> NULL
     / \  / \
    3->4->6->7 -> NULL

    Example Explanation:
    Explanation 1:
    Next pointers are set as given in the output.

    Explanation 2:
    Next pointers are set as given in the output.
    */

    private static class TreeLinkNode {
        public int val;
        public TreeLinkNode left;
        public TreeLinkNode right;
        public TreeLinkNode next;

        public TreeLinkNode(int val) {
            this.val = val;
        }
    }

    private static void connect(TreeLinkNode root) {
        TreeLinkNode curr_depth = root;
        while (curr_depth.left != null) {
            TreeLinkNode curr_level = curr_depth;
            while (curr_level != null) {
                curr_level.left.next = curr_level.right;
                if (curr_level.next != null)
                    curr_level.right.next = curr_level.next.left;
                curr_level = curr_level.next;
            }
            curr_depth = curr_depth.left;
        }
    }

    public static void main(String[] args) {
        TreeLinkNode root = new TreeLinkNode(1);
        root.left = new TreeLinkNode(2);
        root.right = new TreeLinkNode(5);
        root.left.left = new TreeLinkNode(3);
        root.left.right = new TreeLinkNode(4);
        root.right.left = new TreeLinkNode(6);
        root.right.right = new TreeLinkNode(7);

        connect(root);
    }
}
