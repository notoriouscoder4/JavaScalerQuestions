package com.jsm.scaler.advance.BitManipulations;

public class SmallestXOR {
    /*
    Given two integers A and B, find a number X such that A xor X is minimum possible, and the number of set bits in X equals B.

    Problem Constraints
    0 <= A <= 109
    0 <= B <= 30

    Input Format
    First argument contains a single integer A. Second argument contains a single integer B.

    Output Format
    Return a single integer X.

    Example Input:
    Input 1:
     A = 3
     B = 3

    Input 2:
     A = 15
     B = 2

    Example Output:
    Output 1:
     7

    Output 2:
     12

    Example Explanation:
    Explanation 1:
     3 xor 7 = 4 which is minimum

    Explanation 2:
     15 xor 12 = 3 which is minimum
    */

    private static int smallestXOR(int A, int B) {
        int X = A, a = A;
        int setBitsA = 0;
        //count the set bits of A
        while (a > 0) {
            if ((a & 1) == 1)
                setBitsA++;
            a = a >> 1;
        }
        // if setBits of A greater than B
        if (B < setBitsA) {
            int i = 0;
            while (B != setBitsA) {
                if (((A >> i) & 1) == 1) {
                    X = X - (1 << i);
                    setBitsA--;
                }
                i++;
            }
            return X;
        }
        // if setBits of A less than B
        else if (B > setBitsA) {
            int i = 0;
            while (B != setBitsA) {
                if ((A & (1 << i)) == 0) {
                    X = X + (1 << i);
                    setBitsA++;
                }
                i++;
            }
            return X;
        } else return X;

        /* Another Solution
        int X = 0;
        First set left most B bits to 1,
        so to get min XOR of A n X

        for(int i = 30; i >=0; i--){
            if(B == 0) return X;
            if((A&(1<<i)) > 0){
                X |= (1<<i);
                B--;
            }
        }
        If B > 0 then set bits from right
        to 1 so to get min XOR

        for(int i = 0; i <= 30; i++){
            if(B == 0) return X;
            if((X&(1<<i)) == 0){
                X |= (1<<i);
                B--;
            }
        }
        return X;
        */
    }

    public static void main(String[] args) {
        int A = 15;
        int B = 2;
        System.out.println(smallestXOR(A, B));
    }
}
