package com.jsm.scaler.beginner.Arrays;

import java.util.ArrayList;

public class LittlePonyWithArrayList {

    public static ArrayList<Integer> solve(ArrayList<Integer> A, ArrayList<Integer> B) {
        ArrayList<Integer> C = new ArrayList<>();

        for (int i = 1; i < A.size(); i++) {
            A.set(i, A.get(i - 1) + A.get(i));
        }

        for (int i = 0; i < B.size(); i++) {
            int ans = 0;
            int s = 0, e = A.size() - 1;

            while (s <= e) {
                int mid = (s + e) / 2;
                if (B.get(i) >= A.get(mid)) {
                    ans = mid + 1;
                    s = mid + 1;
                } else {
                    e = mid - 1;
                }
            }
            C.add(ans);
        }
        return C;
    }

    public static void main(String[] args) {

    }

}
