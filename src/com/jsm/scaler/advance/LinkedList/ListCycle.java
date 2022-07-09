package com.jsm.scaler.advance.LinkedList;

public class ListCycle {
    /*
    Given a linked list, return the node where the cycle begins. If there is no cycle, return null.
    Try solving it using constant additional space.

    Example:
    Input:
                      ______
                     |     |
                     \/    |
            1 -> 2 -> 3 -> 4

    Return the node corresponding to node 3.
    */

    private static class ListNode {
        public int val;
        public ListNode next;

        public ListNode(int val) {
            this.val = val;
            this.next = null;
        }
    }

    private static ListNode detectCycle(ListNode head) {
        /* Floyd's Cycle Detection Algorithm */
        if (head == null)
            return null;

        ListNode slowPtr = head;
        ListNode fastPtr = head;
        boolean isCycle = false;

        while (fastPtr != null && fastPtr.next != null) {
            /* 1st step */
            slowPtr = slowPtr.next;
            /* 2nd step */
            fastPtr = fastPtr.next.next;

            /* 3rd step */
            if (slowPtr == fastPtr) {
                isCycle = true;
                break;
            }
        }
        if (!isCycle) return null;

        slowPtr = head;
        while (slowPtr != fastPtr) {
            slowPtr = slowPtr.next;
            fastPtr = fastPtr.next;
        }
        return slowPtr;
    }
}
