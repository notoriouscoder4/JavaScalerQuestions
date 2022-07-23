package com.jsm.scaler.advance.Stacks;

import java.util.Arrays;
import java.util.Stack;

public class SortStackUsingAnotherStack {
    /*
    Given a stack of integers A, sort it using another stack.
    Return the array of integers after sorting the stack using another stack.

    Problem Constraints
    1 <= |A| <= 5000
    0 <= A[i] <= 10^9

    Input Format
    The only argument is a stack given as an integer array A.

    Output Format
    Return the array of integers after sorting the stack using another stack.

    Example Input
    Input 1:
     A = [5, 4, 3, 2, 1]

    Input 2:
     A = [5, 17, 100, 11]

    Example Output
    Output 1:
     [1, 2, 3, 4, 5]

    Output 2:
     [5, 11, 17, 100]

    Example Explanation:
    Explanation 1:
     Just sort the given numbers.

    Explanation 2:
     Just sort the given numbers.
    */

    private static int[] solve(int[] A) {
        Stack<Integer> s1 = new Stack<>();
        for (int a : A)
            s1.push(a);
        Stack<Integer> s2;
        s2 = mergeSort(s1);
        s2 = reverse(s2);

        int[] res = new int[A.length];
        int k = 0;
        while (s2.size() > 0) {
            res[k++] = s2.pop();
        }
        return res;
    }

    private static Stack<Integer> mergeSort(Stack<Integer> s) {
        if (s.size() <= 1) return s;
        Stack<Integer> s2 = new Stack<>();
        int n = s.size();
        for (int i = 0; i < n / 2; i++) {
            s2.push(s.pop());
        }
        s = mergeSort(s);
        s2 = mergeSort(s2);
        return merge(s, s2);
    }

    private static Stack<Integer> merge(Stack<Integer> s1, Stack<Integer> s2) {
        Stack<Integer> sortedStack = new Stack<>();
        while (s1.size() > 0 && s2.size() > 0) {
            if (s1.peek() > s2.peek())
                sortedStack.push(s1.pop());
            else
                sortedStack.push(s2.pop());
        }
        while (s1.size() > 0)
            sortedStack.push(s1.pop());
        while (s2.size() > 0)
            sortedStack.push(s2.pop());
        return reverse(sortedStack);
    }

    private static Stack<Integer> reverse(Stack<Integer> s) {
        Stack<Integer> revStack = new Stack<>();
        while (s.size() > 0)
            revStack.push(s.pop());
        return revStack;
    }

    public static void main(String[] args) {
        int[] A = {5, 4, 3, 2, 1};
        System.out.println(Arrays.toString(solve(A)));
    }
}
