package _30_Graph_Theory._05_ShortestPath_Algorithm.Questions;
import java.util.*;

//https://takeuforward.org/data-structure/g-36-shortest-distance-in-a-binary-maze/
//Shortest Distance in a Binary Maze
class ShortestDistanceInBinaryMaze {
    
    class Tuple {
        int first, second, third;
        Tuple(int _first, int _second, int _third) {
            this.first = _first;
            this.second = _second;
            this.third = _third;
        }
    }

    int shortestPath(int[][] grid, int[] source, int[] destination) {

        // Edge Case: if the source is only the destination.
        if(source[0] == destination[0] && 
           source[1] == destination[1]) return 0; 

        Queue<Tuple> q = new LinkedList<>();  
        int n = grid.length; 
        int m = grid[0].length;

        // Create a distance matrix with initially all the cells marked as
        // unvisited and the source cell as 0. 
        int[][] dist = new int[n][m]; 
        for(int i = 0; i < n; i++) {
            for(int j = 0; j < m; j++) {
                dist[i][j] = (int)(1e9); 
            }
        }

        dist[source[0]][source[1]] = 0; 
        q.add(new Tuple(0, source[0], source[1])); 


        int dr[] = {-1, 0, 1, 0}; 
        int dc[] = {0, 1, 0, -1}; 
 
        while(!q.isEmpty()) {
            Tuple it = q.peek(); 
            q.remove(); 
            int dis = it.first; 
            int r = it.second; 
            int c = it.third; 
            
            for(int i = 0; i < 4; i++) {
                int newr = r + dr[i]; 
                int newc = c + dc[i]; 
                
                if(newr >= 0 && newr < n && newc >= 0 && newc < m 
                && grid[newr][newc] == 1 && dis + 1 < dist[newr][newc]) {
                    dist[newr][newc] = 1 + dis; 

                    if(newr == destination[0] && 
                       newc == destination[1]) return dis + 1; 
                    q.add(new Tuple(1 + dis, newr, newc)); 
                }
            }
        }
        return -1; 
    }

    public static void main(String[] args) {
        int[] source = {0, 1};
        int[] destination = {2, 2};

        int[][] grid = {
                {1, 1, 1, 1},
                {1, 1, 0, 1},
                {1, 1, 1, 1},
                {1, 1, 0, 0},
                {1, 0, 0, 1}
        };

        ShortestDistanceInBinaryMaze obj = new ShortestDistanceInBinaryMaze();
        int res = obj.shortestPath(grid, source, destination);

        System.out.println(res);
    }
}
