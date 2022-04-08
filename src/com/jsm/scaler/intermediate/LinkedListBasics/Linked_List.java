package com.jsm.scaler.intermediate.LinkedListBasics;

public class Linked_List {
    /*
    Design and implement a Linked List data structure.
    A node in a linked list should have the following attributes - an integer value and a pointer to the next node.
    It should support the following operations:
    insert_node(position, value) - To insert the input value at the given position in the linked list.
    delete_node(position) - Delete the value at the given position from the linked list.
    print_ll() - Print the entire linked list, such that each element is followed by a single space.

    Note:
    If an input position does not satisfy the constraint, no action is required.
    Each print query has to be executed in a new line.

    Problem Constraints
    1 <= position <= n where, n is the size of the linked-list.

    Input Format
    First line contains an integer denoting number of cases, let's say t.
    Next t line denotes the cases.

    Output Format
    When there is a case of print_ll(),  Print the entire linked list, such that each element is followed by a single space.
    NOTE: You don't need to return anything.

    Example Input

    5
    i 1 23
    i 2 24
    p
    d 1
    p

    Example Output

    23 24
    24

    Example Explanation

    After first two cases linked list contains two elements 23 and 24.
    At third case print: 23 24.
    At fourth case delete value at first position, only one element left 24.
    At fifth case print: 24.
    */

    public static ListNode head = null;
    public static int length;

    public static class ListNode {
        int data;
        ListNode next;

        public ListNode(int data) {
            this.data = data;
            this.next = null;
        }
    }

    public static void insert_node(int position, int value) {
        // @params position, integer
        // @params value, integer
        ListNode node = new ListNode(value);
        if (position > length + 1 || position < 1)
            return;
        if (position == 1 || head == null) {
            node.next = head;
            head = node;
        } else {
            ListNode temp = head;
            int count = 1;
            while (count < position - 1) {
                temp = temp.next;
                count++;
            }
            node.next = temp.next;
            temp.next = node;
        }
        length++;
    }

    public static void delete_node(int position) {
        // @params position, integer
        if (position > length)
            return;
        if (position == 1) {
            head = head.next;
        } else {
            ListNode temp = head;
            int count = 1;
            while (count < position - 1) {
                count++;
                temp = temp.next;
            }
            temp.next = temp.next.next;
        }
        length--;
    }

    public static void print_ll() {
        // Output each element followed by a space
        if (length == 0)
            return;
        ListNode temp = head;
        while (temp.next != null) {
            System.out.print(temp.data + " ");
            temp = temp.next;
        }
        System.out.print(temp.data);
    }

    public static void main(String[] args) {
        insert_node(1, 23);
        insert_node(2, 24);
        print_ll();
        delete_node(1);
        print_ll();
    }
}
