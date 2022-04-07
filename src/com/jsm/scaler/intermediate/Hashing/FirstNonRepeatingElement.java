package com.jsm.scaler.intermediate.Hashing;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;

public class FirstNonRepeatingElement {
    public static int solve(ArrayList<Integer> A) {
        HashMap<Integer, Integer> freqHashMap = new HashMap<>();
        for (int i = 0; i < A.size(); i++) {
            if (freqHashMap.containsKey(A.get(i))) {
                freqHashMap.put(A.get(i), freqHashMap.get(A.get(i)) + 1);
            } else {
                freqHashMap.put(A.get(i), 1);
            }
        }
        for (int i = 0; i < A.size(); i++) {
            if (freqHashMap.get(A.get(i)) == 1) {
                return A.get(i);
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        ArrayList<Integer> A = new ArrayList<>(Arrays.asList(8, 2, 8, 3, 1, 2, 6, 5));
        System.out.println(solve(A));
    }
}
