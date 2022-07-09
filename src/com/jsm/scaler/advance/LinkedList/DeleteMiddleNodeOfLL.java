package com.jsm.scaler.advance.LinkedList;

public class DeleteMiddleNodeOfLL {
    /*
    Given a singly linked list, delete middle of the linked list.

    For example, if given linked list is 1->2->3->4->5 then linked list should be modified to 1->2->4->5

    If there are even nodes, then there would be two middle nodes, we need to delete the second middle element.
    For example, if given linked list is 1->2->3->4->5->6 then it should be modified to 1->2->3->5->6.

    Return the head of the linked list after removing the middle node.
    If the input linked list has 1 node, then this node should be deleted and a null node should be returned.

    Input Format
    The only argument given is the node pointing to the head node of the linked list
    */

    private static class ListNode {
        public int val;
        public ListNode next;

        public ListNode(int val) {
            this.val = val;
            this.next = null;
        }
    }

    private static ListNode solve(ListNode A) {
        if (A == null || A.next == null)
            return null;

        // getSecondMiddleNode of LL
        ListNode slowPtr = A;
        ListNode fastPtr = A;
        ListNode prev = null;

        while (fastPtr != null && fastPtr.next != null) {
            prev = slowPtr;
            slowPtr = slowPtr.next;
            fastPtr = fastPtr.next.next;
        }
        prev.next = slowPtr.next;
        return A;
    }
}
