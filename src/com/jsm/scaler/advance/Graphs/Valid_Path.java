package com.jsm.scaler.advance.Graphs;

import java.util.LinkedList;
import java.util.Queue;

public class Valid_Path {
    /*
    There is a rectangle with left bottom as (0, 0) and right up as (x, y).
    There are N circles such that their centers are inside the rectangle.
    Radius of each circle is R. Now we need to find out if it is possible that we can move from (0, 0) to (x, y) without touching any circle.

    Note : We can move from any cell to any of its 8 adjacent neighbours, and we cannot move outside the boundary of the rectangle at any point of time.

    Problem Constraints
    0 <= x , y, R <= 100
    1 <= N <= 1000
    Center of each circle would lie within the grid

    Input Format
    1st argument given is an Integer x , denoted by A in input.
    2nd argument given is an Integer y, denoted by B in input.
    3rd argument given is an Integer N, number of circles, denoted by C in input.
    4th argument given is an Integer R, radius of each circle, denoted by D in input.
    5th argument given is an Array A of size N, denoted by E in input, where A[i] = x coordinate of ith circle
    6th argument given is an Array B of size N, denoted by F in input, where B[i] = y coordinate of ith circle

    Output Format
    Return YES or NO depending on weather it is possible to reach cell (x,y) or not starting from (0,0).

    Example Input:
    Input 1:
     x = 2
     y = 3
     N = 1
     R = 1
     A = [2]
     B = [3]

    Input 2:
     x = 1
     y = 1
     N = 1
     R = 1
     A = [1]
     B = [1]

    Example Output:
    Output 1:
     NO

    Output 2:
     NO

    Example Explanation:
    Explanation 1:
    There is NO valid path in this case

    Explanation 2:
     There is NO valid path in this case
    */

    /*
    1. Find all the points on the coordinate inside the rectangle which lie outside every circle
    2. We will make graph out of all those points which are found in step 1 by connecting the adjacent points with the edge
    3. Now we will check whether (0,0) or (x,y) lie in the same connected component of the graph or not.
       Also, we will check whether (0,0) or (x,y) any one of these coordinate lies inside any circle or not
    */
    private static String solve(int A, int B, int C, int D, int[] E, int[] F) {
        int[] x = {-1, 1, 0, 0, -1, 1, -1, 1};
        int[] y = {0, 0, 1, -1, -1, 1, 1, -1};
        int[][] valid = new int[A + 1][B + 1];

        for (int i = 0; i <= A; ++i) {
            for (int j = 0; j <= B; ++j) {
                for (int z = 0; z < C; ++z) {
                    if (Math.sqrt(Math.pow(E[z] - i, 2) + Math.pow(F[z] - j, 2)) <= D) {
                        valid[i][j] = -1;
                        break;
                    }
                }
            }
        }

        if (valid[0][0] == -1 || valid[A][B] == -1)
            return "NO";
        //System.out.println("starting ending no problem");
        boolean[][] vis = new boolean[A + 1][B + 1];
        vis[0][0] = true;
        Queue<Integer> q = new LinkedList<>();
        q.add(0);
        q.add(0);
        while (!q.isEmpty()) {
            int i = q.poll();
            int j = q.poll();
            for (int z = 0; z < 8; ++z) {
                int ix = i + x[z];
                int iy = j + y[z];
                //System.out.println(ix+" "+iy);
                if (!(ix < 0 || iy < 0 || ix >= A + 1 || iy >= B + 1) && !vis[ix][iy] && valid[ix][iy] != -1) {
                    //System.out.println(ix+"valid"+iy);
                    if (ix == A && iy == B) {
                        return "YES";
                    }
                    q.add(ix);
                    q.add(iy);
                    vis[ix][iy] = true;
                }
            }
        }
        return "NO";
    }

    public static void main(String[] args) {
        int A = 2;
        int B = 3;
        int C = 1;
        int D = 1;
        int[] E = {2};
        int[] F = {3};

        System.out.println(solve(A, B, C, D, E, F));
    }
}
