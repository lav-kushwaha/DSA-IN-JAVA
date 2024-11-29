package Questions.Questions;

import java.util.PriorityQueue;
//https://leetcode.com/problems/minimum-time-to-visit-a-cell-in-a-grid/description/
//2577. Minimum Time to Visit a Cell In a Grid
class minimumTime {
    private static final int[][] directions = { {1, 0}, {-1, 0}, {0, 1}, {0, -1} };

    public int minimumTime(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;

        if (grid[0][1] > 1 && grid[1][0] > 1) {
            return -1;
        }

        boolean[][] visited = new boolean[m][n];
        int[][] result = new int[m][n];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                result[i][j] = Integer.MAX_VALUE;
            }
        }

        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> Integer.compare(a[0], b[0]));
        pq.offer(new int[] { grid[0][0], 0, 0 });
        result[0][0] = 0;

        while (!pq.isEmpty()) {
            int[] curr = pq.poll();
            int time = curr[0], row = curr[1], col = curr[2];

            if (row == m - 1 && col == n - 1) {
                return result[m - 1][n - 1];
            }

            if (visited[row][col]) continue;
            visited[row][col] = true;

            for (int[] dir : directions) {
                int r = row + dir[0];
                int c = col + dir[1];

                if (r < 0 || r >= m || c < 0 || c >= n || visited[r][c]) {
                    continue;
                }

                int nextTime;
                if (grid[r][c] <= time + 1) {
                    nextTime = time + 1;
                } else if ((grid[r][c] - time) % 2 == 0) {
                    nextTime = grid[r][c] + 1;
                } else {
                    nextTime = grid[r][c];
                }

                if (nextTime < result[r][c]) {
                    result[r][c] = nextTime;
                    pq.offer(new int[] { nextTime, r, c });
                }
            }
        }

        return -1;
    }
}