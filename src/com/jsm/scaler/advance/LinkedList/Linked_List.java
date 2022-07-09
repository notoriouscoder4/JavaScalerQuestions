package com.jsm.scaler.advance.LinkedList;

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

    Example Explanation:
    After first two cases linked list contains two elements 23 and 24.
    At third case print: 23 24.
    At fourth case delete value at first position, only one element left 24.
    At fifth case print: 24.
    */

    private static class Node {
        public int val;
        public Node next;

        public Node(int val) {
            this.val = val;
            this.next = null;
        }
    }

    private static Node head = null;
    private static Node tail = null;
    private static int length = 0;

    private static void insert_node(int position, int value) {
        boolean flag = true;
        if (position > length + 1 || position < 1) return; // Edge Case

        Node newNode = new Node(value);
        // 3 cases:
        // At the start.
        // At the End.
        // At the Mid.

        // If the LL is empty
        if (length == 0) {
            head = newNode;
            tail = newNode;
            length++;
            return;
        }

        // If position is 1. That is at the start and LL has nodes.
        if (position == 1) {
            newNode.next = head;
            head = newNode;
            length++;
            return;
        }

        // If the position is the last.
        if (position == length + 1) {
            tail.next = newNode;
            tail = newNode;
            length++;
            return;
        }

        // If you have to push in between, any position.
        Node temp = head;
        int count = 1;
        while (temp != null && count < position - 1) {
            temp = temp.next;
            count++;
        }
        newNode.next = temp.next;
        temp.next = newNode;
        length++;
    }

    private static void delete_node(int position) {
        // 3 Cases.
        // Del the first node.
        // Del the last node.
        // Del at the beginning.

        if (position < 0 || position > length) return; // Not a valid position to delete.

        // Only 1 node in the list.
        if (length == 1) {
            head = null;
            tail = null;
            length--;
            return;
        }

        Node temp = head;

        // Del the first node.
        if (position == 1) {
            head = head.next;
            temp.next = null;
            length--;
            return;
        }

        // Del from last.
        if (position == length) {
            while (temp.next.next != null) {
                temp = temp.next;
            }
            temp.next = null;
            tail = temp;
            length--;
            return;
        }

        // Del in the between, any position.
        int count = 1;
        while (temp.next.next != null && count < position - 1) {
            temp = temp.next;
            count++;
        }
        Node nodeToDel = temp.next;
        temp.next = nodeToDel.next;
        nodeToDel.next = null;
        length--;
    }

    private static void print_ll() {
        // Proceed only if List has nodes.
        if (length < 1) return;
        Node temp = head;
        while (temp.next != null) {
            System.out.print(temp.val + " ");
            temp=temp.next;
        }
        System.out.print(temp.val);
    }

    public static void main(String[] args) {
        insert_node(1, 1);
        insert_node(2, 2);
        insert_node(3, 3);
        insert_node(4, 4);
        insert_node(5, 5);
        insert_node(6, 6);

        delete_node(1);
        delete_node(3);
        delete_node(5);

        print_ll();
    }
}
