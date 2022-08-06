package com.jsm.scaler.advance.Trees.BinarySearchTrees;

import java.util.Stack;

public class BST_Iterator_For_Next {

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

    public BST_Iterator_For_Next(TreeNode root) {
        pushAllLeft(root);
    }

    public boolean hashNext() {
        return !stack.isEmpty();
    }

    public int next() {
        TreeNode tempNode = stack.pop();
        pushAllLeft(tempNode.right);
        return tempNode.val;
    }

    private static void pushAllLeft(TreeNode node) {
        for (; node != null; stack.push(node), node = node.left) ;
    }
}
