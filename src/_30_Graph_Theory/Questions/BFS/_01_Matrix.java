package _30_Graph_Theory.Questions.BFS;

import java.util.*;

//https://leetcode.com/problems/01-matrix/description/
//542. 01 Matrix
//Distance of nearest cell having 1 in a binary matrix
//https://www.geeksforgeeks.org/problems/distance-of-nearest-cell-having-1-1587115620/1?itm_source=geeksforgeeks&itm_medium=article&itm_campaign=practice_card
class _01_Matrix {
    static class Node {
        int row;
        int col;
        int steps;

        Node(int row, int col, int steps) {
            this.row = row;
            this.col = col;
            this.steps = steps;
        }
    }

    public int[][] nearest(int[][] grid) {
        int n = grid.length;
        int m = grid[0].length;

        int[][] vis = new int[n][m];
        int[][] dist = new int[n][m];

        Queue<Node> q = new LinkedList<>();

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (grid[i][j] == 1) {
                    q.add(new Node(i, j, 0));
                    vis[i][j] = 1;
                }
            }
        }

        int[] delRow = {-1, 0, 1, 0};
        int[] delCol = {0, 1, 0, -1};

        while (!q.isEmpty()) {
            Node node = q.poll();
            int row = node.row;
            int col = node.col;
            int steps = node.steps;

            dist[row][col] = steps;

            for (int i = 0; i < 4; i++) {
                int newRow = row + delRow[i];
                int newCol = col + delCol[i];

                if (newRow >= 0 && newRow < n && newCol >= 0 && newCol < m && vis[newRow][newCol] == 0) {
                    vis[newRow][newCol] = 1;
                    q.add(new Node(newRow, newCol, steps + 1));
                }
            }
        }

        return dist;
    }

    public static void main(String[] args) {
        int[][] grid = {
            {0, 1, 1, 0},
            {1, 1, 0, 0},
            {0, 0, 1, 1}
        };

        _01_Matrix obj = new _01_Matrix();
        int[][] ans = obj.nearest(grid);

        for (int[] row : ans) {
            for (int val : row) {
                System.out.print(val + " ");
            }
            System.out.println();
        }
    }
}
