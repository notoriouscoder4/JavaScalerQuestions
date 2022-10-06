package com.jsm.scaler.advance.Graphs;

public class Number_Of_Islands {
    /*
    Given a matrix of integers A of size N x M consisting of 0 and 1. A group of connected 1's forms an island.
    From a cell (i, j) such that A[i][j] = 1 you can visit any cell that shares a corner with (i, j) and value in that cell is 1.
    More formally, from any cell (i, j) if A[i][j] = 1, you can visit:

    (i-1, j) if (i-1, j) is inside the matrix and A[i-1][j] = 1. // top
    (i, j-1) if (i, j-1) is inside the matrix and A[i][j-1] = 1. // left
    (i+1, j) if (i+1, j) is inside the matrix and A[i+1][j] = 1. // down
    (i, j+1) if (i, j+1) is inside the matrix and A[i][j+1] = 1. // right
    (i-1, j-1) if (i-1, j-1) is inside the matrix and A[i-1][j-1] = 1. // top-left diagonal
    (i+1, j+1) if (i+1, j+1) is inside the matrix and A[i+1][j+1] = 1. // right-down diagonal
    (i-1, j+1) if (i-1, j+1) is inside the matrix and A[i-1][j+1] = 1. // top-right diagonal
    (i+1, j-1) if (i+1, j-1) is inside the matrix and A[i+1][j-1] = 1. // left-down diagonal
    Return the number of islands.

    NOTE: Rows are numbered from top to bottom and columns are numbered from left to right.

    Problem Constraints
    1 <= N, M <= 100
    0 <= A[i] <= 1

    Input Format
    The only argument given is the integer matrix A.

    Output Format
    Return the number of islands.

    Example Input:
    Input 1:
     A = [
           [0, 1, 0]
           [0, 0, 1]
           [1, 0, 0]
         ]

    Input 2:
     A = [
           [1, 1, 0, 0, 0]
           [0, 1, 0, 0, 0]
           [1, 0, 0, 1, 1]
           [0, 0, 0, 0, 0]
           [1, 0, 1, 0, 1]
         ]

    Example Output:
    Output 1:
     2

    Output 2:
     5

    Example Explanation:
    Explanation 1:
     The 1's at position A[0][1] and A[1][2] forms one island.
     Other is formed by A[2][0].

    Explanation 2:
     There 5 island in total.
    */

    private static int solve(int[][] A) {
        int N = A.length;
        int M = A[0].length;
        return islands(A, N, M);
    }

    private static int islands(int[][] mat, int N, int M) {
        int count = 0;
        for (int i = 0; i < N; ++i) {
            for (int j = 0; j < M; ++j) {
                if (mat[i][j] == 1) {
                    count++;
                    dfs(mat, i, j, N, M);
                }
            }
        }
        return count;
    }

    /*
    Since, we can do 8-type of movements as given in the question:
    // Adjacent Movements-
    Top- (i-1, j)
    Bottom- (i+1, j)
    Right- (i, j+1)
    Left- (i, j-1)

    // Diagonal Movements-
    Top-Left- (i-1, j-1)
    Top-Right- (i-1, j+1)
    Bottom-Left- (i+1, j-1)
    Bottom-Right- (i+1, j+1)
    */
    private static void dfs(int[][] mat, int i, int j, int N, int M) {
        int[] x = {-1, 1, 0, 0, -1, 1, -1, 1};
        int[] y = {0, 0, 1, -1, -1, 1, 1, -1};
        if (i < 0 || j < 0 || i >= N || j >= M || mat[i][j] == 0) {
            return;
        }
        mat[i][j] = 0;
        for (int k = 0; k < 8; ++k) {
            dfs(mat, i + x[k], j + y[k], N, M);
        }
    }

    public static void main(String[] args) {
        int[][] A = {{1, 1, 0, 0, 0},
                {0, 1, 0, 0, 0},
                {1, 0, 0, 1, 1},
                {0, 0, 0, 0, 0},
                {1, 0, 1, 0, 1}};
        System.out.println("The no. of islands are: " + solve(A));
    }
}
