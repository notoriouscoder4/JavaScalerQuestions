package com.jsm.scaler.advance.LinkedList;

public class ReverseLL {
    /*
    You are given a singly linked list having head node A. You have to reverse the linked list and return the head node of that reversed list.

    NOTE: You have to do it in-place and in one-pass.

    Problem Constraints
    1 <= Length of linked list <= 10^5
    Value of each node is within the range of a 32-bit integer.

    Input Format
    First and only argument is a linked-list node A.

    Output Format
    Return a linked-list node denoting the head of the reversed linked list.

    Example Input
    Input 1:
     A = 1 -> 2 -> 3 -> 4 -> 5 -> NULL

    Input 2:
     A = 3 -> NULL

    Example Output
    Output 1:
     5 -> 4 -> 3 -> 2 -> 1 -> NULL

    Output 2:
     3 -> NULL

    Example Explanation:
    Explanation 1:
     The linked list has 5 nodes. After reversing them, the list becomes : 5 -> 4 -> 3 -> 2 -> 1 -> NULL

    Explanation 2:
     The linked list consists of only a single node. After reversing it, the list becomes : 3 -> NULL
    */

    private static class ListNode {
        public int data;
        public ListNode next;

        public ListNode(int data) {
            this.data = data;
            this.next = null;
        }
    }

    private static ListNode reverseList(ListNode A) {
        if (A == null) return null;
        ListNode h1 = A;
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
            System.out.print(temp.data + " --> ");
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
    }
}

/*
public class Solution {
	public ListNode reverseList(ListNode A) {
	    ListNode node, prev, temp;
	    node = A;

	    if (node == null)
	        return null;

	    prev = null;

	    while (node != null) {
	        temp = node.next;
	        node.next = prev;
	        prev = node;
	        node = temp;
	    }
	    return prev;
	}
}
*/

/* C++ Solution

 * Definition for singly-linked list.
 * struct ListNode {
 *     int val;
 *     ListNode *next;
 *     ListNode(int x) : val(x), next(NULL) {}
 * };

ListNode* Solution::reverseList(ListNode* A) {
        ListNode* head = A;
        if(head == NULL) return NULL;
        ListNode *cur = head, *nextNode, *prevNode;
        prevNode = NULL;

        while (cur != NULL) {
        nextNode = cur->next;
        cur->next = prevNode;
        prevNode = cur;
        cur = nextNode;
        }

        head = prevNode;
        return head;
        }
*/
