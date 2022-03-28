package com.jsm.scaler.intermediate.Strings;

public class CountOccurrences {
    /*
    Find number of occurrences of bob in the string A consisting of lowercase english alphabets.

    Problem Constraints
    1 <= |A| <= 1000

    Input Format
    The first and only argument contains the string A consisting of lowercase english alphabets.

    Output Format
    Return an integer containing the answer.

    Example Input

    Input 1:
      "abobc"

    Input 2:
      "bobob"

    Example Output

    Output 1:
      1

    Output 2:
      2

    Example Explanation

    Explanation 1:
      The only occurrence is at second position.

    Explanation 2:
      Bob occures at first and third position.
    */
    public static int countOccurrences(String A) {
        String bob = "bob";
        int fromIndex = 0;
        int count = 0;
        while ((fromIndex = A.indexOf(bob, fromIndex)) != -1) {
            count++;
            fromIndex++;
        }
        return count;
        /*
        int ans = 0;
        for(int i = 0; i+2 < A.length(); ++i){
            if(A.charAt(i) == 'b' && A.charAt(i+1) == 'o' && A.charAt(i+2) == 'b'){
                ++ans;
            }
        }
        return ans;
        */
    }

    public static void main(String[] args) {
        String A = "abobc";
        System.out.println(countOccurrences(A));
    }
}
