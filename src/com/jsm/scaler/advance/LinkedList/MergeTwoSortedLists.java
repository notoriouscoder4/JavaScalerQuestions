package com.jsm.scaler.advance.LinkedList;

public class MergeTwoSortedLists {
    /*
    Merge two sorted linked lists, A and B, and return it as a new list.
    The new list should be made by splicing together the nodes of the first two lists and should also be sorted.

    Problem Constraints
    0 <= |A|, |B| <= 10^5

    Input Format
    The first argument of input contains a pointer to the head of linked list A.
    The second argument of input contains a pointer to the head of linked list B.

    Output Format
    Return a pointer to the head of the merged linked list.

    Example Input:
    Input 1:
     A = 5 -> 8 -> 20
     B = 4 -> 11 -> 15

    Input 2:
     A = 1 -> 2 -> 3
     B = Null

    Example Output:
    Output 1:
     4 -> 5 -> 8 -> 11 -> 15 -> 20

    Output 2:
     1 -> 2 -> 3

    Example Explanation:
    Explanation 1:
     Merging A and B will result in 4 -> 5 -> 8 -> 11 -> 15 -> 20

    Explanation 2:
     We don't need to merge as B is empty.
    */

    private static class ListNode {
        public int val;
        public ListNode next;

        public ListNode(int val) {
            this.val = val;
            this.next = null;
        }
    }

    private static ListNode mergeTwoLists(ListNode A, ListNode B) {
        if (A == null)
            return B;
        if (B == null)
            return A;
        ListNode head;
        if (A.val < B.val) {
            head = A;
            A = A.next;
        } else {
            head = B;
            B = B.next;
        }

        ListNode temp = head;
        while (A != null && B != null) {
            if (A.val < B.val) {
                temp.next = A;
                A = A.next;
            } else {
                temp.next = B;
                B = B.next;
            }
            temp = temp.next;
        }
        if (A == null)
            temp.next = B;
        else
            temp.next = A;
        return head;
    }

    private static ListNode head = null;

    private static void insertLastLL(int value) {
        ListNode newNode = new ListNode(value);
        if (head == null) {
            newNode.next = head;
            head = newNode;
        }
        ListNode temp = head;
        while (temp.next != null) {
            temp = temp.next;
        }
        temp.next = newNode;
    }

    private static void displayLL() {
        ListNode temp = head;
        while (temp != null) {
            System.out.print(temp.val + " --> ");
            temp = temp.next;
        }
        System.out.println("null");
    }

    public static void main(String[] args) {

    }
}

/* C++ Solution
ListNode * Solution::mergeTwoLists(ListNode * l1, ListNode * l2) {
    if (l1 == NULL)
        return l2;
    if (l2 == NULL)
        return l1;
    ListNode * head = NULL; // head of the list to return
    // find first element (can use dummy node to put this part inside of the loop)
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
*/
