package Questions.Questions;

//Approach (Simple Simulation)
//T.C : O(m*n + G*(m+n)), where G =  size of guards
//S.C : O(m*n), considering the size of grid we took
//https://leetcode.com/problems/count-unguarded-cells-in-the-grid/description/
//2257. Count Unguarded Cells in the Grid
class markGuarded {
    public void markGuarded(int row, int col, int[][] grid) {
        // Up
        for (int i = row - 1; i >= 0; i--) {
            if (grid[i][col] == 2 || grid[i][col] == 3) {
                break;
            }
            grid[i][col] = 1; // Marking as guarded
        }

        // Down
        for (int i = row + 1; i < grid.length; i++) {
            if (grid[i][col] == 2 || grid[i][col] == 3) {
                break;
            }
            grid[i][col] = 1; // Marking as guarded
        }

        // Left
        for (int j = col - 1; j >= 0; j--) {
            if (grid[row][j] == 2 || grid[row][j] == 3) {
                break;
            }
            grid[row][j] = 1; // Marking as guarded
        }

        // Right
        for (int j = col + 1; j < grid[0].length; j++) {
            if (grid[row][j] == 2 || grid[row][j] == 3) {
                break;
            }
            grid[row][j] = 1; // Marking as guarded
        }
    }

    public int countUnguarded(int m, int n, int[][] guards, int[][] walls) {
        int[][] grid = new int[m][n];

        // Mark guard positions
        for (int[] guard : guards) {
            int i = guard[0];
            int j = guard[1];
            grid[i][j] = 2; // Guard
        }

        // Mark wall positions
        for (int[] wall : walls) {
            int i = wall[0];
            int j = wall[1];
            grid[i][j] = 3; // Wall
        }

        // Mark cells guarded by each guard
        for (int[] guard : guards) {
            int i = guard[0];
            int j = guard[1];
            markGuarded(i, j, grid);
        }

        // Count unguarded cells
        int count = 0;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == 0) { // Unguarded
                    count++;
                }
            }
        }

        return count;
    }
}