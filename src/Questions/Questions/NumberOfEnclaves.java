package Questions.Questions;

import java.util.LinkedList;
import java.util.Queue;

//https://www.geeksforgeeks.org/problems/number-of-enclaves/0
class NumberOfEnclaves
 {
    class Pair{
    int first;
    int second;
    
    public Pair(int row, int col){
       this.first = row;
       this.second = col;
        }
    }

    int numberOfEnclaves(int[][] grid) {
        // Your code here
        Queue<Pair> queue = new LinkedList<>();
        int n = grid.length;
        int m = grid[0].length;
        
        int vis [][] = new int[n][m];
        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                //first row, first col, last row, last col
                if(i==0 || j==0 || i==n-1 || j==m-1){
                    if(grid[i][j]==1){
                        queue.add(new Pair(i,j));
                        vis[i][j] = 1;
                    }
                }
            }
        }
        
        int[] delRow = {-1,0,1,0};
        int[] delCol = {0,-1,0,1};
        
        while(!queue.isEmpty()){
            int row = queue.peek().first;
            int col = queue.peek().second;
            queue.remove();
            
            //traverse all 4 directions
            for(int i=0; i<4; i++){
                int nrow = row + delRow[i];
                int ncol = col + delCol[i];
                
                if(nrow>=0 && nrow<n && ncol>=0 && ncol<m && vis[nrow][ncol]==0 && grid[nrow][ncol]==1){
                    queue.add(new Pair(nrow,ncol));
                    vis[nrow][ncol] = 1;
                }
            }
            
        }
        
        int count = 0;
        
        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                if(grid[i][j]==1 && vis[i][j]==0) count++;
            }
        }
        return count;
        
    }
    
}