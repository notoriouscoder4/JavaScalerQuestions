package com.jsm.scaler.advance.BackTracking;

import java.util.ArrayList;

public class NQueens {
    /*
    The n-queens puzzle is the problem of placing n queens on an n×n chessboard such that no two queens attack each other.
    Given an integer A, return all distinct solutions to the n-queens puzzle.

    Each solution contains a distinct board configuration of the n-queens' placement, where 'Q' and '.' both indicate a queen and an empty space respectively.
    The final list should be generated in such a way that the indices of the queens in each list should be in reverse lexicographical order.


    Problem Constraints
    1 <= A <= 10

    Input Format
    First argument is an integer n denoting the size of chessboard

    Output Format
    Return an array consisting of all distinct solutions in which each element is a 2d char array representing a unique solution.

    Example Input:
    Input 1:
    A = 4

    Input 2:
    A = 1

    Example Output:
    Output 1:
    [
     [".Q..",  // Solution 1
      "...Q",
      "Q...",
      "..Q."],

     ["..Q.",  // Solution 2
      "Q...",
      "...Q",
      ".Q.."]
    ]

    Output 2:
    [
     [Q]
    ]

    Example Explanation:
    Explanation 1:
    There exist only two distinct solutions to the 4-queens puzzle:

    Explanation 1:
    There exist only one distinct solutions to the 1-queens puzzle:
    */

    private static ArrayList<ArrayList<String>> solveNQueens(int A) {
        char[][] board = new char[A][A];
        for (int i = 0; i < A; ++i) {
            for (int j = 0; j < A; ++j) {
                board[i][j] = '.';
            }
        }
        ArrayList<ArrayList<String>> ans = new ArrayList<>();
        nQueens(board, 0, ans);
        return ans;
    }

    private static void nQueens(char[][] board, int i, ArrayList<ArrayList<String>> ans) {
        if (i == board.length) {
            ans.add(construct(board));
            return;
        }
        // At ith row, we need to place the queen
        for (int j = 0; j < board.length; ++j) {
            // Place the queen at (i,j) and check if it is possible
            if (check(board, i, j)) {
                board[i][j] = 'Q'; // place queen
                nQueens(board, i + 1, ans);
                board[i][j] = '.'; // Backtrack
            }
        }
    }

    private static ArrayList<String> construct(char[][] board) {
        ArrayList<String> ds = new ArrayList<>();
        for (int i = 0; i < board.length; ++i) {
            String s = new String(board[i]);
            ds.add(s);
        }
        return ds;
    }

    private static boolean check(char[][] board, int i, int j) {
        // check column
        int row;
        for (row = 0; row < i; ++row) {
            if (board[row][j] == 'Q')
                return false;
        }
        // check row
        int col;
        for (col = 0; col < j; ++col) {
            if (board[i][col] == 'Q')
                return false;
        }
        // Right diagonal
        row = i - 1;
        col = j + 1;
        while (row >= 0 && col < board.length) {
            if (board[row][col] == 'Q')
                return false;
            row--;
            col++;
        }
        // Left diagonal
        row = i - 1;
        col = j - 1;
        while (row >= 0 && col >= 0) {
            if (board[row][col] == 'Q')
                return false;
            row--;
            col--;
        }
        return true;
    }

    public static void main(String[] args) {
        int n = 4;
        ArrayList<ArrayList<String>> queen = solveNQueens(n);
        int i = 1;
        for (ArrayList<String> it : queen) {
            for (String s : it) {
                System.out.println(s);
            }
            System.out.println();
            i += 1;
        }
    }
}
