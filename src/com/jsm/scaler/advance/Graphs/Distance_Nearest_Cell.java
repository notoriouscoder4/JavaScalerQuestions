package com.jsm.scaler.advance.Graphs;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class Distance_Nearest_Cell {
    /*
    Given a matrix of integers A of size N x M consisting of 0 or 1.
    For each cell of the matrix find the distance of nearest 1 in the matrix.
    Distance between two cells (x1, y1) and (x2, y2) is defined as |x1 - x2| + |y1 - y2|.
    Find and return a matrix B of size N x M which defines for each cell in A distance of nearest 1 in the matrix A.

    NOTE: There is at least one 1 is present in the matrix.

    Problem Constraints
    1 <= N, M <= 1000
    0 <= A[i][j] <= 1

    Input Format
    The first argument given is the integer matrix A.

    Output Format
    Return the matrix B.

    Example Input:
    Input 1:
     A = [
           [0, 0, 0, 1]
           [0, 0, 1, 1]
           [0, 1, 1, 0]
         ]

    Input 2:
     A = [
           [1, 0, 0]
           [0, 0, 0]
           [0, 0, 0]
         ]

    Example Output:
    Output 1:
     [
       [3, 2, 1, 0]
       [2, 1, 0, 0]
       [1, 0, 0, 1]
     ]

    Output 2:
     [
       [0, 1, 2]
       [1, 2, 3]
       [2, 3, 4]
     ]

    Example Explanation:
    Explanation 1:
     A[0][0], A[0][1], A[0][2] will be nearest to A[0][3].
     A[1][0], A[1][1] will be nearest to A[1][2].
     A[2][0] will be nearest to A[2][1] and A[2][3] will be nearest to A[2][2].

    Explanation 2:
     There is only a single 1. Fill the distance from that 1.
    */

    private static class Pair {
        int first;
        int second;

        public Pair(int x, int y) {
            this.first = x;
            this.second = y;
        }
    }

    private static int[][] solve(int[][] A) {
        int n = A.length;
        int m = A[0].length;
        Queue<Pair> q = new LinkedList<>();
        int[][] distance = new int[n][m];
        for (int[] row : distance) {
            Arrays.fill(row, Integer.MAX_VALUE);
        }
        //Using multi-source BFS
        //Inserting coordinates whose value is 1 in queue
        for (int i = 0; i < n; ++i) {
            for (int j = 0; j < m; ++j) {
                if (A[i][j] == 1) {
                    distance[i][j] = 0;
                    q.add(new Pair(i, j));
                }
            }
        }

        int[] x_dir = {-1, 1, 0, 0};
        int[] y_dir = {0, 0, 1, -1};
        while (!q.isEmpty()) {
            Pair pair = q.poll();
            int x = pair.first;
            int y = pair.second;
            //updating the nearest distance to its adjacent top,bottom,up,down direction
            for (int k = 0; k < 4; ++k) {
                int dx = x + x_dir[k];
                int dy = y + y_dir[k];
                if (dx < n && dx >= 0 && dy < m && dy >= 0 && distance[dx][dy] > distance[x][y] + 1) {
                    distance[dx][dy] = distance[x][y] + 1;
                    q.add(new Pair(dx, dy));
                }
            }
        }
        return distance;
    }

    public static void main(String[] args) {
        int[][] A = {{0, 0, 0, 1}, {0, 0, 1, 1}, {0, 1, 1, 0}};
        System.out.println(Arrays.deepToString(solve(A)));
    }
}
