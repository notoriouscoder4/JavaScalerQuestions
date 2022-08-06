package com.jsm.scaler.advance.Trees.BinaryTrees;

import java.util.ArrayList;

public class Morris_Preorder_Traversal {
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

    /* TC: O(N), SC: O(1) */
    private static ArrayList<Integer> morrisPreorderTraversal(TreeNode root) {
        if (root == null)
            return new ArrayList<>();

        ArrayList<Integer> ans = new ArrayList<>();
        TreeNode curr = root;
        while (curr != null) {
            if (curr.left == null) {
                ans.add(curr.val);
                curr = curr.right;
            } else {
                TreeNode temp = curr.left;
                while (temp.right != null && temp.right != curr)
                    temp = temp.right;
                if (temp.right == null) {
                    temp.right = curr;
                    ans.add(curr.val);
                    curr = curr.left;
                } else {
                    temp.right = null;
                    curr = curr.right;
                }
            }
        }
        return ans;
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(6);
        root.right = new TreeNode(8);
        root.right.right = new TreeNode(29);
        root.right.right.left = new TreeNode(20);
        root.right.right.right = new TreeNode(32);
        root.right.right.left.left = new TreeNode(15);
        root.right.right.left.right = new TreeNode(23);
        root.right.right.right.left = new TreeNode(30);
        root.right.right.right.right = new TreeNode(25);
        root.right.right.left.left.left = new TreeNode(9);
        root.right.right.left.left.right = new TreeNode(17);
        root.right.right.left.right.right = new TreeNode(25);
        root.right.right.right.right.left = new TreeNode(33);
        root.right.right.right.right.right = new TreeNode(39);
        root.right.right.left.left.left.right = new TreeNode(10);
        root.right.right.left.left.right.right = new TreeNode(19);
        root.right.right.left.left.left.right.right = new TreeNode(13);

        System.out.println(morrisPreorderTraversal(root));
    }
}
