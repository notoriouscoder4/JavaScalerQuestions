package com.jsm.scaler.advance.Heaps;

import java.util.*;

public class N_Max_Pair_Combinations {
    /*
    Given two integers arrays, A and B, of size N each.
    Find the maximum N elements from the sum combinations (A[i] + B[j]) formed from elements in arrays A and B.

    Problem Constraints
    1 <= N <= 2 * 10^5
    -1000 <= A[i], B[i] <= 1000

    Input Format
    The first argument is an integer array A.
    The second argument is an integer array B.

    Output Format
    Return an integer array denoting the N maximum element in descending order.

    Example Input:
    Input 1:
     A = [1, 4, 2, 3]
     B = [2, 5, 1, 6]

    Input 2:
     A = [2, 4, 1, 1]
     B = [-2, -3, 2, 4]

    Example Output:
    Output 1:
     [10, 9, 9, 8]

    Output 2:
     [8, 6, 6, 5]

    Example Explanation:
    Explanation 1:
     4 maximum elements are 10(6+4), 9(6+3), 9(5+4), 8(6+2).

    Explanation 2:
     4 maximum elements are 8(4+4), 6(4+2), 6(4+2), 5(4+1).
    */

    private static class HeapNode {
        public int indexA;
        public int indexB;
        public int nodeSum;

        public HeapNode(int i, int j, int nodeSum) {
            this.indexA = i;
            this.indexB = j;
            this.nodeSum = nodeSum;
        }
    }

    private static ArrayList<Integer> solve(ArrayList<Integer> A, ArrayList<Integer> B) {
        int n = A.size();
        ArrayList<Integer> ans = new ArrayList<>();

        PriorityQueue<HeapNode> max_Heap = new PriorityQueue<>((o1, o2) -> o2.nodeSum - o1.nodeSum);
        Collections.sort(A, Comparator.reverseOrder());
        Collections.sort(B, Comparator.reverseOrder());
        HashSet<String> usedPairs = new HashSet<>();

        max_Heap.add(new HeapNode(0, 0, A.get(0) + B.get(0)));
        while (ans.size() < n) {
            HeapNode currNode = max_Heap.poll();
            String indexPair = currNode.indexA + "#" + currNode.indexB;
            if (!usedPairs.contains(indexPair)) {
                usedPairs.add(indexPair);
                ans.add(currNode.nodeSum);
            }
            if (ans.size() == n) {
                break;
            }
            int indexA = currNode.indexA + 1;
            int indexB = currNode.indexB + 1;

            if (indexA < n && !usedPairs.contains(indexA + "#" + currNode.indexB)) {
                max_Heap.add(new HeapNode(indexA, currNode.indexB, A.get(indexA) + B.get(currNode.indexB)));
            }
            if (indexB < n && !usedPairs.contains(currNode.indexA + "#" + indexB)) {
                max_Heap.add(new HeapNode(currNode.indexA, indexB, A.get(currNode.indexA) + B.get(indexB)));
            }
        }
        return ans;
    }

    public static void main(String[] args) {
        ArrayList<Integer> A = new ArrayList<>(Arrays.asList(1, 4, 2, 3));
        ArrayList<Integer> B = new ArrayList<>(Arrays.asList(2, 5, 1, 6));

        System.out.println(solve(A, B));
    }
}
