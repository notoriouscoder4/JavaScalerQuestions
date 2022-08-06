package com.jsm.scaler.advance.Trees.BinaryTrees;

public class Path_Sum {
    /*
    Given a binary tree and a sum, determine if the tree has a root-to-leaf path such that adding up all the values along the path equals the given sum.

    Problem Constraints
    1 <= number of nodes <= 10^5
    -100000 <= B, value of nodes <= 100000

    Input Format
    First argument is a root node of the binary tree, A.
    Second argument is an integer B denoting the sum.

    Output Format
    Return 1, if there exist root-to-leaf path such that adding up all the values along the path equals the given sum. Else, return 0.

    Example Input:
    Input 1:
     Tree:    5
             / \
            4   8
           /   / \
          11  13  4
         /  \      \
        7    2      1

     B = 22

    Input 2:
     Tree:    5
             / \
            4   8
           /   / \
         -11 -13  4

     B = -1

    Example Output:
    Output 1:
     1

    Output 2:
     0

    Example Explanation:
    Explanation 1:
     There exist a root-to-leaf path 5 -> 4 -> 11 -> 2 which has sum 22. So, return 1.

    Explanation 2:

     There is no path which has sum -1.
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

    private static boolean hasSum(TreeNode root, int target) {
        if (root == null)
            return false;
        if (root.left == null && root.right == null)
            return target - root.val == 0;
        return hasSum(root.left, target - root.val) || hasSum(root.right, target - root.val);
    }

    private static int hasPathSum(TreeNode A, int B) {
        return hasSum(A, B) ? 1 : 0;
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(5);
        root.left = new TreeNode(4);
        root.right = new TreeNode(8);
        root.left.left = new TreeNode(11);
        root.right.left = new TreeNode(3);
        root.right.right = new TreeNode(4);
        root.left.left.left = new TreeNode(7);
        root.left.left.right = new TreeNode(2);
        root.right.right.right = new TreeNode(1);

        int B = 22;
        System.out.println(hasPathSum(root, B));
    }
}
