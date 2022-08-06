package com.jsm.scaler.advance.Trees.BinarySearchTrees;

import java.util.ArrayList;
import java.util.Arrays;

public class Check_BST_One_Child {
    /*
    Given preorder traversal of a binary tree, check if it is possible that it is also a preorder traversal of a Binary Search Tree (BST),
    where each internal node (non-leaf nodes) have exactly one child.

    Problem Constraints
    1 <= number of nodes <= 100000

    Input Format
    First and only argument is an integer array denoting the preorder traversal of binary tree.

    Output Format
    Return a string "YES" if true else "NO".

    Example Input
    Input 1:
     A : [4, 10, 5, 8]

    Input 2:
     A : [1, 5, 6, 4]

    Example Output
    Output 1:
     "YES"

    Output 2:
     "NO"

    Example Explanation:
    Explanation 1:
     The possible BST is:
                4
                 \
                 10
                 /
                 5
                  \
                  8

    Explanation 2:
     There is no possible BST which have the above preorder traversal.
    */

    private static String solve(ArrayList<Integer> A) {
        int L = Integer.MIN_VALUE;
        int R = Integer.MAX_VALUE;
        int root = A.get(0);
        for (int i = 1; i < A.size(); ++i) {
            if (A.get(i) > root)
                L = root;
            else
                R = root;
            if (A.get(i) < L || A.get(i) > R)
                return "NO";
            root = A.get(i);
        }
        return "YES";
    }

    public static void main(String[] args) {
        ArrayList<Integer> A = new ArrayList<>(Arrays.asList(1, 5, 6, 4));
        System.out.println(solve(A));
    }
}
