package com.jsm.scaler.advance.Trees.BinaryTrees;

import java.util.HashMap;
import java.util.HashSet;

public class Equal_Tree_Partition {
    /*
    Given a binary tree A.
    Check whether it is possible to partition the tree to two trees which have equal sum of values after removing exactly one edge on the original tree.

    Problem Constraints
    1 <= size of tree <= 100000
    0 <= value of node <= 10^9

    Input Format
    First and only argument is head of tree A.

    Output Format
    Return 1 if the tree can be partitioned into two trees of equal sum else return 0.

    Example Input:
    Input 1:
                    5
                   /  \
                  3    7
                 / \  / \
                4  6  5  6

    Input 2:
                    1
                   / \
                  2   10
                      / \
                     20  2

    Example Output:
    Output 1:
     1

    Output 2:
     0

    Example Explanation:
    Explanation 1:
     Remove edge between 5(root node) and 7:
            Tree 1 =                                               Tree 2 =
                            5                                                     7
                           /                                                     / \
                          3                                                     5   6
                         / \
                        4   6
            Sum of Tree 1 = Sum of Tree 2 = 18

    Explanation 2:
     The given Tree cannot be partitioned.
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

    /* The problem is reduced to finding such a subtree which sum of values as Sum/2 where Sum is the sum of all values of B.T
     * Algorithm :
     *   1. Record the sum of every subtree recursively using DFS.
     *   2. Check if some subtree has sum equal to half of the sum of entire tree.
     */

    private static long dfs(TreeNode root, HashMap<Long, Integer> map) {
        if (root == null)
            return 0;
        long sum = root.val + dfs(root.left, map) + dfs(root.right, map);
        map.put(sum, map.getOrDefault(sum, 0) + 1);
        return sum;
    }

    private static int checkEqualPartition(TreeNode root) {
        HashMap<Long, Integer> map = new HashMap<>();
        long sum = dfs(root, map);
        if (sum == 0)
            return map.getOrDefault(sum, 0) > 1 ? 1 : 0;
        return sum % 2 == 0 && map.containsKey(sum / 2) ? 1 : 0;
    }

    private static int solve(TreeNode A) {
        return checkEqualPartition(A);
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(5);
        root.left = new TreeNode(3);
        root.right = new TreeNode(7);
        root.left.left = new TreeNode(4);
        root.left.right = new TreeNode(6);
        root.right.left = new TreeNode(5);
        root.right.right = new TreeNode(6);

        System.out.println(solve(root));
    }
}
