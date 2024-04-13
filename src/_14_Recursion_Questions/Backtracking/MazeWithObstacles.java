package _14_Recursion_Questions.Backtracking;

//https://leetcode.com/problems/unique-paths-ii/
//63. Unique Paths II
//maze with obstacles.

public class MazeWithObstacles {
    public static void main(String[] args) {
        boolean [][] maze = {
                {true,true,true},
                {true,false,true},
                {true,true,true}
        };
        Obstaclespath("",maze,0,0);

        System.out.println(Obstaclespath(maze,0,0));


    }
    static void Obstaclespath(String p,boolean[][] maze, int row, int col) {
        // Base case: reached the bottom-right corner
        if(row==maze.length-1 && col== maze[0].length-1){
            System.out.println(p);
            return;
        }
        if(!maze[row][col]){
            return;
        }

        if(row<maze.length-1){
            Obstaclespath(p+"D",maze,row+1,col);
        }

        if(col<maze[0].length-1){
            Obstaclespath(p+"R",maze,row,col+1);
        }
    }

    static int Obstaclespath(boolean[][] maze, int row, int col) {
        // Base case: reached the bottom-right corner
        if(row==maze.length-1 && col== maze[0].length-1){
            return 1;
        }
        if(!maze[row][col]){
            return 0;
        }

        int count = 0 ;
        if(row<maze.length-1){
            count = count + Obstaclespath(maze,row+1,col);
        }

        if(col<maze[0].length-1){
           count = count + Obstaclespath(maze,row,col+1);
        }

        return count;

    }
}
