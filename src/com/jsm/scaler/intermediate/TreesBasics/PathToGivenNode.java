package com.jsm.scaler.intermediate.TreesBasics;

import java.util.ArrayList;

public class PathToGivenNode {
    /*
    Given a Binary Tree A containing N nodes, you need to find the path from Root to a given node B.
    NOTE:
    No two nodes in the tree have the same data values.
    You can assume that B is present in tree A and a path always exists.

    Problem Constraints
    1 <= N <= 105
    1 <= Data Values of Each Node <= N
    1 <= B <= N

    Input Format
    First Argument represents pointer to the root of binary tree A.
    Second Argument is an integer B denoting the node number.

    Output Format
    Return a one-dimensional array denoting the path from Root to the node B in order.

    Example Input

    Input 1:
     A =
               1
             /   \
            2     3
           / \   / \
          4   5 6   7

     B = 5

    Input 2:
     A =
                1
              /   \
             2     3
            / \ .   \
           4   5 .   6

     B = 1

    Example Output

    Output 1:
     [1, 2, 5]

    Output 2:
     [1]

    Example Explanation

    Explanation 1:
     We need to find the path from root node to node with data value 5.
     So the path is 1 -> 2 -> 5 so we will return [1, 2, 5]

    Explanation 2:
     We need to find the path from root node to node with data value 1.
     As node with data value 1 is the root so there is only one node in the path.
     So we will return [1]
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

    static ArrayList<Integer> res = new ArrayList<>();
    static boolean ans = false;

    private static ArrayList<Integer> solve(TreeNode A, int B) {
        if (A == null)
            return null;
        res.add(A.val);
        if (A.val == B) {
            ans = true;
            return res;
        }
        ArrayList<Integer> left = solve(A.left, B);
        if (ans)
            return res;
        ArrayList<Integer> right = solve(A.right, B);
        if (ans)
            return res;
        res.remove(A.val);
        return res;
    }

    public static void main(String[] args) {

    }
}
