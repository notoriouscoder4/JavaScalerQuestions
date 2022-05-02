package com.jsm.scaler.advance.Arrays;

import java.util.ArrayList;
import java.util.Arrays;

public class MergeIntervals {
    /*
    Given a set of non-overlapping intervals, insert a new interval into the intervals (merge if necessary).
    You may assume that the intervals were initially sorted according to their start times.

    Problem Constraints
    0 <= |intervals| <= 105

    Input Format
    First argument is the vector of intervals,
    Second argument is the new interval to be merged

    Output Format
    Return the vector of intervals after merging

    Example Input:
    Input 1:
    Given intervals [1, 3], [6, 9] insert and merge [2, 5] .

    Input 2:
    Given intervals [1, 3], [6, 9] insert and merge [2, 6] .

    Example Output:
    Output 1:
     [ [1, 5], [6, 9] ]

    Output 2:
     [ [1, 9] ]

    Example Explanation:
    Explanation 1:
    (2,5) does not completely merge the given intervals

    Explanation 2:
    (2,6) completely merges the given intervals
    */

    private static class Interval {
        int start;
        int end;

        Interval() {
            start = 0;
            end = 0;
        }

        Interval(int s, int e) {
            start = s;
            end = e;
        }
    }

    private static ArrayList<Interval> insert(ArrayList<Interval> intervals, Interval newInterval) {
        ArrayList<Interval> ans = new ArrayList<>();
        for (int i = 0; i < intervals.size(); i++) {
            if (newInterval.start > intervals.get(i).end) {
                ans.add(intervals.get(i));
            } else if (newInterval.end < intervals.get(i).start) {
                ans.add(newInterval);
                for (int j = i; j < intervals.size(); j++)
                    ans.add(intervals.get(j));
                return ans;
            } else {
                newInterval.start = Math.min(newInterval.start, intervals.get(i).start);
                newInterval.end = Math.max(newInterval.end, intervals.get(i).end);
            }
        }
        ans.add(newInterval);
        return ans;

        /*
        int n = intervals.size();
        if (n == 0)
            return {newInterval};
        // case 1: newInterval lies before the interval range
        // case 2: newInterval lies after the interval range
        // case 3: newInterval lies inside the interval range
        // case 3a: newInterval overlaps with the interval range
        // case 3b: newInterval doesn't overlap but lies inside the given interval range
        if (newInterval.end < intervals.get(0).start)
            intervals.add(intervals.end(), newInterval);
        else if (newInterval.start > intervals.get(n - 1).end)
            intervals.add(intervals.end(), newInterval);
        else {
            int s = newInterval.start;
            int e = newInterval.end;
            int start_overlap = Integer.MAX_VALUE, end_overlap = Integer.MIN_VALUE;
            for (int i = 0; i < n; i++) {
                if (s <= intervals.get(i).end && e >= intervals.get(i).start) {
                    s = Math.min(s, intervals.get(i).start);
                    e = Math.max(e, intervals.get(i).end);
                    start_overlap = Math.min(start_overlap, i);
                    end_overlap = Math.max(end_overlap, i);
                } else if (newInterval.start > intervals.get(i).end && newInterval.end < intervals.get(i).start) {
                    intervals.add(intervals.begin() + i + 1, newInterval);
                    return intervals;
                }
            }
            intervals.remove(intervals.begin() + start_overlap, intervals.begin() + end_overlap + 1);
            intervals.add(intervals.begin() + start_overlap, new Interval(s, e));
        }
        return intervals;*/
    }

    public static void main(String[] args) {
//        ArrayList<Interval> intervals = new ArrayList<>(Arrays.asList({1, 3}, {6, 9}));
//        Interval newInterval = new Interval();
//        System.out.println(insert(intervals, newInterval));
    }
}
