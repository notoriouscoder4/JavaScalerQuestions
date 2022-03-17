package com.jsm.scaler.intermediate.ModularArithmetic;

public class ConcatenateThreeNumbers {
    /*
    Given three 2-digit integers, A, B, and C, find out the minimum number obtained by concatenating them in any order.
    Return the minimum result obtained.

    Problem Constraints
    10 <= A, B, C <= 99

    Input Format
    The first argument of input contains an integer, A.
    The second argument of input contains an integer, B.
    The third argument of input contains an integer, C.

    Output Format
    Return an integer representing the answer.

    Example Input

    Input 1:
     A = 10
     B = 20
     C = 30

    Input 2:
     A = 55
     B = 43
     C = 47

    Example Output

    Output 1:
     102030

    Output 2:
     434755

    Example Explanation

    Explanation 1:
     10 + 20 + 30 = 102030

    Explanation 2:
     43 + 47 + 55 = 434755
    */

    public static int create(int A, int B, int C) {
        return A * 10000 + B * 100 + C;
    }

    public static int solve(int A, int B, int C) {
        int ans = Integer.MAX_VALUE;
        if (ans > create(A, B, C)) {
            ans = create(A, B, C);
        }

        if (ans > create(A, C, B)) {
            ans = create(A, C, B);
        }

        if (ans > create(B, C, A)) {
            ans = create(B, C, A);
        }

        if (ans > create(B, A, C)) {
            ans = create(B, A, C);
        }

        if (ans > create(C, A, B)) {
            ans = create(C, A, B);
        }

        if (ans > create(C, B, A)) {
            ans = create(C, B, A);
        }
        return ans;

        /*
        int a[] = {A, B, C};
        Arrays.sort(a);
        return 10000*a[0] + 100*a[1] + a[2];
        */
    }

    public static void main(String[] args) {
        System.out.println(solve(10, 20, 30));
    }
}
