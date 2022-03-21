package com.jsm.scaler.intermediate.Arrays_Maths;

import java.util.Arrays;
import java.util.List;

public class Nby3RepeatNumber {
    /*
    You're given a read-only array of N integers. Find out if any integer occurs more than N/3 times
    in the array in linear time and constant additional space.
    If so, return the integer. If not, return -1.
    If there are multiple solutions, return any one.

    Problem Constraints
    1 <= N <= 7*105
    1 <= A[i] <= 109

    Input Format
    The only argument is an integer array A.

    Output Format
    Return an integer.

    Example Input
    [1 2 3 1 1]

    Example Output
    1

    Example Explanation
    1 occurs 3 times which is more than 5/3 times.
    */

    public static int repeatedNumber(final List<Integer> a) {
        int n = a.size();
        int count1 = 0, count2 = 0;

        // take the integers as the maximum
        // value of integer hoping the integer
        // would not be present in the array
        int first =  Integer.MIN_VALUE;;
        int second = Integer.MAX_VALUE;

        for (int i = 0; i < n; i++) {

            // if this element is previously
            // seen, increment count1.
            if (first == a.get(i))
                count1++;

                // if this element is previously
                // seen, increment count2.
            else if (second == a.get(i))
                count2++;

            else if (count1 == 0) {
                count1++;
                first = a.get(i);
            }

            else if (count2 == 0) {
                count2++;
                second = a.get(i);
            }

            // if current element is different
            // from both the previously seen
            // variables, decrement both the
            // counts.
            else {
                count1--;
                count2--;
            }
        }

        count1 = 0;
        count2 = 0;

        // Again traverse the array and
        // find the actual counts.
        for (int i = 0; i < n; i++) {
            if (a.get(i) == first)
                count1++;

            else if (a.get(i) == second)
                count2++;
        }

        if (count1 > n / 3)
            return first;

        if (count2 > n / 3)
            return second;

        return -1;
        /*
        int num;
	    int n = A.size();
	    Collections.sort(A);
	    for (int i = 0; i < n;) {
	        int freq = 0;
	        num = A.get(i);
	        while (i < n && A.get(i) == num) {
	            freq++;
	            i++;
	        }
	        if (freq * 3 > n)
	            return num;
	    }
	    return -1;
        */
    }

    public static void main(String[] args) {
        List<Integer> a = Arrays.asList(1, 1, 1, 2, 3, 5, 7);
        System.out.println(repeatedNumber(a));
    }
}
