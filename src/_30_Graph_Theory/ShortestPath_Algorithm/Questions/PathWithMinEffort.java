package _30_Graph_Theory.ShortestPath_Algorithm.Questions;
import java.util.*;

//https://leetcode.com/problems/path-with-minimum-effort/
//1631. Path With Minimum Effort
class PathWithMinEffort {
    class Tuple{
        int distance;
        int row;
        int col;
        public Tuple(int distance,int row, int col){
            this.row = row;
            this.distance = distance;
            this.col = col;
        }
    }
    public int MinimumEffort(int[][] heights) {
        int n = heights.length;
        int m = heights[0].length;
        int[][] dist = new int[n][m];
        int[][][] parent = new int[n][m][2]; // Store parent coordinates
        
        for (int i = 0; i < n; i++) {
            Arrays.fill(dist[i], Integer.MAX_VALUE);
        }

        PriorityQueue<Tuple> pq = new PriorityQueue<>((a, b) -> a.distance - b.distance);
        pq.add(new Tuple(0, 0, 0));
        dist[0][0] = 0;
        parent[0][0] = new int[]{-1, -1};
        
        int[] dr = {-1, 0, 1, 0};
        int[] dc = {0, 1, 0, -1};
        
        while (!pq.isEmpty()) {
            Tuple curr = pq.poll();
            int diff = curr.distance, row = curr.row, col = curr.col;
            
            if (row == n - 1 && col == m - 1) {
                printPath(parent, row, col);
                return diff;
            }
            
            for (int i = 0; i < 4; i++) {
                int newr = row + dr[i];
                int newc = col + dc[i];
                
                if (newr >= 0 && newc >= 0 && newr < n && newc < m) {
                    int newEffort = Math.max(Math.abs(heights[row][col] - heights[newr][newc]), diff);
                    
                    if (newEffort < dist[newr][newc]) {
                        dist[newr][newc] = newEffort;
                        pq.add(new Tuple(newEffort, newr, newc));
                        parent[newr][newc] = new int[]{row, col}; // Store parent
                    }
                }
            }
        }
        return 0;
    }
    
    private void printPath(int[][][] parent, int row, int col) {
        List<int[]> path = new ArrayList<>();
        while (row != -1 && col != -1) {
            path.add(new int[]{row, col});
            int[] prev = parent[row][col];
            row = prev[0];
            col = prev[1];
        }
        Collections.reverse(path);
        System.out.print("Path: ");
        for (int[] p : path) {
            System.out.print("(" + p[0] + ", " + p[1] + ") -> ");
        }
        System.out.println("END");
    }
    public static void main(String[] args) {
        int[][] heights = {{1, 2, 2}, {3, 8, 2}, {5, 3, 5}};
        PathWithMinEffort obj = new PathWithMinEffort();
        int ans = obj.MinimumEffort(heights);
        System.out.println("Minimum Effort: " + ans);
    }
}

