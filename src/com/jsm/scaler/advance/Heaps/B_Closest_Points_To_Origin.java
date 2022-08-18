package com.jsm.scaler.advance.Heaps;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;

public class B_Closest_Points_To_Origin {
    /*
    We have a list A of points (x, y) on the plane. Find the B-closest points to the origin (0, 0).
    Here, the distance between two points on a plane is the Euclidean distance.
    You may return the answer in any order. The answer is guaranteed to be unique (except for the order that it is in.)

    NOTE: Euclidean distance between two points P1(x1, y1) and P2(x2, y2) is sqrt( (x1-x2)^2 + (y1-y2)^2 ).

    Problem Constraints
    1 <= B <= length of the list A <= 10^5
    -10^5 <= A[i][0] <= 10^5
    -10^5 <= A[i][1] <= 10^5

    Input Format
    The argument given is list A and an integer B.

    Output Format
    Return the B_closest points to the origin (0, 0) in any order.

    Example Input:
    Input 1:
     A = [
           [1, 3],
           [-2, 2]
         ]
     B = 1

    Input 2:
     A = [
           [1, -1],
           [2, -1]
         ]
     B = 1

    Example Output:
    Output 1:
     [ [-2, 2] ]

    Output 2:
     [ [1, -1] ]

    Example Explanation:
    Explanation 1:
     The Euclidean distance will be sqrt(10) for point [1,3] and sqrt(8) for point [-2,2].
     So one closest point will be [-2,2].

    Explanation 2:
     The Euclidean distance will be sqrt(2) for point [1,-1] and sqrt(5) for point [2,-1].
     So one closest point will be [1,-1].
    */

    private static class Point {
        public int x;
        public int y;
        public int distance;

        public Point(int x, int y, int distance) {
            this.x = x;
            this.y = y;
            this.distance = distance;
        }
    }

    private static class PointComparator implements Comparator<Point> {

        @Override
        public int compare(Point p1, Point p2) {
            if (p1.distance > p2.distance)
                return 1;
            else if (p1.distance < p2.distance)
                return -1;
            return 0;
        }
    }

    private static int[][] solve(int[][] A, int B) {

        PriorityQueue<Point> max_heap = new PriorityQueue<>(new PointComparator());

        for (int i = 0; i < A.length; ++i) {
            int x = A[i][0];
            int y = A[i][1];
            int distance = x * x + y * y;
            Point p = new Point(x, y, distance);

            max_heap.add(p);

            if (max_heap.size() > B)
                max_heap.poll();
        }

        int[][] result = new int[B][2];
        for (int i = 0; i < B; ++i) {
            Point point = max_heap.poll();
            result[i][0] = point.x;
            result[i][1] = point.y;
        }
        return result;
    }

    public static void main(String[] args) {
        int[][] A = {{1, 3}, {-2, 2}};
        int B = 1;

        System.out.println(Arrays.deepToString(solve(A, B)));
    }
}
