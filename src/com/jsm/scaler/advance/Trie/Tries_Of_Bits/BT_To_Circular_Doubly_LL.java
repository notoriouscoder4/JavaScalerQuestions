package com.jsm.scaler.advance.Trie.Tries_Of_Bits;

public class BT_To_Circular_Doubly_LL {
    /*
    Given a binary tree convert it into circular doubly linked list based on the following rules:

    The left and right pointers in nodes are to be used as previous and next pointers respectively in converted Circular Linked List.
    The order of nodes in List must be same as Inorder of the given Binary Tree.
    The first node of Inorder traversal must be the head node of the Circular List.
    NOTE: You are expected to convert the binary tree into Doubly linked list in place.

    Problem Constraints
    1 <= Number of nodes in tree <= 100000
    1 <= Value of node <= 10^9

    Input Format
    The only argument given is the root pointer of the tree, A.

    Output Format
    Return the head pointer of the converted circular doubly linked list.

    Example Input:
    Input 1:
     Serialized from input of binary tree: where 7 denotes the number of elements in serial
        7 20 8 -1 -1 22 -1 -1
        Binary tree is
          20
         /  \
        8    22
        8 is the left child of 20 and 22 is the right child of 20.

    Input 2:
     Serialized from input of binary tree: where 7 denotes the number of elements in serial
        7 10 8 -1 -1 11 -1 -1
        Binary tree is
          10
         /  \
        8    11
        8 is the left child of 10 and 11 is the right child of 10.

    Example Output:
    Output 1:
         _____________
        |             |
        8 <-> 20 <-> 22
        |_____________|

    Output 2:
         _____________
        |             |
        8 <-> 10 <-> 11
        |_____________|

    Example Explanation:
    Explanation 1:
     The inorder traversal of binary tree is: [8, 20, 22]. Return the head pointer of the circular doubly linked list.

    Explanation 2:
     The inorder traversal of binary tree is: [8, 10, 11]. Return the head pointer of the circular doubly linked list.
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

    private static TreeNode concatenate(TreeNode leftList, TreeNode rightList) {
        // If either of the list is empty, then
        // return the other list
        if (leftList == null)
            return rightList;
        if (rightList == null)
            return leftList;

        // Store the last Node of left List
        TreeNode leftLast = leftList.left;
        // Store the last Node of right List
        TreeNode rightLast = rightList.left;

        // Connect the last node of Left List
        // with the first Node of the right List
        leftLast.right = rightLast;
        rightLast.left = leftLast;

        // left of first node refers to
        // the last node in the list
        leftList.left = rightLast;
        // Right of last node refers to the first
        // node of the List
        rightLast.right = leftList;

        // Return the Head of the List
        return leftList;
    }

    private static TreeNode solve(TreeNode root) {
        if (root == null)
            return null;

        TreeNode left = solve(root.left);
        TreeNode right = solve(root.right);

        root.left = root.right = root;

        return concatenate(concatenate(left, right), right);
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(20);
        root.left = new TreeNode(8);
        root.right = new TreeNode(22);

        // head refers to the head of the Link List
        TreeNode head = solve(root);

        // Display the Circular LinkedList
        System.out.println("Circular Linked List is :");
        TreeNode itr = head;
        do {
            System.out.print(itr.val + " ");
            itr = itr.right;
        } while (itr != head);
        System.out.println();
    }
}
