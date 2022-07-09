package com.jsm.scaler.advance.LinkedList;

public class KReverseLL {
    /*
    Given a singly linked list A and an integer B, reverse the nodes of the list B at a time and return the modified linked list.

    Problem Constraints
    1 <= |A| <= 10^3
    B always divides A

    Input Format
    The first argument of input contains a pointer to the head of the linked list.
    The second argument of input contains the integer, B.

    Output Format
    Return a pointer to the head of the modified linked list.

    Example Input:
    Input 1:
     A = [1, 2, 3, 4, 5, 6]
     B = 2

    Input 2:
     A = [1, 2, 3, 4, 5, 6]
     B = 3

    Example Output:
    Output 1:
     [2, 1, 4, 3, 6, 5]

    Output 2:
     [3, 2, 1, 6, 5, 4]

    Example Explanation:
    Explanation 1:
     For the first example, the list can be reversed in groups of 2.
        [[1, 2], [3, 4], [5, 6]]
     After reversing the K-linked list
        [[2, 1], [4, 3], [6, 5]]

    Explanation 2:
     For the second example, the list can be reversed in groups of 3.
        [[1, 2, 3], [4, 5, 6]]
     After reversing the K-linked list
        [[3, 2, 1], [6, 5, 4]]
    */

    private static class ListNode {
        public int val;
        public ListNode next;

        public ListNode(int val) {
            this.val = val;
            this.next = null;
        }
    }

    private static ListNode head;

    /*
        Approach Using Recursion:
        1. The given LL can be split into bucket of length B.
        2. Now, let us try to solve the problem for one bucket i.e. reversing a single LL.
        3. So now, our problem has been modified to solving the problem for each bucket
           and then concatenating the lists to get a final
           K-reversed LL.
    */
    private static ListNode reverseList(ListNode A, int B) {
        ListNode temp = A;
        ListNode next = null;
        ListNode prev = null;
        int count = 0;
        while (temp != null && count < B) {
            next = temp.next;
            temp.next = prev;
            prev = temp;
            temp = next;
            count++;
        }
        if (next != null) {
            A.next = reverseList(next, B);
        }
        return prev;
    }
}

/*
public class Solution {
    public ListNode reverseList(ListNode A, int B) {
        ListNode dummy = new ListNode(0);
        ListNode prev = dummy;
        prev.next = A;
        while (A != null) {
            int cnt = 1;
            ListNode cur = A;
            while (cur.next != null && cnt < B) {
                cnt++;
                cur = cur.next;
            }
            if (cnt == B) {
                ListNode next = cur.next;
                cur.next = null;
                ListNode rev = reverse(A);
                prev.next = rev;
                A.next = next;
            }
            prev = A;
            A = A.next;
        }
        return dummy.next;
    }

    public ListNode reverse(ListNode A) {
        ListNode prev = new ListNode(0), head = A;
        prev.next = A;
        while (A != null) {
            ListNode tmp = A.next;
            A.next = prev;
            prev = A;
            A = tmp;
        }
        head.next = null;
        return prev;
    }
}
*/

/* C++ Solution

ListNode * reverse(ListNode * A) {
    if (!A -> next)
        return A;
    ListNode * next = A -> next;
    A -> next = NULL;
    ListNode * reversed = reverse(next);
    next -> next = A;
    return reversed;
}

ListNode * Solution::reverseList(ListNode * A, int K) {
    ListNode * reversedFirst = A;
    for (int i = 1; i < K; i += 1) {
        reversedFirst = reversedFirst -> next;
    }
    ListNode * prev = new ListNode(0);
    ListNode * first;
    prev -> next = A;
    ListNode * last = prev;
    while (last -> next) {
        for (int i = 1; i <= K; i += 1) {
            last = last -> next;
        }
        first = prev -> next;
        prev -> next = NULL;
        ListNode * next = last -> next;
        last -> next = NULL;
        reverse(first);
        prev -> next = last;
        first -> next = next;
        prev = last = first;
    }
    return reversedFirst;
}
*/
