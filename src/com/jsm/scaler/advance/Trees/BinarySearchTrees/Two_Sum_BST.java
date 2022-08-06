package com.jsm.scaler.advance.Trees.BinarySearchTrees;

import java.util.Stack;

public class Two_Sum_BST {
    /*
    Given a binary search tree A, where each node contains a positive integer, and an integer B,
    you have to find whether there exist two different nodes X and Y such that X.value + Y.value = B.

    Return 1 to denote that two such nodes exist. Return 0, otherwise.

    Problem Constraints
    1 <= size of tree <= 100000
    1 <= B <= 10^9

    Input Format:
    First argument is the head of the tree A.
    Second argument is the integer B.

    Output Format:
    Return 1 if such a pair can be found, 0 otherwise.

    Example Input:
    Input 1:
             10
             / \
            9   20

    B = 19

    Input 2:
              10
             / \
            9   20

    B = 40

    Example Output:
    Output 1:
     1

    Output 2:
     0

    Example Explanation:
    Explanation 1:
     10 + 9 = 19. Hence, 1 is returned.

    Explanation 2:
     No such pair exists.
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

    private static class BST_Iterator {
        public static final Stack<TreeNode> stack = new Stack<>();
        // reverse -> true -> before
        // reverse -> false -> next
        public boolean reverse = true;

        public BST_Iterator(TreeNode root, boolean isReverse) {
            reverse = isReverse;
            pushAll(root);
        }

        /**
         * @return whether we have a next smallest number
         */
        public boolean hashNext() {
            return !stack.isEmpty();
        }

        /**
         * @return the next smallest number
         */
        public int next() {
            TreeNode tempNode = stack.pop();
            if (!reverse)
                pushAll(tempNode.right);
            else
                pushAll(tempNode.left);
            return tempNode.val;
        }

        public void pushAll(TreeNode node) {
            while (node != null) {
                stack.push(node);
                if (reverse)
                    // for before
                    node = node.right;
                else
                    // for next
                    node = node.left;
            }
        }
    }

    private static int twoSumBST(TreeNode A, int B) {
        if (A == null)
            return 0;
        // for next
        BST_Iterator l = new BST_Iterator(A, false);
        // for before
        BST_Iterator r = new BST_Iterator(A, true);

        int i = l.next();
        int j = r.next(); // this should be as r.before() but extra code decrease code quality

        while (i < j) {
            if (i + j == B)
                return 1;
            else if (i + j < B)
                i = l.next();
            else
                j = r.next();
        }
        return 0;
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(10);
        root.left = new TreeNode(9);
        root.right = new TreeNode(20);

        int B = 19;

        System.out.println(twoSumBST(root, B));
    }
}
