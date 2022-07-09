package com.jsm.scaler.advance.LinkedList;

public class RemoveDuplicatesFromSortedList {
    /*
    Given a sorted linked list, delete all duplicates such that each element appears only once.

    Problem Constraints
    0 <= length of linked list <= 10^6

    Input Format
    First argument is the head pointer of the linked list.

    Output Format
    Return the head pointer of the linked list after removing all duplicates.

    Example Input
    Input 1:
     1->1->2

    Input 2:
     1->1->2->3->3

    Example Output
    Output 1:
     1->2

    Output 2:
     1->2->3

    Example Explanation
    Explanation 1:
     Each element appear only once in 1->2.
    */

    private static class ListNode {
        public int val;
        public ListNode next;

        public ListNode(int val) {
            this.val = val;
            this.next = null;
        }
    }

    private static ListNode deleteDuplicates(ListNode head) {
        if (head == null)
            return null;
        ListNode temp = head;
        while (temp.next != null) {
            if (temp.val == temp.next.val)
                temp.next = temp.next.next;
            else
                temp = temp.next;
        }
        return head;
    }
}
