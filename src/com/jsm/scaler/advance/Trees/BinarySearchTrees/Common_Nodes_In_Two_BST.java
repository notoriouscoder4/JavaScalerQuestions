package com.jsm.scaler.advance.Trees.BinarySearchTrees;

import java.util.Stack;

public class Common_Nodes_In_Two_BST {
    /*
    Given two BST's A and B, return the (sum of all common nodes in both A and B) % (109 +7) .
    In case there is no common node, return 0.

    NOTE:
    Try to do it one pass through the trees.

    Problem Constraints
    1 <= Number of nodes in the tree A and B <= 10^5
    1 <= Node values <= 10^6

    Input Format
    First argument represents the root of BST A.
    Second argument represents the root of BST B.

    Output Format
    Return an integer denoting the (sum of all common nodes in both BST's A and B) % (109 +7) .

    Example Input
    Input 1:
     Tree A:
        5
       / \
      2   8
       \   \
        3   15
            /
            9

     Tree B:
        7
       / \
      1  10
       \   \
        2  15
           /
          11

    Input 2:
      Tree A:
        7
       / \
      1   10
       \   \
        2   15
            /
           11

     Tree B:
        7
       / \
      1  10
       \   \
        2  15
           /
          11

    Example Output:
    Output 1:
     17

    Output 2:
     46

    Example Explanation:
    Explanation 1:
     Common Nodes are : 2, 15
     So answer is 2 + 15 = 17

    Explanation 2:
     Common Nodes are : 7, 2, 1, 10, 15, 11
     So answer is 7 + 2 + 1 + 10 + 15 + 11 = 46
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

    private static int solve(TreeNode A, TreeNode B) {
        /* TC: O(N + M), SC: (h1 + h2) */
        long sum = 0;
        long MOD = 1000000007;

        Stack<TreeNode> stackA = new Stack<>();
        Stack<TreeNode> stackB = new Stack<>();

        while (true) {
            if (A != null) {
                stackA.push(A);
                A = A.left;
            } else if (B != null) {
                stackB.push(B);
                B = B.left;
            } else if (!stackA.isEmpty() && !stackB.isEmpty()) {
                A = stackA.peek();
                B = stackB.peek();
                if (A.val == B.val) {
                    sum += A.val;
                    stackA.pop();
                    stackB.pop();
                    A = A.right;
                    B = B.right;
                } else if (A.val < B.val) {
                    stackA.pop();
                    A = A.right;
                    B = null;
                } else {
                    // A.val > B.val
                    stackB.pop();
                    B = B.right;
                    A = null;
                }
            } else
                break;
        }
        return (int) (sum % MOD);
    }

    public static void main(String[] args) {
        TreeNode A = new TreeNode(7);
        A.left = new TreeNode(1);
        A.right = new TreeNode(10);
        A.left.right = new TreeNode(2);
        A.right.right = new TreeNode(15);
        A.right.right.left = new TreeNode(11);

        TreeNode B = new TreeNode(7);
        B.left = new TreeNode(1);
        B.right = new TreeNode(10);
        B.left.right = new TreeNode(2);
        B.right.right = new TreeNode(15);
        B.right.right.left = new TreeNode(11);

        System.out.println(solve(A, B));
    }
}
