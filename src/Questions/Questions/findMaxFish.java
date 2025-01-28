package Questions.Questions;

//https://leetcode.com/problems/maximum-number-of-fish-in-a-grid/description/
//2658. Maximum Number of Fish in a Grid
class findMaxFish {
    private int m, n;
    private final int[][] directions = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};

    private int dfs(int i, int j, int[][] grid) {
        if (i < 0 || i >= m || j < 0 || j >= n || grid[i][j] == 0) {
            return 0;
        }

        int fishCount = grid[i][j];
        grid[i][j] = 0;

        for (int[] dir : directions) {
            int i_ = i + dir[0];
            int j_ = j + dir[1];
            fishCount += dfs(i_, j_, grid);
        }

        return fishCount;
    }

    public int findMaxFish(int[][] grid) {
        m = grid.length;
        n = grid[0].length;

        int maxFish = 0;

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] > 0) { 
                    maxFish = Math.max(maxFish, dfs(i, j, grid));
                }
            }
        }

        return maxFish;
    }
}