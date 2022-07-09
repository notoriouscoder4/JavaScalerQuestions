package com.jsm.scaler.advance.LinkedList;

public class SortList {
    /*
    Sort a linked list, A in O(n log n) time using constant space complexity.

    Problem Constraints
    0 <= |A| = 10^5

    Input Format
    The first and the only argument of input contains a pointer to the head of the linked list, A.

    Output Format
    Return a pointer to the head of the sorted linked list.

    Example Input:
    Input 1:
    A = [3, 4, 2, 8]

    Input 2:
    A = [1]

    Example Output:
    Output 1:
    [2, 3, 4, 8]

    Output 2:
    [1]

    Example Explanation:
    Explanation 1:
     The sorted form of [3, 4, 2, 8] is [2, 3, 4, 8].

    Explanation 2:
     The sorted form of [1] is [1].
    */

    private static class ListNode {
        public int val;
        public ListNode next;

        public ListNode(int val) {
            this.val = val;
            this.next = null;
        }
    }

    private static ListNode sortList(ListNode A) {
        if (A == null || A.next == null)
            return A; // It means List is empty || List is having only one node
        ListNode h1, h2, mid;

        mid = getFirstMid(A);
        h2 = mid.next; // head of second half of list
        mid.next = null; // this is to separate the second half

        h1 = sortList(A); // h1 is the head of first half of list
        h2 = sortList(h2); // h2 is the head of second half of list
        return merge(h1, h2);
    }

    private static ListNode getFirstMid(ListNode head) {
        // If there are N nodes in the linked list and N is even then return the (N/2)th element.
        if (head == null)
            return null;

        ListNode slowPtr = head;
        ListNode fastPtr = head;

        while (fastPtr.next != null && fastPtr.next.next != null) {
            slowPtr = slowPtr.next;
            fastPtr = fastPtr.next.next;
        }
        return slowPtr;
    }

    private static ListNode merge(ListNode h1, ListNode h2) {
        ListNode head;
        if (h1.val < h2.val) {
            head = h1;
            h1 = h1.next;
        } else {
            head = h2;
            h2 = h2.next;
        }

        ListNode temp = head;
        while (h1 != null && h2 != null) {
            if (h1.val < h2.val) {
                temp.next = h1;
                h1 = h1.next;
            } else {
                temp.next = h2;
                h2 = h2.next;
            }
            temp = temp.next;
        }
        if (h1 == null)
            temp.next = h2;
        else
            temp.next = h1;
        return head;
    }
}

/* C++ Solution
ListNode * mergeTwoLists(ListNode * l1, ListNode * l2) {
    if (l1 == NULL)
        return l2;
    if (l2 == NULL)
        return l1;
    ListNode * head = NULL; // head of the list to return
    // find first element (can use dummy node to put this part inside the loop)
    if (l1 -> val < l2 -> val) {
        head = l1;
        l1 = l1 -> next;
    } else {
        head = l2;
        l2 = l2 -> next;
    }
    ListNode * p = head; // pointer to form new list
    while (l1 && l2) {
        if (l1 -> val < l2 -> val) {
            p -> next = l1;
            l1 = l1 -> next;
        } else {
            p -> next = l2;
            l2 = l2 -> next;
        }
        p = p -> next;
    }
    // add the rest of the tail, done!
    if (l1) {
        p -> next = l1;
    } else {
        p -> next = l2;
    }
    return head;
}

ListNode * Solution::sortList(ListNode * head) {
    int sz = 0;
    ListNode * tmp = head;
    while (tmp) {
        tmp = tmp -> next;
        sz++;
    }
    assert(sz <= 1e5);
    if (head == NULL || head -> next == NULL)
        return head;
    // find the middle place
    ListNode * p1 = head;
    ListNode * p2 = head -> next;
    while (p2 && p2 -> next) {
        p1 = p1 -> next;
        p2 = p2 -> next -> next;
    }
    p2 = p1 -> next;
    p1 -> next = NULL;

    return mergeTwoLists(sortList(head), sortList(p2));
}
*/
