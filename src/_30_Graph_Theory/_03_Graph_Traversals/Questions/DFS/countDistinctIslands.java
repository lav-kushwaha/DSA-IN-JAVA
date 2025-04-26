package _30_Graph_Theory.Graph_Traversals.Questions.DFS;
import java.util.*;

//https://www.geeksforgeeks.org/problems/number-of-distinct-islands/
//Number of Distinct Islands
class countDistinctIslands {
    static class Pair {
        int row;
        int col;
        
        public Pair(int row, int col){
            this.row = row;
            this.col = col;
        }
    }
    
    int countDistinctIslands(int[][] grid) {
        // Your Code here
        int n = grid.length;
        int m = grid[0].length;
        int [][] vis = new int[n][m];
        HashSet<ArrayList<String>> unique = new HashSet<>();
        
        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                if(vis[i][j] == 0 && grid[i][j] == 1){
                  ArrayList < String > shape = new ArrayList < > ();
                  dfs(i,j,vis,grid,shape,i,j);
                  unique.add(shape);
                }
            }
        }
        return unique.size();
    }
    private void dfs(int row, int col, int[][] vis, int[][] grid, ArrayList < String > shape, int row0, int col0) {
         vis[row][col] = 1;
        
         // coordinates - base coordinates
        shape.add(toString(row - row0, col - col0));
        int n = grid.length;
        int m = grid[0].length;
        
         // delta row and delta column
        int delrow[] = {-1, 0, +1, 0}; 
        int delcol[] = {0, -1, 0, +1}; 
        
         // traverse all 4 neighbours
        for (int i = 0; i < 4; i++) {
          int nrow = row + delrow[i];
          int ncol = col + delcol[i];
          // check for valid unvisited land neighbour coordinates
          if (nrow >= 0 && nrow < n && ncol >= 0 && ncol < m && vis[nrow][ncol] == 0 && grid[nrow][ncol] == 1) {
            dfs(nrow, ncol, vis, grid, shape, row0, col0);
          }
        }
    }
    private String toString(int r, int c) {

        return Integer.toString(r) + " " + Integer.toString(c);
    }
    public static void main(String[] args) {
        int grid[][] = {
                {1, 1, 0, 1, 1},
                {1, 0, 0, 0, 0},
                {0, 0, 0, 0, 1},
                {1, 1, 0, 1, 1}};

        countDistinctIslands ob = new countDistinctIslands();
        int ans = ob.countDistinctIslands(grid);
        System.out.println(ans);
    }
}