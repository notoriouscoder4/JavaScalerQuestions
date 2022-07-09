package com.jsm.scaler.advance.LinkedList;

public class FlattenLL {
    /*
    Given a linked list where every node represents a linked list and contains two pointers of its type:

    Pointer to next node in the main list (right pointer)
    Pointer to a linked list where this node is head (down pointer). All linked lists are sorted.
    You are asked to flatten the linked list into a single list. Use down pointer to link nodes of the flattened list.
    The flattened linked list should also be sorted.

    Problem Constraints
    1 <= Total nodes in the list <= 100000
    1 <= Value of node <= 10^9

    Input Format
    The only argument given is head pointer of the doubly linked list.

    Output Format
    Return the head pointer of the Flattened list.

    Example Input
    Input 1:
       3 -> 4 -> 20 -> 20 ->30
       |    |    |     |    |
       7    11   22    20   31
       |               |    |
       7               28   39
       |               |
       8               39

    Input 2:
       2 -> 4
       |    |
       7    11
       |
       7

    Example Output
    Output 1:
     3 -> 4 -> 7 -> 7 -> 8 -> 11 -> 20 -> 20 -> 20 -> 22 -> 28 -> 30 -> 31 -> 39 -> 39

    Output 2:
     2 -> 4 -> 7 -> 7 -> 11

    Example Explanation:
    Explanation 1:
     The return linked list is the flattened sorted list.
    */

    private static class ListNode {
        public int val;
        public ListNode right;
        public ListNode down;

        public ListNode(int val) {
            this.val = val;
            this.right = null;
            this.down = null;
        }
    }

    private static ListNode flatten(ListNode root) {
        if (root == null || root.right == null)
            return root;
        // recursion for list on right
        root.right = flatten(root.right);

        // now merge
        root = mergeTwoLists(root, root.right);

        // return the root
        // it will be in turn merged with its left
        return root;
    }

    private static ListNode mergeTwoLists(ListNode a, ListNode b) {
        ListNode temp = new ListNode(0);
        ListNode res = temp;

        while (a != null && b != null) {
            if (a.val < b.val) {
                temp.down = a;
                temp = temp.down;
                a = a.down;
            } else {
                temp.down = b;
                temp = temp.down;
                b = b.down;
            }
        }
        if (a != null) temp.down = a;
        else temp.down = b;

        return res.down;
    }
}
