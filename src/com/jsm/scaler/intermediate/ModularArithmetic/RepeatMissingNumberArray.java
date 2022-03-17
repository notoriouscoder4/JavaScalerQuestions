package com.jsm.scaler.intermediate.ModularArithmetic;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class RepeatMissingNumberArray {
    /*
    There are certain problems which are asked in the interview to also check how you take care of overflows in your problem.
    This is one of those problems.
    Please take extra care to make sure that you are type-casting your ints to long properly and at all places. Try to verify if your solution works if number of elements is as large as 105

    Food for thought :

    Even though it might not be required in this problem, in some cases, you might be required to order the operations cleverly so that the numbers do not overflow.
    For example, if you need to calculate n! / k! where n! is factorial(n), one approach is to calculate factorial(n), factorial(k) and then divide them.
    Another approach is to only multiple numbers from k + 1 ... n to calculate the result.
    Obviously approach 1 is more susceptible to overflows.

    You are given a read only array of n integers from 1 to n.
    Each integer appears exactly once except A which appears twice and B which is missing.
    Return A and B.

    Note: Your algorithm should have a linear runtime complexity. Could you implement it without using extra memory?
    Note that in your output A should precede B.

    Example:

    Input:[3 1 2 5 3]

    Output:[3, 4]

    A = 3, B = 4

    Sum of squares of n natural numbers = (n * (n + 1) * (2n + 1)) / 6;

    Sum of squares of first n even numbers = (2n * (n + 1) * (2n + 1)) / 3;

    Sum of squares of first n odd numbers = (n * (2n + 1) * (2n - 1)) / 3;

    */

    public static ArrayList<Integer> repeatedNumber(final List<Integer> A) {
        ArrayList<Integer> res = new ArrayList<>();

        int n = A.size();

        long sumOfNum = (((long) n) * ((long) n + 1)) / 2;
        long sumOfSq = (((long) n) * ((long) n + 1) * ((long) 2 * n + 1)) / 6;

        for (int i = 0; i < n; i++) {
            sumOfNum -= (long) A.get(i);
            // System.out.println("sumOfNum: " + sumOfNum);
        }

        for (int i = 0; i < n; i++) {
            sumOfSq -= (long) A.get(i) * (long) A.get(i);
            // System.out.println("sumOfSq: " + sumOfSq);
        }

        long sumNum = sumOfSq / sumOfNum;
        // System.out.println("sumNum: " + sumNum);

        int missing = (int) (sumNum + sumOfNum) / 2;
        // System.out.println("missing:" + missing);
        int repeated = (int) (sumNum - missing);
        // System.out.println("repeated:" + repeated);

        res.add(repeated);
        res.add(missing);

        return res;

        /*
        ArrayList<Integer> res = new ArrayList<>();

	    Collections.sort(A);
	    int n = A.size();
	    int rep = -1;
	    int miss = -1;
	    long sum = A.get(0);

	    for (int i = 1; i < n; i++) {
	        if (A.get(i).intValue() == A.get(i - 1).intValue()) {
	            rep = A.get(i);
	        }
            sum += A.get(i);
	    }

	    miss = (int) ((1L * n * (1L * n + 1)) / 2 - sum + rep);

	    res.add(rep);
	    res.add(miss);

	    return res;
        */
    }

    public static void main(String[] args) {
        List<Integer> A = Arrays.asList(3, 1, 2, 5 , 3);
        System.out.println(repeatedNumber(A));
    }
}
