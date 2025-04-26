package _30_Graph_Theory._03_Graph_Traversals.Questions.BFS;
import java.util.LinkedList;
import java.util.Queue;

//https://leetcode.com/problems/rotting-oranges/
//994. Rotting Oranges

class RottingOranges {
    public static int orangesRotting(int[][] grid) {
        // If grid is empty, no rotting is possible
        if (grid == null || grid.length == 0) return 0;

        int rows = grid.length;
        int cols = grid[0].length;
        Queue<int[]> queue = new LinkedList<>();
        int totalOranges = 0, minutes = 0, rottenOranges = 0;

        // Traverse the grid, adding rotten oranges to the queue and counting all oranges
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                if (grid[i][j] == 2) {
                    queue.offer(new int[]{i, j});
                }
                if (grid[i][j] != 0) {
                    totalOranges++;
                }
            }
        }

        // If there are no oranges, return 0
        if (totalOranges == 0) return 0;

        // Directions array for moving up, down, left, and right
        int[] dx = {0, 0, 1, -1};
        int[] dy = {1, -1, 0, 0};

        // BFS to spread the rot from rotten oranges to fresh oranges
        while (!queue.isEmpty()) {
            int size = queue.size();
            rottenOranges += size;

            for (int i = 0; i < size; i++) {
                int[] point = queue.poll();

                for (int j = 0; j < 4; j++) {
                    int x = point[0] + dx[j];
                    int y = point[1] + dy[j];

                    // Check bounds and if the neighboring orange is fresh
                    if (x < 0 || y < 0 || x >= rows || y >= cols || grid[x][y] != 1) {
                        continue;
                    }

                    // Mark the fresh orange as rotten and add it to the queue
                    grid[x][y] = 2;
                    queue.offer(new int[]{x, y});
                }
            }

            // Increment minutes if there are still oranges to rot
            if (!queue.isEmpty()) {
                minutes++;
            }
        }

        // If all oranges have rotted, return minutes, otherwise return -1
        return (totalOranges == rottenOranges) ? minutes : -1;
    }
}
