package com.jsm.scaler.advance.BackTracking;

import java.util.ArrayList;

public class Rat_In_A_Maze {
    /*
    Given a grid A, a rat is at position (1, 1). He wants to go to the position (n, n) where n is size of the square matrix A.
    1 represents a traversable cell and 0 represents a non-traversable cell. Rat can only move right or down.

    Return a path that the rat can take.

    Problem Constraints
    1 <= |A| <= 4

    Input Format
    First and only argument is the vector of vectors A.

    Output Format
    Return a vector of vectors that denotes a path that can be taken.

    Example Input:
    Input 1:
    A = [   [1, 0]
            [1, 1]
        ]

    Input 2:
    A = [    [1, 1, 1]
             [1, 0, 1]
             [0, 0, 1]
        ]

    Example Output:
    Output 1:
    [   [1, 0]
        [1, 1]
    ]

    Output 2:
    [    [1, 1, 1]
         [0, 0, 1]
         [0, 0, 1]
    ]

    Example Explanation:
    Explanation 1:
     Path is shown in output.

    Explanation 2:
     Path is shown in output.
    */

    private static int[][] solve(int[][] A) {
        int n = A.length;
        int m = A[0].length;
        int[][] ans = new int[n][m];

        ratInAMaze(A, ans, 0, 0, n, m);
        return ans;
    }

    private static boolean ratInAMaze(int[][] mat, int[][] ans, int x, int y, int N, int M) {
        if (x == N - 1 && y == M - 1) {
            ans[x][y] = 1; // rat is successfully able to reach to the position
            return true;
        }
        if (x < 0 || x >= N || y < 0 || y >= M) {
            return false; // rat should not be out of bound from N*N matrix
        }
        if (mat[x][y] == 0 || mat[x][y] == 2 || ans[x][y] == 1) {
            return false;
        }
        ans[x][y] = 1;
        mat[x][y] = 2;// visited location is marked as visited
        if (ratInAMaze(mat, ans, x + 1, y, N, M)
                ||
                ratInAMaze(mat, ans, x, y + 1, N, M)
                ||
                ratInAMaze(mat, ans, x - 1, y, N, M)
                ||
                ratInAMaze(mat, ans, x, y - 1, N, M))
            return true;
        ans[x][y] = 0;
        return false;
    }
}
