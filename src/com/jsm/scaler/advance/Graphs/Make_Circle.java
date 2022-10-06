package com.jsm.scaler.advance.Graphs;

import java.util.ArrayList;
import java.util.Arrays;

public class Make_Circle {
    /*
    Given an array of strings A of size N, find if the given strings can be chained to form a circle.
    A string X can be put before another string Y in circle if the last character of X is same as first character of Y.

    NOTE: All strings consist of lower case characters.

    Problem Constraints
    1 <= N <= 10^5
    Sum of length of all strings <= 10^6

    Input Format
    First and only argument is a string array A of size N.

    Output Format
    Return an integer 1 if it is possible to chain the strings to form a circle else return 0.

    Example Input:
    Input 1:
     A = ["aab", "bac", "aaa", "cda"]

    Input 2:
     A = ["abc", "cbc"]

    Example Output:
    Output 1:
     1

    Output 2:
     0

    Example Explanation:
    Explanation 1:
     We can chain the strings aab -> bac -> cda -> aaa -> aab. So this forms a circle. So, output will be 1.

    Explanation 2:
     There is no way to chain the given strings such that they form a circle.
    */

    private static void dfs(int start, ArrayList<ArrayList<Integer>> adjList, boolean[] visited) {
        visited[start] = true;
        for (Integer it : adjList.get(start)) {
            if (!visited[it]) {
                dfs(it, adjList, visited);
            }
        }
    }

    private static int isStronglyConnected(int s, ArrayList<ArrayList<Integer>> adjList, boolean[] mark) {
        boolean[] visited = new boolean[26];
        Arrays.fill(visited, false);
        dfs(s, adjList, visited);

        for (int i = 0; i < 26; ++i) {
            //Edge case to check if vertex was visited in mark while keeping track of inDegree and outDegree and visited while running dfs,
            // if both are not marked true then they are not StronglyConnected
            if (!visited[i] && mark[i])
                return 0;
        }
        return 1;
    }

    /* KosaRaju Algo| DFS | TC: O(N+E) | SC: O(N) */
    private static int solve(String[] A) {
        boolean[] mark = new boolean[26];
        Arrays.fill(mark, false);

        ArrayList<ArrayList<Integer>> adjList = new ArrayList<>();
        for (int i = 0; i < 26; ++i) {
            ArrayList<Integer> list = new ArrayList<>();
            adjList.add(list);
        }

        int[] inDegree = new int[26];
        int[] outDegree = new int[26];

        //Maintaining adjacency list and inDegree,outDegree array to keep track
        for (String s : A) {
            int U = s.charAt(0) - 'a';
            int V = s.charAt(s.length() - 1) - 'a';
            mark[U] = mark[V] = true;
            inDegree[V]++;
            outDegree[U]++;
            adjList.get(U).add(V);
        }

        //Checking if incoming and outgoing edges at each vertex is same, if It's not then graph does not Eulerian circuit
        for (int i = 0; i < 26; ++i) {
            if (inDegree[i] != outDegree[i])
                return 0;
        }

        //Starting from first letter of first string
        return isStronglyConnected(A[0].charAt(0) - 'a', adjList, mark);
    }

    public static void main(String[] args) {
        String[] A = {"aab", "bac", "aaa", "cda"};
        System.out.println("Is it possible to chain the strings to form a circle: " + solve(A));
    }
}
