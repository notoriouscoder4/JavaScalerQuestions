package com.jsm.scaler.advance.Graphs;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class Shortest_Distance_Maze {
    /*
    Given a matrix of integers A of size N x M describing a maze. The maze consists of empty locations and walls.
    1 represents a wall in a matrix and 0 represents an empty location in a wall.

    There is a ball trapped in a maze. The ball can go through empty spaces by rolling up, down, left or right,
    but it won't stop rolling until hitting a wall (maze boundary is also considered as a wall).
    When the ball stops, it could choose the next direction.
    Given two array of integers of size B and C of size 2 denoting the starting and destination position of the ball.

    Find the shortest distance for the ball to stop at the destination.
    The distance is defined by the number of empty spaces traveled by the ball from the starting position (excluded) to the destination (included).
    If the ball cannot stop at the destination, return -1.

    Problem Constraints
    2 <= N, M <= 100
    0 <= A[i] <= 1
    0 <= B[i][0], C[i][0] < N
    0 <= B[i][1], C[i][1] < M

    Input Format
    The first argument given is the integer matrix A.
    The second argument given is an array of integer B.
    The third argument if an array of integer C.

    Output Format
    Return a single integer, the minimum distance required to reach destination

    Example Input:
    Input 1:
    A = [ [0, 0], [0, 0] ]
    B = [0, 0]
    C = [0, 1]

    Input 2:
    A = [ [0, 0], [0, 1] ]
    B = [0, 0]
    C = [0, 1]

    Example Output:
    Output 1:
     1

    Output 2:
     1

    Example Explanation:
    Explanation 1:
     Go directly from start to destination in distance 1.

    Explanation 2:
     Go directly from start to destination in distance 1.
    */

    private static class Triplet {
        int i;
        int j;
        int dir;

        public Triplet(int i, int j, int dir) {
            this.i = i;
            this.j = j;
            this.dir = dir;
        }
    }

    private static boolean canBeVisited(int[][][] distance, int i, int j, int n, int m, int dir) {
        return i >= 0 && i < n && j >= 0 && j < m && distance[i][j][dir] == Integer.MAX_VALUE;
    }

    private static boolean isObstacle(int[][] A, int i, int j, int n, int m) {
        return i < 0 || i >= n || j < 0 || j >= m || A[i][j] == 1;
    }

    private static int shortestDistance(int[][] A, int src1, int src2, int dest1, int dest2) {
        Queue<Triplet> queue = new LinkedList<>();
        int[][][] distance = new int[A.length][A[0].length][4];

        for (int i = 0; i < A.length; ++i) {
            for (int j = 0; j < A[0].length; ++j) {
                Arrays.fill(distance[i][j], Integer.MAX_VALUE);
            }
        }

        int[] dx = {1, -1, 0, 0};
        int[] dy = {0, 0, 1, -1};
        //adding all four directions for the source point
        for (int i = 0; i < 4; ++i) {
            queue.add(new Triplet(src1, src2, i));
            distance[src1][src2][i] = 0;
        }

        while (!queue.isEmpty()) {
            Triplet front = queue.poll();
            int i = front.i;
            int j = front.j;
            int dir = front.dir;

            int nI = i + dx[dir];
            int nJ = j + dy[dir];
            if (isObstacle(A, nI, nJ, A.length, A[0].length)) {
                //We can call in other directions
                if (i == dest1 && j == dest2) {
                    return distance[i][j][dir];
                }
                for (int k = 0; k < 4; ++k) {
                    if (k == dir) continue;
                    int x = i + dx[k];
                    int y = j + dy[k];
                    if (!isObstacle(A, x, y, A.length, A[0].length) && canBeVisited(distance, x, y, A.length, A[0].length, k)) {
                        queue.add(new Triplet(x, y, k));
                        distance[x][y][k] = distance[i][j][dir] + 1;
                    }
                }
            } else {
                if (canBeVisited(distance, nI, nJ, A.length, A[0].length, dir)) {
                    queue.add(new Triplet(nI, nJ, dir));
                    distance[nI][nJ][dir] = distance[i][j][dir] + 1;
                }
            }
        }
        return -1;
    }

    private static int solve(int[][] A, int[] B, int[] C) {
        return shortestDistance(A, B[0], B[1], C[0], C[1]);
    }

    public static void main(String[] args) {
        int[][] A = {{0, 0}, {0, 0}};
        int[] B = {0, 0};
        int[] C = {0, 1};

        System.out.println("The minimum distance required to reach destination: " + solve(A, B, C));
    }
}
