package com.jsm.scaler.advance.LinkedList;

public class MiddleElementLL {
    /*
    Given a linked list of integers, find and return the middle element of the linked list.
    NOTE: If there are N nodes in the linked list and N is even then return the (N/2 + 1)th element.

    Problem Constraints
    1 <= length of the linked list <= 100000
    1 <= Node value <= 10^9

    Input Format
    The only argument given head pointer of linked list.

    Output Format
    Return the middle element of the linked list.

    Example Input
    Input 1:
     1 -> 2 -> 3 -> 4 -> 5

    Input 2:
     1 -> 5 -> 6 -> 2 -> 3 -> 4

    Example Output
    Output 1:
     3

    Output 2:
     2

    Example Explanation:
    Explanation 1:
     The middle element is 3.

    Explanation 2:
     The middle element in even length linked list of length N is ((N/2) + 1)th element which is 2.
    */

    private static class ListNode {
        public int val;
        public ListNode next;

        public ListNode(int val) {
            this.val = val;
            this.next = null;
        }
    }

    private static int solve(ListNode A) {
        // If there are N nodes in the linked list and N is even then return the (N/2 + 1)th element.
        if (A == null) return 0;
        ListNode slowPtr = A;
        ListNode fastPtr = A;
        while (fastPtr != null && fastPtr.next != null) {
            slowPtr = slowPtr.next;
            fastPtr = fastPtr.next.next;
        }
        return slowPtr.val;
    }

    private static int getMid(ListNode head) {
        // If there are N nodes in the linked list and N is even then return the (N/2)th element.
        if (head == null) return 0;
        ListNode slowPtr = head;
        ListNode fastPtr = head;
        while (fastPtr.next != null && fastPtr.next.next != null) {
            slowPtr = slowPtr.next;
            fastPtr = fastPtr.next.next;
        }
        return slowPtr.val;
    }

    private static ListNode head;

    private static void insertLastLL(int value) {
        ListNode newNode = new ListNode(value);
        if (head == null) {
            head = newNode;
            return;
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
        insertLastLL(1);
        insertLastLL(2);
        insertLastLL(3);
        insertLastLL(4);
        insertLastLL(5);
        insertLastLL(6);
        displayLL();
        System.out.println(getMid(head));
    }
}

/* C++ Solution

/**
 * Definition for singly-linked list.
 * struct ListNode {
 *     int val;
 *     ListNode *next;
 *     ListNode(int x) : val(x), next(NULL) {}
 * };

    int middleElement(ListNode * head) {
        // IF ONLY A SINGLE ELEMENT
        if (head -> next == NULL)
            return head -> val;
        // slow and fast pointer
        ListNode * slow = head;
        ListNode * fast = head;
        while (fast && fast -> next) {
            fast = fast -> next -> next;
            slow = slow -> next;
        }
        return slow -> val;
    }

    int Solution::solve(ListNode * A) {
        return middleElement(A);
        }
*/
