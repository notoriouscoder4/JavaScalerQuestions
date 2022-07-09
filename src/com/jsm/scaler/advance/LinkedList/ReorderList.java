package com.jsm.scaler.advance.LinkedList;

public class ReorderList {
    /*
    Given a singly linked list A:
     A: A0 → A1 → … → An-1 → An

    reorder it to:
     A0 → An → A1 → An-1 → A2 → An-2 → …

    You must do this in-place without altering the nodes' values.

    Problem Constraints
    1 <= |A| <= 10^6

    Input Format
    The first and the only argument of input contains a pointer to the head of the linked list A.

    Output Format
    Return a pointer to the head of the modified linked list.

    Example Input
    Input 1:
     A = [1, 2, 3, 4, 5]

    Input 2:
     A = [1, 2, 3, 4]

    Example Output
    Output 1:
     [1, 5, 2, 4, 3]

    Output 2:
     [1, 4, 2, 3]

    Example Explanation:
    Explanation 1:
     The array will be arranged to [A0, An, A1, An-1, A2].

    Explanation 2:
     The array will be arranged to [A0, An, A1, An-1, A2].
    */

    private static class ListNode {
        public int val;
        public ListNode next;

        public ListNode(int val) {
            this.val = val;
            this.next = null;
        }
    }

    /* Steps to solve this problem:
       1. Split the LL into two halves:
            a). Find mid of the LL that will be first mid of the LL
       2. Reverse the second half
       3. Connect one by one
    */
    private static ListNode reorderList(ListNode head) {
        if (head == null || head.next == null)
            return head;

        // Find mid of the LL that will be first mid of the LL
        ListNode slowPtr = head;
        ListNode fastPtr = head;

        while (fastPtr.next != null && fastPtr.next.next != null) {
            slowPtr = slowPtr.next;
            fastPtr = fastPtr.next.next;
        }

        // spilt the LL after finding the mid
        ListNode firstHalfHead = head;
        ListNode secondHalfHead = reverseList(slowPtr.next);

        // Connect one by one
        while (firstHalfHead != null && secondHalfHead != null) {
            ListNode temp = firstHalfHead.next;
            firstHalfHead.next = secondHalfHead;
            firstHalfHead = temp;

            temp = secondHalfHead.next;
            secondHalfHead.next = firstHalfHead;
            secondHalfHead = temp;
        }

        if (firstHalfHead != null)
            firstHalfHead.next = null;
        return head;
    }

    private static ListNode reverseList(ListNode head) {
        if (head == null)
            return null;
        ListNode h1 = head;
        ListNode h2 = null;
        ListNode temp;

        while (h1 != null) {
            temp = h1;
            h1 = h1.next;
            temp.next = h2;
            h2 = temp;
        }
        return h2;
    }
}
