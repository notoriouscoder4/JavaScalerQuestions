package com.jsm.scaler.advance.LinkedList;

public class RemoveNthNodeFromListEnd {
    /*
    Given a linked list A, remove the B-th node from the end of the list and return its head.

    For example, Given linked list: 1->2->3->4->5, and B = 2. After removing the second node from the end, the linked list becomes 1->2->3->5.

    NOTE: If B is greater than the size of the list, remove the first node of the list.
    NOTE: Try doing it using constant additional space.

    Problem Constraints
    1 <= |A| <= 10^6

    Input Format
    The first argument of input contains a pointer to the head of the linked list.
    The second argument of input contains the integer B.

    Output Format
    Return the head of the linked list after deleting the B-th element from the end.

    Example Input
    Input 1:
    A = [1, 2, 3, 4, 5]
    B = 2

    Input 2:
    A = [1]
    B = 1

    Example Output
    Output 1:
    [1, 2, 3, 5]

    Output 2:
     []

    Example Explanation:
    Explanation 1:
    In the first example, 4 is the second last element.

    Explanation 2:
    In the second example, 1 is the first and the last element.
    */

    private static class ListNode {
        public int val;
        public ListNode next;

        public ListNode(int val) {
            this.val = val;
            this.next = null;
        }
    }

    private static ListNode removeNthFromEnd(ListNode head, int B) {
        ListNode t1 = head;
        ListNode t2 = head;
        int size = 0;

        while (t1 != null) { // with the help of t1 we will calculate the size of the LL
            t1 = t1.next;
            size++;
        }
        if (B >= size) // If B is greater than the size of the list, remove the first node of the list.
            head = head.next;
        else { // Since we cannot traverse backward in the LL so, to delete Nth node from end, we will traverse from head
            // and calculate the Xth node using the given Nth node: - X + (N - 1) = Size of LL
            // Why (N - 1) because if we want to delete Nth node from end then there will be remaining (N - 1) node.
            for (int i = 0; i < size - B - 1; i++)
                t2 = t2.next;
            t2.next = t2.next.next;
        }
        return head;
    }
}
