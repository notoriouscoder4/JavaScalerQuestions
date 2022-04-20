package com.jsm.scaler.intermediate.TreesBasics;

public class CountingNodes {
    /*
    Given the root of a tree A with each node having a certain value, find the count of nodes with more value than all its ancestor.

    Problem Constraints
    1 <= Number of Nodes <= 200000
    1 <= Value of Nodes <= 2000000000

    Input Format
    The first and only argument of input is a tree node.

    Output Format
    Return a single integer denoting the count of nodes that have more value than all of its ancestors.

    Example Input

    Input 1:
         3

    Input 2:
        4
       / \
      5   2
         / \
        3   6

    Example Output

    Output 1:
     1

    Output 2:
     3

    Example Explanation

    Explanation 1:
     There's only one node in the tree that is the valid node.

    Explanation 2:
     The valid nodes are 4, 5 and 6.
    */

    private static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int val) {
            this.val = val;
            this.left = null;
            this.right = null;
        }
    }

    private static int solve(TreeNode A) {
        return countNodes(A, Integer.MIN_VALUE);
    }

    private static int countNodes(TreeNode root, int maxx) {
        if (root == null) // Base condition
            return 0;

        int ans = countNodes(root.left, Math.max(maxx, root.val)) + countNodes(root.right, Math.max(maxx, root.val));
        if (root.val > maxx) // Actual condition
            ans++;
        return ans;
    }

    public static void main(String[] args) {

    }
}
