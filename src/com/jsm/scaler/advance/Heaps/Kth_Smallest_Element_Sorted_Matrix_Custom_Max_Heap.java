package com.jsm.scaler.advance.Heaps;

import java.util.ArrayList;
import java.util.List;

public class Kth_Smallest_Element_Sorted_Matrix_Custom_Max_Heap {
    /*
    Given a sorted matrix of integers A of size N x M and an integer B.
    Each of the rows and columns of matrix A is sorted in ascending order, find the Bth smallest element in the matrix.

    NOTE: Return The Bth smallest element in the sorted order, not the Bth distinct element.

    Problem Constraints
    1 <= N, M <= 500
    1 <= A[i] <= 10Z^9
    1 <= B <= N * M

    Input Format
    The first argument given is the integer matrix A.
    The second argument given is an integer B.

    Output Format
    Return the B-th smallest element in the matrix.

    Example Input
    Input 1:
     A = [ [9, 11, 15],
           [10, 15, 17] ]
     B = 6

    Input 2:
     A = [  [5, 9, 11],
            [9, 11, 13],
            [10, 12, 15],
            [13, 14, 16],
            [16, 20, 21] ]
     B = 12

    Example Output:
    Output 1:
     17

    Output 2:
     16

    Example Explanation:
    Explanation 1:
     6th smallest element in the sorted matrix is 17.

    Explanation 2:
     12th smallest element in the sorted matrix is 16.
     */

    private static class MaxHeap<T extends Comparable<T>> {
        List<T> heap;

        public MaxHeap() {
            heap = new ArrayList<T>();
        }

        public int size() {
            return heap.size();
        }

        public List<T> getHeap() {
            return heap;
        }

        public boolean isEmpty() {
            if (heap.size() == 0) {
                return true;
            }
            return false;
        }

        public void insert(T x) {

            heap.add(x);
            int i = this.heap.size() - 1;
            while (i > 0) {
                int parentIndex = (i - 1) / 2;
                if (heap.get(i).compareTo(heap.get(parentIndex)) > 0) {
                    swap(i, parentIndex);
                    i = parentIndex;
                } else {
                    return;
                }
            }
        }

        public T getMaximum() {
            T x = null;
            if (!isEmpty()) {
                x = heap.get(0);
                // swap last element and x
                swap(0, heap.size() - 1);
                heap.remove(heap.size() - 1);

                int i = 0;
                while ((2 * i) + 1 < heap.size()) {
                    int leftChildIndex = (2 * i) + 1;
                    int rightChildIndex = (2 * i) + 2;
                    T max = null;

                    // find minimum out of 3
                    max = heap.get(i).compareTo(heap.get(leftChildIndex)) > 0 ? heap.get(i) : heap.get(leftChildIndex);
                    if (rightChildIndex < heap.size()) {
                        max = heap.get(rightChildIndex).compareTo(max) > 0 ? heap.get(rightChildIndex) : max;
                    }

                    if (max == heap.get(i)) {
                        break;
                    } else if (max == heap.get(leftChildIndex)) {
                        swap(i, leftChildIndex);
                        i = leftChildIndex;
                    } else if (rightChildIndex < heap.size() && max == heap.get(rightChildIndex)) {
                        swap(i, rightChildIndex);
                        i = rightChildIndex;
                    }
                }

            }
            return x;
        }

        public T peekMax() {
            return heap.get(0);
        }

        private void swap(int i, int j) {
            T temp = heap.get(i);
            heap.set(i, heap.get(j));
            heap.set(j, temp);
        }

    }

    private static int solve(ArrayList<ArrayList<Integer>> A, int B) {
        int ans = -1;
        MaxHeap<Integer> maxHeap = new MaxHeap<>();

        for (int i = 0; i < A.size(); ++i) {
            for (int j = 0; j < A.get(0).size(); ++j) {
                int currElement = A.get(i).get(j);
                if (maxHeap.size() < B) {
                    maxHeap.insert(currElement);
                } else {
                    if (maxHeap.peekMax() > currElement) {
                        maxHeap.getMaximum();
                        maxHeap.insert(currElement);
                    }
                }
            }
        }
        if (maxHeap.size() > 0) {
            ans = maxHeap.peekMax();
        }
        return ans;
    }
}
