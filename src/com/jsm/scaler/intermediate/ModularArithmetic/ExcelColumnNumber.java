package com.jsm.scaler.intermediate.ModularArithmetic;

public class ExcelColumnNumber {
    /*
    Given a column title as appears in an Excel sheet, return its corresponding column number.

    Problem Constraints
    1 <= length of the column title <= 5

    Input Format
    The only argument is a string that represents the column title in the excel sheet.

    Output Format
    Return a single integer that represents the corresponding column number.

    Example Input

    Input 1:
     AB

    Input 2:
     ABCD

    Example Output

    Output 1:
     28

    Output 2:
     19010

    Example Explanation

    Explanation 1:
     A -> 1
     B -> 2
     C -> 3
     ...
     Z -> 26
     AA -> 27
     AB -> 28
     */

    public static int titleToNumber(String A) {
        int ans = 0;
        int mul = 1; // since A-Z = [1, 26], so this no. system would be of power of 26, and 26^0 = 1
        for (int i = A.length() - 1; i >= 0; i--) {
            ans += mul * (A.charAt(i) - 'A' + 1);
            mul *= 26;
        }
        return ans;
    }

    public static void main(String[] args) {
        System.out.println(titleToNumber("ABCD"));
    }
}
