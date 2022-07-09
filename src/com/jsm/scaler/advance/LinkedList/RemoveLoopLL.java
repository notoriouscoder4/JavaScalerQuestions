package com.jsm.scaler.advance.LinkedList;

public class RemoveLoopLL {
    /*
    You are given a linked list that contains a loop.
    You need to find the node, which creates a loop and break it by making the node point to NULL.

    Problem Constraints
    1 <= number of nodes <= 1000

    Input Format
    Only argument is the head of the linked list.

    Output Format
    return the head of the updated linked list.

    Example Input
    Input 1:
    1 -> 2
    ^    |
    | - -

    Input 2:
    3 -> 2 -> 4 -> 5 -> 6
              ^         |
              |         |
              - - - - - -

    Example Output
    Output 1:
     1 -> 2 -> NULL

    Output 2:
     3 -> 2 -> 4 -> 5 -> 6 -> NULL

    Example Explanation:
    Explanation 1:
     Chain of 1->2 is broken.

    Explanation 2:
     Chain of 4->6 is broken.
    */

    private static class ListNode {
        public int val;
        public ListNode next;

        public ListNode(int val) {
            this.val = val;
            this.next = null;
        }
    }

    private static ListNode removeLoop(ListNode A) {
        ListNode head = A;
        if (head == null || head.next == null) return null;

        ListNode slowPtr = head;
        ListNode fastPtr = head;

        boolean loop = false;
        while (fastPtr != null && fastPtr.next != null) {
            slowPtr = slowPtr.next;
            fastPtr = fastPtr.next.next;

            if (slowPtr == fastPtr) {
                loop = true;
                break;
            }
        }
        if (!loop) return head;
        slowPtr = head;
        while (slowPtr != fastPtr) {
            if (slowPtr.next == fastPtr.next) {
                fastPtr.next = null;
                break;
            }
            slowPtr = slowPtr.next;
            fastPtr = fastPtr.next;
        }
        return head;
    }
}
