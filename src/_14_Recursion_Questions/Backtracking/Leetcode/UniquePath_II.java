package _14_Recursion_Questions.Backtracking.Leetcode;

//https://leetcode.com/problems/unique-paths-ii/
//63. Unique Paths II
//maze with obstacles.

class UniquePath_II {
    public int uniquePathsWithObstacles(int[][] obstacleGrid) {
        return pathCount(obstacleGrid,0,0);
    }
    static int pathCount(int[][] arr,int row, int col){
         if(row==arr.length-1 && col==arr[0].length-1){
             return 1;
         }

         if(row>=arr.length || col>=arr[0].length || arr[row][col]==1){
             return 0;
         }

         int left = pathCount(arr,row+1,col);
         int right = pathCount(arr,row,col+1);

         return left+right;
    }
}