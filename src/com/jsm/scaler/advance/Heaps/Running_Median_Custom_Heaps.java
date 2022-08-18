package com.jsm.scaler.advance.Heaps;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Running_Median_Custom_Heaps {
    /*
    Given an array of integers, A denoting a stream of integers. New arrays of integer B and C are formed.
    Each time an integer is encountered in a stream, append it at the end of B and append the median of array B at the C.

    Find and return the array C.

    NOTE:
    If the number of elements is N in B and N is odd, then consider the median as B[N/2] ( B must be in sorted order).
    If the number of elements is N in B and N is even, then consider the median as B[N/2-1]. ( B must be in sorted order).

    Problem Constraints
    1 <= length of the array <= 100000
    1 <= A[i] <= 10^9

    Input Format
    The only argument given is the integer array A.

    Output Format
    Return an integer array C, C[i] denotes the median of the first i elements.

    Example Input:
    Input 1:
     A = [1, 2, 5, 4, 3]

    Input 2:
     A = [5, 17, 100, 11]

    Example Output:
    Output 1:
     [1, 1, 2, 2, 3]

    Output 2:
     [5, 5, 17, 11]

    Example Explanation:
    Explanation 1:
     stream          median
     [1]             1
     [1, 2]          1
     [1, 2, 5]       2
     [1, 2, 5, 4]    2
     [1, 2, 5, 4, 3] 3

    Explanation 2:
     stream          median
     [5]              5
     [5, 17]          5
     [5, 17, 100]     17
     [5, 17, 100, 11] 11
    */

    private static class MaxHeap<T extends Comparable<T>> {
        List<T> heap;

        public MaxHeap() {
            heap = new ArrayList<>();
        }

        public int size() {
            return heap.size();
        }

        public List<T> getHeap() {
            return heap;
        }

        public boolean isEmpty() {
            return heap.size() == 0;
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
                    T max;

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

    private static class MinHeap<T extends Comparable<T>> {
        List<T> heap;

        public MinHeap() {
            heap = new ArrayList<>();
        }

        public int size() {
            return heap.size();
        }

        public List<T> getHeap() {
            return heap;
        }

        public boolean isEmpty() {
            return heap.size() == 0;
        }

        public void insert(T x) {
            heap.add(x);
            int i = this.heap.size() - 1;
            while (i > 0) {
                int parentIndex = (i - 1) / 2;
                if (heap.get(i).compareTo(heap.get(parentIndex)) < 0) {
                    swap(i, parentIndex);
                    i = parentIndex;
                } else {
                    return;
                }
            }
        }

        public T getMinimum() {
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
                    T min;

                    // find minimum out of 3
                    min = heap.get(i).compareTo(heap.get(leftChildIndex)) < 0 ? heap.get(i) : heap.get(leftChildIndex);
                    if (rightChildIndex < heap.size()) {
                        min = heap.get(rightChildIndex).compareTo(min) < 0 ? heap.get(rightChildIndex) : min;
                    }

                    if (min == heap.get(i)) {
                        break;
                    } else if (min == heap.get(leftChildIndex)) {
                        swap(i, leftChildIndex);
                        i = leftChildIndex;
                    } else if (rightChildIndex < heap.size() && min == heap.get(rightChildIndex)) {
                        swap(i, rightChildIndex);
                        i = rightChildIndex;
                    }
                }

            }
            return x;
        }

        public T peekMin() {
            return heap.get(0);
        }

        private void swap(int i, int j) {
            T temp = heap.get(i);
            heap.set(i, heap.get(j));
            heap.set(j, temp);
        }
    }

    private static int[] solve(int[] A) {
        int[] output = new int[A.length];
        MaxHeap<Integer> maxHeap = new MaxHeap<>();
        MinHeap<Integer> minHeap = new MinHeap<>();

        int index = 0;
        for (int a : A) {
            // insert into maxHeap if empty
            if (maxHeap.isEmpty()) {
                maxHeap.insert(a);
            } else {
                if (a < maxHeap.peekMax()) {
                    // insert into maxHeap
                    maxHeap.insert(a);
                    if (maxHeap.size() - minHeap.size() > 1) {
                        // if size(maxHeap) - size(minHeap) > 1, insert top element from maxHeap into
                        // minHeap
                        minHeap.insert(maxHeap.getMaximum());
                    }
                } else {
                    // insert into minHeap
                    minHeap.insert(a);
                    if (minHeap.size() > maxHeap.size()) {
                        // if size(minHeap) > size(minHeap), insert top element from minHeap into
                        // maxHeap
                        maxHeap.insert(minHeap.getMinimum());
                    }
                }
            }

            output[index++] = maxHeap.peekMax();
        }
        return output;
    }

    public static void main(String[] args) {
        int[] A = new int[]{1, 1, 2, 2, 3};
        System.out.println(Arrays.toString(solve(A)));
    }
}
