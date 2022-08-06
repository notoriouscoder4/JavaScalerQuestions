package com.jsm.scaler.advance.Trees.BinaryTrees;

public class Sum_BT_Or_Not {
    /*
    Given a binary tree. Check whether the given tree is a Sum-binary Tree or not.
    Sum-binary Tree is a Binary Tree where the value of every node is equal to sum of the nodes present in its left subtree and right subtree.
    An empty tree is Sum-binary Tree and sum of an empty tree can be considered as 0. A leaf node is also considered as SumTree.

    Return 1 if it sum-binary tree else return 0.

    Problem Constraints
    1 <= length of the array <= 100000
    0 <= node values <= 50

    Input Format
    The only argument given is the root node of tree A.

    Output Format
    Return 1 if it is sum-binary tree else return 0.

    Example Input:
    Input 1:
           26
         /    \
        10     3
       /  \     \
      4   6      3

    Input 2:
           26
         /    \
        10     3
       /  \     \
      4   6      4

    Example Output:
    Output 1:
     1

    Output 2:
     0

    Example Explanation:
    Explanation 1:
     All leaf nodes are considered as SumTree.
     Value of Node 10 = 4 + 6.
     Value of Node 3 = 0 + 3
     Value of Node 26 = 20 + 6

    Explanation 2:
     Sum of left subtree and right subtree is 27 which is not equal to the value of root node which is 26.
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

    private static class TreeInfo {
        public int sum;
        public boolean isSum;

        public TreeInfo(int sum, boolean isSum) {
            this.sum = sum;
            this.isSum = isSum;
        }
    }

    private static TreeInfo isSumTree(TreeNode root) {
        if (root == null)
            return new TreeInfo(0, true);

        if (root.left == null && root.right == null)
            return new TreeInfo(root.val, true);

        TreeInfo lInfo = isSumTree(root.left);
        TreeInfo rInfo = isSumTree(root.right);

        if (lInfo.isSum && rInfo.isSum && (lInfo.sum + rInfo.sum == root.val))
            return new TreeInfo(lInfo.sum + rInfo.sum + root.val, true);
        else
            return new TreeInfo(0, false);
    }

    private static int solve(TreeNode A) {
        if (A == null) return 0;
        return isSumTree(A).isSum ? 1 : 0;
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(26);
        root.left = new TreeNode(10);
        root.right = new TreeNode(3);
        root.left.left = new TreeNode(4);
        root.left.right = new TreeNode(6);
        root.right.right = new TreeNode(3);

        System.out.println(solve(root));
    }
}
