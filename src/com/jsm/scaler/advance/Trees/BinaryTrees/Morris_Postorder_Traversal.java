package com.jsm.scaler.advance.Trees.BinaryTrees;

import java.util.ArrayList;

public class Morris_Postorder_Traversal {
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
    private static ArrayList<Integer> morrisPostorderTraversal(TreeNode root) {
        if (root == null)
            return new ArrayList<>();

        ArrayList<Integer> ans = new ArrayList<>();

        TreeNode curr, parent, middle, back;
        TreeNode temp = new TreeNode(0);
        temp.left = root;
        curr = temp;
        while (curr != null) {
            if (curr.left == null)
                curr = curr.right;
            else {
                TreeNode predecessor = curr.left;
                while (predecessor.right != null && predecessor.right != curr)
                    predecessor = predecessor.right;
                if (predecessor.right == null) {
                    predecessor.right = curr;
                    curr = curr.left;
                } else {
                    parent = curr;
                    middle = curr.left;
                    while (middle != curr) {
                        back = middle.right;
                        middle.right = parent;
                        parent = middle;
                        middle = back;
                    }
                    parent = curr;
                    middle = predecessor;
                    while (middle != curr) {
                        ans.add(middle.val);
                        back = middle.right;
                        middle.right = parent;
                        parent = middle;
                        middle = back;
                    }
                    predecessor.right = null;
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

        System.out.println(morrisPostorderTraversal(root));
    }
}
