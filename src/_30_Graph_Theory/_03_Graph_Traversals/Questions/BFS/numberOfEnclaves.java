package _30_Graph_Theory.Graph_Traversals.Questions.BFS;

import java.util.*;

//https://www.geeksforgeeks.org/problems/number-of-enclaves/
//Number Of Enclaves
class numberOfEnclaves {
    static class Pair {
        int first;
        int second;

        public Pair(int row, int col) {
            this.first = row;
            this.second = col;
        }
    }

    public static int numberOfEnclaves(int[][] grid) {
        Queue<Pair> queue = new LinkedList<>();
        int n = grid.length;
        int m = grid[0].length;

        int[][] vis = new int[n][m];

        // Adding boundary land cells to the queue
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (i == 0 || j == 0 || i == n - 1 || j == m - 1) {
                    if (grid[i][j] == 1) {
                        queue.add(new Pair(i, j));
                        vis[i][j] = 1;
                    }
                }
            }
        }

        int[] delRow = {-1, 0, 1, 0};
        int[] delCol = {0, -1, 0, 1};

        // BFS traversal to mark reachable land cells from boundaries
        while (!queue.isEmpty()) {
            Pair p = queue.poll();
            int row = p.first;
            int col = p.second;

            // Traverse all 4 directions
            for (int i = 0; i < 4; i++) {
                int nrow = row + delRow[i];
                int ncol = col + delCol[i];

                // Check if the new position is within bounds and is an unvisited land cell
                if (nrow >= 0 && nrow < n && ncol >= 0 && ncol < m && vis[nrow][ncol] == 0 && grid[nrow][ncol] == 1) {
                    queue.add(new Pair(nrow, ncol));
                    vis[nrow][ncol] = 1;
                }
            }
        }

        int count = 0;
        // Counting enclave cells
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (grid[i][j] == 1 && vis[i][j] == 0) count++;
            }
        }

        return count;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Taking input for grid dimensions
        System.out.println("Enter number of rows:");
        int n = scanner.nextInt();
        System.out.println("Enter number of columns:");
        int m = scanner.nextInt();

        int[][] grid = new int[n][m];

        // Taking input for the grid
        System.out.println("Enter grid values (0 for water, 1 for land):");
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                grid[i][j] = scanner.nextInt();
            }
        }

        // Calling the function and printing result
        int result = numberOfEnclaves(grid);
        System.out.println("Number of enclaves: " + result);
    }
}
