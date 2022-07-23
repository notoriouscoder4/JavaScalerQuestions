package com.jsm.scaler.advance.Stacks;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Stack;

public class MaximumFrequencyStack {
    /*
    You are given a matrix A which represents operations of size N x 2.
    Assume initially you have a stack-like data structure you have to perform operations on it.

    Operations are of two types:

    1 x: push an integer x onto the stack and return -1.
    2 0: remove and return the most frequent element in the stack.

    If there is a tie for the most frequent element, the element closest to the top of the stack is removed and returned.

    A[i][0] describes the type of operation to be performed. A[i][1] describe the element x or 0 corresponding to the operation performed.

    Problem Constraints
    1 <= N <= 100000
    1 <= A[i][0] <= 2
    0 <= A[i][1] <= 10^9

    Input Format
    The only argument given is the integer array A.

    Output Format
    Return the array of integers denoting the answer to each operation.

    Example Input
    Input 1:
    A = [
                [1, 5]
                [1, 7]
                [1, 5]
                [1, 7]
                [1, 4]
                [1, 5]
                [2, 0]
                [2, 0]
                [2, 0]
                [2, 0]  ]

    Input 2:
     A =  [
            [1, 5]
            [2, 0]
            [1, 4]   ]

    Example Output
    Output 1:
     [-1, -1, -1, -1, -1, -1, 5, 7, 5, 4]

    Output 2:
     [-1, 5, -1]

    Example Explanation:
    Explanation 1:
     Just simulate given operations.

    Explanation 2:
     Just simulate given operations.
    */

    private static HashMap<Integer, Integer> eleFreqMap;
    private static HashMap<Integer, Stack<Integer>> stackFreqMap;
    private static int highestFreq;

    public MaximumFrequencyStack() {
        eleFreqMap = new HashMap<>();
        stackFreqMap = new HashMap<>();
        highestFreq = 0;
    }

    private static int push(int x) {
        int currentFreqOfX = 1;
        // update current frequency of x in eleFreqMap
        if (eleFreqMap.containsKey(x)) {
            currentFreqOfX = eleFreqMap.get(x);
            currentFreqOfX = currentFreqOfX + 1;
        }
        eleFreqMap.put(x, currentFreqOfX);

        // update highestFreq value if currentFreqOfX is > highestFreq
        highestFreq = Math.max(highestFreq, currentFreqOfX);

        // update stackFreqMap with currentFreqOfX as key and stack as value
        Stack<Integer> stack;
        if (stackFreqMap.containsKey(currentFreqOfX)) {
            stack = stackFreqMap.get(currentFreqOfX);
            stack.push(x);
        } else {
            stack = new Stack<>();
            stack.push(x);
        }
        stackFreqMap.put(currentFreqOfX, stack);
        return -1;
    }

    private static int pop() {
        int x = -1;
        // retrieve the stack of the current max freq element
        if (stackFreqMap.containsKey(highestFreq)) {
            Stack<Integer> stack = stackFreqMap.get(highestFreq);
            x = stack.pop();

            // if there are no more elements with max freq in stack, remove entry and decrement highestFreq
            if (stack.isEmpty()) {
                stackFreqMap.remove(highestFreq);
                highestFreq--;
            }
        }

        // update eleFreqMap for current max freq element
        if (eleFreqMap.containsKey(x)) {
            int currentFreqOfX = eleFreqMap.get(x) - 1;
            if (currentFreqOfX == 0)
                eleFreqMap.remove(x);
            else
                eleFreqMap.put(x, currentFreqOfX);
        }
        return x;
    }

    private static ArrayList<Integer> solve(ArrayList<ArrayList<Integer>> A) {
        ArrayList<Integer> ans = new ArrayList<>();

        for (ArrayList<Integer> currentRec : A) {
            int operation = currentRec.get(0);
            int x = currentRec.get(1);

            int result;
            if (operation == 1)
                result = push(x);
            else
                result = pop();
            ans.add(result);
        }
        return ans;
    }

    public static void main(String[] args) {
        ArrayList<ArrayList<Integer>> A = new ArrayList<>();
        System.out.println(solve(A));
    }
}
