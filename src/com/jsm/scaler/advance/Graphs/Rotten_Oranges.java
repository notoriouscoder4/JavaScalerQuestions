package com.jsm.scaler.advance.Graphs;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class Rotten_Oranges {
    /*
    Given a matrix of integers A of size N x M consisting of 0, 1 or 2.

    Each cell can have three values:
    The value 0 representing an empty cell.
    The value 1 representing a fresh orange.
    The value 2 representing a rotten orange.

    Every minute, any fresh orange that is adjacent (Left, Right, Top, or Bottom) to a rotten orange becomes rotten.
    Return the minimum number of minutes that must elapse until no cell has a fresh orange. If this is impossible, return -1 instead.

    Note: Your solution will run on multiple test cases. If you are using global variables, make sure to clear them.

    Problem Constraints
    1 <= N, M <= 1000
    0 <= A[i][j] <= 2

    Input Format
    The first argument given is the integer matrix A.

    Output Format
    Return the minimum number of minutes that must elapse until no cell has a fresh orange.
    If this is impossible, return -1 instead.

    Example Input:
    Input 1:
    A = [   [2, 1, 1]
        [1, 1, 0]
        [0, 1, 1]   ]

    Input 2:
    A = [   [2, 1, 1]
        [0, 1, 1]
        [1, 0, 1]   ]

    Example Output:
    Output 1:
    4

    Output 2:
    -1

    Example Explanation:
    Explanation 1:
    Max of 4 using (0,0) , (0,1) , (1,1) , (1,2) , (2,2)

    Explanation 2:
    Task is impossible
    */

    private static int solve(int[][] A) {
        int N = A.length;
        int M = A[0].length;
        return minTime(A, N, M);
    }

    private static class Pair {
        int i;
        int j;

        public Pair(int i, int j) {
            this.i = i;
            this.j = j;
        }
    }

    private static int minTime(int[][] mat, int N, int M) {
        Queue<Pair> queue = new LinkedList<>();
        int[][] time = new int[N][M];
        for (int[] row : time) {
            Arrays.fill(row, -1);
        }

        for (int i = 0; i < N; ++i) {
            for (int j = 0; j < M; ++j) {
                if (mat[i][j] == 2) {
                    queue.add(new Pair(i, j));
                    time[i][j] = 0;
                }
            }
        }

        int[] x = {-1, 1, 0, 0};
        int[] y = {0, 0, 1, -1};
        while (queue.size() > 0) {
            Pair d = queue.peek();
            queue.poll();
            int i = d.i;
            int j = d.j;

            for (int k = 0; k < 4; ++k) {
                int a = i + x[k];
                int b = j + y[k];
                if (a >= 0 && a < N && b >= 0 && b < M && mat[a][b] == 1) {
                    mat[a][b] = 2;
                    queue.add(new Pair(a, b));
                    time[a][b] = time[i][j] + 1;
                }
            }
        }

        int ans = Integer.MIN_VALUE;
        for (int i = 0; i < N; ++i) {
            for (int j = 0; j < M; ++j) {
                if (mat[i][j] == 1) {
                    return -1;
                } else {
                    ans = Math.max(ans, time[i][j]);
                }
            }
        }
        return ans;
    }

    public static void main(String[] args) {
        int[][] A = {{2, 1, 1},
                {1, 1, 0},
                {0, 1, 1}};
        System.out.println(solve(A));
    }
}
