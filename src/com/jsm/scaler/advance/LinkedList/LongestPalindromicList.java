package com.jsm.scaler.advance.LinkedList;

public class LongestPalindromicList {
    /*
    Given a linked list of integers. Find and return the length of the longest palindrome list that exists in that linked list.
    A palindrome list is a list that reads the same backward and forward.
    Expected memory complexity : O(1)

    Problem Constraints
    1 <= length of the linked list <= 2000
    1 <= Node value <= 100

    Input Format
    The only argument given is head pointer of the linked list.

    Output Format
    Return the length of the longest palindrome list.

    Example Input
    Input 1:
     2 -> 3 -> 3 -> 3

    Input 2:
     2 -> 1 -> 2 -> 1 ->  2 -> 2 -> 1 -> 3 -> 2 -> 2

    Example Output
    Output 1:
     3

    Output 2:
     5

    Example Explanation:
    Explanation 1:
     3 -> 3 -> 3 is largest palindromic sublist

    Explanation 2:
     2 -> 1 -> 2 -> 1 -> 2 is largest palindromic sublist.
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
        ListNode prev = null;
        ListNode curr = A;
        int lengthLongestPalindromicList = 0;
        while (curr != null) {
            // reverse linked list till curr
            ListNode nxt = curr.next;
            curr.next = prev;

            // find the longest palindromic list of even size
            lengthLongestPalindromicList = Math.max(lengthLongestPalindromicList, 2 * getCommonElements(curr, nxt));

            // find the longest palindromic list of odd size
            lengthLongestPalindromicList = Math.max(lengthLongestPalindromicList, 2 * getCommonElements(prev, nxt) + 1);

            // update prev and curr
            prev = curr;
            curr = nxt;
        }
        return lengthLongestPalindromicList;
    }

    private static int getCommonElements(ListNode A, ListNode B) {
        int count = 0;
        while (A != null && B != null) {
            if (A.val != B.val)
                break;
            count++;
            A = A.next;
            B = B.next;
        }
        return count;
    }
}
