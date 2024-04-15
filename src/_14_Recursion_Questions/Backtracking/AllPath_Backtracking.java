package _14_Recursion_Questions.Backtracking;

//All possible way means all direction.

import java.util.Arrays;

public class AllPath_Backtracking {
    public static void main(String[] args) {
        boolean[][] board = {
                {true, true, true},
                {true, true, true},
                {true, true, true}
        };
//        allPath("",board,0,0);
        int[][] path = new int[board.length][board[0].length];
        allPathPrint("", board, 0, 0, path, 1);

    }
    static void allPath(String p, boolean[][] maze, int r, int c) {
        // Base case: reached the bottom-right corner - v.imp
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


    static void allPathPrint(String p, boolean[][] maze, int r, int c, int[][] path, int step) {
        if (r == maze.length - 1 && c == maze[0].length - 1) {
            //it will add last element.
            // if u did not understand, comment this line and print and uncomment print u will understand.
            path[r][c] = step;
            for(int[] arr : path) {
                System.out.println(Arrays.toString(arr));
            }
            System.out.println(p);
            System.out.println();
            return;
        }

        if (!maze[r][c]) {
            return;
        }

        // i am considering this block in my path
        maze[r][c] = false;

        //This line will be add, every step.
        path[r][c] = step;
        if (r < maze.length - 1) {
            allPathPrint(p + 'D', maze, r+1, c, path, step+1);
        }

        if (c < maze[0].length - 1) {
            allPathPrint(p + 'R', maze, r, c+1, path, step+1);
        }

        if (r > 0) {
            allPathPrint(p + 'U', maze, r-1, c, path, step+1);
        }

        if (c > 0) {
            allPathPrint(p + 'L', maze, r, c-1, path, step+1);
        }

        // this line is where the function will be over
        // so before the function gets removed, also remove the changes that were made by that function
        maze[r][c] = true;
        path[r][c] = 0;
    }

}
