package com.jsm.scaler.advance.BackTracking;

public class Sudoku {
    /*
    Write a program to solve a Sudoku puzzle by filling the empty cells. Empty cells are indicated by the character '.'
    You may assume that there will be only one unique solution.

    Problem Constraints
    N = 9

    Input Format
    First argument is an array of array of characters representing the Sudoku puzzle.

    Output Format
    Modify the given input to the required answer.

    Example Input
    Input 1:
    A = [[53..7....], [6..195...], [.98....6.], [8...6...3], [4..8.3..1], [7...2...6], [.6....28.], [...419..5], [....8..79]]

    Example Output
    Output 1:
    [[534678912], [672195348], [198342567], [859761423], [426853791], [713924856], [961537284], [287419635], [345286179]]

    Example Explanation:
    Explanation 1:
    Look at the diagrams given in the question.
    */

    private static void solveSudoku(char[][] A) {
        solve(A);
    }

    private static boolean solve(char[][] board) {
        for (int i = 0; i < board.length; ++i) {
            for (int j = 0; j < board[0].length; ++j) {
                if (board[i][j] == '.') {
                    for (char c = '1'; c <= '9'; ++c) {
                        if (valid(board, i, j, c)) {
                            board[i][j] = c;
                            if (solve(board))
                                return true;
                            else
                                board[i][j] = '.';
                        }
                    }
                    return false;
                }
            }
        }
        return true;
    }

    private static boolean valid(char[][] mat, int row, int col, char c) {
        for (int i = 0; i < 9; ++i) {
            if (mat[row][i] == c)
                return false;
            if (mat[i][col] == c)
                return false;
        }
        int x = row - row % 3;
        int y = col - col % 3;
        for (int i = x; i < x + 3; ++i) {
            for (int j = y; j < y + 3; ++j) {
                if (mat[i][j] == c)
                    return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        char[][] board = {
                {'9', '5', '7', '.', '1', '3', '.', '8', '4'},
                {'4', '8', '3', '.', '5', '7', '1', '.', '6'},
                {'.', '1', '2', '.', '4', '9', '5', '3', '7'},
                {'1', '7', '.', '3', '.', '4', '9', '.', '2'},
                {'5', '.', '4', '9', '7', '.', '3', '6', '.'},
                {'3', '.', '9', '5', '.', '8', '7', '.', '1'},
                {'8', '4', '5', '7', '9', '.', '6', '1', '3'},
                {'.', '9', '1', '.', '3', '6', '.', '7', '5'},
                {'7', '.', '6', '1', '8', '5', '4', '.', '9'}
        };
        solveSudoku(board);
        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++)
                System.out.print(board[i][j] + " ");
            System.out.println();
        }
    }
}
