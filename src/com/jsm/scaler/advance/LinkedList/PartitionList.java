package com.jsm.scaler.advance.LinkedList;

public class PartitionList {
    /*
    Given a linked list A and a value B, partition it such that all nodes less than B come before nodes greater than or equal to B.
    You should preserve the original relative order of the nodes in each of the two partitions.

    Problem Constraints
    1 <= |A| <= 10^6
    1 <= A[i], B <= 10^9

    Input Format
    The first argument of input contains a pointer to the head to the given linked list.
    The second argument of input contains an integer, B.

    Output Format
    Return a pointer to the head of the modified linked list.

    Example Input
    Input 1:
    A = [1, 4, 3, 2, 5, 2]
    B = 3

    Input 2:
    A = [1, 2, 3, 1, 3]
    B = 2

    Example Output
    Output 1:
    [1, 2, 2, 4, 3, 5]

    Output 2:
    [1, 1, 2, 3, 3]

    Example Explanation:
    Explanation 1:
     [1, 2, 2] are less than B whereas [4, 3, 5] are greater than or equal to B.

    Explanation 2:
     [1, 1] are less than B whereas [2, 3, 3] are greater than or equal to B.
    */

    private static class ListNode {
        public int val;
        public ListNode next;

        public ListNode(int val) {
            this.val = val;
            this.next = null;
        }
    }

    private static ListNode partition(ListNode A, int B) {
        ListNode smaller = new ListNode(0);
        ListNode higher = new ListNode(0);

        ListNode smallerHead = smaller;
        ListNode higherHead = higher;

        while (A != null) {
            if (A.val < B) {
                // smaller list
                smallerHead.next = A;
                smallerHead = smallerHead.next;
            } else {
                // higher list
                higherHead.next = A;
                higherHead = higherHead.next;
            }
            A = A.next;
        }
        smallerHead.next = higher.next;
        higherHead.next = null;

        return smaller.next;
    }
}
