package com.jsm.scaler.beginner.Arrays;

import java.util.Scanner;

public class SquareRootUsingBinarySearch {

    public static int sqrt(int A) {
        if (A == 0)
            return 0;

        int start = 1;
        int end = A;
        int ans = 0;

        while (start <= end) {
            int mid = start + (end - start) / 2;
            if (mid <= A / mid) {
                ans = mid;
                start = mid + 1;
            } else {
                end = mid - 1;
            }
        }
        return ans;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();

        System.out.println(sqrt(n));
    }
}
