package com.jsm.scaler.advance.Stacks;

import java.util.Stack;

public class MAX_MIN {
    /*
    Given an array of integers A.

    value of an array = max(array) - min(array).

    Calculate and return the sum of values of all possible sub_arrays of A modulo 10^9+7.

    Problem Constraints
    1 <= |A| <= 100000
    1 <= A[i] <= 1000000

    Input Format
    The first and only argument given is the integer array A.

    Output Format
    Return the sum of values of all possible sub_arrays of A modulo 109+7.

    Example Input
    Input 1:
     A = [1]

    Input 2:
     A = [4, 7, 3, 8]

    Example Output
    Output 1:
     0

    Output 2:
     26

    Example Explanation:
    Explanation 1:
    Only 1 sub_array exists. Its value is 0.

    Explanation 2:
    value ( [4] ) = 4 - 4 = 0
    value ( [7] ) = 7 - 7 = 0
    value ( [3] ) = 3 - 3 = 0
    value ( [8] ) = 8 - 8 = 0
    value ( [4, 7] ) = 7 - 4 = 3
    value ( [7, 3] ) = 7 - 3 = 4
    value ( [3, 8] ) = 8 - 3 = 5
    value ( [4, 7, 3] ) = 7 - 3 = 4
    value ( [7, 3, 8] ) = 8 - 3 = 5
    value ( [4, 7, 3, 8] ) = 8 - 3 = 5
    sum of values % 10^9+7 = 26
    */

    private static int solve(int[] A) {
        int[] nglIndex = NGLIndex(A);
        int[] ngrIndex = NGRIndex(A);

        int[] nslIndex = NSLIndex(A);
        int[] nsrIndex = NSRIndex(A);

        long ans = 0;
        int MOD = 1000000007;

        /* Contribution Technique:-
            Contribution of all elements in finding MAX - Contribution of all elements in finding MIN
            For every element A[i], find in how many sub_arrays A[i] will be present as MAX and MIN

            so , find count of sub_arrays in which A[i] is MAX = x;
                 find count of sub_arrays in which A[i] is MIN = y;

            so, ans = ans + (A[i] * x - A[i] * y)
        */
        for (int i = 0; i < A.length; ++i) {
            /* For MAX - No. of sub_arrays in which A[i] will be as MAX
            x = (i - s) * (e - i)
            where, s : Nearest Greater Element Index on left
                   e : Nearest Greater Element Index on right
            */
            long max = (long) (i - nglIndex[i]) * (ngrIndex[i] - i) % MOD;
            long maxContribution = (max * A[i]) % MOD;


            /* For MIN - No. of sub_arrays in which A[i] will be as MIN
            y = (i - s) * (e - i)
            where, s : Nearest Smaller Element Index on left
                   e : Nearest Smaller Element Index on right
            */
            long min = (long) (i - nslIndex[i]) * (nsrIndex[i] - i) % MOD;
            long minContribution = (min * A[i]) % MOD;

            ans = (ans % MOD) + ((maxContribution - minContribution) % MOD);
            ans = ans % MOD;
        }
        if (ans < 0)
            ans = (ans + MOD) % MOD;
        return (int) ans % MOD;
    }

    private static int[] NGLIndex(int[] A) {
        int[] nglIndex = new int[A.length];
        Stack<Integer> stack = new Stack<>();

        for (int i = 0; i < A.length; ++i) {
            while (!stack.isEmpty() && A[stack.peek()] <= A[i])
                stack.pop();
            if (stack.isEmpty())
                nglIndex[i] = -1;
            else
                nglIndex[i] = stack.peek();
            stack.push(i);
        }
        return nglIndex;
    }

    private static int[] NGRIndex(int[] A) {
        int[] ngrIndex = new int[A.length];
        Stack<Integer> stack = new Stack<>();

        for (int i = A.length - 1; i >= 0; --i) {
            while (!stack.isEmpty() && A[stack.peek()] <= A[i])
                stack.pop();
            if (stack.isEmpty())
                ngrIndex[i] = A.length;
            else
                ngrIndex[i] = stack.peek();
            stack.push(i);
        }
        return ngrIndex;
    }

    private static int[] NSLIndex(int[] A) {
        int[] nslIndex = new int[A.length];
        Stack<Integer> stack = new Stack<>();

        for (int i = 0; i < A.length; ++i) {
            while (!stack.isEmpty() && A[stack.peek()] >= A[i])
                stack.pop();
            if (stack.isEmpty())
                nslIndex[i] = -1;
            else
                nslIndex[i] = stack.peek();
            stack.push(i);
        }
        return nslIndex;
    }

    private static int[] NSRIndex(int[] A) {
        int[] nsrIndex = new int[A.length];
        Stack<Integer> stack = new Stack<>();

        for (int i = A.length - 1; i >= 0; --i) {
            while (!stack.isEmpty() && A[stack.peek()] >= A[i])
                stack.pop();
            if (stack.isEmpty())
                nsrIndex[i] = A.length;
            else
                nsrIndex[i] = stack.peek();
            stack.push(i);
        }
        return nsrIndex;
    }

    public static void main(String[] args) {
        int[] A = {4, 7, 3, 8};
        System.out.println(solve(A));
    }
}
