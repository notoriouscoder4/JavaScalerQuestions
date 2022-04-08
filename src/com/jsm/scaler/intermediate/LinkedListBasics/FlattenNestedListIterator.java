package com.jsm.scaler.intermediate.LinkedListBasics;

import java.util.ArrayList;
import java.util.List;

public class FlattenNestedListIterator {
    /*
    You are given a nested list of integers nestedList. Each element is either an integer or a list whose elements may
    also be integers or other lists. Implement an iterator to flatten it.

    Implement the NestedIterator class:

    NestedIterator(List nestedList) Initializes the iterator with the nested list nestedList.
    int next() Returns the next integer in the nested list.
    boolean hasNext() Returns true if there are still some integers in the nested list and false otherwise.

    Example 1:
    Input: nestedList = [[1,1],2,[1,1]]
    Output: [1,1,2,1,1]

    Explanation: By calling next repeatedly until hasNext returns false, the order of elements returned by next should be: [1,1,2,1,1].

    Example 2:
    Input: nestedList = [1,[4,[6]]]
    Output: [1,4,6]

    Explanation: By calling next repeatedly until hasNext returns false, the order of elements returned by next should be: [1,4,6].

    Constraints:
    The sum of integers in all cases does not exceed 1e5.
    The values of the integers in the nested list are in the range [-1e6, 1e6].
    */

    // public class Main {

    // This is the interface that allows for creating nested lists.
    // You should not implement it, or speculate about its implementation.
//    class NestedInteger {
//
//        NestedInteger(int x) {
//        }
//
//        // Return true if this NestedInteger holds a single integer, rather than a nested list.
//        boolean isInteger() {
//        }
//
//        // Return the single integer that this NestedInteger holds, if it holds a single integer.
//        // The result is 1e9 if this NestedInteger holds a nested list.
//        int getInteger() {
//
//        }
//
//        // Return the nested list that this NestedInteger holds, if it holds a nested list.
//        // The result is an empty ArrayList if this NestedInteger holds a single integer.
//        ArrayList<NestedInteger> getList() {
//
//        }
//    }

//    class NestedIterator {
//        private List<Integer> elements = new ArrayList<>();
//        int index = 0;
//
//        NestedIterator(ArrayList<NestedInteger> nestedList) {
//            init(nestedList);
//        }
//
//        int next() {
//            return elements.get(index++);
//        }
//
//        boolean hasNext() {
//            if (index < this.elements.size())
//                return true;
//            else
//                return false;
//        }
//
//        private void init(ArrayList<NestedInteger> nestedList) {
//            if (nestedList.isEmpty())
//                return;
//            for (NestedInteger nst : nestedList) {
//                if (!nst.isInteger()) {
//                    init(nst.getList());
//                } else
//                    elements.add(nst.getInteger());
//            }
//        }
//    }

    public static void main(String[] args) {

    }
}
