package com.jsm.scaler.intermediate.LinkedListBasics;

/*
 * Definition for singly-linked list.
 * class ListNode {
 *     public int val;
 *     public ListNode next;
 *     ListNode(int x) { val = x; next = null; }
 * }
 */

public class DesignLinkedList {

    /*
    Given a matrix A of size Nx3 representing operations. Your task is to design the linked list based on these operations.

    There are four types of operations:

    0 x -1: Add a node of value x before the first element of the linked list. After the insertion,
    the new node will be the first node of the linked list.

    1 x -1: Append a node of value x to the last element of the linked list.

    2 x index: Add a node of value x before the index-th node in the linked list. If the index equals the length of the linked list,
    the node will be appended to the end of the linked list. If the index is greater than the length, the node will not be inserted.

    3 index -1: Delete the index-th node in the linked list, if the index is valid.

    A[i][0] represents the type of operation.

    A[i][1], A[i][2] represents the corresponding elements with respect to type of operation.

    Note: Indexing is 0 based.

    Problem Constraints
    1 <= Number of operations <= 1000
    1 <= All node values <= 109

    Input Format
    The only argument given is matrix A.

    Output Format
    Return the pointer to the starting of the linked list.

    Example Input

    Input 1:
    A = [[0, 1, -1],
         [1, 2, -1],
         [2, 3, 1]]

    Input 2:
    A = [[0, 1, -1],
         [1, 2, -1],
         [2, 3, 1],
         [0, 4, -1],
         [3, 1, -1],
         [3, 2, -1]]

    Example Output

    Output 1:
    1 -> 3 -> 2 -> NULL

    Output 2:
    4 -> 3 -> NULL


    Example Explanation

    Explanation 1:
    After first operation the list is 1 -> NULL
    After second operation the list is 1 -> 2 -> NULL
    After third operation the list is 1 -> 3 -> 2 -> NULL

    Explanation 2:
    After first operation the list is 1 -> NULL
    After second operation the list is 1 -> 2 -> NULL
    After third operation the list is 1 -> 3 -> 2 -> NULL
    After fourth operation the list is 4 -> 1 -> 3 -> 2 -> NULL
    After fifth operation the list is 4 -> 3 -> 2 -> NULL
    After sixth operation the list is 4 -> 3 -> NULL
    */

    public static class ListNode {
        public int val;
        public ListNode next;

        public ListNode(int x) {
            this.val = x;
            this.next = null;
        }
    }

    public static ListNode head;
    public static int size = 0;

    public static ListNode solve(int[][] A) {
        /* For resetting head and size after every test case*/
        head = null;
        size = 0;
        for (int i = 0; i < A.length; i++) {
            if (A[i][0] == 0) {
                addAtFirst(A[i][1]);
            } else if (A[i][0] == 1) {
                addAtLast(A[i][1]);
            } else if (A[i][0] == 2) {
                addNode(A[i][1], A[i][2]);
            } else if (A[i][0] == 3) {
                deleteByValue(A[i][1]);
            }
        }
        return head;
    }

    public static void addAtFirst(int value) {
        if (head == null)
            head = new ListNode(value);
        else {
            ListNode newNode = new ListNode(value);
            newNode.next = head;
            head = newNode;
        }
        size += 1;
    }

    public static void addAtLast(int value) {
        ListNode newNode = new ListNode(value);
        ListNode temp = head;
        if (head == null)
            head = newNode;
        else {
            while (temp.next != null)
                temp = temp.next;
            temp.next = newNode;
        }
        size += 1;
    }

    public static void addAtIndex(int value, int index) {
        if (size < index - 1)
            return;
        int count = 0;
        ListNode temp = head;
        while (count < index - 1) {
            temp = temp.next;
            count++;
        }
        ListNode newNode = new ListNode(value);
        newNode.next = temp.next;
        temp.next = newNode;
        size += 1;
    }

    public static void addNode(int value, int index) {
        if (index > size || index < 0)
            return;
        if (index == size) {
            addAtLast(value);
        } else if (index == 0) {
            addAtFirst(value);
        } else {
            addAtIndex(value, index);
        }
    }

    public static void deleteByValue(int position) {
        if (head == null) return;
        ListNode ptr = head;
        if (position < size) {
            if (position == 0) {
                head = head.next;
            } else {
                for (int k = 0; k < position - 1; k++) {
                    ptr = ptr.next;
                }
                ptr.next = ptr.next.next;
            }
            size -= 1;
        }
    }

    public static void main(String[] args) {

    }
}
