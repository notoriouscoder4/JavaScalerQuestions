package com.jsm.scaler.advance.Trees.BinarySearchTrees;

import java.util.Stack;

public class BST_Iterator_For_Before {

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

    private static Stack<TreeNode> stack = new Stack<>();

    public BST_Iterator_For_Before(TreeNode root) {
        pushAllRight(root);
    }

    public boolean hasBefore() {
        return !stack.isEmpty();
    }

    public int before() {
        TreeNode tempNode = stack.pop();
        pushAllRight(tempNode.left);
        return tempNode.val;
    }

    private static void pushAllRight(TreeNode node) {
        for (; node != null; stack.push(node), node = node.right) ;
    }
}
