package Questions.Questions;

import java.util.*;

//https://leetcode.com/problems/minimum-cost-to-make-at-least-one-valid-path-in-a-grid/description/?
//1368. Minimum Cost to Make at Least One Valid Path in a Grid

class minCost {
    private static final int[][] dirs = {{0, 1}, {0, -1}, {1, 0}, {-1, 0}};

    public int minCost(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;

        Deque<int[]> deque = new LinkedList<>();
        deque.offer(new int[]{0, 0, 0});

        int[][] cost = new int[m][n];
        for (int[] row : cost) {
            Arrays.fill(row, Integer.MAX_VALUE);
        }
        cost[0][0] = 0;

        while (!deque.isEmpty()) {
            int[] current = deque.poll();
            int i = current[0];
            int j = current[1];
            int currentCost = current[2];

            if (i == m - 1 && j == n - 1) {
                return currentCost;
            }

            // Explore all four directions
            for (int d = 0; d < 4; d++) {
                int ni = i + dirs[d][0];
                int nj = j + dirs[d][1];

                if (ni >= 0 && ni < m && nj >= 0 && nj < n) {
                    int newCost = currentCost + (grid[i][j] == d + 1 ? 0 : 1);

                    if (newCost < cost[ni][nj]) {
                        cost[ni][nj] = newCost;
                        if (grid[i][j] == d + 1) {
                            // Add to the front of the deque if cost is 0
                            deque.offerFirst(new int[]{ni, nj, newCost});
                        } else {
                            // Add to the back of the deque if cost is 1
                            deque.offerLast(new int[]{ni, nj, newCost});
                        }
                    }
                }
            }
        }
        return -1; 
    }
}