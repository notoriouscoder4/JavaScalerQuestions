package com.jsm.scaler.advance.Hashing;

import java.util.HashSet;
import java.util.Set;

public class CountRectangles {
    /*
    Given two arrays of integers A and B of size N each, where each pair (A[i], B[i]) for 0 <= i < N
    represents a unique point (x, y) in a 2-D Cartesian plane.

    Find and return the number of unordered quadruplet (i, j, k, l) such that (A[i], B[i]), (A[j], B[j]), (A[k], B[k]) and (A[l], B[l])
    form a rectangle with the rectangle having all the sides parallel to either x-axis or y-axis.

    Problem Constraints
    1 <= N <= 2000
    0 <= A[i], B[i] <= 10^9

    Input Format
    The first argument given is the integer array A.
    The second argument given is the integer array B.

    Output Format
    Return the number of unordered quadruplets that form a rectangle.

    Example Input:
    Input 1:
     A = [1, 1, 2, 2]
     B = [1, 2, 1, 2]

    Input 1:
     A = [1, 1, 2, 2, 3, 3]
     B = [1, 2, 1, 2, 1, 2]

    Example Output:
    Output 1:
     1

    Output 2:
     3

    Example Explanation:
    Explanation 1:
     All four given points make a rectangle. So, the answer is 1.

    Explanation 2:
     3 quadruplets which make a rectangle are: (1, 1), (2, 1), (2, 2), (1, 2)
                                               (1, 1), (3, 1), (3, 2), (1, 2)
                                               (2, 1), (3, 1), (3, 2), (2, 2)
    */

    /**
     * (x1, y1) (x2, y2) (x3, y3) (x4, y4)
     * find diagonal points (x1, y1) and (x2, y2), to be diagonal points,
     * x1 != x2 and y1 != y2.
     * Two other points of a rectangle will be (x1, y2) and (x2, y1).
     * Check if these points exists or not.
     * if exists, it makes rectangle. count = count + 1.
     * In the processing of finding rectangle counts, we will come across both diagonals
     * of a rectangle, i.e. we will count same rectangle twice.
     * so after finding total counts of rectangle, return (count / 2).
     *
     * @param A - list of x coordinates
     * @param B - list of y coordinates
     * @return - count of rectangles
     */

    private static int countRectangles(int[] A, int[] B) {
        Set<Coordinates> set = new HashSet<>();
        for (int i = 0; i < A.length; i++) {
            set.add(new Coordinates(A[i], B[i]));
        }

        int count = 0;
        for (int i = 0; i < A.length; i++) {
            for (int j = i + 1; j < B.length; j++) {
                if (A[i] != A[j] && B[i] != B[j]) {
                    if (set.contains(new Coordinates(A[i], B[j])) && set.contains(new Coordinates(A[j], B[i]))) {
                        count++;
                    }
                }
            }
        }
        return count / 2;
    }

    private static class Coordinates {
        private final int x;
        private final int y;

        private Coordinates(int x, int y) {
            this.x = x;
            this.y = y;
        }

        public int getX() {
            return x;
        }

        public int getY() {
            return y;
        }

        @Override
        public int hashCode() {
            final int prime = 31;
            int result = 1;
            result = prime * result + x;
            result = prime * result + y;
            return result;
        }

        @Override
        public boolean equals(Object obj) {
            if (this == obj)
                return true;
            if (obj == null)
                return false;
            if (getClass() != obj.getClass())
                return false;
            Coordinates other = (Coordinates) obj;
            return this.x == other.x && this.y == other.y;
        }
    }

    public static void main(String[] args) {
        int[] A = {1, 1, 2, 2, 3, 3};
        int[] B = {1, 2, 1, 2, 1, 2};
        System.out.println(countRectangles(A, B));
    }
}
