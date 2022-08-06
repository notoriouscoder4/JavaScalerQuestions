package com.jsm.scaler.advance.Trees.BinarySearchTrees;

import java.util.ArrayList;

public class Recover_BST {
    /*
    Two elements of a binary search tree (BST), represented by root A are swapped by mistake.
    Tell us the 2 values swapping which the tree will be restored.
    A solution using O(n) space is pretty straightforward. Could you devise a constant space solution?

    Problem Constraints
    1 <= size of tree <= 100000

    Input Format
    First and only argument is the head of the tree,A

    Output Format
    Return the 2 elements which need to be swapped.

    Example Input:
    Input 1:
             1
            / \
           2   3

    Input 2:
             2
            / \
           3   1

    Example Output:
    Output 1:
     [2, 1]

    Output 2:
     [3, 1]

    Example Explanation:
    Explanation 1:
    Swapping 1 and 2 will change the BST to be
             2
            / \
           1   3
    which is a valid BST

    Explanation 2:
    Swapping 1 and 3 will change the BST to be
             2
            / \
           1   3
    which is a valid BST
    */

    /*
    We will maintain three-pointers, first, middle, and last.
    When we find the first point where the current node value is smaller than the previous node value,
    we update the first with the previous node & the middle with the current node.
    When we find the second point where the current node value is smaller than the previous node value,
    we update the last with the current node. In the case of #2, we will never find the second point.
    So, the last pointer will not be updated. After processing, if the last node value is null, then two swapped nodes of BST are adjacent.
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

    private static TreeNode first;
    private static TreeNode middle;
    private static TreeNode last;
    private static TreeNode prev;

    private static void inorder(TreeNode root) {
        if (root == null) return;
        inorder(root.left);

        if (prev != null && root.val < prev.val) {
            // If this is first violation, mark these two nodes as
            // 'first' and 'middle'
            if (first == null) {
                first = prev;
                middle = root;
            } else
                // If this is second violation, mark this node as last
                last = root;
        }

        // Mark this node as previous (it will be first time)
        prev = root;
        inorder(root.right);
    }

    private static ArrayList<Integer> recoverTree(TreeNode A) {
        ArrayList<Integer> ans = new ArrayList<>();

        first = middle = last = null;
        prev = new TreeNode(Integer.MIN_VALUE);
        inorder(A);
        if (first != null && last != null) {
            int temp = first.val;
            first.val = last.val;
            last.val = temp;
            ans.add(first.val);
            ans.add(last.val);
        } else if (first != null && middle != null) {
            int temp = first.val;
            first.val = middle.val;
            middle.val = temp;
            ans.add(first.val);
            ans.add(middle.val);
        }
        return ans;
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(2);
        root.left = new TreeNode(3);
        root.right = new TreeNode(1);
        System.out.println(recoverTree(root));
    }
}
