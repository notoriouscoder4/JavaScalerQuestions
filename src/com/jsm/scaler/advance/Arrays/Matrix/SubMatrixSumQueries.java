package com.jsm.scaler.advance.Arrays.Matrix;

public class SubMatrixSumQueries {
    /*
    Given a matrix of integers A of size N x M and multiple queries Q, for each query, find and return the submatrix sum.
    Inputs to queries are top left (b, c) and bottom right (d, e) indexes of submatrix whose sum is to find out.

    NOTE:
    Rows are numbered from top to bottom, and columns are numbered from left to right.
    Sum may be large, so return the answer mod 10^9 + 7.

    Problem Constraints
    1 <= N, M <= 1000
    -100000 <= A[i] <= 100000
    1 <= Q <= 100000
    1 <= B[i] <= D[i] <= N
    1 <= C[i] <= E[i] <= M

    Input Format
    The first argument given is the integer matrix A.
    The second argument given is the integer array B.
    The third argument given is the integer array C.
    The fourth argument given is the integer array D.
    The fifth argument given is the integer array E.
    (B[i], C[i]) represents the top left corner of the i'th query.
    (D[i], E[i]) represents the bottom right corner of the i'th query.

    Output Format
    Return an integer array containing the submatrix sum for each query.

    Example Input
    Input 1:
     A = [   [1, 2, 3]
             [4, 5, 6]
             [7, 8, 9]   ]
     B = [1, 2]
     C = [1, 2]
     D = [2, 3]
     E = [2, 3]

    Input 2:
     A = [   [5, 17, 100, 11]
             [0, 0,  2,   8]    ]
     B = [1, 1]
     C = [1, 4]
     D = [2, 2]
     E = [2, 4]

    Example Output
    Output 1:
     [12, 28]

    Output 2:
     [22, 19]


    Example Explanation:
    Explanation 1:
     For query 1: Submatrix contains elements: 1, 2, 4 and 5. So, their sum is 12.
     For query 2: Submatrix contains elements: 5, 6, 8 and 9. So, their sum is 28.

    Explanation 2:
     For query 1: Submatrix contains elements: 5, 17, 0 and 0. So, their sum is 22.
     For query 2: Submatrix contains elements: 11 and 8. So, their sum is 19.
    */

    private static int[] solve(int[][] A, int[] B, int[] C, int[] D, int[] E) {
        prefixSumMatrix(A);
        int[] result = new int[B.length];
        for (int i = 0; i < B.length; i++) {
            int a1 = B[i] - 1;
            int b1 = C[i] - 1;

            int a2 = D[i] - 1;
            int b2 = E[i] - 1;

            int sum = A[a2][b2];

            if (b1 > 0)
                sum -= A[a2][b1 - 1];
            if (a1 > 0)
                sum -= A[a1 - 1][b2];
            if (a1 > 0 && b1 > 0)
                sum += A[a1 - 1][b1 - 1];
            result[i] = getMod(sum);
        }
        return result;

        /* Scaler Solution
        int n = A.length, m = A[0].length, mod = 1000000007;
        int sum = 0;
        long preSum[][] = new long[n+1][m+1];
        //preSum[i][j] denotes the sum of elements of matrix (0, 0) to (i, j)
        for(int i = 1; i <= n ; i++){
            for(int j = 1; j <= m; j++){
                preSum[i][j] = (A[i-1][j-1] + preSum[i-1][j] + preSum[i][j-1] - preSum[i-1][j-1] + mod) % mod;
            }
        }
        int res[] = new int[B.length];
        for(int i = 0; i < B.length; i++){
            int x1 = B[i], y1 = C[i], x2 = D[i], y2 = E[i];
            long ans = preSum[x2][y2] - preSum[x2][y1-1] - preSum[x1-1][y2] + preSum[x1-1][y1-1];
            while(ans < 0)
                ans += mod;
            ans = ans % mod;
            res[i] = (int)ans;
        }
        return res;
        */
    }

    private static void prefixSumMatrix(int[][] A) {
        // row wise prefix sum
        for (int row = 0; row < A.length; row++) {
            int sum = A[row][0];
            for (int col = 1; col < A[row].length; col++) {
                sum = getMod(sum + A[row][col]);
                A[row][col] = sum;
            }
        }

        // column wise prefix sum
        for (int col = 0; col < A[0].length; col++) {
            int sum = A[0][col];
            for (int row = 1; row < A.length; row++) {
                sum = getMod(sum + A[row][col]);
                A[row][col] = sum;
            }
        }
    }

    private static int getMod(int num) {
            int mod = 1000000007;
        int res = num % mod;
        if (res < 0)
            return (res + mod) % mod;
        return res;
    }
}
