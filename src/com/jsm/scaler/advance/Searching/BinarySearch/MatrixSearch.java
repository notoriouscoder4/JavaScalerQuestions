package com.jsm.scaler.advance.Searching.BinarySearch;

public class MatrixSearch {
    /*
    Given a matrix of integers A of size N x M and an integer B. Write an efficient algorithm that searches for integer B in matrix A.

    This matrix A has the following properties:
    Integers in each row are sorted from left to right.
    The first integer of each row is greater than or equal to the last integer of the previous row.
    Return 1 if B is present in A, else return 0.

    NOTE: Rows are numbered from top to bottom, and columns are from left to right.

    Problem Constraints
    1 <= N, M <= 1000
    1 <= A[i][j], B <= 10^6

    Input Format:
    The first argument given is the integer matrix A.
    The second argument given is the integer B.

    Output Format:
    Return 1 if B is present in A else, return 0.

    Example Input:
    Input 1:
    A = [
          [1,   3,  5,  7]
          [10, 11, 16, 20]
          [23, 30, 34, 50]
        ]
    B = 3

    Input 2:
    A = [
          [5, 17, 100, 111]
          [119, 120, 127, 131]
        ]
    B = 3

    Example Output:
    Output 1:
    1

    Output 2:
    0

    Example Explanation:
    Explanation 1:
     3 is present in the matrix at A[0][1] position so return 1.

    Explanation 2:
     3 is not present in the matrix so return 0.
    */

    private static int searchMatrix(int[][] A, int B) {
        // TC: O(log(nm))
        int n = A.length; // rows
        int m = A[0].length; // columns
        int low = 0;
        int high = (n * m) - 1;
        while (low <= high) {
            int mid = (low + high) / 2;
            int i = mid / m;
            int j = mid % m;
            if (A[i][j] == B)
                return 1;
            else if (A[i][j] > B)
                high = mid - 1;
            else
                low = mid + 1;
        }
        return 0;

        /* TC: O(log(n + m))
         int i=0;
        int j=A[0].length-1;
        while(i <= A.length-1 && j >=0){
            if(A[i][j] == B){
                return 1;
            }else if(A[i][j] > B){
                j--;
            }else{
                i++;
            }
        }
        return 0;
        */
    }

    public static void main(String[] args) {
        int[][] A = {
                {1, 3, 5, 7},
                {10, 11, 16, 20},
                {23, 30, 34, 50}
        };
        int B = 3;
        System.out.println(searchMatrix(A, B));
    }
}
