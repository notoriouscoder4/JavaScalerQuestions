package com.jsm.scaler.advance.Graphs;

import java.util.Arrays;

public class Floyd_Warshall_Algorithm {
    /*
    Given a matrix of integers A of size N x N, where A[i][j] represents the weight of directed edge from i to j (i ---> j).
    If i == j, A[i][j] = 0, and if there is no directed edge from vertex i to vertex j, A[i][j] = -1.
    Return a matrix B of size N x N where B[i][j] = the shortest path from vertex i to vertex j.
    If there is no possible path from vertex i to vertex j , B[i][j] = -1

    Note: Rows are numbered from top to bottom and columns are numbered from left to right.

    Problem Constraints
    1 <= N <= 200
    -1 <= A[i][j] <= 1000000

    Input Format
    The first and only argument given is the integer matrix A.

    Output Format
    Return a matrix B of size N x N where B[i][j] = the shortest path from vertex i to vertex j
    If there is no possible path from vertex i to vertex j, B[i][j] = -1.

    Example Input:
    A = [ [0 , 50 , 39]
              [-1 , 0 , 1]
              [-1 , 10 , 0] ]


    Example Output:
    [ [0 , 49 , 39 ]
       [-1 , 0 , -1 ]
       [-1 , 10 , 0 ] ]

    Example Explanation:
    The Shortest Path from 1 to 2 would be 1 ---> 3 ---> 2 and not directly from 1 to 2,
    All remaining distances remains same.
    */

    private static int[][] solve(int[][] A) {
        int row = A.length;
        int col = A[0].length;
        int[][] shortest_path = new int[row][col];

        // copy the initial state
        for (int i = 0; i < row; ++i) {
            for (int j = 0; j < col; ++j) {
                if (A[i][j] == -1) {
                    shortest_path[i][j] = (int) (1e9);
                } else if (i == j) {
                    shortest_path[i][j] = 0;
                } else {
                    shortest_path[i][j] = A[i][j];
                }
            }
        }

        // Floyd Warshall Algorithm
        for (int k = 0; k < row; ++k) {
            for (int i = 0; i < row; ++i) {
                for (int j = 0; j < col; ++j) {
                    if (i == j) continue;
                    shortest_path[i][j] = Math.min(shortest_path[i][j], shortest_path[i][k] + shortest_path[k][j]);
                }
            }
        }

        for (int i = 0; i < row; ++i) {
            for (int j = 0; j < col; ++j) {
                if (shortest_path[i][j] == (int) (1e9)) {
                    shortest_path[i][j] = -1;
                }
            }
        }
        return shortest_path;
    }

    public static void main(String[] args) {
        int[][] A = {{0, 50, 39}, {-1, 0, 1}, {-1, 10, 0}};
        System.out.println(Arrays.deepToString(solve(A)));
    }
}
