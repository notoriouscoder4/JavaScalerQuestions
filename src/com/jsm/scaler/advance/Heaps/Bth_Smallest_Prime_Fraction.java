package com.jsm.scaler.advance.Heaps;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;

public class Bth_Smallest_Prime_Fraction {
    /*
    Given a sorted array of integers A which contains 1 and some number of primes.
    Then, for every p < q in the list, we consider the fraction p / q.
    What is the B-th smallest fraction considered?

    Return your answer as an array of integers, where answer[0] = p and answer[1] = q.

    Problem Constraints
    1 <= length(A) <= 2000
    1 <= A[i] <= 30000
    1 <= B <= length(A)*(length(A) - 1)/2

    Input Format
    The first argument of input contains the integer array, A.
    The second argument of input contains an integer B.

    Output Format
    Return an array of two integers, where answer[0] = p and answer[1] = q.

    Example Input
    Input 1:
     A = [1, 2, 3, 5]
     B = 3

    Input 2:
     A = [1, 7]
     B = 1

    Example Output:
    Output 1:
     [2, 5]

    Output 2:
     [1, 7]

    Example Explanation:
    Explanation 1:
     The fractions to be considered in sorted order are:
     [1/5, 1/3, 2/5, 1/2, 3/5, 2/3]
     The third fraction is 2/5.

    Explanation 2:
     The fractions to be considered in sorted order are:
     [1/7]
     The first fraction is 1/7.
    */

    private static class Tuple {
        public int idxNum;
        public int idxDen;
        public double fraction;

        public Tuple(int idxNum, int idxDen, double fraction) {
            this.idxNum = idxNum;
            this.idxDen = idxDen;
            this.fraction = fraction;
        }
    }

    private static class CustomComp implements Comparator<Tuple> {

        @Override
        public int compare(Tuple a, Tuple b) {
            if (a.fraction > b.fraction)
                return 1;
            return -1;
        }
    }

    private static ArrayList<Integer> solve(ArrayList<Integer> A, int B) {
        int n = A.size();
        if (n == 1) {
            ArrayList<Integer> ans = new ArrayList<>();
            ans.add(0, A.get(0));
            ans.add(1, A.get(0));
            return ans;
        }
        PriorityQueue<Tuple> min_heap = new PriorityQueue<>(new CustomComp());

        for (int i = 0; i < n; ++i) {
            for (int j = i + 1; j < n; ++j) {
                double fraction = Double.valueOf(A.get(i)) / Double.valueOf(A.get(j));
                Tuple tuple = new Tuple(A.get(i), A.get(j), fraction);
                if (min_heap.size() < B)
                    min_heap.add(tuple);
                else if (min_heap.size() == B) {
                    // since we want the smallest so if(an element greater than the current element is already
                    // present in the heap we will remove it)
                    if (min_heap.peek().fraction > fraction) {
                        min_heap.poll();
                        min_heap.add(tuple);
                    }
                }
            }
        }

        Tuple temp = min_heap.poll();
        ArrayList<Integer> ans = new ArrayList<>();
        ans.add(0, temp.idxNum);
        ans.add(1, temp.idxDen);
        return ans;
    }

    public static void main(String[] args) {
        ArrayList<Integer> A = new ArrayList<>(Arrays.asList(1, 2, 3, 5));
        int B = 3;

        System.out.println(solve(A, B));
    }
}
