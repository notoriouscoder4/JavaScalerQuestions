package com.jsm.scaler.advance.LinkedList;

public class ReverseLLII {
    /*
    Reverse a linked list A from position B to C.

    NOTE: Do it in-place and in one-pass.

    Problem Constraints
    1 <= |A| <= 10^6
    1 <= B <= C <= |A|

    Input Format
    The first argument contains a pointer to the head of the given linked list, A.
    The second argument contains an integer, B.
    The third argument contains an integer C.

    Output Format
    Return a pointer to the head of the modified linked list.

    Example Input
    Input 1:
     A = 1 -> 2 -> 3 -> 4 -> 5
     B = 2
     C = 4

    Input 2:
     A = 1 -> 2 -> 3 -> 4 -> 5
     B = 1
     C = 5

    Example Output
    Output 1:
     1 -> 4 -> 3 -> 2 -> 5

    Output 2:
     5 -> 4 -> 3 -> 2 -> 1

    Example Explanation:
    Explanation 1:
     In the first example, we want to reverse the highlighted part of the given linked list : 1 -> 2 -> 3 -> 4 -> 5
     Thus, the output is 1 -> 4 -> 3 -> 2 -> 5

    Explanation 2:
     In the second example, we want to reverse the highlighted part of the given linked list : 1 -> 4 -> 3 -> 2 -> 5
     Thus, the output is 5 -> 4 -> 3 -> 2 -> 1
    */

    private static class ListNode {
        public int data;
        public ListNode next;

        public ListNode(int data) {
            this.data = data;
            this.next = null;
        }
    }

    private static ListNode reverseBetween(ListNode A, int B, int C) {
        ListNode current = A;
        ListNode first = null;
        ListNode from = null;
        ListNode to = null;
        ListNode last = null;

        int count = 0;
        while (current != null) {
            count += 1;
            if (count < B)
                first = current;
            if (count == B)
                from = current;
            if (count == C) {
                to = current;
                last = to.next;
                break;
            }
            current = current.next;
        }
        to.next = null;
        reverseList(from);
        if (first != null)
            first.next = to;
        else
            A = to;
        from.next = last;
        return A;
    }

    private static void reverseList(ListNode from) {
        if (from == null)
            return;
        ListNode h1 = from;
        ListNode h2 = null;
        ListNode temp;

        while (h1 != null) {
            temp = h1;
            h1 = h1.next;
            temp.next = h2;
            h2 = temp;
        }
    }
}
