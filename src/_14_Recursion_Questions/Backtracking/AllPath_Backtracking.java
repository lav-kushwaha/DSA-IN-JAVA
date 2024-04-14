package _14_Recursion_Questions.Backtracking;

//All possible way means all direction.

public class AllPath_Backtracking {
    public static void main(String[] args) {
        boolean[][] board = {
                {true, true, true},
                {true, true, true},
                {true, true, true}
        };
//        int[][] path = new int[board.length][board[0].length];
        allPath("",board,0,0);

    }
    static void allPath(String p, boolean[][] maze, int r, int c) {
        if (r == maze.length - 1 && c == maze[0].length - 1) {
            System.out.println(p);
            return;
        }

        if (!maze[r][c]) {
            return;
        }

        // i am considering this block in my path.
        //Make a change.
        maze[r][c] = false;

        if (r < maze.length - 1) {
            allPath(p + 'D', maze, r+1, c);
        }

        if (c < maze[0].length - 1) {
            allPath(p + 'R', maze, r, c+1);
        }

        if (r > 0) {
            allPath(p + 'U', maze, r-1, c);
        }

        if (c > 0) {
            allPath(p + 'L', maze, r, c-1);
        }

        //this line is where the function will be over.
        //so, before the function gets removed, also remove the changes that were made by the function.
        //reverse the change=>when work is done.
        maze[r][c] = true;
    }

}
