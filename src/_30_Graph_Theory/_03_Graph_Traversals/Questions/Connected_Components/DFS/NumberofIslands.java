package _30_Graph_Theory.Graph_Traversals.Questions.Connected_Components.DFS;

// https://leetcode.com/problems/number-of-islands/
// 200. Number of Islands

class NumberofIslands {
    public int numIslands(char[][] grid) {
        int count = 0;

        // Traverse the entire grid
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[i].length; j++) {
                // If we find a land cell ('1'), it's part of an unvisited island
                if (grid[i][j] == '1') {
                    // Use DFS to mark all connected land cells as visited
                    dfs(grid, i, j);
                    count++; // Increment island count after finishing DFS for one island
                }
            }
        }
        return count;
    }

    // Depth-First Search to mark all connected land cells as visited
    public void dfs(char[][] grid, int i, int j) {
        // Boundary check: if out of bounds or cell is water ('0'), stop recursion
        if (i < 0 || j < 0 || i >= grid.length || j >= grid[0].length || grid[i][j] == '0') return;

        // Mark the current cell as visited by setting it to '0'
        grid[i][j] = '0';

        // Recursive DFS calls in all four directions to visit all connected land cells
        dfs(grid, i + 1, j); // Move down
        dfs(grid, i - 1, j); // Move up
        dfs(grid, i, j + 1); // Move right
        dfs(grid, i, j - 1); // Move left
    }

    public static void main(String[] args) {
        // Sample grid where '1' represents land and '0' represents water
        char[][] grid = {
                {'1', '1', '0', '0', '0'},
                {'1', '1', '0', '0', '1'},
                {'0', '0', '0', '1', '1'},
                {'0', '0', '0', '0', '0'},
                {'1', '0', '1', '0', '1'}
        };

        NumberofIslands solution = new NumberofIslands();

        int numberOfIslands = solution.numIslands(grid);

        // Output the result
        System.out.println("Number of islands: " + numberOfIslands);  // Expected output: 5
    }
}


/**
 *
 * Overall Complexity
 * Since every cell is processed at most once (either by the main loop or by dfs), the entire algorithm runs in O(N * M) time.

 * Space Complexity
 * The space complexity is O(N * M) in the worst case due to the recursive stack used by dfs.
 * If the grid consists of one large island, the recursion depth could go up to N * M.

 */

