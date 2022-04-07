package com.jsm.scaler.intermediate.Hashing;

import java.util.List;

public class ValidSudoku {
    /*
    Determine if a Sudoku is valid, according to: http://sudoku.com.au/TheRules.aspx
    The Sudoku board could be partially filled, where empty cells are filled with the character '.'.
    The input corresponding to the above configuration :

    ["53..7....", "6..195...", ".98....6.", "8...6...3", "4..8.3..1", "7...2...6", ".6....28.", "...419..5", "....8..79"]
    A partially filled sudoku which is valid.

    Note:

    A valid Sudoku board (partially filled) is not necessarily solvable. Only the filled cells need to be validated.
    Return 0 / 1 ( 0 for false, 1 for true ) for this problem
    */

    public static int isValidSudoku(final List<String> A) {
        for (String s : A) {
            if (!isValid(s))
                return 0;
        }

        for (int i = 0; i < 9; i++) {
            int[] count = new int[9];
            for (String s : A) {
                char c = s.charAt(i);
                if (Character.isDigit(c)) {
                    count[Character.getNumericValue(c) - 1]++;
                    if (count[Character.getNumericValue(c) - 1] > 1)
                        return 0;
                }
            }
        }

        for (int i = 0; i < 9; i += 3) {
            StringBuilder[] sb = new StringBuilder[3];
            for (int k = 0; k < 3; k++) {
                sb[k] = new StringBuilder("");
            }

            for (int j = 0; j < 3; j++) {
                String str = A.get(i + j);
                sb[0].append(str.substring(0, 3));
                sb[1].append(str.substring(3, 6));
                sb[2].append(str.substring(6, 9));
            }

            for (int k = 0; k < 3; k++) {
                if (!isValid(sb[k].toString()))
                    return 0;
            }
        }
        return 1;
    }

    public static boolean isValid(String s) {
        int[] count = new int[9];
        for (char c : s.toCharArray()) {
            if (Character.isDigit(c)) {
                count[Character.getNumericValue(c) - 1]++;
                if (count[Character.getNumericValue(c) - 1] > 1)
                    return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {

    }
}
