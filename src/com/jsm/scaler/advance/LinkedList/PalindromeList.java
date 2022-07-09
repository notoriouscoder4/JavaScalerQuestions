package com.jsm.scaler.advance.LinkedList;

public class PalindromeList {
    /*
    Given a singly linked list A, determine if it's a palindrome. Return 1 or 0, denoting if it's a palindrome or not, respectively.

    Problem Constraints
    1 <= |A| <= 10^5

    Input Format
    The first and the only argument of input contains a pointer to the head of the given linked list.

    Output Format
    Return 0, if the linked list is not a palindrome.
    Return 1, if the linked list is a palindrome.

    Example Input
    Input 1:
    A = [1, 2, 2, 1]

    Input 2:
    A = [1, 3, 2]

    Example Output
    Output 1:
     1

    Output 2:
     0

    Example Explanation:
    Explanation 1:
     The first linked list is a palindrome as [1, 2, 2, 1] is equal to its reversed form.

    Explanation 2:
     The second linked list is not a palindrome as [1, 3, 2] is not equal to [2, 3, 1].
    */

    private static class ListNode {
        public int val;
        public ListNode next;

        public ListNode(int val) {
            this.val = val;
            this.next = null;
        }
    }

    private static int isPalindrome(ListNode A) {
        if (A == null || A.next == null)
            return 1;

        ListNode slow = A;
        ListNode fast = A;

        // find middle of linked list that will be first mid
        while (fast.next != null && fast.next.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }

        // reverse the right half
        slow.next = reverseList(slow.next);

        // move slow to right half
        slow = slow.next;

        // check for left half and right half equal or not
        while (slow != null) {
            if (A.val != slow.val)
                return 0;
            A = A.next;
            slow = slow.next;
        }
        return 1;
    }

    private static ListNode reverseList(ListNode head) {
        if (head == null) return null;
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
