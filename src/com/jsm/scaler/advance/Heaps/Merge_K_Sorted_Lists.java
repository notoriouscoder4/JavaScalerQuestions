package com.jsm.scaler.advance.Heaps;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.PriorityQueue;

public class Merge_K_Sorted_Lists {
    /*
    Given a list containing head pointers of N sorted linked lists.
    Merge these given sorted linked lists and return them as one sorted list.

    Problem Constraints
    1 <= total number of elements in given linked lists <= 100000

    Input Format
    The first and only argument is a list containing N head pointers.

    Output Format
    Return a pointer to the head of the sorted linked list after merging all the given linked lists.

    Example Input
    Input 1:
     1 -> 10 -> 20
     4 -> 11 -> 13
     3 -> 8 -> 9

    Input 2:
     10 -> 12
     13
     5 -> 6

    Example Output:
    Output 1:
     1 -> 3 -> 4 -> 8 -> 9 -> 10 -> 11 -> 13 -> 20

    Output 2:
     5 -> 6 -> 10 -> 12 ->13

    Example Explanation"
    Explanation 1:
     The resulting sorted Linked List formed after merging is 1 -> 3 -> 4 -> 8 -> 9 -> 10 -> 11 -> 13 -> 20.

    Explanation 2:
     The resulting sorted Linked List formed after merging is 5 -> 6 -> 10 -> 12 ->13.
    */

    private static class ListNode {
        public int val;
        public ListNode next;

        public ListNode(int val) {
            this.val = val;
            this.next = null;
        }
    }

    private static class Pair {
        public int val;
        public ListNode node;

        public Pair(int val, ListNode node) {
            this.val = val;
            this.node = node;
        }
    }

    private static ListNode mergeKLists(ArrayList<ListNode> a) {
        int n = a.size();
        PriorityQueue<Pair> min_heap = new PriorityQueue<>(n, (p1, p2) -> {
            return Integer.compare(p1.val, p2.val);
        });

        for (int i = 0; i < n; ++i) {
            if (a.get(i) != null)
                min_heap.add(new Pair(a.get(i).val, a.get(i)));
        }

        ListNode ansHead = new ListNode(-1);
        ListNode temp = ansHead;

        while (!min_heap.isEmpty()) {
            Pair p = min_heap.peek();
            min_heap.poll();
            temp.next = p.node;
            temp = temp.next;
            if (temp.next != null)
                min_heap.add(new Pair(temp.next.val, temp.next));
        }
        return ansHead.next;
    }
}
